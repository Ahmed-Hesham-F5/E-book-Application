/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package e._book._store;

import static e._book._store.application.query;
import static e._book._store.application.rs;
import static e._book._store.application.ss;
import java.awt.GridLayout;
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

public class authors_form extends JPanel implements ActionListener {

    JLabel Ahuthor_ID_label = new JLabel("Ahuthor ID");
    JTextField Ahuthor_ID_text = new JTextField();
    JLabel First_Name_label = new JLabel("First Name");
    JTextField First_Name_text = new JTextField();
    JLabel Last_Name_label = new JLabel("Last Name");
    JTextField Last_Name_text = new JTextField();

    JButton Add_btn = new JButton("Add");
    JButton Delete_btn = new JButton("Delete");
    JButton Update_btn = new JButton("Update");
    JButton Show_ALL_btn = new JButton("Show ALL");

    JButton authors_books_form_btn = new JButton("authors books");

    static JTable p5_table;
    JScrollPane p5_scroll;
    DefaultTableModel t5;
    application application;

    public authors_form(application _application) {

        application = _application;
        //authors

        this.setBounds(200, 0, 900, 630);

        application.parentpanel.add(this);
        this.setLayout(null);

        Ahuthor_ID_label.setBounds(40, 10, 100, 30);
        this.add(Ahuthor_ID_label);
        Ahuthor_ID_text.setBounds(30, 40, 100, 30);
        this.add(Ahuthor_ID_text);

        First_Name_label.setBounds(170, 10, 100, 30);
        this.add(First_Name_label);
        First_Name_text.setBounds(150, 40, 100, 30);
        this.add(First_Name_text);

        Last_Name_label.setBounds(290, 10, 100, 30);
        this.add(Last_Name_label);
        Last_Name_text.setBounds(270, 40, 100, 30);
        this.add(Last_Name_text);

        Add_btn.setBounds(500, 40, 80, 30);
        this.add(Add_btn);
        Add_btn.addActionListener(this);
        Update_btn.setBounds(590, 40, 80, 30);
        this.add(Update_btn);
        Update_btn.addActionListener(this);
        Delete_btn.setBounds(680, 40, 80, 30);
        this.add(Delete_btn);
        Delete_btn.addActionListener(this);
        Show_ALL_btn.setBounds(770, 40, 100, 30);
        this.add(Show_ALL_btn);
        Show_ALL_btn.addActionListener(this);

        authors_books_form_btn.setBounds(733, 300, 150, 30);
        this.add(authors_books_form_btn);
        authors_books_form_btn.addActionListener(this);

        String[][] authors = {};
        String[] aheader = {"author_id", "First name", "Last name"};
        t5 = new DefaultTableModel(authors, aheader);
        p5_table = new JTable(t5);
        p5_scroll = new JScrollPane(p5_table);
        this.add(p5_scroll);
        p5_scroll.setBounds(30, 100, 700, 900);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text1, text2, text3;
        //author table 
        //insert
        if (e.getSource() == Add_btn) {
            if (Ahuthor_ID_text.getText().equals("") || First_Name_text.getText().equals("") && Last_Name_text.getText().equals("")) {

                JOptionPane.showMessageDialog(this, "please enter author id and name");

            } else {
                try {

                    text1 = Ahuthor_ID_text.getText();
                    text2 = First_Name_text.getText();
                    text3 = Last_Name_text.getText();

                    query = "insert into author values(N'" + text1 + "',N'" + text2 + "',N'" + text3 + "')";

                    ss.executeUpdate(query);

                    JOptionPane.showMessageDialog(this, "Data added successfully");

                    Ahuthor_ID_text.setText("");
                    First_Name_text.setText("");
                    Last_Name_text.setText("");

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, ex);
                    //Logger.getLogger(application.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
        //update
        if (e.getSource() == Update_btn) {

            if (Ahuthor_ID_text.getText().equals("")) {

                JOptionPane.showMessageDialog(this, "please enter author id");

            } else {
                try {

                    text1 = Ahuthor_ID_text.getText();
                    text2 = First_Name_text.getText();
                    text3 = Last_Name_text.getText();

                    query = "update author set Fname = N'" + text2 + "',Lname = N'" + text3 + "'where author_id = N'" + text1 + "'";

                    ss.executeUpdate(query);

                    JOptionPane.showMessageDialog(this, "Data Updated successfully");

                    Ahuthor_ID_text.setText("");
                    First_Name_text.setText("");
                    Last_Name_text.setText("");

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, ex);
                    // Logger.getLogger(application.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        //delete
        if (e.getSource() == Delete_btn) {

            if (Ahuthor_ID_text.getText().equals("")) {

                JOptionPane.showMessageDialog(this, "please enter author id");

            } else {
                try {

                    text1 = Ahuthor_ID_text.getText();
                    query = "delete from author where author_id = N'" + text1 + "'";

                    ss.executeUpdate(query);

                    JOptionPane.showMessageDialog(this, "Data deleted successfully");

                    Ahuthor_ID_text.setText("");
                    First_Name_text.setText("");
                    Last_Name_text.setText("");

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, ex);
                    //Logger.getLogger(application.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        //show on table
        if (e.getSource() == Show_ALL_btn) {

            try {

                query = "select * from author";

                rs = ss.executeQuery(query);

                t5.setRowCount(0);
                while (rs.next()) {

                    String author_id = rs.getString("author_id");
                    String Fname = rs.getString("Fname");
                    String Lname = rs.getString("Lname");

                    String data[] = {author_id, Fname, Lname};

                    t5.addRow(data);
                }

                JOptionPane.showMessageDialog(this, "Data imported sucssfully");

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex);
                //Logger.getLogger(application.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (e.getSource() == authors_books_form_btn) {

           application. parentpanel.removeAll();
           application. parentpanel.add(application.authors_books_form);
           application. parentpanel.repaint();
           application. parentpanel.revalidate();
        }
    }

}
