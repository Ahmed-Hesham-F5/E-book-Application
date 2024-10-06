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

public class authors_books_form extends JPanel implements ActionListener {
    JLabel ISBN_label=new JLabel("ISBN");JTextField ISBN_text=new JTextField();    
    JLabel authors_ID_label=new JLabel("authors ID");JTextField authors_ID_text=new JTextField();
  
    
    JButton Add_btn = new JButton("Add");
    JButton Delete_btn = new JButton("Delete");
    JButton Update_btn = new JButton("Update");
    JButton Show_ALL_btn = new JButton("Show ALL");
    
    JTable table;
    JScrollPane scroll;
    DefaultTableModel TableModel ;
    application application;

    public authors_books_form(application _application) {

        application = _application;
        //authors books
        
        this.setBounds(200, 0, 900, 630);
        application.parentpanel.add(this);
        this.setLayout(null);
        
             
        ISBN_label.setBounds(50,10, 100 , 30);this.add(ISBN_label);
        ISBN_text.setBounds(30,40, 100 , 30);this.add(ISBN_text);
    
        authors_ID_label.setBounds(170,10, 100 , 30);this.add(authors_ID_label);
        authors_ID_text.setBounds(150,40, 100 , 30);this.add(authors_ID_text);
  
         
        Add_btn.setBounds(500, 40, 80 ,30); this.add(Add_btn);Add_btn.addActionListener(this);
        Update_btn.setBounds(590, 40, 80 ,30); this.add(Update_btn);Update_btn.addActionListener(this);
        Delete_btn.setBounds(680, 40, 80 ,30); this.add(Delete_btn);Delete_btn.addActionListener(this);
        Show_ALL_btn.setBounds(770, 40, 100 ,30); this.add(Show_ALL_btn);Show_ALL_btn.addActionListener(this);
        
      
        
                String [][] Authors_books = { 
      
        };
        String[] aheader_books={"ISBN","authors ID"}; 
      TableModel = new DefaultTableModel (Authors_books,aheader_books);
        table = new JTable(TableModel);
        scroll =new JScrollPane(table);    
        this.add(scroll);
        scroll.setBounds(30, 100, 700, 900);
        
        
      
    }

    @Override
    public void actionPerformed(ActionEvent e) {   
        String text1, text2;
//////////////////////////////////authors books///////////////////////////////////////////////////////////////
 if(e.getSource()==Add_btn){
          if (ISBN_text.getText().equals("")||authors_ID_text.getText().equals("")){
          
            JOptionPane.showMessageDialog(this, "please enter all data");
          
          }
          else{
          try {
              
          text1= ISBN_text.getText();
          text2= authors_ID_text.getText();          
         query = "insert into authors_books values(N'"+text1+"',N'"+text2+"')";
        
              ss.executeUpdate(query);
              
              JOptionPane.showMessageDialog(this, "Data added successfully");
              
                  ISBN_text.setText("");
                  authors_ID_text.setText("");
         
              
            } catch (SQLException ex) {
                 JOptionPane.showMessageDialog(this, ex);
                //Logger.getLogger(application.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
        
        }
        //update
        if(e.getSource()==Update_btn){
        
         if (authors_ID_text.getText().equals("")||authors_ID_text.getText().equals("")){
          
            JOptionPane.showMessageDialog(this, "please enter all data");
          
          }
          else{
          try {
              
          text1= ISBN_text.getText();
          text2= authors_ID_text.getText();

                     
         query = "update authors_books set author_id = N'"+text2+"' where ISBN = N'"+text1+"'";
        
              ss.executeUpdate(query);
              
              JOptionPane.showMessageDialog(this, "Data Updated successfully");
              
                  ISBN_text.setText("");
                  authors_ID_text.setText("");

              
            } catch (SQLException ex) {
                  JOptionPane.showMessageDialog(this, ex);
                //Logger.getLogger(application.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
        }
        
        
        //delete
         if(e.getSource()==Delete_btn){
        
         if (authors_ID_text.getText().equals("")||authors_ID_text.getText().equals("")){
          
            JOptionPane.showMessageDialog(this, "please enter All Data");
          
          }
          else{
          try {
              
          text1= ISBN_text.getText();
          text2= authors_ID_text.getText();
          
         query = "delete from authors_books where ISBN = N'"+text1+"'and author_id = N'"+text2+"'";
        
              ss.executeUpdate(query);
              
              JOptionPane.showMessageDialog(this, "Data deleted successfully");
              
                  ISBN_text.setText("");
                  authors_ID_text.setText("");

            } catch (SQLException ex) {
                     JOptionPane.showMessageDialog(this, ex);
               // Logger.getLogger(application.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
        }
        
        
        //show on table
             if(e.getSource()==Show_ALL_btn){
                 
          try {
              
                  query = "select * from authors_books";
        
             
                   rs = ss.executeQuery(query);
                   
                   
               
               TableModel.setRowCount(0);
              while(rs.next()){
              
                String ISBN = rs.getString("ISBN");  
                String author_id = rs.getString("author_id");  
                String data [] = {ISBN ,author_id};
               
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
