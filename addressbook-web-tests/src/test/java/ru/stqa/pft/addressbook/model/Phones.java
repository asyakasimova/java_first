package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;

/**
 * Created by Valkyrja on 27.03.2016.
 */
public class Phones {
    @Expose
    public String work;
    @Expose
    public String home;
    @Expose
    public String mobile;

    public String getWork() {
        return work;
    }

    public Phones withWork(String work) {
        this.work = work;
        return this;
    }

    public String getHome() {
        return home;
    }

    public Phones withHome(String home) {
        this.home = home;
        return this;
    }

    public String getMobile() {
        return mobile;
    }

    public Phones withMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }
}
