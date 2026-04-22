package com.rsproject.your_punchbread.mood;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Mood {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public enum moodTypes {
        HAPPY, SAD, BORED, ENERGETIC, ANXIOUS, CALM, MAD, MISSING
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "mood_type")
    private moodTypes mood;

    private LocalDateTime moodTime;
    private String reasonMessage;

    public Mood() {}

    public Mood(moodTypes mood, String reasonMessage) {
        this.mood = mood;
        this.reasonMessage = reasonMessage;
    }

    public String getReasonMessage() {
        return reasonMessage;
    }

    public void setReasonMessage(String reasonMessage) {
        this.reasonMessage = reasonMessage;
    }

    public LocalDateTime getMoodTime() {
        return moodTime;
    }

    public void setMoodTime(LocalDateTime moodTime) {
        this.moodTime = moodTime;
    }

    public moodTypes getMood() {
        return mood;
    }

    public void setMood(moodTypes mood) {
        this.mood = mood;
    }
}
