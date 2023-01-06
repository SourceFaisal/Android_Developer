package id.ac.poliban.e020320066.codingchallenge9_1;

import android.view.View;
import android.widget.AdapterView;

public interface SettingActivity {
    void onItemSelected(AdapterView<?> parent, View view, int position, long id);

    void onNothingSelected(AdapterView<?> parent);
}
