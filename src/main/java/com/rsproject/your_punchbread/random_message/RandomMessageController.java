package com.rsproject.your_punchbread.random_message;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class RandomMessageController {
    RandomMessageService randomMessageService;

    public RandomMessageController(RandomMessageService randomMessageService) {
        this.randomMessageService = randomMessageService;
    }
}
