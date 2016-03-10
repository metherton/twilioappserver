package com.martinetherton;

import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by martin on 10/03/16.
 */
@RestController
public class SmsController {
    private final MessageFactory messageFactory;

    public SmsController(MessageFactory messageFactory) {
        this.messageFactory = messageFactory;
    }

    @RequestMapping(value="/sms", method= RequestMethod.POST)
    public void send(@RequestBody SmsMessage smsMessage) {
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("Body", smsMessage.getBody()));
        params.add(new BasicNameValuePair("To", smsMessage.getTo()));
        params.add(new BasicNameValuePair("From", "123456"));

        try {
            messageFactory.create(params);
        } catch (TwilioRestException e) {
            e.printStackTrace();
        }
    }
}
