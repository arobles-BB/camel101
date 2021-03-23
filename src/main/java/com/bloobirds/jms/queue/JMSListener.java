package com.bloobirds.jms.queue;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class JMSListener implements MessageListener {

    private static final Logger log = LogManager.getLogger("rootLogger");

    public void onMessage(Message m) {
        try {
            TextMessage msg = (TextMessage) m;
            log.info("following message is received:" + msg.getText());
        } catch (JMSException e) {
            log.error(e);
        }
    }
}
