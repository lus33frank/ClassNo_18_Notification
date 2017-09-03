package tw.com.frankchang.houli.classno_18_notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    NotificationManager ntfiManager;

    private final int NTFI_ID = 9999;
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();

        ntfiManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }

    public void sendOnClick(View view) {
        count++;
        Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.cartoon);

        Notification ntfi =new Notification.Builder(this)
                .setLargeIcon(bmp)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("標題")
                .setContentText("詳細文字")
                .setTicker("我是 Notification")
                .setContentInfo(String.valueOf(count))
                .setWhen(System.currentTimeMillis())
                .setVibrate(new long[]{300,500,300,1000})
                .setProgress(100,50,true)
                .setPriority(Notification.PRIORITY_MAX)
                .setOngoing(true)
                .build();

        ntfiManager.notify(NTFI_ID, ntfi);
    }

    public void cancelOnClick(View view) {
        ntfiManager.cancel(NTFI_ID);
    }
}
