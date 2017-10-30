package com.example.bccenten.httpsocketpowertest;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private TextView inputTextView;
    private TextView outputTextView;

    private String response;

    private Switch outlet1;
    private Switch outlet2;
    private Switch outlet3;
    private Switch outlet4;
    private Switch outlet5;
    private Switch outlet6;
    private List<Switch> outlets;

    private Client clientObject;
    private List<Device> deviceObjects;

    private ToggleButton urlToggle;


    private FormatConversion fc;

    private String urlTest;
    private String clientJson;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instantiateGuiComponents();
        urlTest = getString(R.string.urlTest);
        clientObject = new Client();
        deviceObjects = new ArrayList<>();

        fc = new FormatConversion();
//
        clientJson = getString(R.string.sampleClient);
//
        clientObject = fc.convertJsonToClient(clientJson);
        deviceObjects = clientObject.getDevices();

        attachListener();
    }

    private void instantiateGuiComponents() {
        urlToggle = findViewById(R.id.urlToggle);
        inputTextView = findViewById(R.id.inputTextView);
        outputTextView = findViewById(R.id.outputTextView);

        outlet1 = findViewById(R.id.outlet1);
        outlet2 = findViewById(R.id.outlet2);
        outlet3 = findViewById(R.id.outlet3);
        outlet4 = findViewById(R.id.outlet4);
        outlet5 = findViewById(R.id.outlet5);
        outlet6 = findViewById(R.id.outlet6);

        outlets = new ArrayList<>();

        outlets.add(outlet1);
        outlets.add(outlet2);
        outlets.add(outlet3);
        outlets.add(outlet4);
        outlets.add(outlet5);
        outlets.add(outlet6);

    }

    public void attachListener() {

        urlToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    urlTest = "https://socketpowerbackend.herokuapp.com/webapi/services/test";
                    //urlTest = "http://10.0.2.2:8080/webapi/services/test";
                } else {
                    urlTest = "http://10.0.2.2:8080/webapi/services/test";

                }
            }
        });





        outlet1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    deviceObjects.get(0).getOutlets().get(0).setOutlet_status(true);
                    Outlet outlet = deviceObjects.get(0).getOutlets().get(0);
                    String command = fc.convertOutletToJson(outlet);
                    inputTextView.setText(command);

                    try {
                        outputTextView.setText(new TestCommand().execute(command).get());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }

                } else {
                    deviceObjects.get(0).getOutlets().get(0).setOutlet_status(false);
                    String jsonCommand = fc.convertOutletToJson(deviceObjects.get(0).getOutlets().get(0));
                    inputTextView.setText(jsonCommand);
                    new TestCommand().execute(jsonCommand);
                    outputTextView.setText(response);

                    try {
                        outputTextView.setText(new TestCommand().execute(jsonCommand).get());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }


                }
            }
        });


    }

    public class TestCommand extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {

            try {

                String jsonCommand = strings[0];
                //String testCommand = "{\"yo\": 9}";

                //Create client object
                OkHttpClient client = new OkHttpClient();

                //Transport the request and wait for response to process next
                RequestBody body =
                        RequestBody.create(MediaType.parse("application/json; charset=utf-8"), jsonCommand);

                Request request = new Request.Builder()
                        .url(urlTest)
                        .post(body)
                        .build();
                Response response = client.newCall(request).execute();

                return response.body().string();

            } catch (java.io.IOException e) {
                e.printStackTrace();
            }

            return "ERROR";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }


    }

//    public class FeedTask extends AsyncTask<String, Void, String> {
//
//        @Override
//        protected String doInBackground(String... params) {
//            try {
//
//                String jsonCommand = params[0];
//
//                //Create client object
//                OkHttpClient client = new OkHttpClient();
//
//                //Transport the request and wait for response to process next
//                RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), jsonCommand);
//
//                Request request = new Request.Builder()
//                        .url("https://socketpowerbackend.herokuapp.com/webapi/services/test")
//                        .post(body)
//                        .build();
//                Response response = client.newCall(request).execute();
//                return response.body().string();
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            return null;
//        }
//
//        @Override
//        protected void onPostExecute(String s) {
//            super.onPostExecute(s);
//            response = s;
//        }
//
//    }
}


