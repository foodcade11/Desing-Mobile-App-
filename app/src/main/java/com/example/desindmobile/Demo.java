package com.example.desindmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Demo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        //varibles
        EditText txtname=findViewById(R.id.txtname);
        Button btngetName=findViewById(R.id.btngetName);
        TextView lblname=findViewById(R.id.lblname);
        btngetName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // logic after button click
                String name= txtname.getText().toString();
                        lblname.setText(name);
                txtname.setText("");
            }
        });
    }
}