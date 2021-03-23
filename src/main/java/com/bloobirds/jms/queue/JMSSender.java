package com.bloobirds.jms.queue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.Properties;

public class JMSSender {

    private static final Logger log = LogManager.getLogger("rootLogger");

    private static final String MESSAGE="This is a message!!";
    private static final String QUEUE_FACTORY="ConnectionFactory";
    private static final String QUEUE="dynamicQueues/jmsqueue";

    public static void main(String[] args) throws Exception {

        Properties props = new Properties();
        props.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
        props.setProperty(Context.PROVIDER_URL, "tcp://localhost:61616");
        //Create and start connection
        Context ctx = new InitialContext(props);
        //InitialContext ctx = new InitialContext();
        QueueConnectionFactory f = (QueueConnectionFactory) ctx.lookup(QUEUE_FACTORY);
        QueueConnection con = f.createQueueConnection();
        con.start();
        //2) create queue session
        QueueSession ses = con.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
        //3) get the Queue object
        Queue t = (Queue) ctx.lookup(QUEUE);
        //4)create QueueSender object
        QueueSender sender = ses.createSender(t);
        //5) create TextMessage object
        TextMessage msg = ses.createTextMessage();
        //6) write message
        msg.setText(MESSAGE);
        //7) send message
        sender.send(msg);
        log.info("Message successfully sent.");
        //8) connection close
        con.close();
    }
}
