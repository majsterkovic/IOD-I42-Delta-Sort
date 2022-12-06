package pl.put.poznan.sorting.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.sorting.logic.DummySort;
import pl.put.poznan.sorting.logic.SortContext;

import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/{method}/{order}")
public class SortingMadnessController {

        private static final Logger logger = LoggerFactory.getLogger(SortingMadnessController.class);

        @RequestMapping(method = RequestMethod.GET, produces = "application/json")
        public String [] get(@PathVariable String method, @PathVariable String order, @RequestParam(value="numbers") String[] numbers) {

                // log the parameters
                logger.debug(Arrays.toString(numbers));

                // perform the transformation, you should run your logic here, below is just a silly example
                SortContext context = new SortContext(new DummySort());

                return context.sort(numbers);
        }

        @RequestMapping(method = RequestMethod.POST, produces = "application/json")
        public String [] post(@PathVariable String method, @PathVariable String order, @RequestBody String[] numbers) {

                // log the parameters
                logger.debug(Arrays.toString(numbers));

                // perform the transformation, you should run your logic here, below is just a silly example
                SortContext context = new SortContext(new DummySort());

                return context.sort(numbers);
        }



}


