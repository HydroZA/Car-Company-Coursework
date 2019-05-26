/*
CS4001 Programming
Coursework 2
All code by JAMES LEGGE
London Metropolitan University
BSc Computer Networking and Cyber Security
*/
package main;
public class Car 
{
	//	Declaring Attributes
    public String description;
    public String customerName;
    
	//	Parameterised Constructor
    public Car (String desc)
    {
        description = desc;
        customerName = "";
    }
    
	//	Accessor Methods
    
    //Accesor method for description 
    public String getDescription()
    {
        return description;
    }
    
    public String getCustomerName()
    {
        return customerName;
    }
	
    //	Edit the customers name
    public void setCustomerName(String cName)
    {
        customerName = cName;
    }
    
    //	Display all info - toString is the naming standard for printing all info in a class.
    public String toString()
    {
        if (customerName.equals(""))
        {
            return "The description is " + description;
        }
        else
        {
            return "Customer Name = " + customerName + "\nDescription = " + description;
        }
    }
}
