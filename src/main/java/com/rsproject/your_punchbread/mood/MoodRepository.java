package com.rsproject.your_punchbread.mood;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;


public interface MoodRepository extends JpaRepository<Mood, Integer> {
    List<Mood> findByMoodTimeAfter(LocalDateTime time);

    @Query(value = "SELECT mood_type, COUNT(*) FROM mood " +
            "WHERE mood_time >= DATE_SUB(NOW(), INTERVAL 30 DAY) " +
            "GROUP BY mood_type", nativeQuery = true)
    List<Object[]> countMoodsLast30Days();

    List<Mood> findByMood(Mood.moodTypes mood);

    List<Mood> findByMoodTime(LocalDateTime moodTime);
}
