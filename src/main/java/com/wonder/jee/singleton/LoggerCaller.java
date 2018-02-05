package com.wonder.jee.singleton;



import javax.ejb.embeddable.EJBContainer;
import javax.inject.Inject;
import javax.naming.Context;
import javax.naming.NamingException;
import java.util.Properties;

/**
 * Created by liviu on 05.02.2018.
 */
public class LoggerCaller {
    @Inject
    LoggerSingleton logger;

    public static void main(String[] args) throws NamingException {
        Properties props = new Properties();
        EJBContainer ec = EJBContainer.createEJBContainer();


        Context ctx = ec.getContext();
        System.out.println(ctx.list(""));
        Object lookup = ctx.lookup("java:global/classes/LoggerSingleton");
        System.out.println(lookup.toString());


    }
}
