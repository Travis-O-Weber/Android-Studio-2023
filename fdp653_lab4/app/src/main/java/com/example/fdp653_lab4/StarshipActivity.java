package com.example.fdp653_lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import java.io.IOException;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.example.fdp653_lab4.model.Fleet;
import com.example.fdp653_lab4.model.Starship;
import com.example.fdp653_lab4.model.CrewMember;
import com.example.fdp653_lab4.controller.StarshipController;
public class StarshipActivity extends AppCompatActivity {

    private int[] imageViewIds;
    private int[] textViewIds;

    /*
        private String[] imageFilenames = {
                "kirk", "spock", "mccoy", "scott",
                "picard", "riker", "crusher", "laforge",
                "troi", "worf", "data", "yar",
                "chapel", "torres", "paris", "doctor",
                "uhura", "neelix", "sulu", "kes",
                "chekov", "janeway", "chakotay", "tuvok"
        };
    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starship);

        String registry = getIntent().getStringExtra("STARSHIP_REGISTRY");
        String buttonText = getIntent().getStringExtra("BUTTON_TEXT");
        //get registry and button text from the intent


        Fleet unitedFederation = new Fleet("United Federation of Planets", getApplicationContext());
        // Create a new Fleet instance

        TextView textView2 = findViewById(R.id.textView2);
        textView2.setText(buttonText);
        // Set the buttonText to textView2

        try {
            unitedFederation.loadStarships();
        } catch (IOException e) {
            e.printStackTrace();
        }// Load the starships for the fleet


        Starship starship = unitedFederation.getStarshipByRegistry(registry);
        // Get the starship by registry
        if (starship != null) {
            List<CrewMember> crewMembers = starship.getCrewMembers();
            // Get the crew members of the starship
            displayCrewMembers(crewMembers);
            // Displays the crew members and update the starship information
            updateStarshipInfo(starship);
        }
    }


    public void updateStarshipInfo(Starship starship)
    // Method to update starship information (crew members)
    {
        List<CrewMember> crewMembers = starship.getCrewMembers();
        int crewSize = crewMembers.size();

        for (int i = 0; i < crewSize; i++) {
            CrewMember crewMember = crewMembers.get(i);
            String imageName = crewMember.getName().toLowerCase().replaceAll("\\s+", "");
            int resourceId = getResources().getIdentifier(imageName, "drawable", getPackageName());

            // Set the ImageView with the crew member's image.
            ImageView crewImageView = findViewById(imageViewIds[i]);
            crewImageView.setImageResource(resourceId);

            // Set the TextView with the crew member's rank, name, and position.
            TextView crewTextView = findViewById(textViewIds[i]);
            String crewInfo = crewMember.getRank() + " " + crewMember.getName() + ", " + crewMember.getPosition();
            crewTextView.setText(crewInfo);
        }
        // Loop through the crew members and display their info

    }


    private void displayCrewMembers(List<CrewMember> crewMembers)
    // Method to display crew members
    {
        textViewIds = new int[]{
                R.id.textView2, R.id.textView3,
                R.id.textView4, R.id.textView5,
                R.id.textView6, R.id.textView7,
                R.id.textView8, R.id.textView9,
                R.id.textView10, R.id.textView11,
                R.id.textView12, R.id.textView13,
                R.id.textView14, R.id.textView15
        };

        imageViewIds = new int[]{
                R.id.imageView2,
                R.id.imageView3,
                R.id.imageView4,
                R.id.imageView5,
                R.id.imageView6,
                R.id.imageView7,
                R.id.imageView8,
                R.id.imageView9
        };
        // Initialize the textViewIds and imageViewIds arrays


        int maxCrewMembers = textViewIds.length / 2;
        // Calculates the max number of crew members that can be displayed


        for (int i = 0; i < crewMembers.size() && i < maxCrewMembers; i++)
        // Iterate through the crew members list, but don't exceed the maxCrewMembers limit

        {
            CrewMember crewMember = crewMembers.get(i);
            // Gets the current crew member


            TextView nameTextView = findViewById(textViewIds[i * 2]);
            nameTextView.setText(crewMember.getName());
            // Sets the name TextView with the crew member's name


            TextView rankTextView = findViewById(textViewIds[i * 2 + 1]);
            rankTextView.setText(crewMember.getRank());
            // Set the rank TextView with the crew member's rank


            ImageView crewImageView = findViewById(imageViewIds[i]);
            int resourceId = getResources().getIdentifier(crewMember.getImageName(), "drawable", getPackageName());
            crewImageView.setImageResource(resourceId);
            // Set the ImageView with the crew member's image

        }

        for (int i = crewMembers.size(); i < maxCrewMembers; i++) {
            TextView nameTextView = findViewById(textViewIds[i * 2]);
            nameTextView.setText("");
            // Clears the name TextView


            TextView rankTextView = findViewById(textViewIds[i * 2 + 1]);
            rankTextView.setText("");
            // Clears the rank TextView

        }// Clears the remaining TextViews if there are fewer crew members than TextViews

    }
}
/*
Starship Activity is responsible for displaying
The details of a selected starship and its crewmembers.

onCreate(): This method is called when the activity is created. It initializes the
activity view then gets the starship registry and button value from the intent, creates a
Fleet object(unitedFederation) loads the starships and retrieves the selected starship based
It then displays the starship's crewmembers on its registry and updates the starship info.

updateStarshipInfo(Starshipstarship): This method takes a Starship object and then updates
theImageView andTextView elements for each crew member with their image,rank,name,and position.

Display CrewMembers(List<CrewMember>crewMembers): This method takes a list of CrewMember objects and
Displays their names, ranks, and images in the activity's layout. It also clears any remaining TextViews
If there are fewer crew members than TextViews.

In summary, StarshipActivity is responsible for displaying info about a specific starship and
Its crew members in the. The activity retrieves the starship's details based on its registry
And updates the UI element to stop resending this info.
*/



