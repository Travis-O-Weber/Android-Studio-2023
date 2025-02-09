package com.example.fdp653_lab4.controller;

import com.example.fdp653_lab4.StarshipActivity;
import com.example.fdp653_lab4.model.Fleet;
import com.example.fdp653_lab4.model.Starship;

public class StarshipController
{
    private StarshipActivity starshipActivity;
    private Fleet fleet;
    private Starship starship;
    // Declare private member variables for StarshipActivity, Fleet, and Starship.


    public StarshipController(StarshipActivity starshipActivity, Fleet fleet, String registry)
    {
        // StarshipController constructor, taking StarshipActivity, Fleet objects and a registry String as arguments.

        this.starshipActivity = starshipActivity;
        this.fleet = fleet;
        this.starship = fleet.getStarshipByRegistry(registry);
        // Retrieve the Starship object from the fleet using the registry.

    }

    public void updateStarshipView()
    {
        starshipActivity.updateStarshipInfo(starship);
        // Update the StarshipActivity view with the starship and crew member info

    }

    public Starship getStarshipByRegistry(String registry)
    {
        // Method to get a Starship object by its registry from the fleet.

        return fleet.getStarshipByRegistry(registry);
        // Call the getStarshipByRegistry method on the Fleet object, passing the registry string.

    }
}
/*
The StarshipController class is a custom controller for handling the logic related to
the StarshipActivity in a specific Android application. The class has member variables
for StarshipActivity, Fleet, and Starship. The constructor takes a StarshipActivity
object, a Fleet object, and a registry string as arguments. It initializes the
corresponding member variables and retrieves the Starship object from the fleet using
the registry string.

The updateStarshipView method updates the StarshipActivity view with the starship and
crew member information by calling the updateStarshipInfo method on the StarshipActivity
object and passing the Starship object. The getStarshipByRegistry method gets a
Starship object by its registry from the fleet by calling the getStarshipByRegistry
method on the Fleet object and passing the registry string. This controller manages the interaction between the StarshipActivity and the Fleet model.
 */