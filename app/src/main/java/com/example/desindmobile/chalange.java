package com.example.desindmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class chalange extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chalange);

        EditText txt_l_username=findViewById(R.id.l_txtname);
        EditText txt_l_pass=findViewById(R.id.l_txtpassword);

        Button btn_login=findViewById(R.id.btn_log);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user=txt_l_username.getText().toString();
                String pass=txt_l_pass.getText().toString();

                MysqliteDB sql=new MysqliteDB(chalange.this);
//                SQLiteDatabase db=sql.getWritableDatabase();
//                sql.onUpgrade(db,1,2);
                sql.checkUserInfo(user,pass);
            }
        });
    }
}