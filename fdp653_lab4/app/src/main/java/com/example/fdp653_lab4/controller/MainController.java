package com.example.fdp653_lab4.controller;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import com.example.fdp653_lab4.MainActivity;
import com.example.fdp653_lab4.StarshipActivity;
import com.example.fdp653_lab4.model.Fleet;

public class MainController implements View.OnClickListener
{
    private MainActivity mainActivity;
    private Fleet fleet;

    public MainController(MainActivity mainActivity, Fleet fleet)

    {
        this.mainActivity = mainActivity;
        this.fleet = fleet;
    }
    /* MainController constructor, taking MainActivity and Fleet objects as arguments.
   Initialize the member var*/

    @Override
    public void onClick(View view)
    {
        String registry = (String) view.getTag();
        // Retrieve the registry value associated with the clicked view (button).

        String buttonText = ((Button) view).getText().toString();
        // get the text from the clicked button.


        Intent intent = new Intent(mainActivity, StarshipActivity.class);
        // Create a new Intent object to launch StarshipActivity from MainActivity.

        intent.putExtra("STARSHIP_REGISTRY", registry);
        intent.putExtra("BUTTON_TEXT", buttonText);
        // Attaches the textn as vals to the intent.

        mainActivity.startActivity(intent);
        // Start the StarshipActivity with the intent.



    }
}

/*
The MainController class is a custom controller for handling button click events
in a specific Android application. The class implements the View.OnClickListener
interface, which requires the onClick method to be overridden. The constructor takes a
MainActivity and Fleet object as arguments and initializes the corresponding member
variables.

When a button is clicked, the onClick method is called. It retrieves the
registry value and the text from the clicked button creates a new Intent
object to launch the StarshipActivity attaches the registry and buttonText
as extras to the intent and starts the activity with the intent. This controller
essentially handles the navigation between the main activity and the StarshipActivity
bypassing necessary information (registry and buttonText) between them.
 */