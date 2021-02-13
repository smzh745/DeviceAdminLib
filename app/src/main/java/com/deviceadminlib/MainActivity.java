package com.deviceadminlib;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.deviceadminlibrary.DeviceAdminCall;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void checkDeviceAdminBtn(View view) {
        DeviceAdminCall.getInstance(this).activateAdmin();
    }

    public void deDeviceAdminBtn(View view) {
        DeviceAdminCall.getInstance(this).deactivateAdmin();

    }

    public void lockScreenBtn(View view) {
        DeviceAdminCall.getInstance(this).deviceLock();

    }

    public void eraseDataBtn(View view) {
        DeviceAdminCall.getInstance(this).eraseData();

    }
}