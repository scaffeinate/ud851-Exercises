package com.example.android.explicitintent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by sudhar on 10/6/17.
 */

public class ChildActivity extends AppCompatActivity {

    private TextView mDisplayTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);

        mDisplayTextView = (TextView) findViewById(R.id.tv_display);
        mDisplayTextView.setText("Hello World!");
    }
}
