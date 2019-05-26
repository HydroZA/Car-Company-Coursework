/*
CS4001 Programming
Coursework 2
All code by JAMES LEGGE
London Metropolitan University
BSc Computer Networking and Cyber Security
*/

package main;
//	This class inherits attributes from Car so the " extends " keyword is used in the class declaration
public class CarToBuy extends Car
{
	//	Declaring attributes
    public int price, regYear, mileage;
    public boolean sold;
    
	//	Parameterised constructor
    public CarToBuy(String d, int p, int ry, int m)
    {
        super(d);
        description = d;
        price = p;
        regYear = ry;
        mileage = m;
        sold = false;   
    }
    
	//	Accessor methods
    public int getPrice()
    {
        return price;
    }
    
    public int getRegistrationYear()
    {
        return regYear;
    }
    
    public int getMileage()
    {
        return mileage;
    }
    
    public boolean isSold()
    {
        return sold;
    }
    
	//	Void method to set the price
    public void setPrice(int p)
    {
        if (sold == true)
        {
            System.out.println ("Sorry but the car has already been sold");
        }
        else
        {
            price = p;
        }
    }
    
	//	Void method to buy the car
    public void buyCar(String cn)
    {
        if (sold == true)
        {
            System.out.println("Sorry but this car has already been sold");
        }
        else
        {
            setCustomerName(cn);
            sold = true;
        }
    }
	//	toString method to print all the object info
    public String toString()
    {
        if (sold == true)
        {
            return "The car has been sold\n" + super.toString();
        }
        else
        {
            return "The car has not been sold!\n" + super.toString() + "\nPrice = " + price + "\nRegistration Year = " + regYear + "\nMileage = " + mileage;
        }
    }
}
