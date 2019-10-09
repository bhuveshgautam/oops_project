package com.example.humsafar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.humsafar.Models.personalinfo;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<personalinfo> farmers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textview = (TextView)findViewById(R.id.textView);
        personalinfo.loadData(getApplicationContext(), "farmers");
        textview.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, Registration.class);
                startActivity(intent);
            }
        });
    }

    public void Login(View view){
        EditText txtname = findViewById(R.id.username);
        EditText txtpwd = findViewById(R.id.password);
        String name = txtname.getText().toString();
        String pwd = txtpwd.getText().toString();
        int flag = 0;
        Context context = getApplicationContext();

        for(personalinfo i : personalinfo.farmers){
            if(i.getname().equals(name)){
                flag++;
                if(i.getpassword().equals(pwd)){
                    Toast toast = Toast.makeText(context, "Authenticated", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else{
                    Toast toast = Toast.makeText(context, "Wrong password", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        }
        if(flag == 0){
            Toast toast = Toast.makeText(context, "No such user", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
