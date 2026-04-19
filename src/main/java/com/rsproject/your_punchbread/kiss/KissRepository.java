package com.rsproject.your_punchbread.kiss;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface KissRepository extends JpaRepository<Kiss, Integer> {
    long countByKissTimeAfter(LocalDateTime date);
}
