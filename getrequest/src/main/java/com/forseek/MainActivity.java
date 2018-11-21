package com.forseek;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class MainActivity extends Activity {
    private EditText content;
    private Handler handler;
    private  String result = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        content = (EditText) findViewById(R.id.content);
        final TextView resultTV = (TextView) findViewById(R.id.result);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if ("".equals(content.getText().toString())){
                    Toast.makeText(MainActivity.this,"请输入要发表的内容!",Toast.LENGTH_SHORT).show();
                    return;
                }
                handler = new Handler(){
                    @Override
                    public void handleMessage(Message msg) {
                        if (result != null){
                            resultTV.setText(result);
                            content.setText("");
                        }
                        super.handleMessage(msg);
                    }
                };
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        send();
                        Message m = handler.obtainMessage();
                        handler.sendMessage(m);
                    }
                }).start();
            }
        });
    }
    public void send(){
        String target = "";
//        target = "http://192.168.1.198:8080/example/get.jsp?content="
//                + base64(content.getText().toString().trim());
        target = "https://www.baidu.com/s?wd="+base64(content.getText().toString().trim());
        URL url;
        try {
            url = new URL(target);
            HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
            InputStreamReader in = new InputStreamReader(urlConn.getInputStream());
            BufferedReader buffer = new BufferedReader(in);
            String inputLine = null;
            while ((inputLine=buffer.readLine())!=null){
                result += inputLine + "\n";
            }
            in.close();
            urlConn.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public String base64(String content){
        try {
            content = Base64.encodeToString(content.getBytes("utf-8"),Base64.DEFAULT);
            content = URLEncoder.encode(content,"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return content;
    }
}
