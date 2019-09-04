package com.example.multipleitemlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ViewListContents extends AppCompatActivity {

    DatabaseHelper db=new DatabaseHelper(this);
    ArrayList<User> userList=new ArrayList<>();
    ListView listView;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_list_contents);
        Cursor data = db.getListContents();
        int numRows = data.getCount();
        if (numRows==0){
        Toast.makeText(ViewListContents.this,"There is Nothing in this Database!!",Toast.LENGTH_LONG).show();
    }else{
            int i=0;
            while(data.moveToNext()){
                user = new User(data.getString(1),data.getString(2),data.getString(3));
                userList.add(user);
            }
            ThreeColumn_ListAdapter adapter = new ThreeColumn_ListAdapter(this, R.layout.list_adapter_view,userList);
            ListView listView=findViewById(R.id.listView);
            listView.setAdapter(adapter);
        }
    }
}
