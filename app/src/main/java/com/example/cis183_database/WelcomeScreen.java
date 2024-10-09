package com.example.cis183_database;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class WelcomeScreen extends AppCompatActivity {
    TextView tv_j_userFName;
    TextView tv_j_userLName;
    TextView tv_j_numOfPost;
    TextView tv_j_recentPost;
    Button btn_j_goBack;
    DatabaseHelper dbHelper;
    Intent intent_j_mainactivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_welcome_screen);

        //set attributes
        tv_j_userFName = findViewById(R.id.tv_v_ws_userfname);
        tv_j_userLName = findViewById(R.id.tv_j_ws_userlname);
        tv_j_numOfPost = findViewById(R.id.tv_v_ws_numofpost);
        btn_j_goBack = findViewById(R.id.btn_v_ws_goback);
        tv_j_recentPost = findViewById(R.id.tv_v_ws_recentpost);
        intent_j_mainactivity = new Intent(this, MainActivity.class);
        //Create new instance of database helper
        dbHelper = new DatabaseHelper(this);

        setWelcomeMessage();
        tv_j_numOfPost.setText(String.valueOf(dbHelper.getNumOfPostForUserGivenID(SessionData.getLoggedInUser().getId())));
        setRecentPost();



        goBack();
    }

    private void setWelcomeMessage(){
        tv_j_userFName.setText(SessionData.getLoggedInUser().getFname());
        tv_j_userLName.setText(SessionData.getLoggedInUser().getLname());
    }

    private void setRecentPost(){
        tv_j_recentPost.setText(dbHelper.getRecentPostGivenID(SessionData.getLoggedInUser().getId()).getPost());
    }

    private void goBack(){
        btn_j_goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent_j_mainactivity);
            }
        });

    }
}