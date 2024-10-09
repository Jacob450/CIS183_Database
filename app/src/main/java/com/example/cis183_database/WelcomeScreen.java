package com.example.cis183_database;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class WelcomeScreen extends AppCompatActivity {
    TextView tv_j_userFName;
    TextView tv_j_userLName;
    TextView tv_j_numOfPost;
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_welcome_screen);

        //set attributes
        tv_j_userFName = findViewById(R.id.tv_v_ws_userfname);
        tv_j_userLName = findViewById(R.id.tv_j_ws_userlname);
        tv_j_numOfPost = findViewById(R.id.tv_v_ws_numofpost);
        //Create new instance of database helper
        dbHelper = new DatabaseHelper(this);

        tv_j_userFName.setText(SessionData.getLoggedInUser().getFname());
        tv_j_userLName.setText(SessionData.getLoggedInUser().getLname());
        tv_j_numOfPost.setText(String.valueOf(dbHelper.getNumOfPostForUserGivenID(SessionData.getLoggedInUser().getId())));







    }
}