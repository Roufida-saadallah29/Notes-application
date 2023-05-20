package dz.esi.tdm.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

public class DetailsActivity extends AppCompatActivity {
    TextToSpeech textToSpeech;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Note mynote= (Note) getIntent().getSerializableExtra("Note");

        SimpleDateFormat dateFormat = new SimpleDateFormat("E MMM d HH:mm:ss 'GMT' +01:00 y");

        // Set the time zone to GMT+1:00
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT+01:00"));

        // Format the current date and time as a string
        String currentDateTime = dateFormat.format(mynote.getCreationaDate());

        ImageView myimg=findViewById(R.id.imageView);
        int imageID=mynote.getIdImage();
        myimg.setImageResource(imageID);
        TextView titre=findViewById(R.id.titre);
        titre.setText(mynote.getTitre());
        TextView description=findViewById(R.id.desc);
        description.setText(mynote.getDescription()+'\n'+currentDateTime);
        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {

                // if No error is found then only it will run
                if(i!=TextToSpeech.ERROR){
                    // To Choose language of speech
                    textToSpeech.setLanguage(Locale.UK);
                }
            }
        });
        ImageView audio=findViewById(R.id.audio);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.audioanimation);
        audio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                audio.startAnimation(animation);
                textToSpeech.speak(mynote.getDescription(),TextToSpeech.QUEUE_FLUSH,null,null);
              //  textToSpeech.stop();
            }
        });
        audio.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                textToSpeech.stop();
                return false;
            }
        });
    }
}