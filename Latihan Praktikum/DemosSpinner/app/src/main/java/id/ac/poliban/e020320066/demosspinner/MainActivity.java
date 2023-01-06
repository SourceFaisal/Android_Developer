package id.ac.poliban.e020320066.demosspinner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.main_menu:
                displayToast("i'm in breakfast");
                break;
            case R.id.main_menu2:
                displayToast("i'm in Lunch");
                break;
            case R.id.main_menu3:
                displayToast("i'm in Dinner");
                break;
            case R.id.main_menu4:
                displayToast("i'm in Meeting");
                break;
            case R.id.main_menu5:
                displayToast("i'm in party");
                break;
        }
        return true;
    }

    private void displayToast(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu,
                                    View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.context_edit:
                displayToast1(getString(R.string.edit_message));
                return true;
            case R.id.context_share:
                displayToast1(getString(R.string.share_message));
                return true;
            case R.id.context_delete:
                displayToast1(getString(R.string.delete_message));
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    private void displayToast1(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();;
    }

    public void onClickShowAlert(View view) {
        AlertDialog.Builder builder =
                new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Anda ingin pesan?")
                .setTitle("Black Coffe")
                .setIcon(R.drawable.cafe)
                .setPositiveButton("Pesan", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(MainActivity.this, "Saya Ingin Pesan",
                                Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Ogah", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(MainActivity.this, "Saya Ogah Pesan",
                                Toast.LENGTH_SHORT).show();
                    }
                })
                .setNeutralButton("Bingung", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(MainActivity.this, "Saya Bingung Pesan Apa",
                                Toast.LENGTH_SHORT).show();
                    }
                });
        // Create the AlertDialog object and return it
        builder.show();;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt1 = findViewById(R.id.bt_show_message);
        ConstraintLayout layout = findViewById(R.id.constraint_layout);
        registerForContextMenu(layout);
        Spinner spinner = (Spinner) findViewById(R.id.label_spinner);
    // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.daftar_negara, android.R.layout.simple_spinner_item);
    // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //tangkap item yang dipilih
                String item = adapterView.getAdapter().getItem(i).toString();
                //tampilkan ke dalam toast
                Toast.makeText(MainActivity.this, "Anda memilih " + item
                        , Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(MainActivity.this, "Item Belum di Klik!",
                        Toast.LENGTH_SHORT).show();
            }



        }

        );

    }
}