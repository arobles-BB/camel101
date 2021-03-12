package com.bloobirds;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class FileProcessor implements Processor {

    private static final Logger log = LogManager.getLogger("rootLogger");

    public void process(Exchange exchange) throws Exception {

        String originalFileContent = (String) exchange.getIn().getBody(String.class);

        log.info("ORIGINAL CONTENT: {"+originalFileContent+"}");

        String upperCaseFileContent = originalFileContent.toUpperCase();

        log.info("TRANSFORM CONTENT: {"+upperCaseFileContent+"}");


        exchange.getIn().setBody(upperCaseFileContent);
    }
}
