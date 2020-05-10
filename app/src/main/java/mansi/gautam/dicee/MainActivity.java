package mansi.gautam.dicee;

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


public class MainActivity extends AppCompatActivity {

    private int mrollSoundId;
    private static  int splashtime =4000;

    int roll, number1,number2;
   // @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button rollbutton;
        rollbutton = (Button) findViewById(R.id.rollbutton);

        final ImageView leftDice,rightDice;
        leftDice = (ImageView) findViewById(R.id.image_leftDice);
        rightDice = (ImageView) findViewById(R.id.image_rightDice);
        final int[] dicearray= {
                R.drawable.dice1,
                R.drawable.dice2,
                R.drawable.dice3,
                R.drawable.dice4,
                R.drawable.dice5,
                R.drawable.dice6
                         };
        // TODO: Create a new SoundPool
        AudioAttributes audioAttributes = new AudioAttributes.Builder()
                                        .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                                        .setUsage(AudioAttributes.USAGE_MEDIA)
                                        .build();
     final    SoundPool msoundpool = new SoundPool.Builder()
                .setMaxStreams(7)
                .setAudioAttributes(audioAttributes)
                .build();
        // TODO: Load and get the IDs to identify the sounds
        mrollSoundId=msoundpool.load(getApplicationContext(),R.raw.roll21,1);



        rollbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d ("Dicee","The button has been pressed!");
                msoundpool.play(mrollSoundId,1.0f,1.0f,0,0,1.0f);
                Random randomNumberGenerator = new Random();
                number1 = randomNumberGenerator.nextInt(6);
                Log.d ("Dicee","The random number for left dice is "+ number1);
                leftDice.setImageResource(dicearray[number1]);
                number2 = randomNumberGenerator.nextInt(6);
                Log.d ("Dicee","The random number for right dice is "+ number2);
                rightDice.setImageResource(dicearray[number2]);
                condition( number1,number2);

            }

        });


    }
    private void condition (int x ,int y ) {
        if (x == y) {

       final     AlertDialog.Builder alert1 = new AlertDialog.Builder(this,R.style.MyDialogTheme);
            alert1.setCancelable(false);

            alert1.setTitle("Same Roll!!!");
            alert1.setMessage(" Do you want to continue ?");
            alert1.setNegativeButton("CLOSE APPLICATION", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            });
            alert1.setPositiveButton("CONTINUE TO PLAY", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();

                }
            });
            alert1.show();

        }
    }

}
