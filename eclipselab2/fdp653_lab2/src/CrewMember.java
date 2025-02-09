public class CrewMember {
	
String Name; //string variable // string for (e.g. “James T. Kirk”)
String Position; //string variable // (e.g. “Commanding Officer”)
String Rank; //string variable //(e.g. “Captain”)
String Species; //string variable //(e.g. “Human”)
String Assignment;//string variable // string for (e.g. “NCC-1701-A”)

public CrewMember(String Name, String Position, String Rank, String Species, String Assignment) 
{
	
	this.Name = Name;
	this.Position = Position;
	this.Rank = Rank;
	this.Species = Species;
	this.Assignment = Assignment;
	
}// constructor using the dot notation 


public CrewMember(String name, String position, String rank, String species) 
	
	{
    this(name, position, rank, species, null);
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



public String getName() 
{
	return Name;
}
public void setName(String name) 
{
	this.Name =name;
}// Getters and Setters for Name



public String getPosition() 
{
	return Position;
}
public void setPosition(String position) 
{
	this.Position = position;
}// Getters and Setters for Position



public String getRank()
{
	return Rank;
}
public void setRank(String rank) 
{
	this.Rank = rank;
}// Getters and Setters for Rank



public String getSpecies() 
{
	return Species;
}
public void setSpecies(String species) 
{
	this.Species = species;
}// Getters and Setters for Species



public String getAssignment() 
{
	return Assignment;
}
public void setAssignment(String assignment) 
{
	this.Assignment = assignment;
}// Getters and Setters for Assignment



}

//This class will represent a CrewMember object, which we will define as having: