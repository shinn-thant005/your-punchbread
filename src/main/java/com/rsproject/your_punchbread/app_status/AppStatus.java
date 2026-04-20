package com.rsproject.your_punchbread.app_status;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class AppStatus {
    @Id
    private Integer id = 1;

    private int currentPhotoIndex = 10;

    public AppStatus() {};

    public int getCurrentPhotoIndex() {
        return currentPhotoIndex;
    }

    public void setCurrentPhotoIndex(int currentPhotoIndex) {
        this.currentPhotoIndex = currentPhotoIndex;
    }
}
