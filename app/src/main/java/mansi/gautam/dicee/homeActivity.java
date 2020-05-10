package mansi.gautam.dicee;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import java.util.Random;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Build;



public class homeActivity extends AppCompatActivity {
private static int splashtime=4000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        new Handler() .postDelayed(new Runnable(){
            @Override
            public void run (){
                Intent homeintent = new Intent (homeActivity.this, MainActivity.class);
                startActivity(homeintent);
                finish();
            }

        } ,splashtime);


    }
}
