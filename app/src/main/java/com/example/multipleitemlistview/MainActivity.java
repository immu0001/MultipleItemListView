package com.example.multipleitemlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText FirstName,LastName,FavColor;
    Button add, view;
    DatabaseHelper db=new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirstName = findViewById(R.id.FirstName);
        LastName = findViewById(R.id.ScdName);
        FavColor = findViewById(R.id.FavClr);
        add = findViewById(R.id.AddBtn);
        view = findViewById(R.id.ViewBtn);

        FirstName.setOnClickListener(this);
        LastName.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){

            case R.id.AddBtn:
                String fName = FirstName.getText().toString();
                String lName = LastName.getText().toString();
                String fColor = FavColor.getText().toString();
                if(fName.length() != 0 && lName.length() != 0 && fColor.length() != 0){
                    AddData(fName,lName, fColor);
                    FirstName.setText("");
                    LastName.setText("");
                    FavColor.setText("");
                }else{
                    Toast.makeText(MainActivity.this,"You must put something in the text field!",Toast.LENGTH_LONG).show();
                }

                break;


            case R.id.ViewBtn:

                break;
        }

    }
    public void AddData(String firstName,String lastName, String favFood ){
        boolean insertData = db.addData(firstName,lastName,favFood);

        if(insertData==true){
            Toast.makeText(MainActivity.this,"Successfully Entered Data!",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(MainActivity.this,"Something went wrong :(.",Toast.LENGTH_LONG).show();
        }
    }

}
