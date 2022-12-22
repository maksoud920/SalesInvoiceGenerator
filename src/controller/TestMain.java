package controller;
import model.InvoiceHeader;
import model.InvoiceLine;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class TestMain {
    public static void main(String[] s) {
        try {
            Scanner s1 = new Scanner(new File("./Data/InvoiceHeader.csv"));
            InvoiceHeader inv = new InvoiceHeader();
            InvoiceLine invLine = new InvoiceLine();
            while (s1.hasNext()) {
                String[] line1 = s1.nextLine().split(",");
                inv.setInvoiceNum(Integer.parseInt(line1[0]));
                inv.setInvoiceDate(line1[1]);
                inv.setCustomerName(line1[2]);
                System.out.println(inv.getInvoiceNum());
                System.out.println("{");
                System.out.print(inv.getInvoiceDate());
                System.out.println(", " + inv.getCustomerName());
                /////////////////////////
                Scanner s2 = new Scanner(new File("./Data/InvoiceLine.csv"));
                while (s2.hasNext()) {
                    String[] line2 = s2.nextLine().split(",");
                        if (Integer.parseInt(line1[0]) == Integer.parseInt(line2[0])) {
                            invLine.setItemName(line2[1]);
                            invLine.setItemPrice(Integer.parseInt(line2[2]));
                            invLine.setCount(Integer.parseInt(line2[3]));
                            System.out.print(invLine.getItemName());
                            System.out.print(", " + invLine.getItemPrice());
                            System.out.println(", " + invLine.getCount());
                        }
                }
                System.out.println("}");
                System.out.println();
                System.out.println();
            }
        }   catch (FileNotFoundException e) {e.printStackTrace();}
    }
}






