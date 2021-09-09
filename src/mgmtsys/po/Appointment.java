/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mgmtsys.po;

/**
 *
 * @author HP
 */
public class Appointment {
    
    private String id;
    private String pfirstname;
    private String plastname;
    private String dateofapp;
    private String timeofapp;
    private String pcontact;
    private String pgender;
    private String doctorname;
    private String dcontact;
    private String search;

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPfirstname() {
        return pfirstname;
    }

    public void setPfirstname(String pfirstname) {
        this.pfirstname = pfirstname;
    }

    public String getPlastname() {
        return plastname;
    }

    public void setPlastname(String plastname) {
        this.plastname = plastname;
    }

    public String getDateofapp() {
        return dateofapp;
    }

    public void setDateofapp(String dateofapp) {
        this.dateofapp = dateofapp;
    }

    public String getTimeofapp() {
        return timeofapp;
    }

    public void setTimeofapp(String timeofapp) {
        this.timeofapp = timeofapp;
    }

    public String getPcontact() {
        return pcontact;
    }

    public void setPcontact(String pcontact) {
        this.pcontact = pcontact;
    }

    public String getPgender() {
        return pgender;
    }

    public void setPgender(String pgender) {
        this.pgender = pgender;
    }

    public String getDoctorname() {
        return doctorname;
    }

    public void setDoctorname(String doctorname) {
        this.doctorname = doctorname;
    }

    public String getDcontact() {
        return dcontact;
    }

    public void setDcontact(String dcontact) {
        this.dcontact = dcontact;
    }
}
