package com.example.gebruiker.sannedonker_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FillActivity extends AppCompatActivity {

    Story story;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill);

        Intent intent = getIntent();
        story = (Story) intent.getSerializableExtra("story_clicked");

        // set the number of words left and the type of word you need to fill in
        ((TextView) findViewById(R.id.word_count)).setText(
                    story.getPlaceholderRemainingCount() + " word(s) left");
        ((TextView) findViewById(R.id.word_type)).setText(
                    "please type a/an " + story.getNextPlaceholder().toLowerCase());
    }

    public void admitWord(View view) {

        // safes the typed word in a string
        String word = ((TextView) findViewById(R.id.typed_word)).getText().toString();

        // if a word is filled in proceed otherwise clicking the button won't work
        if (word.equals("") == false) {
            story.fillInPlaceholder(word);

            // if all the placeholders are filled, gives the full story to CompletedStoryActivity
            if (story.isFilledIn()){
                Intent intent = new Intent(FillActivity.this,
                                            CompletedStoryActivity.class);
                intent.putExtra("full_story", story);
                startActivity(intent);
            }

            // set the new values of words left, type of word and entry field
            else {
                ((TextView) findViewById(R.id.word_count)).setText(
                            story.getPlaceholderRemainingCount() + " word(s) left");
                ((TextView) findViewById(R.id.word_type)).setText(
                            "please type a/an " + story.getNextPlaceholder().toLowerCase());
                ((TextView) findViewById(R.id.typed_word)).setText("");
            }
        }
    }
}
