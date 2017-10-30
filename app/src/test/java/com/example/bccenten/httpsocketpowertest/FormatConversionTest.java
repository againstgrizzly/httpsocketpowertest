package com.example.bccenten.httpsocketpowertest;


import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bccenten on 10/30/2017.
 */

public class FormatConversionTest {

    Client client;
    Device device;
    Outlet outlet;
    FormatConversion fc;

    String clientJson;

    @Before
    public void setup(){

        clientJson = "{\"client_id\":1,\"firstname\":\"John\",\"lastname\":\"Smith\",\"email\":\"comeatmebro@sample.com\",\"username\":\"dudebro64\",\"password\":\"password\",\"date_of_birth\":\"1911-11-11\",\"phonenumber\":1112223333,\"devices\":[{\"device_id\":\"460028000751353530373132\",\"access_token\":\"9753c88bb2723d4a882497bc80627a62270cb683\",\"outlets\":[{\"outlet_id\":1,\"outlet_status\":false,\"device_id\":\"460028000751353530373132\"},{\"outlet_id\":2,\"outlet_status\":false,\"device_id\":\"460028000751353530373132\"},{\"outlet_id\":3,\"outlet_status\":false,\"device_id\":\"460028000751353530373132\"},{\"outlet_id\":4,\"outlet_status\":false,\"device_id\":\"460028000751353530373132\"},{\"outlet_id\":5,\"outlet_status\":false,\"device_id\":\"460028000751353530373132\"},{\"outlet_id\":6,\"outlet_status\":false,\"device_id\":\"460028000751353530373132\"}]}]}";

        client = new Client();
        client.setClient_id(1);
        client.setFirstname("John");
        client.setLastname("Smith");
        client.setUsername("dudebro64");

        client.setDate_of_birth(new Date(19111111));

        client.setPassword("password");
        client.setEmail("coolguy@example.com");

        device = new Device();
        device.setDevice_id("1111");
        device.setAccess_token("1111");

        outlet = new Outlet();
        outlet.setDevice_id("1111");
        outlet.setOutlet_id(1);
        outlet.setOutlet_status(false);

        List<Outlet> outlets = new ArrayList<>();
        outlets.add(outlet);
        device.setOutlets(outlets);

        List<Device> devices = new ArrayList<>();
        devices.add(device);
        client.setDevices(devices);

        fc = new FormatConversion();


    }

    @After
    public void teardown(){

    }

    @Test
    public void convertClientToJsonTest(){
        String clientJson = fc.convertClientToJson(client);
        System.out.println(clientJson);
        Assert.assertTrue(true);
    }

    @Test
    public void convertDeviceToJsonTest(){

    }

    @Test
    public void convertOutletToJsonTest(){


    }

    @Test
    public void convertJsonToClientTest(){
        Client client;

        client = fc.convertJsonToClient(clientJson);

        Assert.assertEquals("John", client.getFirstname());
    }



}
