package com.forseek;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    private  static final String action1 = "com.forseek";
    private  static  final  String action2 = "forseek";

    public MyReceiver() {

    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(action1)){
            Toast.makeText(context,"MyReceiver 收到:com.forseek的广播",Toast.LENGTH_SHORT).show();

        }else if (intent.getAction().equals(action2)){
            Toast.makeText(context,"MyReceiver 收到:forseek的广播",Toast.LENGTH_SHORT).show();
        }
    }
}
