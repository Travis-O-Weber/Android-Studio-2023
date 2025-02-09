
package com.example.fdp653_lab4.model;
public class CrewMember {

    String Name; //string variable nasme
    String Position; //string var role
    String Rank; //string var rank
    String Species; //string var race)
    String Assignment;//string varfor (e.g. “NCC-1701-A”)

    int imageIndex;;

    private static final String[] imageNames = {
            "kirk", "spock", "mccoy", "scott",
            "picard", "riker", "crusher", "laforge",
            "troi", "worf", "data", "yar",
            "chapel", "torres", "paris", "doctor",
            "uhura", "neelix", "sulu", "kes",
            "chekov", "janeway", "chakotay", "tuvok"
    };

    public CrewMember(String Name, String Position, String Rank, String Species, String Assignment, int imageIndex)
    {

        this.Name = Name;
        this.Position = Position;
        this.Rank = Rank;
        this.Species = Species;
        this.Assignment = Assignment;
        this.imageIndex = imageIndex;

    }// constructor using the dot notation


    public CrewMember(String name, String position, String rank, String species) {
        this(name, position, rank, species, null, -1);
    }//copy constructor with null in it in the case of the crew member not hving a rank or something like that or in this case an assignment

    public String toString() {
        String s = "CrewMember[" +
                "Name=" + Name +
                ",Rank=" + Rank +
                ",Position=" + Position +
                ",Species=" + Species +
                "]";
        return s;
    }// a too string method


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        this.Position = position;
    }

    public String getRank() {
        return Rank;
    }
    public void setRank(String rank) {
        this.Rank = rank;
    }

    public String getSpecies() {
        return Species;
    }
    public void setSpecies(String species) {
        this.Species = species;
    }

    public String getAssignment() {
        return Assignment;
    }
    public void setAssignment(String assignment) {
        this.Assignment = assignment;
    }

    public int getImageIndex() {
        return imageIndex;
    }
    public void setImageIndex(int imageIndex) {
        this.imageIndex = imageIndex;
    }

    //getters and setters for class atribuets
    public String getImageName() {
        if (imageIndex >= 0 && imageIndex < imageNames.length) {
            return imageNames[imageIndex];
        } else {
            return null;
        }
    }
    // getImageName method, returning the corresponding image name for the current image index
}
/*
The CrewMember class represents a crew member in the starship simulation. It has
attributes for the crew member's name, position, rank, species, and assignment, as
well as an image index for the character image.

There are two constructors, one for creating a CrewMember object with all attributes
and another for creating a CrewMember object without an assignment and image index.

The toString() method returns a formatted string representation of the crew member object.
The class also has getters and setters for each attribute and a method to get the
corresponding image name based on the image index.
 */
