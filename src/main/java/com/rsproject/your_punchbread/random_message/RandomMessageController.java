package com.rsproject.your_punchbread.random_message;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class RandomMessageController {
    RandomMessageService randomMessageService;

    public RandomMessageController(RandomMessageService randomMessageService) {
        this.randomMessageService = randomMessageService;
    }

    @PostMapping("/add-message")
    public String addMessage(@RequestBody RandomMessages newMessages) {
        randomMessageService.addMessage(newMessages);
        return "New Message added!";
    }

    @GetMapping("/get-messages")
    public List<RandomMessages> getMessages() {
        return randomMessageService.getMessages();
    }

    @DeleteMapping("/delete-message/{id}")
    public String deleteMessage(@PathVariable Integer id) {
        randomMessageService.deleteMessageById(id);
        return "Message with Id: " +  id + " was deleted!";
    }

    @PutMapping("/update-message/{id}")
    public String updateMessage(@PathVariable Integer id, @RequestBody RandomMessages newMessages) {
        randomMessageService.updateMessageById(id, newMessages.getMessage());
        return "Message with Id: " +  id + " updated!";
    }

    @GetMapping("/get-random-message")
    public RandomMessages getRandomMessage() {
        return  randomMessageService.getRandomMessage();
    }
}
