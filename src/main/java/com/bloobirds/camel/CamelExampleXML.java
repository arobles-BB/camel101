package com.bloobirds.camel;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CamelExampleXML {

    private static final Logger log = LogManager.getLogger("rootLogger");

    public static void main(String[] args) throws Exception {

        // Loading a route automatically executes it
        ClassPathXmlApplicationContext applicationContext =
        //        new ClassPathXmlApplicationContext("routes/activemq-consumer.xml");
              new ClassPathXmlApplicationContext("routes/activemq.xml");
        //      new ClassPathXmlApplicationContext("routes/files.xml");
        //      new ClassPathXmlApplicationContext("routes/basic.xml");

        log.info("press Ctrl+c to shutdown...");
        while (true) {
            Thread.sleep(1000);
        }
    }

}
