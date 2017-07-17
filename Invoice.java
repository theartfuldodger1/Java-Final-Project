/*
Author: Cordell hurst
Course: CSCI 293
Instructor: Dr. Musab Yasin
Assignment: Final Project
Date: 7/17/2017

This program defines the Invoice class in order to demonstrate the use of lambdas 
and streams available in Java 8.
*/
package invoice;//MAY HAVE NOT RUN IF ATTEMPTED TO RUN AS .JAVA. MAY NEED TO COMMENT OUT THIS LINE IN BOTH FILES

public class Invoice 
{
    private double Price; //Include two decimal places
    private int PartNumber; //unique number
    private int Quantity; //quantity purchased
    private String PartDescription; //Brief description of item
    
    //No-param constructor
    //Precondition: none
    //Postcondition: Creation of Invoice object. Variables assigned 0 or 0.0 where 
    //appropriate with exception of PartDescription (see PartDescription below)
    Invoice ()
    {
        Price = 0.0;
        PartNumber = 0;
        Quantity = 0;
        PartDescription = "No description has been added";
    }
    //Constructor setting all params
    //Precondition: none
    //Postcondition: Creation of Invoice object. Variables assigned according to 
    //incoming params
    Invoice (int partNumIn, String partDescriptionIn, int quantityIn, double princeIn)
    {
        Price = princeIn;
        PartNumber = partNumIn;
        Quantity = quantityIn;
        PartDescription = partDescriptionIn;
    }
    //Setter for ALL fields
    //Precondition: Invoice object must be created first
    //Postcondition: Invoice object with all variables assigned according to incoming params
    public void setAll (double princeIn, int partNumIn, int quantityIn, String partDescriptionIn)
    {
        Price = princeIn;
        PartNumber = partNumIn;
        Quantity = quantityIn;
        PartDescription = partDescriptionIn;
    }
    //Setter for Price
    //Precondition: Invoice object must be created first
    //Postcondition: Invoice object with Price variable assigned according to 
    //incoming params
    public void setPrice (double priceIn)
    {
        Price = priceIn;
    }
    //Setter for PartNumber
    //Precondition: Invoice object must be created first
    //Postcondition: Invoice object with PartNumber variable assigned according to 
    //incoming params
    public void setPartNumber (int partNumIn)
    {
        PartNumber = partNumIn;
    }
   //Setter for Quantity
    //Precondition: Invoice object must be created first
    //Postcondition: Invoice object with Quantity variable assigned according to 
    //incoming params
    public void setQuantity (int quantityIn)
    {
        Quantity = quantityIn;
    }
    //Setter for PartDescription
    //Precondition: Invoice object must be created first
    //Postcondition: Invoice object with PartDescription variable assigned according to 
    //incoming params
    public void setPartDescription (String partDescriptionIn)
    {
        PartDescription = partDescriptionIn;
    }
    //Defines toString for Invoice Class
    //Precondition: Invoice object must be created first
    //Postcondition: Returns all populated variable values. Ensures 2 decimal places
    @Override
    public String toString ()
    {
        return (PartNumber + " " + PartDescription + " " + Quantity 
                + " " + String.format("%.2f", Price));//ensures 2 decimal places
    }
    //Getter for Price
    //Precondition: Invoice object must be created first
    //Postcondition: Returns Price variable value
    public double getPrice ()
    {
        return Price;
    }
    //Getter for PartNumber
    //Precondition: Invoice object must be created first
    //Postcondition: Returns PartNumber variable value
    public int getPartNumber ()
    {
        return PartNumber;
    }
    //Getter for Quantity
    //Precondition: Invoice object must be created first
    //Postcondition: Returns Quantity variable value
    public int getQuantity ()
    {
        return Quantity;
    }
    //Getter for PartDescription
    //Precondition: Invoice object must be created first
    //Postcondition: Returns PartDescription variable value 
    public String getPartDescription ()
    {
        return PartDescription;
    }
    //Getter for PartDescription AND Quantity
    //Precondition: Invoice object must be created first
    //Postcondition: Returns PartDescription and Quantity values as a string
    public String getDescriptionAndQuantity() 
    {
        return String.format("%s %s", PartDescription, Quantity);
    }
    //Getter for PartDescription AND Invoice Value (Quantity * Price)
    //Precondition: Invoice object must be created first.
    //Postcondition: Determines Invoice value (Quantity * Price). 
    //  Returns PartDescription and Invoice Value as a string. Ensures 2 decimal places
    public String getDescriptionAndValue() 
    {
       return String.format("%s %.2f", PartDescription, Quantity * Price);//ensures 2 decimal places
    }
    //Getter for Invoice Value (Quantity * Price)
    //Precondition: Invoice object must be created first.
    //Postcondition: Determines Invoice value (Quantity * Price). 
    //  Returns Invoice Value as a double.
    public double getValue() 
    {
       return Quantity * Price;
    }
}
