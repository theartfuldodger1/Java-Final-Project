/*
Author: Cordell hurst
Course: CSCI 293
Instructor: Dr. Musab Yasin
Assignment: Final Project
Date: 07/17/2017

This progam demonstrates the use of lambdas and streams available in Java 8.
*/
package invoice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.List;
import java.util.stream.Collectors;

public class InvoiceDriver 
{
    public static void main(String[] args) 
    {
        Invoice[] invoiceArr = {
            new Invoice(83 , "Electric sander", 7, 57.89),
            new Invoice(24, "Power saw", 18, 99.99),
            new Invoice(7, "Sledge hammer", 11, 21.50),
            new Invoice(77, "Hammer", 76, 11.99),
            new Invoice(39, "Lawn mower", 3, 79.50),
            new Invoice(68, "Screwdriver", 106, 6.99),
            new Invoice(56, "Jig saw", 21 ,11.00),
            new Invoice(3, "Wrench", 34, 7.50)};
        
        List<Invoice> InvoiceList = Arrays.asList(invoiceArr);
        
        //Sort Functions
        Function<Invoice, String> sortPartDescription = Invoice::getPartDescription;
        Function<Invoice, Integer> sortPartNumber = Invoice::getPartNumber;
        Function<Invoice, Double> sortPrice = Invoice::getPrice;
        Function<Invoice, Integer> sortQuantity = Invoice::getQuantity;
        Function<Invoice, Double> sortValue = Invoice::getValue;
        
        //Comparator by PartDescsriprion
        Comparator<Invoice> byPartDesc = Comparator.comparing(sortPartDescription);
        //Use lambdas and streams to sort the Invoice objects by PartDescription, 
        //then display the results.
        System.out.printf("%nInvoice objects sorted by Part Description: %n");
            InvoiceList.stream()
                .sorted(byPartDesc)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        //Comparator by Price
        Comparator<Invoice> byPrice = Comparator.comparing(sortPrice);
        //Use lambdas and streams to sort the Invoice objects by Price, 
        //then display the results.
        System.out.printf("%nInvoice Objects sorted by Price: %n");
            InvoiceList.stream()
                .sorted(byPrice)
                .forEach(System.out::println);
        
        //Comparator by Quantity
        Comparator<Invoice> byQuantity = Comparator.comparing(sortQuantity);
        //Use lambdas and streams to map each Invoice to its PartDescription and Quantity , 
        //sort the results by Quantity , then display the results.
        System.out.printf("%nInvoice objects mapped to Part Descripton and Quantity: %n");
            InvoiceList.stream()
                .sorted(byQuantity)
                .map(Invoice::getDescriptionAndQuantity)
                .forEach(System.out::println);
        
        //Comparator by Invoice Value (Quantity * Price)
        Comparator<Invoice> byValue = Comparator.comparing(sortValue);
        //lambdas and streams to map each Invoice to its PartDescription and 
        //the value of the Invoice (i.e., Quantity * Price ). Order the results by Invoice value.
        System.out.printf("%nInvoice objects mapped to Part Descripton and Invoice Value: %n");
            InvoiceList.stream()
                .sorted(byValue)
                .map(Invoice::getDescriptionAndValue)
                .forEach(System.out::println);
        
        //Modify Part (d) to select the Invoice values in the range $200 to $500.
        System.out.printf("%nInvoice objects mapped to Part Descripton and Invoice Value. "
            + "%nFilters Invoice values to the range $200 to $500: %n");
            InvoiceList.stream()
                .sorted(byValue)
                .filter(Invoice -> Invoice.getValue() > 200 && Invoice.getValue() < 500)
                .map(Invoice::getDescriptionAndValue)
                .forEach(System.out::println);
    }
}
