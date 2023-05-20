package dz.esi.tdm.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // int theme =getTheme(R.style.Theme_Notes2);// R.style.AppTheme_RED
        setTheme(R.style.Theme_NotesNoactionBarr);
        setContentView(R.layout.activity_splash);
        ImageView spl=findViewById(R.id.spl);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.splashanimation);
        spl.startAnimation(animation);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intr= new Intent(SplashActivity.this,MainActivity.class);
                startActivity(intr);
                finish();

            }
        },4000);
    }
}