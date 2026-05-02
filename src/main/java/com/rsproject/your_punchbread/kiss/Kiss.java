package com.rsproject.your_punchbread.kiss;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Kiss {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDateTime kissTime;

    public Kiss(LocalDateTime kissTime) {
        this.kissTime = kissTime;
    }

    public Kiss() {
    }

    public LocalDateTime getKissTime() {
        return kissTime;
    }

    public void setKissTime(LocalDateTime kissTime) {
        this.kissTime = kissTime;
    }
}
