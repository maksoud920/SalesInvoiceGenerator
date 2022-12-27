package model;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class FileOperations {

    public FileOperations() {
    }

    public ArrayList<InvoiceHeader> readFile(String inputFilePath) {  //Read data from the InvoiceHeader and InvoiceLine files

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
                System.out.println(invoiceHeader.getInvoiceNum());
                System.out.println(invoiceHeader.getInvoiceDate());
                System.out.println(invoiceHeader.getCustomerName());
                Scanner s2 = new Scanner(new File("../Data/InvoiceLine.csv"));
                while (s2.hasNext()) {
                    InvoiceLine invoiceLine = new InvoiceLine();
                    String[] lineS2 = s2.nextLine().split(",");
                    if (Integer.parseInt(lineS1[0]) == Integer.parseInt(lineS2[0])) {
                        invoiceLine.setItemName(lineS2[1]);
                        invoiceLine.setItemPrice(Integer.parseInt(lineS2[2]));
                        invoiceLine.setCount(Integer.parseInt(lineS2[3]));
                        System.out.print(invoiceLine.getItemName());
                        System.out.print(", " + invoiceLine.getItemPrice());
                        System.out.println(", " + invoiceLine.getCount());
                        invoiceLineArray.add(invoiceLine);
                    }
                }
                invoiceHeader.setInvoiceLine(invoiceLineArray);
                invoiceArray.add(invoiceHeader);

            }

        } catch (FileNotFoundException e) {
            File f = new File("../Data/InvoiceHeader.csv");
            if (!f.exists()) {
                JOptionPane.showMessageDialog(null, "InvoiceHeader file not Found", "Error", JOptionPane.ERROR_MESSAGE);
            }
            File f2 = new File("../Data/InvoiceLine.csv");
            if (!f2.exists()) {
                JOptionPane.showMessageDialog(null, "InvoiceLine file not Found", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
        return invoiceArray;
    }

        public void writeFile (ArrayList<InvoiceHeader> invoiceHeadersList) {  // write data to the InvoiceHeader and InvoiceLine files
            try {
                FileWriter fw = new FileWriter("../Data/InvoiceHeader.csv", false);
                FileWriter fw2 = new FileWriter("../Data/InvoiceLine.csv", false);
                BufferedWriter bw = new BufferedWriter(fw);
                BufferedWriter bw2 = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                PrintWriter pw2 = new PrintWriter(bw);
                int sizeheader = invoiceHeadersList.size();
                for (int i = 0; i < sizeheader; i++) {
                    int InvNo = invoiceHeadersList.get(i).getInvoiceNum();
                    String InDate = invoiceHeadersList.get(i).getInvoiceDate();
                    String CusName = invoiceHeadersList.get(i).getCustomerName();
                    int sizeline = invoiceHeadersList.get(i).getInvoiceLine().size();
                    for(int j = 0; j < sizeline; j++) {
                        String ItemName = invoiceHeadersList.get(i).getInvoiceLine().get(j).getItemName();
                        int ItemPrice = invoiceHeadersList.get(i).getInvoiceLine().get(j).getItemPrice();
                        int ItemCount = invoiceHeadersList.get(i).getInvoiceLine().get(j).getCount();
                        pw2.println(InvNo + "," + ItemName + ", " + ItemPrice + "," + ItemCount); //writing data to the InvoiceLine file
                    }
                    pw.println(InvNo + "," + InDate + "," + CusName); //writing data to the InvoiceHeader file
                    pw.flush();
                }
                pw.close();

                JOptionPane.showMessageDialog(null, "Invoices Saved to File");

            } catch (IOException e) {
                File f = new File("../Data/InvoiceHeader.csv");
                if (!f.exists()) {
                    JOptionPane.showMessageDialog(null, "InvoiceHeader file not Found", "Error", JOptionPane.ERROR_MESSAGE);
                }

                File f2 = new File("../Data/InvoiceLine.csv");
                if (!f2.exists()) {
                    JOptionPane.showMessageDialog(null, "InvoiceLine file not Found", "Error", JOptionPane.ERROR_MESSAGE);
                }

            }

        }


    }
