package com.example.sql;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et,et2,et3,et4;
    Button btn,btn2,btn3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et=findViewById(R.id.editText);
        et2=findViewById(R.id.editText2);
        et3=findViewById(R.id.editText3);
        et4=findViewById(R.id.editTexti);
        btn=findViewById(R.id.button);
        btn2=findViewById(R.id.button2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper dbhelper = new DatabaseHelper(MainActivity.this);
                boolean res = dbhelper.insertData(et.getText().toString(), et2.getText().toString(), Integer.parseInt(et3.getText().toString()));
                if (res)
                    Toast.makeText(MainActivity.this, "Insert Success", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this, "Insert Failed", Toast.LENGTH_LONG).show();

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper dbhelper = new DatabaseHelper(MainActivity.this);
                boolean res = dbhelper.updateData(et4.getText().toString(),et.getText().toString(), et2.getText().toString(), Integer.parseInt(et3.getText().toString()));
                if (res)
                    Toast.makeText(MainActivity.this, "Update Success", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this, "Update Failed", Toast.LENGTH_LONG).show();


            }
        });
    }
}