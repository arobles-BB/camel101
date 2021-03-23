package com.bloobirds.jms.topic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.Properties;

public class JMSSubscriber {

    private static final Logger log = LogManager.getLogger("rootLogger");

    private static final String MESSAGE="This is a message!!";
    private static final String TOPIC_FACTORY="ConnectionFactory"; // (Pub/Sub)
    private static final String TOPIC="dynamicTopics/jmstopic";


    public static void main(String[] args) throws Exception {

        Properties props = new Properties();
        props.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
        props.setProperty(Context.PROVIDER_URL, "tcp://localhost:61616");
        //Create and start connection
        Context ctx = new InitialContext(props);

        TopicConnectionFactory f = (TopicConnectionFactory) ctx.lookup(TOPIC_FACTORY);
        TopicConnection con = f.createTopicConnection();
        con.start();
        //2) create topic session
        TopicSession ses = con.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
        //3) get the Topic object
        Topic t = (Topic) ctx.lookup(TOPIC);
        //4) create a topic subscriber (diff!!!)
        TopicSubscriber topicSubscriber  = ses.createSubscriber(t);

        //5) receive TextMessage object

        while(true) {
            TextMessage msg = null;
            msg = (TextMessage) topicSubscriber.receive(5000);
            if (msg == null)
                log.info("Subscriber timeout");
            else
                log.info("Message successfully received: "+ msg.getText());
        }
    }
}
