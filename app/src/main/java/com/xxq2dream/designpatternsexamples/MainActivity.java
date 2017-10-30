package com.xxq2dream.designpatternsexamples;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.xxq2dream.designpatternsexamples.decorator_pattern.NotifyProxy;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button btnNotify;
    private ListView listView;

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

    class Adapter extends BaseAdapter {
        private List<String> mDatas;

        public Adapter(List<String> datas) {
            mDatas = datas;
        }

        @Override
        public int getCount() {
            return mDatas.size();
        }

        @Override
        public long getItemId(int position) { return position; }

        @Override
        public Object getItem(int position) { return mDatas.get(position);}

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if (convertView == null) {
                //初始化View
            }
            //初始化数据

            return convertView;
        }
    }
}
