package id.ac.poliban.e020320066.demobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //membuat objek button
        Button btOne = findViewById(R.id.bt1);
        Button btTwo = findViewById(R.id.bt2);
        Button btThree = findViewById(R.id.bt3);


        // memanggil button di setOnClickListener
        btOne.setOnClickListener(o ->
                Toast.makeText(this, "Hello Button 1", Toast.LENGTH_SHORT).show());

        btTwo.setOnClickListener(o ->
                Toast.makeText(this, "Hello Button 2", Toast.LENGTH_SHORT).show());

        btThree.setOnClickListener(o ->
                Toast.makeText(this, "Hello Button 3 di Klik", Toast.LENGTH_SHORT).show());

    }
}