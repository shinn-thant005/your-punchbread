package com.rsproject.your_punchbread.app_status;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/status")
public class AppStatusController {
    private final AppStatusService appStatusService;

    public AppStatusController(AppStatusService appStatusService) {
        this.appStatusService = appStatusService;
    }

    @GetMapping
    public int getCurrentIndex() {
        return appStatusService.getStatus().getCurrentPhotoIndex();
    }
}
