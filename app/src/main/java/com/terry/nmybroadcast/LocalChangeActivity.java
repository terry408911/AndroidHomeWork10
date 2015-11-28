package com.terry.nmybroadcast;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by terry on 11/28/15.
 */
public class LocalChangeActivity extends Activity {

    private IntentFilter intentFilter;
    private LocalChangeReceiver localChangeReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.local_changed);
        intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.LOCALE_CHANGED");
        localChangeReceiver = new LocalChangeReceiver();
        registerReceiver(localChangeReceiver,intentFilter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(localChangeReceiver);
    }

    class LocalChangeReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context,Intent intent){
            Log.d("LocalChangeReceiver", "语言已切换");
        }
    }
}
