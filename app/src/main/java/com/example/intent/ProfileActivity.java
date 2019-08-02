package com.example.intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
    TextView txtNama;
    Button btnUbah;
    int request = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        txtNama = (TextView)findViewById(R.id.txtNama);
        btnUbah = (Button)findViewById(R.id.btnUbah);
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            txtNama.setText(bundle.getString("NAMA"));
        }
        btnUbah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, UbahProfileActivity.class);
                startActivityForResult(intent,request);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==request){
            if(resultCode==RESULT_OK){
                txtNama.setText(data.getStringExtra("RESULT"));
            }
        }
    }
}
