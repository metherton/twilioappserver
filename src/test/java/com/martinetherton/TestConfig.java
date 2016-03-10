package com.martinetherton;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.resource.factory.MessageFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by martin on 10/03/16.
 */
@Configuration
public class TestConfig {

    @Value("${accountsid}")
    private String accountSid;

    @Value("${authtoken}")
    private String authToken;

    @Bean
    public SmsController smsController() {
        SmsController smsController = new SmsController(messageFactory());
        return smsController;
    }

    @Bean
    public MessageFactory messageFactory() {
        return twilioRestClient().getAccount().getMessageFactory();
    }

    @Bean
    public TwilioRestClient twilioRestClient() {
        return new TwilioRestClient(accountSid, authToken);
    }
}
