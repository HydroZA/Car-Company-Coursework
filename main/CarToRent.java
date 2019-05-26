/*
CS4001 Programming
Coursework 2
All code by JAMES LEGGE
London Metropolitan University
BSc Computer Networking and Cyber Security
*/
 
 package main;
public class CarToRent extends Car
{
    public String rentalDate, returnDate;
    public int adminFee, numOfDays, dailyRate, totalAccumulated;
    public boolean onLoan;
    
    public CarToRent(String d, int af, int dr)
    {
        super(d);
        description = d;
        adminFee = af;
        dailyRate = dr;
        rentalDate = "";
        returnDate = "";
        numOfDays = 0;
        totalAccumulated = 0;
        onLoan = false;
    }
    
    public String getRentalDate()
    {
        return rentalDate;
    }
    public String getReturnDate()
    {
        return returnDate;
    }
    public int getNumberOfDays()
    {
        return numOfDays;
    }
    public int getAdminFee()
    {
        return adminFee;
    }
    public int getDailyRate()
    {
        return dailyRate;
    }
    public int getTotalAccumulated()
    {
        return totalAccumulated;
    }
    public boolean isOnloan()
    {
        return onLoan;
    }
    
    public void setDailyRate(int dr)
    {
        dailyRate = dr;
    }
    
    public void setAdminFee(int af)
    {
        adminFee = af;
    }
    
    public void rentCar(String cn, String rentD, String returnD, int nd)
    {
        if (onLoan == true)
        {
            System.out.println("Error, this car is already rented");
        }
        else
        {
            rentalDate = rentD;
            returnDate = returnD;
            numOfDays = nd;
            setCustomerName(cn);
            onLoan = true;
            
            int amtPaid = (dailyRate * numOfDays) + adminFee;
            totalAccumulated += amtPaid;
        }
    }
    
    public void returnCar()
    {   
        if(onLoan == true)
        {
            setCustomerName("");
            numOfDays = 0;
            rentalDate = "";
            returnDate = "";
            onLoan = false;
        }
        
        else
        {
            System.out.println("The car is not on loan, unable to return");
        }
    }
    
    public String printRentCar()
    {
        return super.toString() + "\nThe total accumulated is: " + totalAccumulated;
    }
    
    public String toString()
    {     
        if (onLoan == true)
        {
            return "The description is: " + super.getDescription() + "\nThe admin fee is: " + adminFee + "\nThe daily rate is: " + dailyRate + "\nThe rental date was: " + rentalDate + 
                    "\nThe return date is: " + returnDate + "\nThe number of days the car is rented is: " + numOfDays;
        }
        else
        {    
            return super.toString() + "\nThe admin fee is: " + adminFee + "\nThe daily rate is: " + dailyRate;
    
        }
    }
}
