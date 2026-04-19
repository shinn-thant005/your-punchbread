package com.rsproject.your_punchbread.random_message;

import org.springframework.stereotype.Service;

@Service
public class RandomMessageService {
    RandomMessageRepository randomMessageRepos;

    public RandomMessageService(RandomMessageRepository randomMessageRepos) {
        this.randomMessageRepos = randomMessageRepos;
    }
}
