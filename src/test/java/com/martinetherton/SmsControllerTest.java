package com.martinetherton;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Message;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by martin on 10/03/16.
 */
public class SmsControllerTest {

    private SmsController smsController;

    @Mock
    private MessageFactory mockMessageFactory;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        smsController = new SmsController(mockMessageFactory);
    }

    @Test
    @Ignore
    public void sendSmsMessage() throws TwilioRestException {

        SmsMessage smsMessage = new SmsMessage("Hello Martin", "12345");

        TwilioRestClient client = new TwilioRestClient("username", "password");
        Message message = new Message(client);


        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("Body", smsMessage.getBody()));
        params.add(new BasicNameValuePair("To", smsMessage.getTo()));
        params.add(new BasicNameValuePair("From", "123456"));

        Mockito.when(mockMessageFactory.create(params)).thenReturn(message);

        smsController.send(smsMessage);

        Mockito.verify(mockMessageFactory).create(params);
    }
}
