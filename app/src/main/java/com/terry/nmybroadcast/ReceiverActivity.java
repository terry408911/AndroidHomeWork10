package com.terry.nmybroadcast;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;


/**
 * Created by terry on 11/27/15.
 */
public class ReceiverActivity extends Activity {
    TextView textView;
    TextView textView2;
//    NoOrderBroadcastReceiver noOrderBroadcastReceiver;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.no_order_receiver_activity);
        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);

        Intent intent = getIntent();
        textView.setText(textView.getText()+intent.getStringExtra("title"));
        textView2.setText(textView2.getText()+intent.getStringExtra("content"));
//        IntentFilter intentFilter = new IntentFilter();
//        intentFilter.addAction("com.terry.nmybroadcast.MY_NO_ORDER_BROADCAST");
//        noOrderBroadcastReceiver = new NoOrderBroadcastReceiver();
//        registerReceiver(noOrderBroadcastReceiver, intentFilter);

    }

//    class NoOrderBroadcastReceiver extends BroadcastReceiver {
//
//        @Override
//        public void onReceive(Context context, Intent intent) {
//            ReceiverActivity.this.textView.setText(intent.getStringExtra("msg"));
//        }
//    }

}