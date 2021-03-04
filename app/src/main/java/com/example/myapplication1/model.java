package com.example.myapplication1;

import android.provider.ContactsContract;

import java.io.Serializable;
import java.util.jar.Attributes;

public class model implements Serializable {

    String Name;
    String Call;
    String Email;
    String Address;
    String dob;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCall() {
        return Call;
    }

    public void setCall(String call) {
        Call = call;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
}
