package com.example.a3_smd;

import android.app.Service;
import android.content.Intent;
import android.app.IntentService;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;
/**
 * Created by ishrat.fatima on 4/17/2018.
 */

public class myService extends Service {

    public static boolean isServiceRunning = false;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        try {
            Thread.sleep(10000);
            Intent i = new Intent(this, scaryPg.class);
            this.startActivity(i);
            stopSelf();
        } catch (InterruptedException e) {
            // Restore interrupt status.
            Thread.currentThread().interrupt();
        }
        return START_NOT_STICKY;
    }

    // In case the service is deleted or crashes some how
    @Override
    public void onDestroy() {
//        isServiceRunning = false;
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // Used only in case of bound services.
        return null;
    }
}