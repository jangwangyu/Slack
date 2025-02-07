package com.example.slack.repository;

import com.example.slack.entity.ReportHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportHistoryJpaRepository extends JpaRepository<ReportHistory, Integer> {

}
