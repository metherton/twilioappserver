package com.martinetherton;

import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.instance.Feedback;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by martin on 18/03/16.
 */
@RestController
public class FeedbackController {

    @RequestMapping(value="/feedback", method= RequestMethod.POST)
    public UrlValue send(@RequestBody FeedbackMessage feedback) {
        UrlValue url = new UrlValue();
        url.setUrl("http://www.martinetherton.com");
        return url;
    }
}
