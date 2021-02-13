package com.deviceadminlibrary;

import android.content.Context;
import android.content.Intent;
import android.os.UserHandle;

/**
 * Created by HP# on 10/07/2018.
 */

public class DeviceAdminReceiver extends android.app.admin.DeviceAdminReceiver {

    public DeviceAdminReceiver() {
        super();
    }

    @Override
    public void onEnabled(Context context, Intent intent) {
        super.onEnabled(context, intent);
    }

    @Override
    public CharSequence onDisableRequested(Context context, Intent intent) {
        return super.onDisableRequested(context, intent);
    }

    @Override
    public void onPasswordChanged(Context context, Intent intent, UserHandle user) {
        super.onPasswordChanged(context, intent, user);
    }

    @Override
    public void onDisabled(Context context, Intent intent) {
        super.onDisabled(context, intent);
    }
}
