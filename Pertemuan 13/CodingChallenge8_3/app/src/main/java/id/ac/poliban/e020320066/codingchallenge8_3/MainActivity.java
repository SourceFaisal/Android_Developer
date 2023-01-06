package id.ac.poliban.e020320066.codingchallenge8_3;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private RadioGroup networkOptions;
    private Switch mDeviceIdleSwitch;
    private Switch mDeviceChargingSwitch;
    private SeekBar mSeekBar;
    private JobScheduler mScheduler;
    private static final int JOB_ID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getSupportActionBar()!=null)getSupportActionBar().setTitle("Notification Scheduler Faisal");
        networkOptions = findViewById(R.id.networkOptions);
        mDeviceIdleSwitch = findViewById(R.id.idleSwitch);
        mDeviceChargingSwitch = findViewById(R.id.chargingSwitch);
        mSeekBar = findViewById(R.id.seekBar);
        final TextView seekBarProgress = findViewById(R.id.seekBarProgress);

        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (progress > 0){
                    seekBarProgress.setText(String.format(Locale.ENGLISH, "%d s", progress));
                }
                else {
                    seekBarProgress.setText(R.string.not_set);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void scheduleJob(View view) {
        int selectedNetworkID = networkOptions.getCheckedRadioButtonId();
        int selectedNetworkOption = JobInfo.NETWORK_TYPE_NONE;
        int seekBarInteger = mSeekBar.getProgress();
        boolean seekBarSet = seekBarInteger > 0;
        switch (selectedNetworkID) {
            case R.id.noNetwork:
                selectedNetworkOption = JobInfo.NETWORK_TYPE_NONE;
                break;
            case R.id.anyNetwork:
                selectedNetworkOption = JobInfo.NETWORK_TYPE_ANY;
                break;
            case R.id.wifiNetwork:
                selectedNetworkOption = JobInfo.NETWORK_TYPE_UNMETERED;
                break;
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mScheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
        }
        ComponentName componentName = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            componentName = new ComponentName(getPackageName(), SleeperJobScheduler.class.getName());
        }
        JobInfo.Builder builder = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new JobInfo.Builder(JOB_ID, componentName);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder.setRequiredNetworkType(selectedNetworkOption)
                    .setRequiresDeviceIdle(mDeviceIdleSwitch.isChecked())
                    .setRequiresCharging(mDeviceChargingSwitch.isChecked());
        }
        if (seekBarSet){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                builder.setOverrideDeadline(seekBarInteger * 1000);
            }
        }
        boolean constraintSet = (selectedNetworkOption != JobInfo.NETWORK_TYPE_NONE) || mDeviceChargingSwitch.isChecked() || mDeviceIdleSwitch.isChecked() || seekBarSet;
        if (constraintSet) {
            JobInfo myJobInfo = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                myJobInfo = builder.build();
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                mScheduler.schedule(myJobInfo);
            }
            Toast.makeText(this, "Job Scheduled, job will run when " + "the constraints are met.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Please set at least one constraint", Toast.LENGTH_SHORT).show();
        }
    }

    public void cancelJobs(View view) {
        if (mScheduler != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                mScheduler.cancelAll();
            }
            mScheduler = null;
            Toast.makeText(this, "Job cancelled", Toast.LENGTH_SHORT).show();

        }
    }
}