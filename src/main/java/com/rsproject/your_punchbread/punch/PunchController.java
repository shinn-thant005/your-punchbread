package com.rsproject.your_punchbread.punch;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class PunchController {
    private final PunchService punchService;

    public PunchController(PunchService punchService) {
        this.punchService = punchService;
    }

    @PostMapping("/punch")
    public String punch() {
        punchService.addPunch();
        return "**PUNCH**";
    }

    @GetMapping("/get-total-punch")
    public long getTotalPunch() {
        return punchService.getTotalPunch();
    }

    @GetMapping("/get-total-punch-week")
    public long getTotalPunchWeek() {
        return punchService.getTotalPunchWeek();
    }
}
