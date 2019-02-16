package com.example.androidtraining2019;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.BatteryManager;
import android.widget.Toast;

public class ChargingBroadcast extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,""+intent.getAction(),Toast.LENGTH_LONG).show();
//        String intentAction = intent.getAction();
//        MediaPlayer mPlayer = null;
//
//        if (intentAction != null) {
//            switch (intentAction){
//                case Intent.ACTION_POWER_CONNECTED:
//                    mPlayer = MediaPlayer.create(context, R.raw.s3_charger_connect);
//                    break;
//                case Intent.ACTION_BATTERY_LOW:
//                    mPlayer= MediaPlayer.create(context, R.raw.low_battery);
//                    break;
//                case Intent.ACTION_BATTERY_CHANGED:
//                int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
//                if(level==100)
//                    mPlayer= MediaPlayer.create(context, R.raw.charge_complete);
////                case ACTION_CUSTOM_BROADCAST:
////                    toastMessage =
////                            context.getString(R.string.custom_broadcast_toast);
////                    break;
//            }
//            if(mPlayer!=null)
//                mPlayer.start();
//        }

    }
}
