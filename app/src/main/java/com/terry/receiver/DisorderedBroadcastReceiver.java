package com.terry.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.terry.nmybroadcast.ReceiverActivity;

/**
 * Created by terry on 11/28/15.
 */
public class DisorderedBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context,Intent intent){
//        Log.d("msg", intent.getStringExtra("msg"));
        intent.setClass(context, ReceiverActivity.class);
        intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK);
//        intent.putExtra("msg",intent.getStringExtra("msg"));
        context.startActivity(intent);
//        MainActivity.this.disorderedMsg = intent.getStringExtra("msg");
//        Log.d("disorderedmsg", intent.getStringExtra("msg"));
    }

}
