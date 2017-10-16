package com.xxq2dream.designpatternsexamples;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.xxq2dream.designpatternsexamples.proxy_pattern.notify.NotifyProxy;

public class MainActivity extends AppCompatActivity {

    private Button btnNotify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNotify = (Button) findViewById(R.id.btn_notify);
        btnNotify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new NotifyProxy(MainActivity.this).send();
            }
        });
    }
}
