package com.martinetherton;

/**
 * Created by martin on 10/03/16.
 */
public class SmsMessage {
    private String body;
    private String to;

    public SmsMessage() {}

    public SmsMessage(String body, String to) {
        this.body = body;
        this.to = to;
    }

    public String getBody() {

        return "yo";
    }

    public String getTo() {
        return "0031624543741";
    }
}
