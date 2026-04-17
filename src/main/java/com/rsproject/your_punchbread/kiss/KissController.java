package com.rsproject.your_punchbread.kiss;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class KissController {
    private KissService kissService;

    public KissController(KissService kissService) {
        this.kissService = kissService;
    }

    @PostMapping("/kiss")
    public String kiss() {
        kissService.kiss();
        return "**Kiss**";
    }

    @GetMapping("/get-total-kiss")
    public long getTotalKiss() {
        return kissService.getTotalKiss();
    }

    @GetMapping("/get-total-kiss-week")
    public long getTotalKissWeek() {
        return kissService.getTotalKissWeek();
    }
}
