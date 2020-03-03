package com.example.cedileeventmanager;

import android.content.Intent;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        TextView id = findViewById(R.id.info_id);
        TextView name = findViewById(R.id.info_name);
        TextView email = findViewById(R.id.info_email);

        Intent intent = this.getIntent();

        String[] userData = intent.getStringExtra("decoded").split("\\|", -1);

        id.setText(userData[0]);
        name.setText(String.format("%s %s", userData[1], userData[2]));
        email.setText(userData[4]);
    }
}
