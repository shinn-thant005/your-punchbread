package com.rsproject.your_punchbread.kiss;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class KissService {
    KissRepository kissRepo;

    public KissService(KissRepository kissRepo) {
        this.kissRepo = kissRepo;
    }

    public void kiss() {
        Kiss kiss = new Kiss(LocalDateTime.now());
        kissRepo.save(kiss);
    }

    public long getTotalKiss() {
        return kissRepo.count();
    }

    public long getTotalKissWeek() {
        LocalDateTime lastSevenDays = LocalDateTime.now().minusDays(7);
        return kissRepo.countByKissTimeAfter(lastSevenDays);
    }
}
