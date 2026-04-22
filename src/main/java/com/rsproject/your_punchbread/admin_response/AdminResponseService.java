package com.rsproject.your_punchbread.admin_response;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AdminResponseService {
    AdminResponseRepository responseRepo;

    public AdminResponseService(AdminResponseRepository responseRepo) {
        this.responseRepo = responseRepo;
    }

    public AdminResponse getResponse() {
        // Change "Hey there!" to "No active message"
        return responseRepo.findById(1).orElseGet(() ->
                responseRepo.save(new AdminResponse("No active message", 0, LocalDateTime.now()))
        );
    }

    public void updateResponse(String message, int photoIndex) {
        AdminResponse response = getResponse();
        response.setResponseMessage(message);
        response.setResponsePhotoIndex(photoIndex);
        response.setResponseDate(LocalDateTime.now());
        responseRepo.save(response);
    }

    public void deleteResponse() {
        responseRepo.deleteById(1);
    }
}
