package com.yoeki.kalpnay.hrporatal.all_employee;

import java.io.Serializable;
import java.util.List;

public class AllEmployee_Model implements Serializable {
    String Name;
    String Image;
    String Designation;
    String PhoneNumber;
    String Email;
    String Manager;
    String ManagerDesignation;

    public String getManagerDesignation() {
        return ManagerDesignation;
    }

    public void setManagerDesignation(String managerDesignation) {
        ManagerDesignation = managerDesignation;
    }

    List<AllEmployee_Model> directReportList;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String designation) {
        Designation = designation;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getManager() {
        return Manager;
    }

    public void setManager(String manager) {
        Manager = manager;
    }

    public List<AllEmployee_Model> getDirectReportList() {
        return directReportList;
    }

    public void setDirectReportList(List<AllEmployee_Model> directReportList) {
        this.directReportList = directReportList;
    }


}
