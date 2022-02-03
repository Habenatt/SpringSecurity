package perscholas.dependencyinjectionexample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Worker3 {

    public static final Logger LOG= LoggerFactory.getLogger(Worker3.class);

    public void doWork(){

        System.out.println("worker3");
        LOG.info("This is worker 3");
        try{
            int s=1/0;
        }
        catch(Exception e){
            LOG.debug("This is the message", e);
        }
    }
}
