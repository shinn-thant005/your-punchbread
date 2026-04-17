package com.rsproject.your_punchbread.punch;

import jakarta.transaction.Transactional;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface PunchRepository extends JpaRepository<Punch, Integer> {
    long countByPunchTimeAfter(LocalDateTime time);
}
