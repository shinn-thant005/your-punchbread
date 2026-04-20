package com.rsproject.your_punchbread.kiss;

import com.rsproject.your_punchbread.app_status.AppStatusService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class KissService {
    KissRepository kissRepo;
    AppStatusService appStatusService;

    public KissService(KissRepository kissRepo,  AppStatusService appStatusService) {
        this.kissRepo = kissRepo;
        this.appStatusService = appStatusService;
    }

    public void kiss() {
        Kiss kiss = new Kiss(LocalDateTime.now());
        kissRepo.save(kiss);
        appStatusService.updatePhotoIndex(1);

    }

    public long getTotalKiss() {
        return kissRepo.count();
    }

    public long getTotalKissWeek() {
        LocalDateTime lastSevenDays = LocalDateTime.now().minusDays(7);
        return kissRepo.countByKissTimeAfter(lastSevenDays);
    }
}
