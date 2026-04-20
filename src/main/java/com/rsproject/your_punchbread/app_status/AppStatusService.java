package com.rsproject.your_punchbread.app_status;

import org.springframework.stereotype.Service;

@Service
public class AppStatusService {
    private final AppStatusRepository appStatusRepo;

    public AppStatusService(AppStatusRepository appStatusRepo) {
        this.appStatusRepo = appStatusRepo;
    }

    public AppStatus getStatus() {
        // If the row doesn't exist yet (first run), create it
        return appStatusRepo.findById(1).orElseGet(() -> appStatusRepo.save(new AppStatus()));
    }

    public void updatePhotoIndex(int change) {
        AppStatus status = getStatus();
        int newIndex = status.getCurrentPhotoIndex() + change;

        // Clamp the value between 0 and 20
        if (newIndex < 0) {
            newIndex = 0;
        } else if (newIndex > 20) {
            newIndex = 20;
        }
        status.setCurrentPhotoIndex(newIndex);
        appStatusRepo.save(status);
    }
}
