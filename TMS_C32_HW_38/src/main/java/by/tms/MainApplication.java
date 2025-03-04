package by.tms;
import by.tms.service.MyService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApplication {
    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        MyService myService = context.getBean(MyService.class);
        myService.mySlowMethod();
        myService.myFastMethod();
        context.close();
    }
}