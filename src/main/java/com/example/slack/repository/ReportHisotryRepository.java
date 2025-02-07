package com.example.slack.repository;

import com.example.slack.entity.ReportHistory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ReportHisotryRepository {
    private final ReportHistoryJpaRepository repository;

    public void save(String market, String price) {
        repository.save(
                new ReportHistory(market, price)
        );
    }
}
