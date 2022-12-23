package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class FileOperations {


    public ArrayList<InvoiceHeader> readFile(String inputFilePath) {

        ArrayList<InvoiceHeader> invoiceArray = new ArrayList<>();

        try {
            Scanner s1 = new Scanner(new File(inputFilePath));

            while (s1.hasNext()) {
                InvoiceHeader invoiceHeader = new InvoiceHeader();
                ArrayList<InvoiceLine> invoiceLineArray = new ArrayList<>();


                String[] lineS1 = s1.nextLine().split(",");
                invoiceHeader.setInvoiceNum(Integer.parseInt(lineS1[0]));
                invoiceHeader.setInvoiceDate(lineS1[1]);
                invoiceHeader.setCustomerName(lineS1[2]);
 //               System.out.println(invoiceHeader.getInvoiceNum());
   //             System.out.println(invoiceHeader.getInvoiceDate());
     //           System.out.println(invoiceHeader.getCustomerName());
                Scanner s2 = new Scanner(new File("./Data/InvoiceLine.csv"));
                while (s2.hasNext()){
                    InvoiceLine invoiceLine = new InvoiceLine();
                    String[] lineS2 = s2.nextLine().split(",");
                    if (Integer.parseInt(lineS1[0]) == Integer.parseInt(lineS2[0])) {
                        invoiceLine.setItemName(lineS2[1]);
                        invoiceLine.setItemPrice(Integer.parseInt(lineS2[2]));
                        invoiceLine.setCount(Integer.parseInt(lineS2[3]));
       //                 System.out.print(invoiceLine.getItemName());
         //               System.out.print(", " + invoiceLine.getItemPrice());
           //             System.out.println(", " + invoiceLine.getCount());
                        invoiceLineArray.add(invoiceLine);
                    }
                }
                invoiceHeader.setInvoiceLine(invoiceLineArray);
                invoiceArray.add(invoiceHeader);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return invoiceArray;
    }





    public void writeFile(ArrayList<InvoiceHeader> invoiceHeaders){

    }

}
