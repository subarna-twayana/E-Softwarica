package com.example.e_softwarica.model;

import java.util.ArrayList;
import java.util.List;

public class StudentData {
    private String sname;
    private String sage;
    private String saddress;
    private String sgender;

    public static List<StudentData>list=new ArrayList<>();

    public static List<StudentData> getList() {
        return list;
    }

    public static void setList(List<StudentData> list) {
        StudentData.list = list;
    }

    public StudentData(String sname, String sage, String saddress, String sgender) {
        this.sname = sname;
        this.sage = sage;
        this.saddress = saddress;
        this.sgender = sgender;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSage() {
        return sage;
    }

    public void setSage(String sage) {
        this.sage = sage;
    }

    public String getSaddress() {
        return saddress;
    }

    public void setSaddress(String saddress) {
        this.saddress = saddress;
    }

    public String getSgender() {
        return sgender;
    }

    public void setSgender(String sgender) {
        this.sgender = sgender;
    }
}
