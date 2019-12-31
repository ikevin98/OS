package com.example.prjtab;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import java.util.Calendar;

import static android.content.Context.ALARM_SERVICE;
import static android.content.Intent.getIntent;

public class frag3 extends Fragment {
    public frag3() {
    }

    AlarmManager alarm_manager;
    TimePicker alarm_timepicker;
    Context context;
    PendingIntent pendingIntent;

    // Calendar 객체 생성


    // 알람리시버 intent 생성

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.activity_tab3, container, false);
        // 알람매니저 설정
        this.context=getActivity().getApplicationContext();//이곳 다시 보기
        final Calendar calendar = Calendar.getInstance();
        final Intent my_intent = new Intent(this.context, Alarm_Receiver.class);


        alarm_manager = (AlarmManager) context.getSystemService(ALARM_SERVICE);
        // 타임피커 설정
        alarm_timepicker = (TimePicker) rootView.findViewById(R.id.time_picker);
        // calendar에 시간 셋팅


        // 알람 시작 버튼
        Button alarm_on = null;

        alarm_on = (Button) rootView.findViewById(R.id.btn_start);
        alarm_on.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                calendar.set(Calendar.HOUR_OF_DAY, alarm_timepicker.getHour());
                calendar.set(Calendar.MINUTE, alarm_timepicker.getMinute());
                // 시간 가져옴
                int hour = alarm_timepicker.getHour();
                int minute = alarm_timepicker.getMinute();
                Toast.makeText(context, "Alarm 예정 " + hour + "시 " + minute + "분", Toast.LENGTH_SHORT).show();
                // reveiver에 string 값 넘겨주기
                my_intent.putExtra("state", "alarm on");
                pendingIntent = PendingIntent.getBroadcast(context, 0, my_intent, PendingIntent.FLAG_UPDATE_CURRENT);
                // 알람셋팅
                 alarm_manager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
            }
        });

       /* String name = my_intent.getStringExtra("name");
        TextView textview = (TextView) v.findViewById(R.id.textView2);
        textview.setText(name);
*/

        // 알람 정지 버튼
        Button alarm_off = null;
        alarm_off = rootView.findViewById(R.id.btn_finish);
        alarm_off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Alarm 종료", Toast.LENGTH_SHORT).show();
                // 알람매니저 취소
                alarm_manager.cancel(pendingIntent);

                my_intent.putExtra("state", "alarm off");

                // 알람취소
                context.sendBroadcast(my_intent);
            }
        });



        return rootView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}

