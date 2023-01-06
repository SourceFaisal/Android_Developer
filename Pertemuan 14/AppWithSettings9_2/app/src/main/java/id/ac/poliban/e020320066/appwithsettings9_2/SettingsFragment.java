package id.ac.poliban.e020320066.appwithsettings9_2;

import android.os.Bundle;
import android.support.v7.preference.PreferenceFragmentCompat;


public class SettingsFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState,
                                    String rootKey) {
        setPreferencesFromResource(R.xml.preferences, rootKey);
    }
}
