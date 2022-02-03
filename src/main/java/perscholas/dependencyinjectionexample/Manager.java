package perscholas.dependencyinjectionexample;

import org.hibernate.jdbc.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Manager {

    @Autowired
    private  Worker1 worker1;

    @Autowired
    private  Worker2 worker2;

    @Autowired
    private  Worker3 worker3;

    public Manager() {
        System.out.println("Constructor ");

      /* this.worker1 = worker1;
        this.worker2 = worker2;
        this.worker3 = worker3;*/

    }


@PostConstruct
        public void init2(){
        worker1.doWork();
        worker2.doWork();
        worker3.doWork();
    }





}
