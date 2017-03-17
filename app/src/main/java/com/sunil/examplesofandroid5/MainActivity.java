package com.sunil.examplesofandroid5;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Toast;

import static android.R.layout.simple_spinner_item;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener, View.OnClickListener{
    private SeekBar seek;
    private Spinner spinner;
    private Button startservice,stopservice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seek=(SeekBar)findViewById(R.id.seekBar);
        spinner=(Spinner)findViewById(R.id.spinner);
        seek.setOnSeekBarChangeListener(this);
        startservice=(Button)findViewById(R.id.start);
        stopservice=(Button)findViewById(R.id.stop);

        startservice.setOnClickListener(this);
        stopservice.setOnClickListener(this);

        ArrayAdapter adapter =ArrayAdapter.createFromResource(this,R.array.intents,simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }


    public void onClick(View view){
        int position = spinner.getSelectedItemPosition();
        Intent intent = null;
        switch (position) {
            case 0:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://google.com"));
                startActivity(intent);
                break;
            case 1:
                intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:(+91)123457890"));
                startActivity(intent);
                break;
            case 2:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:50.123,7.1434?z=19"));
                startActivity(intent);
                break;
            case 3:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=query"));
                startActivity(intent);
                break;
            case 4:
                intent = new Intent("android.media.action.IMAGE_CAPTURE");
                startActivity(intent);
                break;
            case 5:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people/"));
                startActivity(intent);
                break;
            case 6:
                intent = new Intent(Intent.ACTION_EDIT, Uri.parse("content://contacts/people/1"));
                startActivity(intent);
                break;
        }
            if (intent != null) {
                startActivity(intent);
            }
           /* switch (view.getId()) {
                case R.id.start:
                    Log.d("Audio_started", "Service started");
                    startService(new Intent(this, MyService.class));
                    break;
                case R.id.stop:
                    Log.d("Audio_Stoped", "Service Stoped");
                    stopService(new Intent(this, MyService.class));
                    break;
            }*/
        }


    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        Toast.makeText(getApplicationContext(),"seekBar progress"+progress,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        Toast.makeText(getApplicationContext(),"seekBar touch startd",Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        Toast.makeText(getApplicationContext(),"seekBar touch Stopped!",Toast.LENGTH_SHORT).show();
    }
}
