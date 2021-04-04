package com.rafidalvi.projectxbloodbank;

public class Requests {


    String rNameS;
    String rAddressS;
    String rdatetime;
    String rphn;
    String rAge;
    String rbloodtype;
    String rUid;
    String rNoteS;
    String rAcceptedS;
    public Requests() {

    }

    public Requests(String rNameS, String rAddressS, String rdatetime, String rphn, String rAge, String rbloodtype, String rUid, String rNoteS, String rAcceptedS) {
        this.rNameS = rNameS;
        this.rAddressS = rAddressS;
        this.rdatetime = rdatetime;
        this.rphn = rphn;
        this.rAge = rAge;
        this.rbloodtype = rbloodtype;
        this.rUid = rUid;
        this.rNoteS = rNoteS;
        this.rAcceptedS = rAcceptedS;
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

    public String getrAcceptedS() {
        return rAcceptedS;
    }

    public void setrAcceptedS(String rAcceptedS) {
        this.rAcceptedS = rAcceptedS;
    }
}
