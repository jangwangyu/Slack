package com.example.slack;

import com.example.slack.http.SlackHttpClient;
import com.example.slack.http.UpbitHttpClient;
import com.example.slack.http.UpbitTickerDto;
import com.example.slack.repository.ReportHisotryRepository;
import com.example.slack.service.UpbitSlackService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.*;


// UpbitSlackService 호출, SlackHttpClient 호출. repository 호출 테스트
@ExtendWith(MockitoExtension.class)
class SlackApplicationTests {
    @Mock
    private SlackHttpClient slackHttpClient;

    @Mock
    private UpbitHttpClient upbitHttpClient;

    @Mock
    private ReportHisotryRepository repository;

    @InjectMocks
    private UpbitSlackService sut;

    @Test
    void test() {
        // given
        String market = "KRW-BTC";
        when(upbitHttpClient.getTickerByMarket(market))
                .thenReturn(UpbitTickerDto.builder()
                        .trade_price(10.0)
                        .build());

        // when
        sut.execute(market);

        // then
        verify(upbitHttpClient, atMostOnce()).getTickerByMarket(market); // HttpClient에서 getTickerByMarket(market)이 한번만 호출(atMostOnce())
        verify(slackHttpClient, atMostOnce()).send(any()); // HttpClient에서 getTickerByMarket(market)이 한번만 호출(atMostOnce())
        verify(repository, atMostOnce()).save(any(), any()); // HttpClient에서 getTickerByMarket(market)이 한번만 호출(atMostOnce())
    }

}
