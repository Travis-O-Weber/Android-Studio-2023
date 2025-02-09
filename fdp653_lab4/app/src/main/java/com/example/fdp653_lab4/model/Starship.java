package com.example.fdp653_lab4.model;

//import com.example.fdp653_lab4.model.CrewMember;

import java.util.ArrayList;
import java.util.List;


public class Starship {

    private String name; // name of the starship USS Enterprise”
    private String registry; // registry of the starship NCC-1701-A”
    private String starshipClass; // class of the starship
    private List<CrewMember> crewMembers;
    //private ArrayList<CrewMember> crew; // list of crew members on the starship //An ArrayList of CrewMember objects

    public Starship(String name, String registry, String starshipClass, List<CrewMember> crewMembers)
    {
        this.name = name;
        this.registry = registry;
        this.starshipClass = starshipClass;
        this.crewMembers = crewMembers;
    }//A constructor foe all String fields and initializes it


    /*public void addCrewMember(CrewMember crewMember)
    {
        crew.add(crewMember);
    }//method nammed addcrew members which adds crew members to the array list*/

    public List<CrewMember> getCrewMembers()
    {
        return crewMembers;
    }
    //gets crew members

    public void addCrewMember(CrewMember crewMember)
    {
        if (this.crewMembers == null)
        {
            this.crewMembers = new ArrayList<CrewMember>();
        }
        this.crewMembers.add(crewMember);
    } // Method that adds CrewMember objects to the starship.


    public int getNumberOfPersonnel()
    {
        return crewMembers.size();
    } // method that gets the numb crew members on the starship


    public String getName()
    {
        return name;
    }//getter for name
    public void setName(String name)
    {
        this.name = name;
    }//setter for name





    public String getRegistry() {
        return registry;
    }
    public void setRegistry(String registry) {
        this.registry = registry;
    }// getter and setter for get registry of the starship


    public String getStarshipClass() {
        return starshipClass;
    }
    public void setStarshipClass(String starshipClass) {
        this.starshipClass = starshipClass;
    }// getter and setter for StarshipClass





    public String toString()
    {
        String crewList = "";
        for (int i = 0; i < crewMembers.size(); i++)
        {
            crewList += crewMembers.get(i).toString();//adds string representation of the crew member at the current index of the crewList string
            if (i < crewMembers.size() - 1)
            {
                crewList += "\n";//adds new line charcter to crewlist if the current index is not the last
            }
        }

        String s = "Starship[" +//starship and the [+
                "name=" + name +//returns string named name
                ",registry=" + registry +//returns string named registry
                ",starshipClass=" + starshipClass +//returns string named starshipclass
                ",crewMembers=" + crewList +//returns string named crewmembers
                "";
        return s;
    }//// method to return a String representation of the starship object
}

/*
    This Starship class represents a Starship object with name,
    registry, starshipClass, and a list of crewMembers. It has a constructor
    for initializing these properties, getters and setters  for each attribute,
    and methods for adding crew members and getting the number of personnel on the starship.
   we also have, the toString method returns a string representation of the Starship object.
*/

