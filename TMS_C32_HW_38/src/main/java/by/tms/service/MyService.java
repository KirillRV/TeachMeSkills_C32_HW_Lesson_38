package by.tms.service;
import by.tms.log.PerformanceLog;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    @PerformanceLog
    public void mySlowMethod() throws InterruptedException {
        Thread.sleep(1500); // Simulate a slow method
        System.out.println("mySlowMethod executed");
    }

    @PerformanceLog
    public void myFastMethod() {
        System.out.println("myFastMethod executed");
    }
}