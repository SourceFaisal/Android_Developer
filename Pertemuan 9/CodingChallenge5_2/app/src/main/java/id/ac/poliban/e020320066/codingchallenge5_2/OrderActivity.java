package id.ac.poliban.e020320066.codingchallenge5_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        if (getSupportActionBar()!=null)getSupportActionBar().setTitle("Detail Material Me!");

        TextView sportsTitle = findViewById(R.id.titleDetail);
        ImageView sportsImage = findViewById(R.id.sportsImageDetail);
        TextView sportsDetail = findViewById(R.id.subTitleDetail);

        Intent intent = getIntent();
        String titleString = intent.getStringExtra("title");
        int imageInt = intent.getIntExtra("image_resource", 0);
        String details = intent.getStringExtra("details");

        sportsTitle.setText(titleString);
        Glide.with(this).load(imageInt).into(sportsImage);
        sportsDetail.setText(details);
    }

}