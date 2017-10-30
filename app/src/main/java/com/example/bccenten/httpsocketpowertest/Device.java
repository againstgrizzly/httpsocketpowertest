package com.example.bccenten.httpsocketpowertest;

/**
 * Created by bccenten on 10/29/2017.
 */

import java.util.List;

public class Device {

    private String device_id;
    private String access_token;
    private List<Outlet> outlets;

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public List<Outlet> getOutlets() {
        return outlets;
    }

    public void setOutlets(List<Outlet> outlets) {
        this.outlets = outlets;
    }
}
