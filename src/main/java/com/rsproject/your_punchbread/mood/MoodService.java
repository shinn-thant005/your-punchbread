package com.rsproject.your_punchbread.mood;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MoodService {
    MoodRepository moodRepo;

    public MoodService(MoodRepository moodRepo) {
        this.moodRepo = moodRepo;
    }

    public void addMood(Mood mood) {
        LocalDateTime now  = LocalDateTime.now();
        mood.setMoodTime(now);
        moodRepo.save(mood);
    }

    public List<Mood> getAllMoods() {
        return moodRepo.findAll();
    }

    public List<Mood> getMoodsMonth() {
        LocalDateTime last30days = LocalDateTime.now().minusDays(30);
        return moodRepo.findByMoodTimeAfter(last30days);
    }

    public Map<String, Long> getMoodStatistics() {
        // 1. Initialize Map with all Enum values set to 0 (Empty State Logic)
        Map<String, Long> moodMap = new HashMap<>();
        for (Mood.moodTypes type : Mood.moodTypes.values()) {
            moodMap.put(type.name(), 0L);
        }

        // 2. Fetch raw data from DB
        List<Object[]> results = moodRepo.countMoodsLast30Days();

        // 3. Populate Map with actual database counts
        for (Object[] result : results) {
            String moodName = (String) result[0]; // The Enum string from DB
            Long count = ((Number) result[1]).longValue();
            moodMap.put(moodName, count);
        }
        return moodMap;
    }

    public List<Mood> getMoodsByType(Mood.moodTypes mood) {
        return moodRepo.findByMood(mood);
    }

    public List<Mood> getMoodsByDate(LocalDateTime date) {
        return moodRepo.findByMoodTime(date);
    }

}
