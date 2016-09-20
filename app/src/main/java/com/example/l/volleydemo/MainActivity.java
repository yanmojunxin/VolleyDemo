package com.example.l.volleydemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button send=(Button)findViewById(R.id.send);
        final TextView textView=(TextView)findViewById(R.id.textview);
        final EditText editText=(EditText)findViewById(R.id.url);
        final RequestQueue requestQueue= Volley.newRequestQueue(this);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url="http://"+editText.getText().toString();
                StringRequest stringRequest=new StringRequest(url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                       textView.setText(s);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Log.d("TAG",volleyError.getMessage(),volleyError);
                    }
                });
                requestQueue.add(stringRequest);
            }
        });
    }
}
