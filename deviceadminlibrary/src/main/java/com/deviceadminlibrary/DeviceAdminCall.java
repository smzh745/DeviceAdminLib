package com.deviceadminlibrary;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class DeviceAdminCall {
    private DevicePolicyManager dpm;
    private ComponentName mDeviceAdminSample;
    private static Context mCtx;
    private static DeviceAdminCall mInstance;

    private DeviceAdminCall(Context context) {
        mCtx = context;
        mDeviceAdminSample = new ComponentName(mCtx, DeviceAdminReceiver.class);
        dpm = (DevicePolicyManager) mCtx.getSystemService(Context.DEVICE_POLICY_SERVICE);
    }

    public static synchronized DeviceAdminCall getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new DeviceAdminCall(context);
        }
        return mInstance;
    }

    public void deviceLock() {
        if (dpm.isAdminActive(mDeviceAdminSample)) {
            dpm.lockNow();
        } else {
            showToast("Please enable device admin permission first!");

        }
    }

    public void eraseData() {
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case DialogInterface.BUTTON_POSITIVE:
                        //Yes button clicked
                        if (dpm.isAdminActive(mDeviceAdminSample)) {
                            dpm.wipeData(1);
                        } else {
                            showToast("Please enable device admin permission first!");
                        }
                        break;

                    case DialogInterface.BUTTON_NEGATIVE:
                        //No button clicked
                        dialog.dismiss();
                        break;
                }
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(mCtx);
        builder.setMessage("Are you sure you want to erase data?").setPositiveButton("Yes", dialogClickListener)
                .setNegativeButton("No", dialogClickListener).show();

    }

    public void activateAdmin() {
        if (!dpm.isAdminActive(mDeviceAdminSample)) {
            Intent intent = new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
            intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, mDeviceAdminSample);
            intent.putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION,
                    "For Erase data,Lock Phone and Password Change");
            ((AppCompatActivity) mCtx).startActivityForResult(intent, 15);


        }
    }


    public void deactivateAdmin() {
        if (dpm.isAdminActive(mDeviceAdminSample)) {
            dpm.removeActiveAdmin(mDeviceAdminSample);
        }

    }

    public void showToast(String msg) {
        Toast.makeText(mCtx, msg, Toast.LENGTH_SHORT).show();
    }
}
