package com.bloobirds.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;


public final class CamelExampleMain {

    /**
     * A main method to start this application.
     */
    public static void main(String[] args) throws Exception {
        // create a CamelContext
        CamelContext camel = new DefaultCamelContext();


        // add routes which can be inlined as anonymous inner class
        // (to keep all code in a single java file for this basic example)
        camel.addRoutes(new RouteBuilder() {
            @Override
            public void configure() {
                from("timer:foo")
                        .log("Hello Camel");
            }
        });

        // start is not blocking
        camel.start();

        // so run for 10 seconds
        Thread.sleep(10_000);

        // and then stop nicely
        camel.stop();
    }
}

