import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Fleet {
    private String name;
    private ArrayList<Starship> starships;

    public Fleet(String name) 
    {
        this.name = name;
        starships = new ArrayList<>();
    }
    public String getCrewMemberRank(CrewMember member) {
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
    
    public void loadStarships(String directoryName) throws FileNotFoundException 
    {
    	//File file = new File(filename);
        //String filePath =filename;
        //System.out.println("File path:" + filePath);
        //System.out.println(file.getAbsolutePath());//hard file path 
        File directory = new File(directoryName);
        File[] files = directory.listFiles((dir, name) -> name.endsWith(".csv"));

        if (files != null) {
            for (File file : files) {
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) 
                {
                    String line = reader.readLine(); // skip header line and read line characters until it reaches the end of the line

                    String name, registry, starshipClass;
                    List<CrewMember> crew = new ArrayList<>();

                    while ((line = reader.readLine()) != null) 
                    {
                        String[] fields = line.split(",");// split method is used to "split" a string into an array of substring
                        if (fields.length >= 4) 
                        {
                            String crewName = fields[0];// trim methods removes any whitespace both infront or after the data 
                            String position = fields[1];
                            String rank = fields[2];
                            String species = fields[3];
                            CrewMember crewMember = new CrewMember(crewName, position, rank, species);
                            crew.add(crewMember);
                        }
                    }
                    
                    //one each pass through the loop we split the line into an array of fields using the split and then get rid of any white space using trim

                    if (!crew.isEmpty()) //check to see if the crew is not empty 
                    {
                        name = file.getName().split("\\.")[0];
                        registry = crew.get(0).getPosition();
                        starshipClass = crew.get(0).getRank();
                        Starship starship = new Starship(name, registry, starshipClass, crew);
                        this.addStarship(starship);
                    }
                } catch (IOException e) 
                {
                    System.out.println("Error loading file: " + file.getName());
                    e.printStackTrace();//catch used for debugging 
                }
            }
        }
    }
    public String toString() 
    {
        String result = name + "\n";
        for (int i = 0; i < starships.size(); i++) 
        {
            result += starships.get(i).toString() + "\n";
        }
        result += "";
        return result;
    }
}
/*
A name, represented as a String (e.g. “United Federation of Planets”)
An ArrayList of Starship objects
A constructor which requires all String fields and initializes the collection
A getSizeOfFleet() method which returns the number of starships in the fleet
An addStarship(..) method which takes a Starship parameter and adds it to the fleet, returning nothing.
A toString() method which calls upon the toString() in Starship to return a string representation of the fleet.
Getters and setters for all fields
A loadStarships(…) method which takes in a directory name and adds a Starship to the Fleet for each file found. 
This method should not return anything and needs to “throw” an exception in order to allow for file I/O. To do this 
you need only define your method as follows:  

public void loadStarships( String directoryName ) throws FileNotFoundException {
}
*/
