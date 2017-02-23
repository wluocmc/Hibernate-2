package com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by weiluo on 2/22/17.
 */
public class MainApp {
    public static void main(String arg[]){
        ApplicationContext beansContext=new ClassPathXmlApplicationContext("Beans.xml");
        SetupDatabase setupDatabase=(SetupDatabase) beansContext.getBean("myDBSetup");
        setupDatabase.ApplyStructure();
//        setupDatabase.ApplyData();
        DataGenerator mydata=(DataGenerator) beansContext.getBean("dataGenerator");
        HibernateExecutor executor=new HibernateExecutor();
        if(executor.StarFactorySuccess()){
            executor.saveCustomer(mydata.getCustomer());
        }

        executor.printCustomer();
        executor.FactoryShutdown();
    }
}
