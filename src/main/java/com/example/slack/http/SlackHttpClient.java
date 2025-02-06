package com.example.slack.http;

import com.slack.api.Slack;
import com.slack.api.webhook.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class SlackHttpClient {
    public void send(String message) {
        try {
            Slack instance = Slack.getInstance();
            Payload payload = Payload.builder()
                    .text(message)
                    .build();
            instance.send("https://hooks.slack.com/services/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",payload);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
