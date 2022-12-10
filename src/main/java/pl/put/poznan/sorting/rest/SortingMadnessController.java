package pl.put.poznan.sorting.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.sorting.logic.DummySort;
import pl.put.poznan.sorting.logic.SortContext;

import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
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
                String direction = "asc";

                // TODO: get data from request, it may be strings or numbers or objects, get objects from JSON

                algorithms = requestData.get("algorithms").toString().split(",");

                if (requestData.containsKey("direction")) {
                        direction = requestData.get("direction").toString();
                }

                // TODO: sort
                return requestData;
        }

        @RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
        void post(@RequestBody Map<String, Object> data) {

                // TODO: implement POST
        }



}


