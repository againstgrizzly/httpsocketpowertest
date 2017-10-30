package com.example.bccenten.httpsocketpowertest;

/**
 * Created by bccenten on 10/29/2017.
 */

public class Outlet {

    private int outlet_id;
    private boolean outlet_status;
    private String device_id;

    public int getOutlet_id() {
        return outlet_id;
    }

    public void setOutlet_id(int outlet_id) {
        this.outlet_id = outlet_id;
    }

    public boolean isOutlet_status() {
        return outlet_status;
    }

    public void setOutlet_status(boolean outlet_status) {
        this.outlet_status = outlet_status;
    }

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    @Override
    public String toString() {
        return "Outlet{" +
                "outlet_id=" + outlet_id +
                ", outlet_status=" + outlet_status +
                ", device_id='" + device_id + '\'' +
                '}';
    }
}