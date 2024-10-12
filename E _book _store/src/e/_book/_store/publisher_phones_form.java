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
    JLabel Publisher_ID_label = new JLabel("Publisher ID");
    JTextField Publisher_ID_text = new JTextField();
    JLabel phone_lable = new JLabel("phone");
    JTextField phone_text = new JTextField();

    JButton Add_btn = new JButton("Add");
    JButton Delete_btn = new JButton("Delete");
    JButton Update_btn = new JButton("Update");
    JButton Show_all_btn = new JButton("Show all");

    JTable table;
    JScrollPane scroll;

    DefaultTableModel TableModel;
    application application;

    public publisher_phones_form(application _application) {

        application = _application;
       //Publisher phone
        
        this.setBounds(200, 0, 900, 630);
       application. parentpanel.add(this);
        this.setLayout(null);
        
        Publisher_ID_label.setBounds(40,10, 100 , 30);this.add(Publisher_ID_label);
        Publisher_ID_text.setBounds(30,40, 100 , 30);this.add(Publisher_ID_text);
    
        phone_lable.setBounds(170,10, 100 , 30);this.add(phone_lable);
        phone_text.setBounds(150,40, 100 , 30);this.add(phone_text);
        
        Add_btn.setBounds(500, 40, 80 ,30); this.add(Add_btn);Add_btn.addActionListener(this);
        Update_btn.setBounds(590, 40, 80 ,30); this.add(Update_btn);Update_btn.addActionListener(this);
        Delete_btn.setBounds(680, 40, 80 ,30); this.add(Delete_btn);Delete_btn.addActionListener(this);
        Show_all_btn.setBounds(770, 40, 100 ,30); this.add(Show_all_btn);Show_all_btn.addActionListener(this);
        
                        String [][] publishers_phone = { 
       
        };
        String[] pheader_phone={"publisher ID","phone"}; 
        TableModel = new DefaultTableModel (publishers_phone,pheader_phone);
        table = new JTable(TableModel);
        scroll =new JScrollPane(table);    
        this.add(scroll);
        scroll.setBounds(30, 100, 700, 900);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         String text1;
         String text2;
      
       ////////////////////////////////publishers phones ////////////////////////////////////////////////////////////////
   if(e.getSource()==Add_btn){
          if (Publisher_ID_text.getText().equals("")||phone_text.getText().equals("")){
          
            JOptionPane.showMessageDialog(this, "please enter all data");
          
          }
          else{
          try {
              
          text1= Publisher_ID_text.getText();
          text2= phone_text.getText();          
         query = "insert into publisher_phones values(N'"+text1+"',N'"+text2+"')";
        
              ss.executeUpdate(query);
              
              JOptionPane.showMessageDialog(this, "Data added successfully");
              
                  Publisher_ID_text.setText("");
                  phone_text.setText("");
         
              
            } catch (SQLException ex) {
                 JOptionPane.showMessageDialog(this, ex);
                //Logger.getLogger(application.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
        
        }
        //update
        if(e.getSource()==Update_btn){
        
         if (phone_text.getText().equals("")){
          
            JOptionPane.showMessageDialog(this, "please enter all data");
          
          }
          else{
          try {
              
          text1= Publisher_ID_text.getText();
          text2= phone_text.getText();

                     
         query = "update publisher_phones set publisher_id = N'"+text1+"' where phone = N'"+text2+"'";
        
              ss.executeUpdate(query);
              
              JOptionPane.showMessageDialog(this, "Data Updated successfully");
              
                  Publisher_ID_text.setText("");
                  phone_text.setText("");

              
            } catch (SQLException ex) {
                  JOptionPane.showMessageDialog(this, ex);
                //Logger.getLogger(application.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
        }
        
        
        //delete
         if(e.getSource()==Delete_btn){
        
         if (phone_text.getText().equals("")){
          
            JOptionPane.showMessageDialog(this, "please enter phone");
          
          }
          else{
          try {
              
          text1= phone_text.getText();
          
         query = "delete from publisher_phones where phone = N'"+text1+"'";
        
              ss.executeUpdate(query);
              
              JOptionPane.showMessageDialog(this, "Data deleted successfully");
              
                  Publisher_ID_text.setText("");
                  phone_text.setText("");

            } catch (SQLException ex) {
                     JOptionPane.showMessageDialog(this, ex);
               // Logger.getLogger(application.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
        }
        
        
        //show on table
             if(e.getSource()==Show_all_btn){
                 
          try {
              
                  query = "select * from publisher_phones";
        
             
                   rs = ss.executeQuery(query);
                   
                   
               
               TableModel.setRowCount(0);
              while(rs.next()){
              
                String publisher_id = rs.getString("publisher_id");  
                String phone = rs.getString("phone");  
                String data [] = {publisher_id ,phone};
               
                 TableModel.addRow(data);
              }
              
              JOptionPane.showMessageDialog(this, "Data imported sucssfully");
              
            } catch (SQLException ex) {
                  JOptionPane.showMessageDialog(this, ex);
               // Logger.getLogger(application.class.getName()).log(Level.SEVERE, null, ex);
            }
          }

    }

}
