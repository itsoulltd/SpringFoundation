package com.itsoul.lab.foundation;

import com.itsoul.lab.repository.CustomerRepository;
import com.itsoul.lab.services.InventoryService;
import com.itsoul.lab.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = {"com.itsoul.lab"})
public class SpringConfig {

    @Bean
    public String greeting(){
        return "World";
    }

    @Bean
    public ResourceConfig resourceConfig(){
        return new ResourceConfig();
    }

    public static void main(String[] args){

        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        String greetingBean = (String) context.getBean("greeting");
        System.out.println("Hello "+greetingBean);

        //
        OrderService service = context.getBean(OrderService.class);
        System.out.println("1st Print :"+ service.toString());

        OrderService service2 = context.getBean(OrderService.class);
        System.out.println("2nd Print :"+ service2.toString());

        CustomerRepository repo = context.getBean(CustomerRepository.class);
        System.out.println(repo.toString());

        //
        InventoryService ivService = context.getBean(InventoryService.class);
        System.out.println("1st Print :"+ ivService.toString());

        InventoryService iv2Service = context.getBean(InventoryService.class);
        System.out.println("2nd Print :"+ iv2Service.toString());

        ResourceConfig config = (ResourceConfig) context.getBean("resourceConfig");
        System.out.println("Application Version : " + config.getVersion());
        System.out.println("DevMode : " + ((config.isDevEnv()) ? "YES" : "NO"));
    }

}
