package id.ac.poliban.e020320066.faisal_add;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {
    private final List <String> mList = new ArrayList<>();
    private ClubAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        mList.add("Arsenal. FC");
        mList.add("Barcelona. FC");
        mList.add("Ecuador. FC");
        mList.add("Real Madrid. FC");
        mList.add("Qatar. FC");

        mAdapter = new ClubAdapter(this, mList);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton fab = findViewById(R.id.fab_recyclerview);
                fab.setOnClickListener(this::addClub);

    }

    private void addClub(View view) {
        View subview = LayoutInflater.from(this)
                .inflate(R.layout.layout_input_item, null, false);
        EditText etClub = subview.findViewById(R.id.et_item);
        etClub.setHint("Enter Your Favorite");
        etClub.setInputType(InputType.TYPE_TEXT_FLAG_CAP_WORDS);

        //TAMPILKAN DIALOG INPUT
        new AlertDialog.Builder(this)
                .setTitle("Add Club")
                .setView(subview)
                .setCancelable(false)
                .setNegativeButton("Cancel", null)
                .setPositiveButton("Add", (dialogInterface, i) -> {
                    if (!etClub.getText().toString().isEmpty()) {
                        mList.add(etClub.getText().toString());
                        mAdapter.notifyDataSetChanged();
                    }
                })
                .show();
    }
}