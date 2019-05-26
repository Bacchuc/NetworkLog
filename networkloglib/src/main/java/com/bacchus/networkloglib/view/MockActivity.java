package com.bacchus.networkloglib.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Build;
import android.os.Bundle;

import com.bacchus.networkloglib.R;

public class MockActivity extends AppCompatActivity {

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mock);
        initView();
    }

    private void initView() {
        mToolbar = findViewById(R.id.toolbar);

        initToolbar();
    }

    private void initToolbar(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mToolbar.setTitle("模拟数据");
        }
        //设置toolbar
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationIcon(R.drawable.back);
    }
}
