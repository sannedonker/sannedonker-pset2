package com.example.gebruiker.sannedonker_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CompletedStoryActivity extends AppCompatActivity {

    Story story;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_completed_story);

        Intent intent = getIntent();
        story = (Story) intent.getSerializableExtra("full_story");

        // set the full story to the TextView story_text
        ((TextView) findViewById(R.id.story_text)).setText(story.toString());
    }

    // makes sure that when pressed back the user goes to the ChooseActivity screen
    @Override
    public void onBackPressed()
    {
        Intent intent = new Intent(CompletedStoryActivity.this, ChooseActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    // when the button is clicked the user goes to the ChooseActivity screen
    public void newStory(View view) {
        Intent intent = new Intent(CompletedStoryActivity.this, ChooseActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
