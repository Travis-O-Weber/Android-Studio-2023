package com.example.fdp653_lab4.model;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
public class Fleet {
    private String name;
    private ArrayList<Starship> starships;

    private Context context;

    public Fleet(String name, Context context)
    {
        this.name = name;
        this.context = context;
        starships = new ArrayList<>();
    }    // Fleet constructor, taking a name and a context object as arguments.

    public String getCrewMemberRank(CrewMember member)
    {

        return member.getRank();
    }

    public String getName()
    {
        return name;
    }//returns name of fleet


    public void setName(String name)
    {
        this.name = name;
    }//sets name of fleet

    // Getter and setter methods for the Fleet class.

    public ArrayList<Starship> getStarships()
    {
        return starships;
    }//returns get an array list of Starship


    public void setStarships(ArrayList<Starship> starships)
    {
        this.starships = starships;
    }//sets the array list of starship


    public int getSizeOfFleet()
    {
        return starships.size();
    }//returns size of starships


    public void addStarship(Starship starship)
    {
        starships.add(starship);
    }//add starship to fleet

    public Starship getStarshipByRegistry(String registry) {
        for (Starship starship : starships) {
            if (starship.getRegistry().equals(registry)) {
                return starship;
            }
        }
        return null;
    }    // Method to get a Starship object by its registry.


    // public void loadStarships(String[] fileNames) throws IOException
   public void loadStarships() throws IOException
    {
        //File file = new File(filename);
        //String filePath =filename;
        //System.out.println("File path:" + filePath);
        //System.out.println(file.getAbsolutePath());//hard file path
        //File directory = new File(directoryName);
        //File[] files = directory.listFiles((dir, name) -> name.endsWith(".csv"));

        List<String> fileNames = Arrays.asList("fleet.csv", "personnel.csv");

        if (fileNames != null)
        {
            for (String fileName : fileNames)
            {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(context.getAssets().open(fileName))))
                {
                    String line = reader.readLine(); // skip header line and read line characters until it reaches the end of the line

                    int crewMemberIndex = 0;


                    while ((line = reader.readLine()) != null)
                    {
                        String[] fields = line.split(",");// split method is used to "split" a string into an array of substring
                        if (fields.length >= 4)
                        {
                            if (fileName.equals("fleet.csv"))
                            {
                                String starshipName = fields[0];
                                String registry = fields[1];
                                String starshipClass = fields[2];
                                Starship starship = new Starship(starshipName, registry, starshipClass, new ArrayList<>());
                                starships.add(starship);
                            }   else
                                {
                                    String crewName = fields[0];
                                    String position = fields[1];
                                    String rank = fields[2];
                                    String registry = fields[3];
                                    String species = fields[4];

                                    CrewMember crewMember = new CrewMember(crewName, position, rank, species, null, crewMemberIndex);

                                    for (Starship starship : starships)
                                    {
                                        if (starship.getRegistry().equals(registry))
                                        {
                                            starship.getCrewMembers().add(crewMember);
                                            break;
                                        }
                                    }
                                    crewMemberIndex++; // Increment the index after adding a crew member
                                }
                        }
                    }

                    //one each pass through the loop we split the line into an array of fields using the split and then get rid of any white space using trim


                } catch (IOException e)
                {
                    System.out.println("Error loading file: " + fileName);
                    e.printStackTrace();
                }//catch
            }
        }
    }    // Method to load Starships from CSV files.

    public String toString()
    {
        String result = name + "\n";
        for (int i = 0; i < starships.size(); i++)
        {
            result += starships.get(i).toString() + "\n";
        }
        result += "";
        return result;
    }    // toString method for the Fleet class.

}
/*
A name represented as a String (e.g. “United Federation of Planets”)
An ArrayList of Starship objects
A constructor which requires all String fields and initializes the collection
A getSizeOfFleet() method which returns the number of starships in the fleet
An addStarship(..) method takes a Starship parameter and adds it to the fleet, returning nothing.
A toString() method calls upon the toString() in Starship to return a string representation of the fleet.
Getters and setters for all fields
A loadStarships(…) method takes in a directory name and adds a Starship to the Fleet for each file found.
This method should not return anything and must “throw” an exception to allow for file I/O. To do this,
you need only define your method as follows:

public void loadStarships( String directoryName ) throws FileNotFoundException {
}
*/
