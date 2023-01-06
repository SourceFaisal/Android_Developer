package id.ac.poliban.e020320066.transitionsandanimations5_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the views.
        ImageView redBlock = findViewById(R.id.redBlock);
        ImageView blueBlock = findViewById(R.id.blueBlock);
        ImageView yellowBlock = findViewById(R.id.yellowBlock);
        ImageView androidBlock = findViewById(R.id.androidBlock);


        // Set the methods from the base class to the appropriate ImageViews.
        explodeTransition(this, redBlock);
        fadeTransition(this, blueBlock);
        rotateView(yellowBlock);
        switchAnimation(androidBlock,blueBlock,new Intent(
                this, SecondActivity.class),this);
    }

    private void switchAnimation(ImageView androidBlock, ImageView blueBlock, Intent intent, MainActivity mainActivity) {
    }

    private void rotateView(ImageView yellowBlock) {
    }

    private void explodeTransition(MainActivity mainActivity, ImageView redBlock) {
    }

    private void fadeTransition(MainActivity mainActivity, ImageView blueBlock) {
    }

}