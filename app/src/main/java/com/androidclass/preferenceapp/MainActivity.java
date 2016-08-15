package com.androidclass.preferenceapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    SharedPreferences prefs = null;
    TextView txSyncText, txSyncNumber, txWelcomeMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        txSyncText = (TextView) findViewById(R.id.text_sync_status);
        txSyncNumber = (TextView) findViewById(R.id.text_sync_number);
        txWelcomeMsg = (TextView) findViewById(R.id.text_welcome_msg);




        Button btnManage = (Button) findViewById(R.id.btn_manage);
        btnManage.setOnClickListener(this);



    }


    @Override
    protected void onResume() {

        super.onResume();

        prefs = PreferenceManager.getDefaultSharedPreferences(this);


        String textSyncStatus = "Sync Status = " + prefs.getBoolean("perform_updates", true);
        String textSyncInterval = "Sync Period = " + prefs.getString("updates_interval", "-1");
        String textWelcomeMsg = "Welcome Message = " + prefs.getString("welcome_message", null);


        txSyncText.setText(textSyncStatus);
        txSyncNumber.setText(textSyncInterval);
        txWelcomeMsg.setText(textWelcomeMsg);


    }



    @Override
    public void onClick(View arg0) {

        Intent i = new Intent(this, ManagePrefsActivity.class);
        startActivity(i);
    }


}
