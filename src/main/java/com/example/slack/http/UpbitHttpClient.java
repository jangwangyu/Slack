package com.example.slack.http;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import java.util.List;

@Component // 스프링 bean 등록
@RequiredArgsConstructor // final로 선언된 필드에 대한 생성자를 자동으로 생성
public class UpbitHttpClient {
    private final HttpClient httpClient; // HTTP 요청을 보내기 위해 사용함. final로 선언되어 있어, 생성자에서만 초기화 가능

    public UpbitTickerDto getTickerByMarket(String market) throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders(); // http 요청 헤더 생성
        headers.add("Accept", "application/json"); // json 형식의 응답을 요청함

        String execute = httpClient.execute(
                "https://api.upbit.com/v1/ticker?markets=" + market,
                HttpMethod.GET,
                headers
        ); // httpClient를 사용하여 업비트 api에 get요청을 보내고, 요청 URL은 "https://api.upbit.com/v1/ticker?markets="에 주어진 market 변수를 결함하여 생성함

        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(
                execute,
                new TypeReference<List<UpbitTickerDto>>() {}
        ).stream().findFirst().get(); // 하나의 데이터가 필요

//        List<UpbitTickerDto> upbitTickerDtos = objectMapper.readValue(
//                execute,
//                new TypeReference<List<UpbitTickerDto>>() {}
//        );   // execute에서 받은 JSON 응답을 List로 변환함 (모든 데이터를 가져옴)
//        return null;
    }
}
