package controller;
//Imports
import model.FileOperations;
import model.InvoiceHeader;
import model.InvoiceLine;
import view.InvoiceFrame;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

//InvoiceController class
public class InvoiceController implements ActionListener, ListSelectionListener {
    private InvoiceFrame frame;
    private FileOperations FileOp = new FileOperations();
    public ArrayList<InvoiceHeader> MainArrayList = new ArrayList<>();

    //Class Constructor
    public InvoiceController(InvoiceFrame frame) {
        this.frame = frame;

    }

    //method for showing data in frame
    public void LoadData(String path){
        frame.getTable1().setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {{null, null, null, null}
              },
                new String [] {
                        "No.", "Date", "Customer", "Total"
                }
        ));
        MainArrayList = FileOp.readFile(path); //retrieve the data from the InvoiceHeaders file and return it in ArrayList variable
        ArrayList<InvoiceLine> line;
        InvoiceHeader header;
        for(int i=0; i < MainArrayList.size(); i++){ //loop on the MainArrayList to get values and show in frame
            header = MainArrayList.get(i);
            int InvNo = header.getInvoiceNum();
            String InvDate = header.getInvoiceDate();
            String InvCus = header.getCustomerName();
            line = header.getInvoiceLine();
            int Total = 0;
            Scanner s2 = null; //Scanner for reading InvoiceLine file
            try {
                s2 = new Scanner(new File("../Data/InvoiceLine.csv"));
            } catch (FileNotFoundException e) {
                File f = new File("../Data/InvoiceLine.csv");
                if (!f.exists()) {
                    JOptionPane.showMessageDialog(null, "File not Found", "Error", JOptionPane.ERROR_MESSAGE);

                }
            }
            while (s2.hasNext()) {  //retrieve data from InvoiceLine file
                String[] line2 = s2.nextLine().split(",");
                if (InvNo == Integer.parseInt(line2[0])) {
                    Total += Integer.parseInt(line2[2]) * Integer.parseInt(line2[3]);
                }
            }
                Object[] row = {InvNo, InvDate, InvCus, Total};
                frame.SetTable1(row); //add rows to the JTable
            }

    }

    public void ShowSelected(int RowIndex){  //method for showing InvoiceLine data in InvoiceLine Table by Selecting the invoice in InvoiceHeaders Table


        int InvNo = (int) frame.getTable1().getModel().getValueAt(RowIndex, 0);
        String InvDate = (String) frame.getTable1().getModel().getValueAt(RowIndex, 1);
        String InvCus = (String) frame.getTable1().getModel().getValueAt(RowIndex, 2);
        int InvTotal = (int) frame.getTable1().getModel().getValueAt(RowIndex, 3);
        int TotalItemPrice;
        frame.setInvNumLbl2(String.valueOf(InvNo));  // show values in frame
        frame.setInvDateTF(InvDate);
        frame.setCusNameTF(InvCus);
        frame.setInvTotalLbl2(String.valueOf(InvTotal));


        Scanner s2 = null;
        try {
            s2 = new Scanner(new File("../Data/InvoiceLine.csv")); //Scanner for reading InvoiceLine file
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            while (s2.hasNext()) { //retrieve data from InvoiceLine file
                String[] line2 = s2.nextLine().split(",");
                if (InvNo == Integer.parseInt(line2[0])) {
                    String ItemName = line2[1];
                    int ItemPrice = Integer.parseInt(line2[2]);
                    int ItemCount = Integer.parseInt(line2[3]);
                    TotalItemPrice = ItemPrice * ItemCount;
                    Object[] row = {InvNo, ItemName, ItemPrice, ItemCount, TotalItemPrice};
                    frame.SetTable2(row);  //add rows to the JTable
                } else {
                }
            }
    }

    public ArrayList<InvoiceHeader> CreateNew(){  //method for creating New Invoice and store InvoiceHeader data in the MainArrayList global variable
        InvoiceHeader header = new InvoiceHeader();
        InvoiceLine line = new InvoiceLine();
        int size = MainArrayList.size();
        header.setInvoiceNum((Integer) frame.getTable1().getValueAt((size+1), 0));
        header.setInvoiceDate((String) frame.getTable1().getValueAt((size+1),1));
        header.setCustomerName((String) frame.getTable1().getValueAt((size+1),2));
        MainArrayList.add(header);
        return MainArrayList;
    }

    public void SaveBtnPressed(){ // method to store InvoiceLine details in the MainArrayList global variable
        ArrayList<InvoiceLine> ArrayLine = new ArrayList<>();
        InvoiceLine line = new InvoiceLine();
        int size = MainArrayList.size();
        line.setInvoiceNum(MainArrayList.get(size - 1).getInvoiceNum());
        line.setItemName((String) frame.getTable2().getValueAt(0,1));
        line.setItemPrice((Integer) frame.getTable2().getValueAt(0,2));
        line.setCount((Integer) frame.getTable2().getValueAt(0,3));
        ArrayLine.add(line);
        MainArrayList.get(size-1).setInvoiceLine(ArrayLine);
    }

    public void DeleteInvoice() //method for deleting the invoice from the table
    {
        int row = frame.getTable1().getSelectedRow();
        frame.getTable1().setValueAt("",row,0);
        frame.getTable1().setValueAt("",row,1);
        frame.getTable1().setValueAt("",row,2);
        frame.getTable1().setValueAt("",row,3);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {

            case "NewBtn": //for create new invoice button
                CreateNew();
                break;

            case "DeleteBtn": // for delete invoice button
                DeleteInvoice();
                break;

            case "SaveBtn": // for save invoice button
                SaveBtnPressed();
                break;

            case "CancelBtn": //for cancel button
                LoadData("../Data/InvoiceHeader.csv"); // Load the data again and ignore any changes happened
                break;

            case "LoadMenu": //for Load file menu item
                LoadData("../Data/InvoiceHeader.csv");
                break;

            case "SaveMenu": //for Save file Menu item
                FileOp.writeFile(MainArrayList); // Write in the file
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + e.getActionCommand());
        }

    }



    @Override
    public void valueChanged(ListSelectionEvent e) {
        frame.getTable2().setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{{null, null, null, null, null}
      /*                  {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null}
     */           },
                new String[]{
                        "No.", "Item Name", "Item Price", "Count", "Item Total"
                }
        ));

        frame.setInvNumLbl2("");
        frame.setInvDateTF("");
        frame.setCusNameTF("");
        frame.setInvTotalLbl2(String.valueOf(""));

        int RowIndex = frame.getTable1().getSelectedRow();
        if( frame.getTable1().getModel().getValueAt(RowIndex, 0) != null) {

            ShowSelected(RowIndex);
        }

    }
}
