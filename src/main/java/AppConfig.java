//import com.pluralsight.repository.CustomerRepository;
//import com.pluralsight.repository.HibernateCustomerRepositoryImpl;
//import com.pluralsight.service.CustomerService;
//import com.pluralsight.service.CustomerServiceImp;
//import jdk.nashorn.internal.objects.annotations.Property;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
//
//
//// ONLY for JAVA injection
//@Configuration
//
////@ComponentScan({"com.pluralsight"})
//
//// Annotation in order to pass in proprerites.
//@PropertySource("app.properties")
//public class AppConfig {
//
//
//    // Setter implementation of injection
//    @Bean("customerService")
//    public CustomerService getCustomerService() {
//        CustomerServiceImp result = new CustomerServiceImp();
//        result.setCustomerRepository(getCustomerRepository());
//        return result;
//    }
//
//    @Bean("customerRepository")
//    public CustomerRepository getCustomerRepository() {
//        return new HibernateCustomerRepositoryImpl();
//    }
//
//    // This is reqruied in order to read the properties in the file
//    @Bean
//    public static PropertySourcesPlaceholderConfigurer getPropertySourcesPlaceholderConfigurer() {
//        return new PropertySourcesPlaceholderConfigurer();
//    }
//}
