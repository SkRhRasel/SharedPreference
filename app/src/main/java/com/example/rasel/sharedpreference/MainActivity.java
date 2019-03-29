package com.example.rasel.sharedpreference;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button storeInformation,showInformation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView =findViewById(R.id.textPreference);

        storeInformation = findViewById(R.id.storeInformation);
        showInformation = findViewById(R.id.showInformation);

        View.OnClickListener listenerObj = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.storeInformation:
                        Intent intent = new Intent(MainActivity.this,PrefActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.showInformation:
                        displaySharedpreference();
                        break;
                    default:
                        break;
                }
            }
        };
        storeInformation.setOnClickListener(listenerObj);
        showInformation.setOnClickListener(listenerObj);
    }


    private void displaySharedpreference() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);

        String userName = sharedPreferences.getString("userName","Default NickName");
        String password = sharedPreferences.getString("password","Default Password");

        boolean checkBox = sharedPreferences.getBoolean("checkBox",false);

        String listpref = sharedPreferences.getString("listpref","Default List Preference");

        StringBuilder builder = new StringBuilder();

        builder.append("UserName: "+ userName+ "\n");
        builder.append("Password: "+ password+ "\n");
        builder.append("Keep Me Logged in: "+ String.valueOf(checkBox)+ "\n");
        builder.append("List Preference: "+ listpref+ "\n");


        textView.setText(builder.toString());
    }
}
