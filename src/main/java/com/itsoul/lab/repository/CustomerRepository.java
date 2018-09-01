package com.itsoul.lab.repository;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.Random;

@Repository
@Scope("prototype")
/* By Default all kind of @Component stereotypes are scoped as singleton.
 * It can be changed to prototype.*/
public class CustomerRepository {

    private Integer id;

    public CustomerRepository() {
        Random rand = new Random();
        id = rand.nextInt(1000) + 1;
    }

    @Override
    public String toString() {
        return "This is CustomerRepo (" + id + ")";
    }
}
