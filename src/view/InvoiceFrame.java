package view;

import javax.swing.*;
import java.awt.*;

public class InvoiceFrame extends JFrame {

    // Variables declaration - do not modify
    private JButton CancelBtn;
    private JLabel CusNameLbl;
    private JTextField CusNameTF;
    private JButton DeleteBtn;
    private JMenu FileMenu;
    private JMenuBar FrameMenuBar;
    private JLabel InvDateLbl;
    private JTextField InvDateTF;
    private JScrollPane InvItemScroll;
    private JTable InvItemTable;
    private JLabel InvItmLbl;
    private JLabel InvNumLbl;
    private JLabel InvNumLbl2;
    private JLabel InvTblLbl;
    private JScrollPane InvTblScroll;
    private JLabel InvTotalLbl;
    private JLabel InvTotalLbl2;
    private JTable InvoiceTable;
    private JPanel LeftPane;
    private JMenu LoadFileMenu;
    private JButton NewInvBtn;
    private JPanel RightPane;
    private JButton SaveBtn;
    private JMenu SaveFileMenu;
    // End of variables declaration

    public static void main(String[] args) {

        new InvoiceFrame().setVisible(true);
    }

    public InvoiceFrame() {

        LeftPane = new JPanel();
        InvTblLbl = new JLabel();
        NewInvBtn = new JButton();
        DeleteBtn = new JButton();
        InvTblScroll = new JScrollPane();
        InvoiceTable = new JTable();
        RightPane = new JPanel();
        InvItemScroll = new JScrollPane();
        InvItemTable = new JTable();
        SaveBtn = new JButton();
        CancelBtn = new JButton();
        InvItmLbl = new JLabel();
        InvNumLbl = new JLabel();
        InvNumLbl2 = new JLabel();
        InvDateLbl = new JLabel();
        InvDateTF = new JTextField();
        CusNameLbl = new JLabel();
        CusNameTF = new JTextField();
        InvTotalLbl = new JLabel();
        InvTotalLbl2 = new JLabel();
        FrameMenuBar = new JMenuBar();
        FileMenu = new JMenu();
        LoadFileMenu = new JMenu();
        SaveFileMenu = new JMenu();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        InvTblLbl.setText("Invoice Table");

        NewInvBtn.setText("Create New Invoice");
        NewInvBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewInvBtnActionPerformed(evt);
            }
        });

        DeleteBtn.setText("Delete Invoice");
        DeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteBtnActionPerformed(evt);
            }
        });

        InvoiceTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String [] {
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));
        InvTblScroll.setViewportView(InvoiceTable);

        GroupLayout LeftPaneLayout = new GroupLayout(LeftPane);
        LeftPane.setLayout(LeftPaneLayout);
        LeftPaneLayout.setHorizontalGroup(
                LeftPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(LeftPaneLayout.createSequentialGroup()
                                .addGroup(LeftPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(LeftPaneLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(InvTblLbl))
                                        .addGroup(LeftPaneLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(InvTblScroll, GroupLayout.PREFERRED_SIZE, 564, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, LeftPaneLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(NewInvBtn)
                                .addGap(69, 69, 69)
                                .addComponent(DeleteBtn)
                                .addGap(137, 137, 137))
        );
        LeftPaneLayout.setVerticalGroup(
                LeftPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(LeftPaneLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(InvTblLbl)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(InvTblScroll, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(LeftPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(DeleteBtn)
                                        .addComponent(NewInvBtn))
                                .addGap(69, 69, 69))
        );

        InvItemTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String [] {
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));
        InvItemScroll.setViewportView(InvItemTable);

        SaveBtn.setText("Save");
        SaveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveBtnActionPerformed(evt);
            }
        });

        CancelBtn.setText("Cancel");
        CancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelBtnActionPerformed(evt);
            }
        });

        InvItmLbl.setText("Invoice Items");

        InvNumLbl.setText("Invoice Number:");

        InvNumLbl2.setText("23");

        InvDateLbl.setText("Invoice Date");

        InvDateTF.setText("jTextField1");

        CusNameLbl.setText("Customer Name:");

        CusNameTF.setText("jTextField2");

        InvTotalLbl.setText("Invoice Total:");

        InvTotalLbl2.setText("jLabel6");

        GroupLayout RightPaneLayout = new GroupLayout(RightPane);
        RightPane.setLayout(RightPaneLayout);
        RightPaneLayout.setHorizontalGroup(
                RightPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(RightPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(RightPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(RightPaneLayout.createSequentialGroup()
                                                .addComponent(InvItmLbl)
                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(RightPaneLayout.createSequentialGroup()
                                                .addGroup(RightPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(InvNumLbl)
                                                        .addComponent(InvDateLbl)
                                                        .addComponent(CusNameLbl)
                                                        .addComponent(InvTotalLbl))
                                                .addGap(33, 33, 33)
                                                .addGroup(RightPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(InvDateTF)
                                                        .addComponent(CusNameTF)
                                                        .addComponent(InvTotalLbl2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(InvNumLbl2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addContainerGap())
                                        .addGroup(RightPaneLayout.createSequentialGroup()
                                                .addComponent(InvItemScroll, GroupLayout.PREFERRED_SIZE, 530, GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 32, Short.MAX_VALUE))))
                        .addGroup(RightPaneLayout.createSequentialGroup()
                                .addGap(104, 104, 104)
                                .addComponent(SaveBtn)
                                .addGap(135, 135, 135)
                                .addComponent(CancelBtn)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        RightPaneLayout.setVerticalGroup(
                RightPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(RightPaneLayout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(RightPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(InvNumLbl)
                                        .addComponent(InvNumLbl2))
                                .addGap(18, 18, 18)
                                .addGroup(RightPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(InvDateLbl)
                                        .addComponent(InvDateTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(RightPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(CusNameLbl)
                                        .addComponent(CusNameTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(RightPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(InvTotalLbl)
                                        .addComponent(InvTotalLbl2))
                                .addGap(48, 48, 48)
                                .addComponent(InvItmLbl)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(InvItemScroll, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                                .addGroup(RightPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(SaveBtn)
                                        .addComponent(CancelBtn))
                                .addGap(59, 59, 59))
        );

        FileMenu.setText("File");

        LoadFileMenu.setText("Load File");
        FileMenu.add(LoadFileMenu);

        SaveFileMenu.setText("Save File");
        FileMenu.add(SaveFileMenu);

        FrameMenuBar.add(FileMenu);

        setJMenuBar(FrameMenuBar);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(LeftPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(RightPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(LeftPane, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(RightPane, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>

    private void NewInvBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void DeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }
    private void SaveBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }
    private void CancelBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

}


