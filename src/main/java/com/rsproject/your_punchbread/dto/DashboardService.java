package com.rsproject.your_punchbread.dto;

import com.rsproject.your_punchbread.admin_response.AdminResponseService;
import com.rsproject.your_punchbread.dto.DashboardDTO;
import com.rsproject.your_punchbread.app_status.AppStatusService;
import com.rsproject.your_punchbread.mood.MoodService;
import com.rsproject.your_punchbread.kiss.KissService;
import com.rsproject.your_punchbread.punch.PunchService;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {

    private final AppStatusService appStatusService;
    private final MoodService moodService;
    private final KissService kissService;
    private final PunchService punchService;
    private final AdminResponseService adminResponseService;

    public DashboardService(
            AppStatusService appStatusService,
            MoodService moodService,
            KissService kissService,
            PunchService punchService,
            AdminResponseService adminResponseService) {
        this.appStatusService = appStatusService;
        this.moodService = moodService;
        this.kissService = kissService;
        this.punchService = punchService;
        this.adminResponseService = adminResponseService;
    }

    public DashboardDTO getDashboardData() {
        return new DashboardDTO(
                appStatusService.getStatus(),         // Fetches or creates ID 1
                moodService.getMoodStatistics(),      // Fetches the 30-day map
                kissService.getTotalKissWeek(),           // Counts kisses in a week
                punchService.getTotalPunchWeek(),          // Counts punches in a week
                adminResponseService.getResponse()
        );
    }

    public AdminDashboardDTO getAdminDashboardData() {
        return new AdminDashboardDTO(
                kissService.getTotalKiss(),
                punchService.getTotalPunch(),
                kissService.getTotalKissWeek(),
                punchService.getTotalPunchWeek(),
                moodService.getMoodStatistics(),
                appStatusService.getStatus().getCurrentPhotoIndex(),
                adminResponseService.getResponse()
        );
    }
}