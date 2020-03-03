package com.example.assistantapp;

import android.content.Intent;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import org.json.JSONException;
import org.json.JSONObject;

public class InfoActivity extends AppCompatActivity {

    private JSONObject userJson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        TextView id = findViewById(R.id.info_id);
        TextView name = findViewById(R.id.info_name);
        TextView email = findViewById(R.id.info_email);

        Intent intent = this.getIntent();

        userJson = new JSONObject();
        String[] userData = intent.getStringExtra("decoded").split("\\|", -1);
        fillUserJson(userData);

        try {

            id.setText(userJson.getString("idUser"));
            name.setText(String.format("%s %s", userJson.getString("nombre"), userJson.getString("apellido")));
            email.setText(userJson.getString("email"));

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void fillUserJson (String[] arr) {

        try {
            userJson.put("idUser", arr[0]);
            userJson.put("nombre", arr[1]);
            userJson.put("apellido", arr[2]);
            userJson.put("documentId", arr[3]);
            userJson.put("email", arr[4]);
            userJson.put("descriptionCategoryCompetitor", arr[5]);
            userJson.put("paymentMethod", arr[6]);

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
