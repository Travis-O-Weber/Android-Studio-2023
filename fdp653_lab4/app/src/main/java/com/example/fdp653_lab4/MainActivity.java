package com.example.fdp653_lab4;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fdp653_lab4.controller.MainController;
import com.example.fdp653_lab4.model.Fleet;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fleet unitedFederation = new Fleet("United Federation of Planets", getApplicationContext());
        // Creates a new Fleet object

        try
        {
            String[] fileNames = {"fleet.csv", "personnel.csv"};
            unitedFederation.loadStarships();
        } catch (Exception e) {
            e.printStackTrace();
        }// catche and try to load starships from CSV files


        Button enterpriseAButton = findViewById(R.id.button);
        Button enterpriseDButton = findViewById(R.id.button2);
        Button voyagerButton = findViewById(R.id.button3);
        //assigns button

        enterpriseAButton.setTag("NCC-1701-A");
        enterpriseDButton.setTag("NCC-1701-D");
        voyagerButton.setTag("NCC-74656");
        // Set tags for each Button view

        MainController mainController = new MainController(this, unitedFederation);
        //creats a main controller objext

        enterpriseAButton.setOnClickListener(mainController);
        enterpriseDButton.setOnClickListener(mainController);
        voyagerButton.setOnClickListener(mainController);
        // Set onClickListener for each Button view
    }

}
/*
The MainActivity class that creates the UI and
Sets up objects and listeners for the application. It
Creates a Fleet object called United Federation and tries to load starships
from CSV files using the load Starships method.The activity also finds the Button
Views for the starships(EnterpriseA, EnterpriseD, and Voyager) and sets the
Appropriate registry as a tag for each button. It creates a MainController
Object and sets it as theOnClickListener for all the buttons. This way, it will do its task when the buttons a reclicked,
The Main Controller handles the click event.
*/