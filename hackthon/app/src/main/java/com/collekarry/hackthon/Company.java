package com.collekarry.hackthon;

/**
 * Created by Chell on 25-03-2018.
 */

public class Company {

    String id;
    String nameee;
    String mailee;
    String cgpaa;
    String branchh;

    public  Company(){

    }

    public Company(String id, String nameee, String mailee, String cgpaa, String branchh) {

        this.id=id;
        this.nameee=nameee;
        this.mailee=mailee;
        this.cgpaa=cgpaa;
        this.branchh=branchh;

    }

    public String getId() {
        return id;
    }

    public String getNameee() {
        return nameee;
    }

    public String getMailee() {
        return mailee;
    }

    public String getCgpaa() {
        return cgpaa;
    }

    public String getBranchh() {
        return branchh;
    }
}
