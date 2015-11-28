package com.terry.nmybroadcast;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.terry.receiver.DisorderedBroadcastReceiver;
import com.terry.receiver.OrderedReceiver;

public class MainActivity extends AppCompatActivity {
    DisorderedBroadcastReceiver disorderedBroadcastReceiver;
    OrderedReceiver orderedBroadcastReceiver;


    EditText editText;
    EditText title;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.button);
        Button button2 = (Button)findViewById(R.id.button2);
        Button button3 = (Button)findViewById(R.id.button3);
        editText = (EditText)findViewById(R.id.editText);
        title = (EditText) findViewById(R.id.editText3);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //                init and register NoOrderBroadcast

                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.terry.nmybroadcast.MY_NO_ORDER_BROADCAST");
                disorderedBroadcastReceiver = new DisorderedBroadcastReceiver();
                registerReceiver(disorderedBroadcastReceiver, intentFilter);

//                sent broadcast

                Intent intent = new Intent();
                intent.setAction("com.terry.nmybroadcast.MY_NO_ORDER_BROADCAST");
                intent.putExtra("title", title.getText().toString());
                intent.putExtra("content",editText.getText().toString());
                sendBroadcast(intent);


            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.terry.broadcast.MY_ORDERED_BROADCAST");
                orderedBroadcastReceiver = new OrderedReceiver();
                registerReceiver(disorderedBroadcastReceiver, intentFilter);

//                sent broadcast

                Intent intent1 = new Intent();
                intent1.setAction("com.terry.broadcast.MY_ORDERED_BROADCAST");
                intent1.putExtra("title", title.getText().toString());
                intent1.putExtra("content", editText.getText().toString());
                sendOrderedBroadcast(intent1, null);
            }
        });


        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(MainActivity.this, LocalChangeActivity.class);
                startActivity(intent3);
            }
        });


    }


    public void onDestroy(){
        super.onDestroy();
        unregisterReceiver(disorderedBroadcastReceiver);
    }

}
