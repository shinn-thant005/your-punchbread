package com.rsproject.your_punchbread.mood;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1")
public class MoodController {
    MoodService moodService;

    public MoodController(MoodService moodService) {
        this.moodService = moodService;
    }

    @PostMapping("/add-mood")
    public String addMood(@RequestBody Mood mood) {
        moodService.addMood(mood);
        return "**New mood state recorded**";
    }

    @GetMapping("/get-all-moods")
    public List<Mood> getAllMoods() {
        return moodService.getAllMoods();
    }

    @GetMapping("/get-moods-month")
    public List<Mood> getMoodsMonth() {
        return moodService.getMoodsMonth();
    }

    @GetMapping("/stats-30-days")
    public Map<String, Long> getMoodStats() {
        return moodService.getMoodStatistics();
    }

    @GetMapping("/get-moods-type/{mood}")
    public List<Mood> getMoodsByType(@PathVariable Mood.moodTypes mood) {
        return moodService.getMoodsByType(mood);
    }

    @GetMapping("/get-moods-date/{date}")
    public List<Mood> getMoodsByDate(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return moodService.getMoodsByDate(date);
    }
}
