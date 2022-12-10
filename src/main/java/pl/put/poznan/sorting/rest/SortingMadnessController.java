package pl.put.poznan.sorting.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.sorting.logic.*;
import pl.put.poznan.sorting.logic.SortContext;

import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class SortingMadnessController {

        private static final Logger logger = LoggerFactory.getLogger(SortingMadnessController.class);

        /** sample request

         GET localhost:8080/
         Content-Type: application/json
         Accept: application/json

         {
         "data": [1, 3, 2, 5, 4],
         "algorithms": "bubble, insertion, selection",
         "direction": "asc"
         }

         */


        @RequestMapping(method = RequestMethod.GET, consumes =  "application/json", produces = "application/json")
        public Map<String, Object> get(@RequestBody Map<String, Object> requestData) {

                System.out.println("requestData: " + requestData.toString());

                String[] algorithms;
                String[] data;
                String direction = "asc";

                String [] sortedData;
                int sortingTime;

                Map<String, Object> response = new HashMap<String, Object>();

                algorithms = requestData.get("algorithms").toString().split(",");

                if (requestData.containsKey("direction")) {
                        direction = requestData.get("direction").toString();
                }

                // TODO: get data from request, it may be strings or numbers or objects, get objects from JSON
                // How to handle it?

                data = requestData.get("data").toString().replaceAll("\\[","").replaceAll("]","").replaceAll(" ", "").split(",");


                SortContext sortContext;

                // TODO: add direction parameter
                // TODO: sort objects, not only strings and numbers

                for (String algorithm : algorithms) {
                        sortContext = switch (algorithm) {
                                case "bubble" -> new SortContext(new BubbleSort());
                                case "insertion" -> new SortContext(new InsertionSort());
                                case "selection" -> new SortContext(new SelectionSort());
                                case "heap" -> new SortContext(new HeapSort());
                                default -> new SortContext(new DummySort());
                                // case "merge" -> new SortContext(new MergeSort());
                                // case "quick" -> new SortContext(new QuickSort());
                        };
                        sortedData = sortContext.sort(data);
                        sortingTime = 0;

                        response.put(algorithm, Arrays.asList(sortingTime, sortedData));
                }

                return response;
        }

        @RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
        void post(@RequestBody Map<String, Object> data) {

                // TODO: implement POST
        }

}