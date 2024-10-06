
package e._book._store;

import static e._book._store.application.query;
import static e._book._store.application.ss;
import static e._book._store.application.rs;
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

/**
 *
 * @author cr721
 */
public class book_form extends JPanel implements ActionListener{
       //books
    
 //   public JPanel p2 = new JPanel();
    
    JButton Add_btn = new JButton("Add");
    JButton Delete_btn = new JButton("Delete");
    JButton Update_btn = new JButton("Update");
    JButton Show_ALL_btn = new JButton("Show ALL");
    
    JLabel ISBN_label = new JLabel("ISBN"); JTextField ISBN_text= new JTextField();
    
    JLabel Title_label = new JLabel("Title");JTextField Title_text= new JTextField();
    
    JLabel page_count_label = new JLabel("page-count");JTextField page_count_text= new JTextField();
    
    JLabel price_label = new JLabel("price");JTextField price_text= new JTextField();
    
    JLabel Subject_Id_label = new JLabel("Subject Id");JTextField Subject_Id_text= new JTextField();
    
    JLabel Publisher_ID_label = new JLabel("Publisher ID");JTextField Publisher_ID_text= new JTextField();  
    
    JTable table;
    JScrollPane scroll;
    DefaultTableModel TableModel ;
     application application;
    
    public book_form(application _application){
        
        application = _application;
           //books
        setBounds(200, 0, 900, 630);
        //p2.setBackground(Color.BLACK);
        application.parentpanel.add(this);
        setLayout(null);
        //p2.setVisible(true);
        
        ISBN_label.setBounds(30, 10, 50 ,30); ISBN_text.setBounds(20,40 , 60, 30);
        add(ISBN_label);add(ISBN_text);
        
        Title_label.setBounds(130,10, 50 ,30); Title_text.setBounds(90,40 , 100, 30);
        add(Title_label); add(Title_text);
       
        page_count_label.setBounds(205,10, 100 ,30); page_count_text.setBounds(200,40 , 70, 30);
        add(page_count_label);add(page_count_text);
     
        price_label.setBounds(295,10, 50 , 30);price_text.setBounds(290,40 , 50, 30);
        add(price_label);add(price_text);
        
        Subject_Id_label.setBounds(352,10, 70 , 30);Subject_Id_text.setBounds(350,40 , 65, 30);
        add(Subject_Id_label);add(Subject_Id_text);
        
        Publisher_ID_label.setBounds(430,10, 100 , 30);Publisher_ID_text.setBounds(430,40 , 60, 30);
        add(Publisher_ID_label);add(Publisher_ID_text);
        
        
        Add_btn.setBounds(500, 40, 80 ,30); add(Add_btn);Add_btn.addActionListener(this);
        Update_btn.setBounds(590, 40, 80 ,30); add(Update_btn);Update_btn.addActionListener(this);
        Delete_btn.setBounds(680, 40, 80 ,30); add(Delete_btn);Delete_btn.addActionListener(this);
        Show_ALL_btn.setBounds(770, 40, 100 ,30); add(Show_ALL_btn);Show_ALL_btn.addActionListener(this);
        
        String [][] books = { 
     
        };
        String[] header={"ISBN","title","page count","price","subject","publisher name" }; 
        TableModel = new DefaultTableModel (books,header);
        table = new JTable(TableModel);
       // p2_table.setBounds(30, 100, 500, 600);
        scroll =new JScrollPane(table);    
        add(scroll);
        scroll.setBounds(30, 100, 700, 900);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
         String text1;
         String text2;
         String text3;
         String text4;
         String text5;
         String text6;
       ////////////////////////////////books/////////////////////////////////////////////////////////////////////////
   if(e.getSource()==Add_btn){
          if (ISBN_text.getText().equals("")||Title_text.getText().equals("")||page_count_text.getText().equals("")||price_text.getText().equals("")||Subject_Id_text.getText().equals("")||Publisher_ID_text.getText().equals("")){
          
            JOptionPane.showMessageDialog(this, "please enter all data");
          
          }
          else{
          try {
              
          text1= ISBN_text.getText();
          text2= Title_text.getText();
          text3= page_count_text.getText();
          text4= price_text.getText();
          text5= Subject_Id_text.getText();
          text6= Publisher_ID_text.getText();
                     
         query = "insert into book values(N'"+text1+"',N'"+text2+"','"+text3+"','"+text4+"',N'"+text5+"',N'"+text6+"')";
        
              ss.executeUpdate(query);
              
              JOptionPane.showMessageDialog(this, "Data added successfully");
              
                  ISBN_text.setText("");
                  Title_text.setText("");
                  page_count_text.setText("");
                  price_text.setText("");
                  Subject_Id_text.setText("");
                  Publisher_ID_text.setText("");
              
            } catch (SQLException ex) {
                 JOptionPane.showMessageDialog(this, ex);
                //Logger.getLogger(application.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
        
        }
        //update
        if(e.getSource()==Update_btn){
        
         if (ISBN_text.getText().equals("")){
          
            JOptionPane.showMessageDialog(this, "please enter ISBN");
          
          }
          else{
          try {
              
          text1= ISBN_text.getText();
          text2= Title_text.getText();
          text3= page_count_text.getText();
          text4= price_text.getText();
          text5= Subject_Id_text.getText();
          text6= Publisher_ID_text.getText();
                     
         query = "update book set title = N'"+text2+"',page_count ='"+text3+"',price ='"+text4+"',subjects_id =N'"+text5+"',publisher_id =N'"+text6+"' where ISBN = N'"+text1+"'";
        
              ss.executeUpdate(query);
              
              JOptionPane.showMessageDialog(this, "Data Updated successfully");
              
                  ISBN_text.setText("");
                  Title_text.setText("");
                  page_count_text.setText("");
                  price_text.setText("");
                  Subject_Id_text.setText("");
                  Publisher_ID_text.setText("");
              
            } catch (SQLException ex) {
                  JOptionPane.showMessageDialog(this, ex);
                //Logger.getLogger(application.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
        }
        
        
        //delete
         if(e.getSource()==Delete_btn){
        
         if (ISBN_text.getText().equals("")){
          
            JOptionPane.showMessageDialog(this, "please enter ISBN");
          
          }
          else{
          try {
              
          text1= ISBN_text.getText();
          
         query = "delete from book where ISBN = N'"+text1+"'";
        
              ss.executeUpdate(query);
              
              JOptionPane.showMessageDialog(this, "Data deleted successfully");
              
                  ISBN_text.setText("");
                  Title_text.setText("");
                  page_count_text.setText("");
                  price_text.setText("");
                  Subject_Id_text.setText("");
                  Publisher_ID_text.setText("");
              
            } catch (SQLException ex) {
                     JOptionPane.showMessageDialog(this, ex);
               // Logger.getLogger(application.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
        }
        
        
        //show on table
             if(e.getSource()==Show_ALL_btn){
                 
          try {
              
                  query = "select b.ISBN , b.title , b.page_count,b.price,s.subjects ,pp.name as [publisher name] " +
"from book b left outer join subjects s  on s.subjects_id =b.subjects_id " +
"left outer join publisher pp on b.publisher_id=pp.publisher_id;";
        
             
                   rs = ss.executeQuery(query);
                   
                   
               
               TableModel.setRowCount(0);
              while(rs.next()){
              
                String ISBN = rs.getString("ISBN");  
                String title = rs.getString("title");  
                String page_count = String.valueOf(rs.getInt("page_count"));
                String price = String.valueOf(rs.getInt("price"));
                String subjects = rs.getString("subjects");
                String publisher_name = rs.getString("publisher name");
                String data [] = {ISBN ,title, page_count,price,subjects,publisher_name};
               
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
