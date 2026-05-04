package com.rsproject.your_punchbread.dto;

import com.rsproject.your_punchbread.admin_response.AdminResponse;

import java.util.Map;

public record AdminDashboardDTO(
        long totalKisses,
        long totalPunches,
        long weekKissee,
        long weekPunches,
        Map<String, Long> moodStatistics,
        int currentPhotoIndex,
        AdminResponse currentResponse
) {}
