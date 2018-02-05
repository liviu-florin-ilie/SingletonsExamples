package com.wonder.jee.singleton;


import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 * Created by liviu on 04.02.2018.
 */
//@DependsOn("DatabaseConnectionBean")
@Startup
@Singleton
public class LoggerSingleton {
    @PostConstruct
    void constructExpensiveObject() {
        // Expensive construction
        System.out.println("Initialise LoggerSingleton");
    }

    @Override
    public String toString() {
        return super.toString() + "AAAAAAAAAAAAAA";
    }
}

