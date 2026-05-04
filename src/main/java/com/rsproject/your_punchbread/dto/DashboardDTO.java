package com.rsproject.your_punchbread.dto;

import com.rsproject.your_punchbread.admin_response.AdminResponse;
import com.rsproject.your_punchbread.app_status.AppStatus;
import java.util.Map;

public record DashboardDTO(
        AppStatus appStatus,
        Map<String, Long> moodStatistics,
        long weekKisses,
        long weekPunches,
        AdminResponse adminResponse
) {}