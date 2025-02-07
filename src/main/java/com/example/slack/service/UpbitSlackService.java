package com.example.slack.service;

import com.example.slack.http.SlackHttpClient;
import com.example.slack.http.UpbitHttpClient;
import com.example.slack.http.UpbitTickerDto;
import com.example.slack.repository.ReportHisotryRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpbitSlackService {
    private final SlackHttpClient slackHttpClient;
    private final UpbitHttpClient upbitHttpClient;
    private final ReportHisotryRepository repository;

    public void execute(String market) {
        // upbit 호출
        UpbitTickerDto tickerByMarket = upbitHttpClient.getTickerByMarket(market);

        // slack 메세지 쏘기
//        StringBuilder sb = new StringBuilder();
//        sb.append("[실시간 데이터]");
//        sb.append(market);
//        sb.append("price = ");
//        sb.append(tickerByMarket.getTrade_price());
//        slackHttpClient.send(sb.toString());

        repository.save(market, String.valueOf(tickerByMarket.getTrade_price()));
    }
}
