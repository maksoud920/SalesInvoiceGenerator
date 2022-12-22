package model;

import java.util.ArrayList;
import java.util.Date;

public class InvoiceHeader {

    private int invoiceNum;
    private Date invoiceDate;
    private String customerName;
    private ArrayList<InvoiceLine> invoiceLine= new ArrayList<>();

}
