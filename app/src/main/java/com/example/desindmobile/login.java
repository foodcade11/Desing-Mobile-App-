package com.example.desindmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText ed_username=findViewById(R.id.r_txtname);
        EditText ed_pass=findViewById(R.id.r_pass);
        EditText ed_c_pass=findViewById(R.id.r_c_pass);

        Button btnregister=findViewById(R.id.btn_reg);

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String user=ed_username.getText().toString();
                String pass=ed_pass.getText().toString();
                String c_pass=ed_c_pass.getText().toString();

                if(!c_pass.equals(pass))
                {
                    Toast.makeText(login.this, "Two Password are not matching",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                    MysqliteDB sql= new MysqliteDB(login.this);
                    sql.addNewUserToDatabase(user, pass);

            }
        });

    }
}




