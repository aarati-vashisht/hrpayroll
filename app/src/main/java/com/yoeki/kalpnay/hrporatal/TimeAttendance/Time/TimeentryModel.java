package com.yoeki.kalpnay.hrporatal.TimeAttendance.Time;

public class TimeentryModel {

    String date;
    String fromtime;
    String totime;
    String totalhours;
    String asigndby;
    String tskdescription;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFromtime() {
        return fromtime;
    }

    public void setFromtime(String fromtime) {
        this.fromtime = fromtime;
    }

    public String getTotime() {
        return totime;
    }

    public void setTotime(String totime) {
        this.totime = totime;
    }

    public String getTotalhours() {
        return totalhours;
    }

    public void setTotalhours(String totalhours) {
        this.totalhours = totalhours;
    }

    public String getAsigndby() {
        return asigndby;
    }

    public void setAsigndby(String asigndby) {
        this.asigndby = asigndby;
    }

    public String getTskdescription() {
        return tskdescription;
    }

    public void setTskdescription(String tskdescription) {
        this.tskdescription = tskdescription;
    }
}
