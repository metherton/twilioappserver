package com.martinetherton;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.resource.factory.MessageFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;

@SpringBootApplication
public class TwilioappserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(TwilioappserverApplication.class, args);
	}

	@Value("${accountsid}")
	private String accountSid;

	@Value("${authtoken}")
	private String authToken;

	@Bean
	public PropertyPlaceholderConfigurer propertyConfigurer() throws IOException {
		PropertyPlaceholderConfigurer props = new PropertyPlaceholderConfigurer();
		props.setLocations(new Resource[] {new ClassPathResource("instance.properties")});
		return props;
	}

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
		//return new TwilioRestClient(accountSid, authToken);
		return new TwilioRestClient("231", "2342");
	}

}
