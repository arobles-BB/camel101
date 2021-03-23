package com.bloobirds.jms.queue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.naming.InitialContext;

public class JMSReceiver {

    private static final Logger log = LogManager.getLogger("rootLogger");
    private static final String MESSAGE="This is a message!!";
    private static final String QUEUE_FACTORY="ConnectionFactory";
    private static final String QUEUE="dynamicQueues/jmsqueue";
    private static final String TOPIC_FACTORY="ConnectionFactory"; // (Pub/Sub)
    private static final String TOPIC="jmstopic";

    public static void main(String[] args) throws Exception {

        //1) Create and start connection
        InitialContext ctx = new InitialContext();
        QueueConnectionFactory f = (QueueConnectionFactory) ctx.lookup(QUEUE_FACTORY);
        QueueConnection con = f.createQueueConnection();
        con.start();
        //2) create Queue session
        QueueSession ses = con.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
        //3) get the Queue object
        Queue t = (Queue) ctx.lookup(QUEUE);
        //4)create QueueReceiver
        QueueReceiver receiver = ses.createReceiver(t);
        //5) create listener object
        JMSListener listener = new JMSListener();
        //6) register the listener object with receiver
        receiver.setMessageListener(listener);
        log.info("Receiver1 is ready, waiting for messages...");
        log.info("press Ctrl+c to shutdown...");
        while (true) {
            Thread.sleep(1000);
        }
    }
}
