package com.example.desindmobile;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Example extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);


        ImageView ex_image=findViewById(R.id.ex_img);
        TextView ex_lbl =findViewById(R.id.ex_text);


        ex_image.setImageDrawable(getResources().getDrawable(R.drawable.back2));

        ex_lbl.setText(R.string.ex_lbl);


        EditText txtnum1= findViewById(R.id.txtnum1);
        EditText txtnum2=findViewById(R.id.txtnum2);
        TextView lblresult=findViewById(R.id.lblresult);
        Button btncal=findViewById(R.id.btncal);


        btncal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num1= Integer.parseInt(txtnum1.getText().toString());
                int num2= Integer.parseInt(txtnum2.getText().toString());
                int sum=num1+num2;

                lblresult.setText(""+sum);
            }
        });

    }
}