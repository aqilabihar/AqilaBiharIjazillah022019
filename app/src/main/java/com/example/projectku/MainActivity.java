package com.example.projectku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    EditText KGUsername;
    EditText KGPassword;
    Button Login;

    private View decorview;


    ImageView Logo;
    TextView welcome;
    LinearLayout Suprise;

    Handler handler = new Handler();

    Runnable runable = new Runnable() {
        @Override
        public void run() {
            Suprise.setVisibility(View.VISIBLE);
        }
    };
    Runnable runable1 = new Runnable() {
        @Override
        public void run() {
            Logo.setVisibility(View.VISIBLE);
        }
    };
    Runnable runable2 = new Runnable() {
        @Override
        public void run() {
            welcome.setVisibility(View.GONE);
        }
    };


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // call id
        KGUsername = (EditText) findViewById(R.id.KNUsername);
        KGPassword = (EditText) findViewById(R.id.KNPassword);
        Login = (Button) findViewById(R.id.Login);
        Suprise = (LinearLayout) findViewById(R.id.Suprise);
        Logo = (ImageView) findViewById(R.id.Logo);
        welcome = (TextView) findViewById(R.id.welcome);

        // logger
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (KGUsername.getText().toString().equalsIgnoreCase("aqila")|
                    KGPassword.getText().toString().equalsIgnoreCase("aqila")){
                    Intent pind = new Intent(MainActivity.this,Main_Menu_Activity.class);
                }else{
                    Toast.makeText(MainActivity.this,"akun belum terdaftar",Toast.LENGTH_SHORT).show();
                }
            }
        });



        //hide bar
        decorview = getWindow().getDecorView();
        decorview.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
            @Override
            public void onSystemUiVisibilityChange(int visibility) {
                if (visibility == 0)
                    decorview.setSystemUiVisibility(hideSystemBars());
            }
        });


        //Timer outView
        handler.postDelayed(runable1, 4000);
        handler.postDelayed(runable, 6000);
        handler.postDelayed(runable2, 2000);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus){
            decorview.setSystemUiVisibility(hideSystemBars());
        }
    }
    private int hideSystemBars(){
        return View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                |View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                |View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                |View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                |View.SYSTEM_UI_FLAG_FULLSCREEN
                |View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;

    }
}