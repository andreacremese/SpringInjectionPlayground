import com.pluralsight.service.CustomerService;
import com.pluralsight.service.CustomerServiceImp;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Application {

    public static void main(String[] args){
        // option 1 and 2, with xml injection
        // note that the name of the service to inject can be either in the annotation of the class OR in the
        // xml file
//        ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//        CustomerService service = appContext.getBean("customerService", CustomerService.class);

        // option none, all cohese like glue
        CustomerService service = new CustomerServiceImp();
        System.out.println(service.findAll().get(0).getFirstName());
    }
}