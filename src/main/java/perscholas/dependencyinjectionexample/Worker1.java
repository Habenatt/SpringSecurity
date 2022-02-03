package perscholas.dependencyinjectionexample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import perscholas.validation.EmailUniqueImpl;

@Component
public class Worker1 {


    public static final Logger LOG= LoggerFactory.getLogger(Worker1.class);
    public void doWork(){

        System.out.println("worker1");
        LOG.info("This is worker 1");

           }
}
