package com.yoeki.kalpnay.hrporatal.Request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Employeegrievancelistmodel {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("UserId")
    @Expose
    private String UserId;
    @SerializedName("ListGreveance")
    @Expose
    private List<ListGreveance> listGreveance = null;

    public  Employeegrievancelistmodel(String UserId){

        this.UserId=UserId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ListGreveance> getListGreveance() {
        return listGreveance;
    }

    public void setListGreveance(List<ListGreveance> listGreveance) {
        this.listGreveance = listGreveance;
    }

    public class ListGreveance {
        @SerializedName("Status")
        @Expose
        private String status;
        @SerializedName("CreatedBy")
        @Expose
        private String createdBy;
        @SerializedName("Date")
        @Expose
        private String date;
        @SerializedName("DateOfSubmission")
        @Expose
        private String dateOfSubmission;
        @SerializedName("GreveanceId")
        @Expose
        private String greveanceId;
        @SerializedName("GreveanceTypeId")
        @Expose
        private String greveanceTypeId;
        @SerializedName("InvolvPerson")
        @Expose
        private String involvPerson;
        @SerializedName("ManagerName")
        @Expose
        private String managerName;
        @SerializedName("Proceduree")
        @Expose
        private String proceduree;

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getCreatedBy() {
            return createdBy;
        }

        public void setCreatedBy(String createdBy) {
            this.createdBy = createdBy;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getDateOfSubmission() {
            return dateOfSubmission;
        }

        public void setDateOfSubmission(String dateOfSubmission) {
            this.dateOfSubmission = dateOfSubmission;
        }

        public String getGreveanceId() {
            return greveanceId;
        }

        public void setGreveanceId(String greveanceId) {
            this.greveanceId = greveanceId;
        }

        public String getGreveanceTypeId() {
            return greveanceTypeId;
        }

        public void setGreveanceTypeId(String greveanceTypeId) {
            this.greveanceTypeId = greveanceTypeId;
        }

        public String getInvolvPerson() {
            return involvPerson;
        }

        public void setInvolvPerson(String involvPerson) {
            this.involvPerson = involvPerson;
        }

        public String getManagerName() {
            return managerName;
        }

        public void setManagerName(String managerName) {
            this.managerName = managerName;
        }

        public String getProceduree() {
            return proceduree;
        }

        public void setProceduree(String proceduree) {
            this.proceduree = proceduree;
        }
    }
    }
