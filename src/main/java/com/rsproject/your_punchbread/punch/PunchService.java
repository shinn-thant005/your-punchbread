package com.rsproject.your_punchbread.punch;

import com.rsproject.your_punchbread.app_status.AppStatusService;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class PunchService {
    private final PunchRepository punchRepo;
    private final AppStatusService appStatusService;

    public PunchService(PunchRepository punchRepo,  AppStatusService appStatusService) {
        this.punchRepo = punchRepo;
        this.appStatusService = appStatusService;
    }

    public void addPunch() {
        Punch newPunch = new Punch(LocalDateTime.now());
        punchRepo.save(newPunch);
        appStatusService.updatePhotoIndex(1);
    }

    public long getTotalPunch() {
        return punchRepo.count();
    }

    public long getTotalPunchWeek() {
        LocalDateTime lastSevenDays = LocalDateTime.now().minusDays(7);
        return punchRepo.countByPunchTimeAfter(lastSevenDays);
    }
}
