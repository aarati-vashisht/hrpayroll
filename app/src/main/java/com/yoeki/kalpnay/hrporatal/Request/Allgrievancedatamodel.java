package com.yoeki.kalpnay.hrporatal.Request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Allgrievancedatamodel {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("ListHRGreveance")
    @Expose
    private List<ListHRGreveance> listHRGreveance = null;

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

    public List<ListHRGreveance> getListHRGreveance() {
        return listHRGreveance;
    }

    public void setListHRGreveance(List<ListHRGreveance> listHRGreveance) {
        this.listHRGreveance = listHRGreveance;
    }

    public class ListHRGreveance {

        @SerializedName("GreveanceId")
        @Expose
        private String greveanceId;
        @SerializedName("Date")
        @Expose
        private String date;
        @SerializedName("EmpName")
        @Expose
        private String empName;
        @SerializedName("GrevanceName")
        @Expose
        private String grevanceName;
        @SerializedName("ManagerName")
        @Expose
        private String managerName;
        @SerializedName("Proceduree")
        @Expose
        private String proceduree;
        @SerializedName("ProperSolution")
        @Expose
        private String properSolution;

        public String getGreveanceId() {
            return greveanceId;
        }

        public void setGreveanceId(String greveanceId) {
            this.greveanceId = greveanceId;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getEmpName() {
            return empName;
        }

        public void setEmpName(String empName) {
            this.empName = empName;
        }

        public String getGrevanceName() {
            return grevanceName;
        }

        public void setGrevanceName(String grevanceName) {
            this.grevanceName = grevanceName;
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

        public String getProperSolution() {
            return properSolution;
        }

        public void setProperSolution(String properSolution) {
            this.properSolution = properSolution;
        }

    }
}
