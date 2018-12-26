package com.yoeki.kalpnay.hrporatal.Request;

public class Shiftmodel {

    String datee;
    String currentshit;
    String changeshift;
    String reason;
    String status;
    String name;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getDatee() {
        return datee;
    }

    public void setDatee(String datee) {
        this.datee = datee;
    }

    public String getCurrentshit() {
        return currentshit;
    }

    public void setCurrentshit(String currentshit) {
        this.currentshit = currentshit;
    }

    public String getChangeshift() {
        return changeshift;
    }

    public void setChangeshift(String changeshift) {
        this.changeshift = changeshift;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
