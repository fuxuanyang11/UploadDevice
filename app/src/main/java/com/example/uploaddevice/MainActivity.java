package com.example.uploaddevice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uploadDeviceInfo();
    }


    private void uploadDeviceInfo() {

        DeviceInfoManager manager = new DeviceInfoManager(this);
        Map<String, String> requestParam = manager.getRequestParam();
        manager.setFromApp("5");
    }




}
