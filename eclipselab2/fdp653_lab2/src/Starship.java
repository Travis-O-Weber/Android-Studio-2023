import java.util.ArrayList;
import java.util.List;

public class Starship {


    private String name; // name of the starship //A name, represented as a String (e.g. “USS Enterprise”)
    private String registry; // registry of the starship //A registry, (e.g. “NCC-1701-A”)
    private String starshipClass; // class of the starship
    //private ArrayList<CrewMember> crew; // list of crew members on the starship //An ArrayList of CrewMember objects
    private List<CrewMember> crewMembers;
    
    public Starship(String name, String registry, String starshipClass, List<CrewMember> crewMembers) {
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

    public void addCrewMember(CrewMember crewMember) {
        if (this.crewMembers == null) 
        {
            this.crewMembers = new ArrayList<CrewMember>();
        }
        this.crewMembers.add(crewMember);
    }
    

    public int getNumberOfPersonnel() {
        return crewMembers.size();
    } // method named gatnumberofpersonnel this gets the number crew members on the starship

    
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
    }// getter and setter for the class of the starship

   
    
    
   
    public String toString() {
        String crewList = "";
        for (int i = 0; i < crewMembers.size(); i++) {
            crewList += crewMembers.get(i).toString();//adds string representation of the crew member at the current index of the crewList string
            if (i < crewMembers.size() - 1) {
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
/*This class will represent a Starship object, which we will define as having:


A class of starship (e.g. “Constitution”)

A constructor which requires all String fields and initializes the collection
A toString() method which returns a String representation of the Starship
An addCrewMember(…) method which takes a CrewMember parameter and adds them to the starship and returns nothing
A getNumberOfPersonnel() method which takes no parameters and returns an integer count of crew members on the starship
Getters and setters for all fields
*/
