package com.sunil.examplesofandroid5;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by Sunil on 03-03-2017.
 */
public class MyService extends Service{

    private MediaPlayer player;

    public void onCreate(){
        super.onCreate();
        Toast.makeText(this,"My Service Created",Toast.LENGTH_SHORT).show();

        //player = MediaPlayer.create(this,R.raw.dou);
        player.setLooping(false);
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent)
    {
        return null;
    }
    @Override
    public int onStartCommand(Intent intent,int flags,int startId){
        Toast.makeText(this,"My Service Started",Toast.LENGTH_SHORT).show();
        player.start();
        return START_STICKY;
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        Toast.makeText(this,"My service Stoped",Toast.LENGTH_SHORT).show();
        player.stop();
    }
}
