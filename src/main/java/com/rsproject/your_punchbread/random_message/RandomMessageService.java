package com.rsproject.your_punchbread.random_message;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RandomMessageService {
    RandomMessageRepository randomMessageRepos;

    public RandomMessageService(RandomMessageRepository randomMessageRepos) {
        this.randomMessageRepos = randomMessageRepos;
    }

    public void addMessage(RandomMessages newMessage) {
        randomMessageRepos.save(newMessage);
    }

    public List<RandomMessages> getMessages() {
        return randomMessageRepos.findAll();
    }

    public void deleteMessageById(Integer id) {
        randomMessageRepos.deleteById(id);
    }

    public void updateMessageById(Integer id, String newMessage) {
        RandomMessages randomMessages = randomMessageRepos.findById(id).get();
        randomMessages.setMessage(newMessage);
        randomMessageRepos.save(randomMessages);
    }
}
