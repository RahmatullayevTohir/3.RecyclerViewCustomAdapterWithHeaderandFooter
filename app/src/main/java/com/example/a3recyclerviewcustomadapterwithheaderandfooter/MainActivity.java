package com.example.a3recyclerviewcustomadapterwithheaderandfooter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.example.a3recyclerviewcustomadapterwithheaderandfooter.adapter.CustomAdapter;
import com.example.a3recyclerviewcustomadapterwithheaderandfooter.model.User;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Context context;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        List<User> users = prepareMemberList();
        refreshAdapter(users);
    }

    private void initViews(){
        recyclerView = findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new GridLayoutManager(context,1));
    }

    private void refreshAdapter(List<User> users){
        CustomAdapter adapter = new CustomAdapter(context, users);
        recyclerView.setAdapter(adapter);
    }

    private List<User> prepareMemberList(){
        List<User> users = new ArrayList<>();
        users.add(new User()); // for Header

        for (int i =0; i<30; i++){
            if (i==0||i==5||i==10||i==12){
                users.add(new User("Rahmatullayev"+i,"Tohir"+i,false));
            }
            else {
                users.add(new User("Rahmatullayev"+i,"Tohir"+i,true));
            }
        }
        users.add(new User()); // for Footer
        return users;
    }
}