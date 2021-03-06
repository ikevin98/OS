package com.example.prjtab;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

public class Alarm_Receiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {

            // intent로부터 전달받은 string
            String get_your_string = intent.getExtras().getString("state");
            Log.i("info",get_your_string);
            // RingtonePlayingService 서비스 intent 생성
            Intent service_intent = new Intent(context , RingtonePlayingService.class);

            // RingtonePlayinService로 extra string값 보내기
            service_intent.putExtra("state", get_your_string);
            // start the ringtone service
            Log.i("info",get_your_string);

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O){
        Log.i("info","startforegroungservice");
        context.startForegroundService(service_intent);
    }
            else {

                Log.i("info", "startservice");
                context.startService(service_intent);

            }
        }
    }
