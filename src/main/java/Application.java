import com.pluralsight.service.CustomerService;
import com.pluralsight.service.CustomerServiceImp;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Application {

    public static void main(String[] args){
//      XML and Annotations
//        ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//        CustomerService service = appContext.getBean("customerService", CustomerService.class);




//      JAVA config
        ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
        CustomerService service = appContext.getBean("customerService", CustomerService.class);

        // option none, all cohese like glue
        //CustomerService service = new CustomerServiceImp();
//








        System.out.println(service.findAll().get(0).getFirstName());
    }
}