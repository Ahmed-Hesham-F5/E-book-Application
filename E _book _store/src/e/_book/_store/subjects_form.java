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

public class subjects_form extends JPanel implements ActionListener {

    JLabel Subject_ID_label=new JLabel("Subject ID");JTextField Subject_ID_text=new JTextField();    
    JLabel Subjects_label=new JLabel("Subjects");JTextField Subjects_text=new JTextField();
    
    JButton Add_btn = new JButton("Add");
    JButton Delete_btn = new JButton("Delete");
    JButton Update_btn = new JButton("Update");
    JButton Show_ALL_btn = new JButton("Show ALL");
    
    JTable table;
    JScrollPane scroll;
    DefaultTableModel TableModel ;
    application application;

    public subjects_form(application _application) {

        application = _application;
          
        //subjects
        
        this.setBounds(200, 0, 900, 630);
       application. parentpanel.add(this);
        this.setLayout(null);
        
        Subject_ID_label.setBounds(40,10, 100 , 30);this.add(Subject_ID_label);
        Subject_ID_text.setBounds(30,40, 100 , 30);this.add(Subject_ID_text);
    
        Subjects_label.setBounds(170,10, 100 , 30);this.add(Subjects_label);
        Subjects_text.setBounds(150,40, 100 , 30);this.add(Subjects_text);
        
        Add_btn.setBounds(500, 40, 80 ,30); this.add(Add_btn);Add_btn.addActionListener(this);
        Update_btn.setBounds(590, 40, 80 ,30); this.add(Update_btn);Update_btn.addActionListener(this);
        Delete_btn.setBounds(680, 40, 80 ,30); this.add(Delete_btn);Delete_btn.addActionListener(this);
        Show_ALL_btn.setBounds(770, 40, 100 ,30); this.add(Show_ALL_btn);Show_ALL_btn.addActionListener(this);
        
                        String [][] subjects = { 
      
        };
        String[] sheader={"subject id","subject"}; 
       TableModel = new DefaultTableModel (subjects,sheader);
        table = new JTable(TableModel);
        scroll =new JScrollPane(table);    
        this.add(scroll);
        scroll.setBounds(30, 100, 700, 900);
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        String text1,text2; 
        
     /////////////////////////////////subjects/////////////////////////////////////////////////////////////////////        
      //insert
      
         if(e.getSource()==Add_btn){
          if (Subject_ID_text.getText().equals("")||Subjects_text.getText().equals("")){
          
            JOptionPane.showMessageDialog(this, "please enter subject id and subject");
          
          }
          else{
          try {
              
          text1= Subject_ID_text.getText();
          text2= Subjects_text.getText();
                     
         query = "insert into subjects values(N'"+text1+"',N'"+text2+"')";
        
              ss.executeUpdate(query);
              
              JOptionPane.showMessageDialog(this, "Data added successfully");
              
                  Subject_ID_text.setText("");
                  Subjects_text.setText("");
                 
              
            } catch (SQLException ex) {
                 JOptionPane.showMessageDialog(this, ex);
                //Logger.getLogger(application.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
        
        }
         //update
         if(e.getSource()==Update_btn){
        
         if (Subject_ID_text.getText().equals("")){
          
            JOptionPane.showMessageDialog(this, "please enter subject id");
          
          }
          else{
          try {
              
          text1= Subject_ID_text.getText();
          text2= Subjects_text.getText();
        
                     
         query = "update subjects set subjects = N'"+text2+"' where subjects_id = N'"+text1+"'";
        
              ss.executeUpdate(query);
              
              JOptionPane.showMessageDialog(this, "Data Updated successfully");
              
                  Subject_ID_text.setText("");
                  Subjects_text.setText("");
              
            } catch (SQLException ex) {
                  JOptionPane.showMessageDialog(this, ex);
               // Logger.getLogger(application.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
        }
                  //delete
         if(e.getSource()==Delete_btn){
        
         if (Subject_ID_text.getText().equals("")){
          
            JOptionPane.showMessageDialog(this, "please enter subjects_id");
          
          }
          else{
          try {
              
          text1= Subject_ID_text.getText();
         query = "delete from subjects where subjects_id = N'"+text1+"'";
        
              ss.executeUpdate(query);
              
              JOptionPane.showMessageDialog(this, "Data deleted successfully");
              
                  Subject_ID_text.setText("");
                  Subjects_text.setText("");
              
            } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, ex);
                //Logger.getLogger(application.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
        }
         //show on table
          if(e.getSource()==Show_ALL_btn){
                 
          try {
              
                  query = "select * from subjects";
        
             
                   rs = ss.executeQuery(query);
                   
                   
               
               TableModel.setRowCount(0);
              while(rs.next()){
              
                String subjects_id = rs.getString("subjects_id");  
                String subjects = rs.getString("subjects");  
                
                String data [] = {subjects_id,subjects};
               
                 TableModel.addRow(data);
              }
              
              JOptionPane.showMessageDialog(this, "Data imported sucssfully");
              
            } catch (SQLException ex) {
                  JOptionPane.showMessageDialog(this, ex);
                //Logger.getLogger(application.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
     

    }

}
