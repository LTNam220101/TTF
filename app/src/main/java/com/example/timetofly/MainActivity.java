package com.example.timetofly;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private boolean isMute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAGS_CHANGED,
                WindowManager.LayoutParams.FLAGS_CHANGED);
        setContentView(R.layout.activity_main);
        findViewById(R.id.play).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, GameActivity.class));
            }
        });
        TextView highScoretxt = findViewById(R.id.highScoreTxt);

        SharedPreferences pref = getSharedPreferences("game", MODE_PRIVATE);
        highScoretxt.setText("HighScore " + pref.getInt("highscore", 0));

        isMute = pref.getBoolean("isMute", false);
        ImageView volumeCtrl = findViewById(R.id.volumeCtrl);
        volumeCtrl.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
              if(isMute)
                  volumeCtrl.setImageResource(R.drawable.ic_baseline_volume_off_24);
              else
                  volumeCtrl.setImageResource(R.drawable.ic_baseline_volume_up_24);
                SharedPreferences.Editor editor = pref.edit();
                editor.putBoolean("isMute", isMute);
                editor.apply();
              }
          }
        );
    }
}