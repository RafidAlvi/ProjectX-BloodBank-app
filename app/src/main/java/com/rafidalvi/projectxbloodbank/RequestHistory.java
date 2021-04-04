package com.rafidalvi.projectxbloodbank;

public class RequestHistory {
    String rNameS;
    String rAddressS;
    String rdatetime;
    String rphn;
    String rAge;
    String rbloodtype;
    String rUid;
    String rNoteS;
    String rStatus;
    String rDoneby;

    public RequestHistory() {
    }

    public RequestHistory(String rNameS, String rAddressS, String rdatetime, String rphn, String rAge, String rbloodtype, String rUid, String rNoteS, String rStatus, String rDoneby) {
        this.rNameS = rNameS;
        this.rAddressS = rAddressS;
        this.rdatetime = rdatetime;
        this.rphn = rphn;
        this.rAge = rAge;
        this.rbloodtype = rbloodtype;
        this.rUid = rUid;
        this.rNoteS = rNoteS;
        this.rStatus = rStatus;
        this.rDoneby = rDoneby;
    }

    public String getrNameS() {
        return rNameS;
    }

    public void setrNameS(String rNameS) {
        this.rNameS = rNameS;
    }

    public String getrAddressS() {
        return rAddressS;
    }

    public void setrAddressS(String rAddressS) {
        this.rAddressS = rAddressS;
    }

    public String getRdatetime() {
        return rdatetime;
    }

    public void setRdatetime(String rdatetime) {
        this.rdatetime = rdatetime;
    }

    public String getRphn() {
        return rphn;
    }

    public void setRphn(String rphn) {
        this.rphn = rphn;
    }

    public String getrAge() {
        return rAge;
    }

    public void setrAge(String rAge) {
        this.rAge = rAge;
    }

    public String getRbloodtype() {
        return rbloodtype;
    }

    public void setRbloodtype(String rbloodtype) {
        this.rbloodtype = rbloodtype;
    }

    public String getrUid() {
        return rUid;
    }

    public void setrUid(String rUid) {
        this.rUid = rUid;
    }

    public String getrNoteS() {
        return rNoteS;
    }

    public void setrNoteS(String rNoteS) {
        this.rNoteS = rNoteS;
    }

    public String getrStatus() {
        return rStatus;
    }

    public void setrStatus(String rStatus) {
        this.rStatus = rStatus;
    }

    public String getrDoneby() {
        return rDoneby;
    }

    public void setrDoneby(String rDoneby) {
        this.rDoneby = rDoneby;
    }


}
