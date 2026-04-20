package com.rsproject.your_punchbread.admin_response;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class AdminResponse {
    @Id
    private Integer id = 1;

    private String responseMessage;
    private int responsePhotoIndex;
    private LocalDateTime responseDate;

    public AdminResponse() {}
    public AdminResponse(String responseMessage, int responsePhotoIndex, LocalDateTime responseDate) {
        this.responseDate = responseDate;
        this.responsePhotoIndex = responsePhotoIndex;
        this.responseMessage = responseMessage;
    }

    public LocalDateTime getResponseDate() {
        return responseDate;
    }

    public void setResponseDate(LocalDateTime responseDate) {
        this.responseDate = responseDate;
    }

    public int getResponsePhotoIndex() {
        return responsePhotoIndex;
    }

    public void setResponsePhotoIndex(int responsePhotoIndex) {
        this.responsePhotoIndex = responsePhotoIndex;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}
