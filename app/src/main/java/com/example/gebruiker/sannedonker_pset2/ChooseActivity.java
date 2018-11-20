package com.example.gebruiker.sannedonker_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.InputStream;


public class ChooseActivity extends AppCompatActivity {

    // instantiate story, list with story id's and list with raw's
    Story story;
    int stories_id[] = {R.id.simple, R.id.tarzan, R.id.university,
                        R.id.clothes, R.id.dance};
    int stories_raw[] = {R.raw.madlib0_simple, R.raw.madlib1_tarzan, R.raw.madlib2_university,
                         R.raw.madlib3_clothes, R.raw.madlib4_dance};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
    }

    public void storyClicked(View view) {

        // checks which button is clicked and safes the clicked story
        for (int i = 0; i < stories_id.length; i++) {
            if (view.getId() == stories_id[i]) {
                InputStream is = getResources().openRawResource(stories_raw[i]);
                story = new Story(is);
                break;
            }
        }

        // gives the clicked story to the FillActivity class
        Intent intent = new Intent(ChooseActivity.this, FillActivity.class);
        intent.putExtra("story_clicked", story);
        startActivity(intent);
    }
}
