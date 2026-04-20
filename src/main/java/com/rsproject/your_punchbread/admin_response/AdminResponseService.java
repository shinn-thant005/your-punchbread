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
        return responseRepo.findById(1).orElseGet(() ->
                responseRepo.save(new AdminResponse("Hey there!", 0, LocalDateTime.now()))
        );
    }

    public void updateResponse(String message, int photoIndex) {
        AdminResponse response = getResponse();
        response.setResponseMessage(message);
        response.setResponsePhotoIndex(photoIndex);
        response.setResponseDate(LocalDateTime.now());
        responseRepo.save(response);
    }
}
