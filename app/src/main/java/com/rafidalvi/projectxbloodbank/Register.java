package com.rafidalvi.projectxbloodbank;

public class Register {
    String uNameS;
    String uAddressS;
    String uFBlogo;
    String uPhn;
    String uAlrphn;
    String uWeight;
    String uReligion;
    String uBirthdate;
    String uMail;
    String ucounts;
    String uBloodType;
    String uLastdonated;

    public Register(){


    }

    public Register(String uNameS, String uAddressS, String uFBlogo, String uPhn, String uAlrphn, String uWeight, String uReligion, String uBirthdate, String uMail, String ucounts, String uBloodType, String uLastdonated) {
        this.uNameS = uNameS;
        this.uAddressS = uAddressS;
        this.uFBlogo = uFBlogo;
        this.uPhn = uPhn;
        this.uAlrphn = uAlrphn;
        this.uWeight = uWeight;
        this.uReligion = uReligion;
        this.uBirthdate = uBirthdate;
        this.uMail = uMail;
        this.ucounts = ucounts;
        this.uBloodType = uBloodType;
        this.uLastdonated = uLastdonated;
    }

    public String getuLastdonated() {
        return uLastdonated;
    }

    public void setuLastdonated(String uLastdonated) {
        this.uLastdonated = uLastdonated;
    }

    public String getuNameS() {
        return uNameS;
    }

    public void setuNameS(String uNameS) {
        this.uNameS = uNameS;
    }

    public String getuAddressS() {
        return uAddressS;
    }

    public void setuAddressS(String uAddressS) {
        this.uAddressS = uAddressS;
    }

    public String getuFBlogo() {
        return uFBlogo;
    }

    public void setuFBlogo(String uFBlogo) {
        this.uFBlogo = uFBlogo;
    }

    public String getuPhn() {
        return uPhn;
    }

    public void setuPhn(String uPhn) {
        this.uPhn = uPhn;
    }

    public String getuAlrphn() {
        return uAlrphn;
    }

    public void setuAlrphn(String uAlrphn) {
        this.uAlrphn = uAlrphn;
    }

    public String getuWeight() {
        return uWeight;
    }

    public void setuWeight(String uWeight) {
        this.uWeight = uWeight;
    }

    public String getuReligion() {
        return uReligion;
    }

    public void setuReligion(String uReligion) {
        this.uReligion = uReligion;
    }

    public String getuBirthdate() {
        return uBirthdate;
    }

    public void setuBirthdate(String uBirthdate) {
        this.uBirthdate = uBirthdate;
    }

    public String getuMail() {
        return uMail;
    }

    public void setuMail(String uMail) {
        this.uMail = uMail;
    }

    public String getUcounts() {
        return ucounts;
    }

    public void setUcounts(String ucounts) {
        this.ucounts = ucounts;
    }

    public String getuBloodType() {
        return uBloodType;
    }

    public void setuBloodType(String uBloodType) {
        this.uBloodType = uBloodType;
    }


}

