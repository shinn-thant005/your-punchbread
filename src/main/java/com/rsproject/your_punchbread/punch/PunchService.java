package com.rsproject.your_punchbread.punch;

import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class PunchService {
    private PunchRepository punchRepo;

    public PunchService(PunchRepository punchRepo) {
        this.punchRepo = punchRepo;
    }

    public void addPunch() {
        Punch newPunch = new Punch(LocalDateTime.now());
        punchRepo.save(newPunch);
    }

    public long getTotalPunch() {
        return punchRepo.count();
    }

    public long getTotalPunchWeek() {
        LocalDateTime lastSevenDays = LocalDateTime.now().minusDays(7);
        return punchRepo.countByPunchTimeAfter(lastSevenDays);
    }
}
