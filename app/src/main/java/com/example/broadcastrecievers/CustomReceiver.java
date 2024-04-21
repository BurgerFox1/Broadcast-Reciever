package com.example.broadcastrecievers;

import android.util.Log;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class CustomReceiver extends BroadcastReceiver {

    private static final String TAG = "CustomReceiver";

    private static final String ACTION_CUSTOM_BROADCAST =
            BuildConfig.APPLICATION_ID + ".ACTION_CUSTOM_BROADCAST";

    @Override
    public void onReceive(Context context, Intent intent) {
        try {
            String intentAction = intent.getAction();
            String toastMessage = "Unknown intent action";

            if (intentAction != null) {
                switch (intentAction) {
                    case Intent.ACTION_HEADSET_PLUG:
                        int state = intent.getIntExtra("state", -1);
                        switch (state) {
                            case 0:
                                toastMessage = "Headset unplugged";
                                break;
                            case 1:
                                toastMessage = "Headset plugged";
                                break;
                        }
                        break;
                    case Intent.ACTION_POWER_CONNECTED:
                        toastMessage = "Power connected!";
                        break;
                    case Intent.ACTION_POWER_DISCONNECTED:
                        toastMessage = "Power disconnected!";
                        break;
                    case ACTION_CUSTOM_BROADCAST:
                        toastMessage = "Custom Broadcast Received";
                        break;
                }
            }

            Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Log.e(TAG, "Error in CustomReceiver: " + e.getMessage(), e);
        }
    }
}