/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package e._book._store;

import static e._book._store.application.query;
import static e._book._store.application.rs;
import static e._book._store.application.ss;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class publisher_form extends JPanel implements ActionListener {

    JLabel Publisher_ID_label = new JLabel("Publisher ID");
    JTextField Publisher_ID_text = new JTextField();
    JLabel Name_label = new JLabel("Name");
    JTextField Name_text = new JTextField();
    JLabel city_label = new JLabel("city");
    JTextField city_text = new JTextField();

    JButton Add_btn = new JButton("Add");
    JButton Delete_btn = new JButton("Delete");
    JButton Update_btn = new JButton("Update");
    JButton Show_ALL_btn = new JButton("Show ALL");

    JButton publisher_Phones_forms_btn = new JButton("PHONES");

    JTable table;
    JScrollPane scroll;
    DefaultTableModel TableModel;

    application application;

    public publisher_form(application _application) {

        application = _application;

        //publishers
        this.setBounds(200, 0, 900, 630);
        //p3.setBackground(Color.BLACK);
        application.parentpanel.add(this);
        this.setLayout(null);

        Publisher_ID_label.setBounds(40, 10, 100, 30);
        this.add(Publisher_ID_label);
        Publisher_ID_text.setBounds(30, 40, 100, 30);
        this.add(Publisher_ID_text);

        Name_label.setBounds(170, 10, 100, 30);
        this.add(Name_label);
        Name_text.setBounds(150, 40, 100, 30);
        this.add(Name_text);

        city_label.setBounds(290, 10, 100, 30);
        this.add(city_label);
        city_text.setBounds(270, 40, 100, 30);
        this.add(city_text);

        Add_btn.setBounds(500, 40, 80, 30);
        this.add(Add_btn);
        Add_btn.addActionListener(this);
        Update_btn.setBounds(590, 40, 80, 30);
        this.add(Update_btn);
        Delete_btn.addActionListener(this);
        Delete_btn.setBounds(680, 40, 80, 30);
        this.add(Delete_btn);
        Update_btn.addActionListener(this);
        Show_ALL_btn.setBounds(770, 40, 100, 30);
        this.add(Show_ALL_btn);
        Show_ALL_btn.addActionListener(this);

        publisher_Phones_forms_btn.setBounds(770, 300, 100, 30);
        this.add(publisher_Phones_forms_btn);
        publisher_Phones_forms_btn.addActionListener(this);

        String[][] publisher = {};
        String[] pheader = {"publisher ID", "name", "city"};
        TableModel = new DefaultTableModel(publisher, pheader);
        table = new JTable(TableModel);
        scroll = new JScrollPane(table);
        this.add(scroll);
        scroll.setBounds(30, 100, 700, 900);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /////////////////////////publishers/////////////////////////////////////////////
        String text1;
        String text2;
        String text3;
        //insert

        if (e.getSource() == Add_btn) {
            if (Publisher_ID_text.getText().equals("") || Name_text.getText().equals("")) {

                JOptionPane.showMessageDialog(this, "please enter publisher id and name");

            } else {
                try {

                    text1 = Publisher_ID_text.getText();
                    text2 = Name_text.getText();
                    text3 = city_text.getText();

                    query = "insert into publisher values(N'" + text1 + "',N'" + text2 + "',N'" + text3 + "')";

                    ss.executeUpdate(query);

                    JOptionPane.showMessageDialog(this, "Data added successfully");

                    Publisher_ID_text.setText("");
                    Name_text.setText("");
                    city_text.setText("");

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, ex);
                    //Logger.getLogger(application.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

        //update
        if (e.getSource() == Update_btn) {

            if (Publisher_ID_text.getText().equals("")) {

                JOptionPane.showMessageDialog(this, "please enter publisher id");

            } else {
                try {

                    text1 = Publisher_ID_text.getText();
                    text2 = Name_text.getText();
                    text3 = city_text.getText();

                    query = "update publisher set name = N'" + text2 + "',city = N'" + text3 + "'where publisher_id = N'" + text1 + "'";

                    ss.executeUpdate(query);

                    JOptionPane.showMessageDialog(this, "Data Updated successfully");

                    Publisher_ID_text.setText("");
                    Name_text.setText("");
                    city_text.setText("");

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, ex);
                    // Logger.getLogger(application.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //delete
        if (e.getSource() == Delete_btn) {

            if (Publisher_ID_text.getText().equals("")) {

                JOptionPane.showMessageDialog(this, "please enter Publisher id");

            } else {
                try {

                    text1 = Publisher_ID_text.getText();
                    query = "delete from publisher where publisher_id = N'" + text1 + "'";

                    ss.executeUpdate(query);

                    JOptionPane.showMessageDialog(this, "Data deleted successfully");

                    Publisher_ID_text.setText("");

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, ex);
                    // Logger.getLogger(application.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //show on table
        if (e.getSource() == Show_ALL_btn) {

            try {

                query = "select * from publisher";

                rs = ss.executeQuery(query);

                TableModel.setRowCount(0);
                while (rs.next()) {

                    String publisher_id = rs.getString("publisher_id");
                    String name = rs.getString("name");
                    String city = rs.getString("city");

                    String data[] = {publisher_id, name, city};

                    TableModel.addRow(data);
                }

                JOptionPane.showMessageDialog(this, "Data imported sucssfully");

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex);
                // Logger.getLogger(application.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == publisher_Phones_forms_btn) {

            application.parentpanel.removeAll();
            application.parentpanel.add(application.publisher_phones_form);
            application.parentpanel.repaint();
            application.parentpanel.revalidate();
        }

    }

}
