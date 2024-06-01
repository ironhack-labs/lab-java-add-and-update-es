package com.example.demo.DTO;

import com.example.demo.model.Status;

public class UpdateEmployeeStatus {

    private Status newStatus;

    public Status getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(Status newStatus) {
        this.newStatus = newStatus;
    }
}
