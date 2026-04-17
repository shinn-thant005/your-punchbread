package com.rsproject.your_punchbread.kiss;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface KissRepository extends JpaRepository<Kiss, Integer> {
    long countByKissTimeAfter(LocalDateTime date);
}
