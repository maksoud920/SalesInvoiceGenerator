package controller;

import model.FileOperations;
import model.InvoiceHeader;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InvoiceController implements ActionListener {
    FileOperations f = new FileOperations();

    public InvoiceController() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {

            case "NewBtn": //for create new invoice button

                break;

            case "DeleteBtn": // for delete invoice button
                JOptionPane.showMessageDialog(null, "You pressed Delete Button", "Welcome", JOptionPane.INFORMATION_MESSAGE);
                break;

            case "SaveBtn": // for save invoice button
                JOptionPane.showMessageDialog(null, "You pressed Save Button", "Welcome", JOptionPane.INFORMATION_MESSAGE);
                break;

            case "CancelBtn": //for cancel button
                JOptionPane.showMessageDialog(null, "You pressed Cancel Button", "Welcome", JOptionPane.INFORMATION_MESSAGE);
                break;

            case "LoadMenu": //for Load file menu item
                f.readFile("./Data/InvoiceHeader.csv");
  //              System.exit(0);
                break;

            case "SaveMenu": //for Save file Menu item
                System.exit(0);
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + e.getActionCommand());
        }


    }

}
