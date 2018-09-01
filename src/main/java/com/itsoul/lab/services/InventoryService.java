package com.itsoul.lab.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@PropertySource("classpath:/application-${itsoul.lab.active}.properties")
@Scope("prototype")
/* By Default all kind of @Component stereotypes are scoped as singleton.
 * It can be changed to prototype.*/
public class InventoryService {

    @Value("${inventory.version}")
    private String version;

    private Integer id;

    public InventoryService() {
        Random rand = new Random();
        id = rand.nextInt(1000) + 1;
    }

    @Override
    public String toString() {
        return "Inventory(" + id +") Version is " + version;
    }

}
