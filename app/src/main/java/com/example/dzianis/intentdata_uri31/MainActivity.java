package com.example.dzianis.intentdata_uri31;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button web, call, map;
    private EditText editTextWeb, editTextCall, editTextMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextWeb = (EditText) findViewById(R.id.editTextWeb);
        editTextCall = (EditText) findViewById(R.id.editTextCall);
        editTextMap = (EditText) findViewById(R.id.editTextMap);

        web = (Button) findViewById(R.id.web);
        call = (Button) findViewById(R.id.call);
        map = (Button) findViewById(R.id.map);

        web.setOnClickListener(this);
        call.setOnClickListener(this);
        map.setOnClickListener(this);

        findViewById(R.id.btnMyWeb).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://" + getValue(editTextWeb))));
            }
        });
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()){
            case R.id.web:
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://" + getValue(editTextWeb)));
                break;
            case R.id.call:
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + getValue(editTextCall)));
                break;
            case R.id.map:
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:" + getValue(editTextMap)));
                break;
        }
        startActivity(intent);
    }

    private String getValue(EditText editText){
        return editText.getText().toString();
    }
}
