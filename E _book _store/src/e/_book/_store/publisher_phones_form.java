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

public class publisher_phones_form extends JPanel implements ActionListener {

    //publisher phones
    JLabel p4_l1 = new JLabel("Publisher ID");
    JTextField p4_t1 = new JTextField();
    JLabel p4_l2 = new JLabel("phone");
    JTextField p4_t2 = new JTextField();

    JButton p4_b1 = new JButton("Add");
    JButton p4_b2 = new JButton("Delete");
    JButton p4_b3 = new JButton("Update");
    JButton p4_b4 = new JButton("Show all");

    JTable p4_table;
    JScrollPane p4_scroll;

    DefaultTableModel t4;
    application application;

    public publisher_phones_form(application _application) {

        application = _application;
       //Publisher phone
        
        this.setBounds(200, 0, 900, 630);
       application. parentpanel.add(this);
        this.setLayout(null);
        
        p4_l1.setBounds(40,10, 100 , 30);this.add(p4_l1);
        p4_t1.setBounds(30,40, 100 , 30);this.add(p4_t1);
    
        p4_l2.setBounds(170,10, 100 , 30);this.add(p4_l2);
        p4_t2.setBounds(150,40, 100 , 30);this.add(p4_t2);
        
        p4_b1.setBounds(500, 40, 80 ,30); this.add(p4_b1);p4_b1.addActionListener(this);
        p4_b3.setBounds(590, 40, 80 ,30); this.add(p4_b3);p4_b3.addActionListener(this);
        p4_b2.setBounds(680, 40, 80 ,30); this.add(p4_b2);p4_b2.addActionListener(this);
        p4_b4.setBounds(770, 40, 100 ,30); this.add(p4_b4);p4_b4.addActionListener(this);
        
                        String [][] publishers_phone = { 
       
        };
        String[] pheader_phone={"publisher ID","phone"}; 
        t4 = new DefaultTableModel (publishers_phone,pheader_phone);
        p4_table = new JTable(t4);
        p4_scroll =new JScrollPane(p4_table);    
        this.add(p4_scroll);
        p4_scroll.setBounds(30, 100, 700, 900);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         String text1;
         String text2;
      
       ////////////////////////////////publishers phones ////////////////////////////////////////////////////////////////
   if(e.getSource()==p4_b1){
          if (p4_t1.getText().equals("")||p4_t2.getText().equals("")){
          
            JOptionPane.showMessageDialog(this, "please enter all data");
          
          }
          else{
          try {
              
          text1= p4_t1.getText();
          text2= p4_t2.getText();          
         query = "insert into publisher_phones values(N'"+text1+"',N'"+text2+"')";
        
              ss.executeUpdate(query);
              
              JOptionPane.showMessageDialog(this, "Data added successfully");
              
                  p4_t1.setText("");
                  p4_t2.setText("");
         
              
            } catch (SQLException ex) {
                 JOptionPane.showMessageDialog(this, ex);
                //Logger.getLogger(application.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
        
        }
        //update
        if(e.getSource()==p4_b3){
        
         if (p4_t2.getText().equals("")){
          
            JOptionPane.showMessageDialog(this, "please enter all data");
          
          }
          else{
          try {
              
          text1= p4_t1.getText();
          text2= p4_t2.getText();

                     
         query = "update publisher_phones set publisher_id = N'"+text1+"' where phone = N'"+text2+"'";
        
              ss.executeUpdate(query);
              
              JOptionPane.showMessageDialog(this, "Data Updated successfully");
              
                  p4_t1.setText("");
                  p4_t2.setText("");

              
            } catch (SQLException ex) {
                  JOptionPane.showMessageDialog(this, ex);
                //Logger.getLogger(application.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
        }
        
        
        //delete
         if(e.getSource()==p4_b2){
        
         if (p4_t2.getText().equals("")){
          
            JOptionPane.showMessageDialog(this, "please enter phone");
          
          }
          else{
          try {
              
          text1= p4_t2.getText();
          
         query = "delete from publisher_phones where phone = N'"+text1+"'";
        
              ss.executeUpdate(query);
              
              JOptionPane.showMessageDialog(this, "Data deleted successfully");
              
                  p4_t1.setText("");
                  p4_t2.setText("");

            } catch (SQLException ex) {
                     JOptionPane.showMessageDialog(this, ex);
               // Logger.getLogger(application.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
        }
        
        
        //show on table
             if(e.getSource()==p4_b4){
                 
          try {
              
                  query = "select * from publisher_phones";
        
             
                   rs = ss.executeQuery(query);
                   
                   
               
               t4.setRowCount(0);
              while(rs.next()){
              
                String publisher_id = rs.getString("publisher_id");  
                String phone = rs.getString("phone");  
                String data [] = {publisher_id ,phone};
               
                 t4.addRow(data);
              }
              
              JOptionPane.showMessageDialog(this, "Data imported sucssfully");
              
            } catch (SQLException ex) {
                  JOptionPane.showMessageDialog(this, ex);
               // Logger.getLogger(application.class.getName()).log(Level.SEVERE, null, ex);
            }
          }

    }

}
