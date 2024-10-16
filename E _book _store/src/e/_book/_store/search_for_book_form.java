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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class search_for_book_form extends JPanel implements ActionListener {
    JLabel Search_by_label=new JLabel("Search by: ");
    JRadioButton ISBN_radio_btn = new JRadioButton("ISBN");
    JRadioButton Author_radio_btn = new JRadioButton("Author id");
    JRadioButton Subject_radio_btn = new JRadioButton("Subject id");
    ButtonGroup ButtonGroup = new ButtonGroup();
    
    JTextField p8_t1=new JTextField(); 
      
          JTable table;
    JScrollPane scroll;
    DefaultTableModel t8 ;
    
    
              JTable table2;
    JScrollPane scroll2;
    DefaultTableModel t8_2 ;
    
              JTable table3;
    JScrollPane scroll3;
    DefaultTableModel t8_3;
    application application;

    public search_for_book_form(application _application) {

        application = _application;
          //search for book
        
        this.setBounds(200, 0, 900, 630);
      application.parentpanel.add(this);
        this.setLayout(null);
        
        Search_by_label.setBounds(40, 40 , 100 , 30);
        
        this.add(Search_by_label);
        
        ISBN_radio_btn.setBounds(140,40, 100 , 30);
        
        Author_radio_btn.setBounds(250,40, 100 , 30);
        
        Subject_radio_btn.setBounds(350,40, 100 , 30);
        
        ButtonGroup.add(ISBN_radio_btn);ButtonGroup.add(Author_radio_btn);ButtonGroup.add(Subject_radio_btn);
        
        this.add(ISBN_radio_btn);ISBN_radio_btn.addActionListener(this);
        this.add(Author_radio_btn);Author_radio_btn.addActionListener(this);
        this.add(Subject_radio_btn);Subject_radio_btn.addActionListener(this);
        
        p8_t1.setBounds(480, 40, 100, 30); this.add(p8_t1);
        
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      String text1; 
 
    
/////////////////////////////////search for book////////////////////////////////////////////////////////////////////////////

    if(e.getSource()==ISBN_radio_btn ){                 
            if (p8_t1.getText().equals("")){
          
            JOptionPane.showMessageDialog(this, "please enter ISBN");
          
          }
          else{     
                      String [][] search = { 
       
        };
        String[] sbooks={"ISBN","title","page_count","price","subjects","publisher_id"}; 
        DefaultTableModel t8 = new DefaultTableModel (search,sbooks);
        table = new JTable(t8);
        scroll =new JScrollPane(table);  
        this.add(scroll);
        scroll.setBounds(30, 100, 700, 900);
        
          try {
              text1=p8_t1.getText();
              
          query = "select b.ISBN , b.title , b.page_count,b.price,s.subjects ,b.publisher_id  from book b left outer join subjects s  on s.subjects_id =b.subjects_id where ISBN ='"+text1+"'";
        
             
          rs = ss.executeQuery(query);
                   
                   
               
               t8.setRowCount(0);
              while(rs.next()){
              
                String ISBN = rs.getString("ISBN");  
                String title = rs.getString("title");  
                String page_count = String.valueOf(rs.getInt("page_count"));
                String price = String.valueOf(rs.getInt("price"));
                String subjects = rs.getString("subjects");
                String publisher_id = rs.getString("publisher_id");
                String data [] = {ISBN ,title, page_count,price,subjects,publisher_id};
                
               
                 t8.addRow(data);
              }
              
              JOptionPane.showMessageDialog(this, "Data imported sucssfully");
              p8_t1.setText("");
            } catch (SQLException ex) {
                Logger.getLogger(application.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
    }
    ///subject id
      if(e.getSource()==Subject_radio_btn ){                 
            if (p8_t1.getText().equals("")){
          
            JOptionPane.showMessageDialog(this, "please enter subject id");
          
          }
          else{     
                      String [][] search = { 
       
        };
        String[] sbooks={"ISBN","title","page_count","price","subjects","publisher_id"}; 
        DefaultTableModel t8_3 = new DefaultTableModel (search,sbooks);
        table3 = new JTable(t8_3);
        scroll3 =new JScrollPane(table3);  
        this.add(scroll3);
        scroll3.setBounds(30, 100, 700, 900);
        
          try {
              text1=p8_t1.getText();
              
          query = "select * from book where subjects_id ='"+text1+"'";
        
             
          rs = ss.executeQuery(query);
                   
                   
               
               t8_3.setRowCount(0);
              while(rs.next()){
              
                String ISBN = rs.getString("ISBN");  
                String title = rs.getString("title");  
                String page_count = String.valueOf(rs.getInt("page_count"));
                String price = String.valueOf(rs.getInt("price"));
                String subjects_id = rs.getString("subjects_id");
                String publisher_id = rs.getString("publisher_id");
                String data [] = {ISBN ,title, page_count,price,subjects_id,publisher_id};
                
               
                 t8_3.addRow(data);
              }
              
              JOptionPane.showMessageDialog(this, "Data imported sucssfully");
              p8_t1.setText("");
            } catch (SQLException ex) {
                Logger.getLogger(application.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
    }
      //by author id
        if(e.getSource()==Author_radio_btn ){                 
            if (p8_t1.getText().equals("")){
          
            JOptionPane.showMessageDialog(this, "please enter author id");
          
          }
          else{     
                      String [][] search = { 
       
        };
        String[] sbooks={"ISBN","title","page_count","price","subjects","publisher_id","author_id"}; 
        DefaultTableModel t8_2 = new DefaultTableModel (search,sbooks);
        table2 = new JTable(t8_2);
        scroll2 =new JScrollPane(table2);  
        this.add(scroll2);
        scroll2.setBounds(30, 100, 700, 900);
        
          try {
              text1=p8_t1.getText();
              
          query = "select b.ISBN , b.title , b.page_count,b.price,s.subjects ,b.publisher_id ,a.author_id from book b left outer join subjects s  on s.subjects_id =b.subjects_id inner join authors_books a on b.ISBN = a.ISBN where author_id ='"+text1+"'";
        
             
          rs = ss.executeQuery(query);
                   
                   
               
               t8_2.setRowCount(0);
              while(rs.next()){
              
                String ISBN = rs.getString("ISBN");  
                String title = rs.getString("title");  
                String page_count = String.valueOf(rs.getInt("page_count"));
                String price = String.valueOf(rs.getInt("price"));
                String subjects = rs.getString("subjects");
                String publisher_id = rs.getString("publisher_id");
                 String author_id = rs.getString("author_id");
                String data [] = {ISBN ,title, page_count,price,subjects,publisher_id,author_id};
                
               
                 t8_2.addRow(data);
              }
              
              JOptionPane.showMessageDialog(this, "Data imported sucssfully");
              p8_t1.setText("");
            } catch (SQLException ex) {
                Logger.getLogger(application.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
    }
    }
}
