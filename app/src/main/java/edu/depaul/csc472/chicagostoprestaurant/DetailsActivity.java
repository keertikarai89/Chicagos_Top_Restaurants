package edu.depaul.csc472.chicagostoprestaurant;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RatingBar;
import android.widget.TextView;

public class DetailsActivity extends Activity {

    private static final String TAG = "DetailsActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Log.d(TAG, "onCreate");
    }

    @Override
    protected void onStart() {
        Log.d(TAG, "onStart");

        super.onStart();
        // The activity is about to become visible.
        Intent intent = getIntent();
        if (intent != null) {
            TextView name = findViewById(R.id.text1);
            TextView description = findViewById(R.id.text2);
            //TextView website = findViewById(R.id.text3);
            //RatingBar rating = findViewById(R.id.rating);
            //ImageView icon = findViewById(R.id.image);
            name.setText(intent.getCharSequenceExtra("RestaurantName"));
            description.setText(intent.getCharSequenceExtra("RestaurantDescription"));
            //website.setText(intent.getCharSequenceExtra("RestaurantWebsite"));
            //rating.setRating(intent.getFloatExtra("RestaurantRating", 4));
            //icon.setImageResource(intent.getIntExtra("RestaurantIcon", -1));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
