package com.example.bccenten.httpsocketpowertest;

/**
 * Created by bccenten on 10/29/2017.
 */

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class FormatConversion {

    private ObjectMapper mapper;

    public Device convertJsonToDevice(String json){

        mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Device device = null;
        try {
            device = mapper.readValue(json, Device.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return device;
    }

    public Client convertJsonToClient(String json) {
        mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Client client = null;
        try {
            client = mapper.readValue(json, Client.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return client;
    }

    public Outlet convertJsonToOutlet(String json) {
        Outlet outlet = null;
        try {
            mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            outlet = mapper.readValue(json, Outlet.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return outlet;
    }

    public String convertDeviceToJson(Device device) {
        String deviceJson = "";
        mapper = new ObjectMapper();
        try {
            deviceJson = mapper.writeValueAsString(device);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return deviceJson;
    }

    public String convertClientToJson(Client client) {
        String clientJson = "";
        mapper = new ObjectMapper();
        try {
            clientJson = mapper.writeValueAsString(client);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return clientJson;
    }

    public String convertOutletToJson(Outlet outlet) {
        String outletJson = "";
        mapper = new ObjectMapper();
        try {
            outletJson = mapper.writeValueAsString(outlet);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return outletJson;
    }

}