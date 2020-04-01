package com.example.basics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;

public class MyReciever extends BroadcastReceiver {
    MediaPlayer myplayer;
    @Override
    public void onReceive(Context context, Intent intent) {
        myplayer=MediaPlayer.create(context,R.raw.photo);
        myplayer.start();

    }
}
