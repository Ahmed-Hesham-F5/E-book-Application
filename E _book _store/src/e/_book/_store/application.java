

// name : ahmed hesham abdelhady abdelaziz   c18    code: 12200281


package e._book._store;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


public class application extends JFrame implements ActionListener  {
    //connection
      Connection con;
     static Statement ss ; 
     static String query ;  
     
     ResultSet rs ;
    
    //menu
    JPanel p1 = new JPanel();
    JButton p1_b1 = new JButton("Books");
    JButton p1_b2 = new JButton("Publishers");
    JButton p1_b3 = new JButton("Authors");
    JButton p1_b4 = new JButton("Subjects");
    JButton p1_b5 = new JButton("Search for book");
    JButton p1_b6 = new JButton("Exit");
    
    //parent panel
    JPanel parentpanel = new JPanel();
    
    //books
    
    JPanel p2 = new JPanel();
    
    JButton p2_b1 = new JButton("Add");
    JButton p2_b2 = new JButton("Delete");
    JButton p2_b3 = new JButton("Update");
    JButton p2_b4 = new JButton("Show ALL");
    
    JLabel p2_l1 = new JLabel("ISBN"); JTextField p2_t1= new JTextField();
    
    JLabel p2_l2 = new JLabel("Title");JTextField p2_t2= new JTextField();
    
    JLabel p2_l3 = new JLabel("page-count");JTextField p2_t3= new JTextField();
    
    JLabel p2_l4 = new JLabel("price");JTextField p2_t4= new JTextField();
    
    JLabel p2_l5 = new JLabel("Subject Id");JTextField p2_t5= new JTextField();
    
    JLabel p2_l6 = new JLabel("Publisher ID");JTextField p2_t6= new JTextField();  
    
    JTable p2_table;
    JScrollPane p2_scroll;
      DefaultTableModel t2 ;
    
    //publisher
    
    JPanel p3 = new JPanel();
    JLabel p3_l1=new JLabel("Publisher ID");JTextField p3_t1=new JTextField();    
    JLabel p3_l2=new JLabel("Name");JTextField p3_t2=new JTextField();
    JLabel p3_l3=new JLabel("city");JTextField p3_t3=new JTextField(); 
    
    JButton p3_b1 = new JButton("Add");
    JButton p3_b2 = new JButton("Delete");
    JButton p3_b3 = new JButton("Update");
    JButton p3_b4 = new JButton("Show ALL");
    
    JButton p3_b5 = new JButton("PHONES");
    
    JTable p3_table;
    JScrollPane p3_scroll;
    DefaultTableModel t3 ;
    
    //publisher phones
    JPanel p4 = new JPanel();
    JLabel p4_l1=new JLabel("Publisher ID");JTextField p4_t1=new JTextField();    
    JLabel p4_l2=new JLabel("phone");JTextField p4_t2=new JTextField();
    
    JButton p4_b1 = new JButton("Add");
    JButton p4_b2 = new JButton("Delete");
    JButton p4_b3 = new JButton("Update");
    JButton p4_b4 = new JButton("Show all");
    
    JTable p4_table;
    JScrollPane p4_scroll;
    
      DefaultTableModel t4 ;
    //authors
        
    JPanel p5 = new JPanel();
    JLabel p5_l1=new JLabel("Ahuthor ID");JTextField p5_t1=new JTextField();    
    JLabel p5_l2=new JLabel("First Name");JTextField p5_t2=new JTextField();
    JLabel p5_l3=new JLabel("Last Name");JTextField p5_t3=new JTextField(); 
    
    JButton p5_b1 = new JButton("Add");
    JButton p5_b2 = new JButton("Delete");
    JButton p5_b3 = new JButton("Update");
    JButton p5_b4 = new JButton("Show ALL");
    
    JButton p5_b5 = new JButton("authors books");
    
    static JTable p5_table;
    JScrollPane p5_scroll;
    DefaultTableModel t5 ;
  
    
    //authors books
    JPanel p6 = new JPanel();
    JLabel p6_l1=new JLabel("ISBN");JTextField p6_t1=new JTextField();    
    JLabel p6_l2=new JLabel("authors ID");JTextField p6_t2=new JTextField();
  
    
    JButton p6_b1 = new JButton("Add");
    JButton p6_b2 = new JButton("Delete");
    JButton p6_b3 = new JButton("Update");
    JButton p6_b4 = new JButton("Show ALL");
    
    JTable p6_table;
    JScrollPane p6_scroll;
    DefaultTableModel t6 ;
    
    //subjects
    JPanel p7 = new JPanel();
    JLabel p7_l1=new JLabel("Subject ID");JTextField p7_t1=new JTextField();    
    JLabel p7_l2=new JLabel("Subjects");JTextField p7_t2=new JTextField();
    
    JButton p7_b1 = new JButton("Add");
    JButton p7_b2 = new JButton("Delete");
    JButton p7_b3 = new JButton("Update");
    JButton p7_b4 = new JButton("Show ALL");
    
    JTable p7_table;
    JScrollPane p7_scroll;
    DefaultTableModel t7 ;
    
    //search for book 
    
     JPanel p8 = new JPanel();
    JLabel p8_l1=new JLabel("Search by: ");
    JRadioButton r1 = new JRadioButton("ISBN");
    JRadioButton r2 = new JRadioButton("Author id");
    JRadioButton r3 = new JRadioButton("Subject id");
    ButtonGroup g1 = new ButtonGroup();
    
    JTextField p8_t1=new JTextField(); 
      
          JTable p8_table;
    JScrollPane p8_scroll;
    DefaultTableModel t8 ;
    
    
              JTable p8_table2;
    JScrollPane p8_scroll2;
    DefaultTableModel t8_2 ;
    
              JTable p8_table3;
    JScrollPane p8_scroll3;
    DefaultTableModel t8_3;
    ////////////////////////////////
    
    application(){
        //conection
        
        connect();
        
        //frame
        setTitle("e-book store");
        setBounds(100,100,1100,630 );
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setResizable(false);
        
        //menu
        p1.setBounds(0, 0, 200, 600);
        //p1.setBackground(Color.RED);
        this.add(p1);
        p1.setLayout(new GridLayout(6,0));
        p1.add(p1_b1);p1.add(p1_b2);p1.add(p1_b3);p1.add(p1_b4);p1.add(p1_b5);p1.add(p1_b6);
        p1_b2.addActionListener(this);p1_b1.addActionListener(this);p1_b6.addActionListener(this);
        p1_b3.addActionListener(this);p1_b4.addActionListener(this);p1_b5.addActionListener(this);
        
        //parent panel
        
        parentpanel.setBounds(200, 0, 900, 630);
        parentpanel.setLayout(new CardLayout());
        this.add(parentpanel);
        
        //this.add(parentpanel);
        
        //books
        p2.setBounds(200, 0, 900, 630);
        //p2.setBackground(Color.BLACK);
        parentpanel.add(p2);
        p2.setLayout(null);
        //p2.setVisible(true);
        
        p2_l1.setBounds(30, 10, 50 ,30); p2_t1.setBounds(20,40 , 60, 30);
        p2.add(p2_l1);p2.add(p2_t1);
        
        p2_l2.setBounds(130,10, 50 ,30); p2_t2.setBounds(90,40 , 100, 30);
        p2.add(p2_l2); p2.add(p2_t2);
       
        p2_l3.setBounds(205,10, 100 ,30); p2_t3.setBounds(200,40 , 70, 30);
        p2.add(p2_l3);p2.add(p2_t3);
     
        p2_l4.setBounds(295,10, 50 , 30);p2_t4.setBounds(290,40 , 50, 30);
        p2.add(p2_l4);p2.add(p2_t4);
        
        p2_l5.setBounds(352,10, 70 , 30);p2_t5.setBounds(350,40 , 65, 30);
        p2.add(p2_l5);p2.add(p2_t5);
        
        p2_l6.setBounds(430,10, 100 , 30);p2_t6.setBounds(430,40 , 60, 30);
        p2.add(p2_l6);p2.add(p2_t6);
        
        
        p2_b1.setBounds(500, 40, 80 ,30); p2.add(p2_b1);p2_b1.addActionListener(this);
        p2_b3.setBounds(590, 40, 80 ,30); p2.add(p2_b3);p2_b3.addActionListener(this);
        p2_b2.setBounds(680, 40, 80 ,30); p2.add(p2_b2);p2_b2.addActionListener(this);
        p2_b4.setBounds(770, 40, 100 ,30); p2.add(p2_b4);p2_b4.addActionListener(this);
        
        String [][] books = { 
     
        };
        String[] header={"ISBN","title","page count","price","subject","publisher ID" }; 
        t2 = new DefaultTableModel (books,header);
        p2_table = new JTable(t2);
       // p2_table.setBounds(30, 100, 500, 600);
        p2_scroll =new JScrollPane(p2_table);    
        p2.add(p2_scroll);
        p2_scroll.setBounds(30, 100, 700, 900);
        //p2.add(p2_table);
        
        
        
        //publishers
        
        p3.setBounds(200, 0, 900, 630);
        //p3.setBackground(Color.BLACK);
        parentpanel.add(p3);
        p3.setLayout(null);
        
             
        p3_l1.setBounds(40,10, 100 , 30);p3.add(p3_l1);
        p3_t1.setBounds(30,40, 100 , 30);p3.add(p3_t1);
    
        p3_l2.setBounds(170,10, 100 , 30);p3.add(p3_l2);
        p3_t2.setBounds(150,40, 100 , 30);p3.add(p3_t2);
    
        p3_l3.setBounds(290,10, 100 , 30);p3.add(p3_l3);
        p3_t3.setBounds(270,40, 100 , 30);p3.add(p3_t3);
        
        
        p3_b1.setBounds(500, 40, 80 ,30); p3.add(p3_b1);p3_b1.addActionListener(this);
        p3_b3.setBounds(590, 40, 80 ,30); p3.add(p3_b3);p3_b2.addActionListener(this);
        p3_b2.setBounds(680, 40, 80 ,30); p3.add(p3_b2);p3_b3.addActionListener(this);
        p3_b4.setBounds(770, 40, 100 ,30); p3.add(p3_b4);p3_b4.addActionListener(this);
        
        p3_b5.setBounds(770, 300, 100 ,30); p3.add(p3_b5);p3_b5.addActionListener(this);
        
                String [][] publisher = { 
        
        };
        String[] pheader={"publisher ID","name","city"}; 
        t3 = new DefaultTableModel (publisher,pheader);
        p3_table = new JTable(t3);
        p3_scroll =new JScrollPane(p3_table);    
        p3.add(p3_scroll);
        p3_scroll.setBounds(30, 100, 700, 900);
        
        
        //Publisher phone
        
        p4.setBounds(200, 0, 900, 630);
        parentpanel.add(p4);
        p4.setLayout(null);
        
        p4_l1.setBounds(40,10, 100 , 30);p4.add(p4_l1);
        p4_t1.setBounds(30,40, 100 , 30);p4.add(p4_t1);
    
        p4_l2.setBounds(170,10, 100 , 30);p4.add(p4_l2);
        p4_t2.setBounds(150,40, 100 , 30);p4.add(p4_t2);
        
        p4_b1.setBounds(500, 40, 80 ,30); p4.add(p4_b1);p4_b1.addActionListener(this);
        p4_b3.setBounds(590, 40, 80 ,30); p4.add(p4_b3);p4_b3.addActionListener(this);
        p4_b2.setBounds(680, 40, 80 ,30); p4.add(p4_b2);p4_b2.addActionListener(this);
        p4_b4.setBounds(770, 40, 100 ,30); p4.add(p4_b4);p4_b4.addActionListener(this);
        
                        String [][] publishers_phone = { 
       
        };
        String[] pheader_phone={"publisher ID","phone"}; 
        t4 = new DefaultTableModel (publishers_phone,pheader_phone);
        p4_table = new JTable(t4);
        p4_scroll =new JScrollPane(p4_table);    
        p4.add(p4_scroll);
        p4_scroll.setBounds(30, 100, 700, 900);
        
        
        //authors
        
        p5.setBounds(200, 0, 900, 630);
       
        parentpanel.add(p5);
        p5.setLayout(null);
        
             
        p5_l1.setBounds(40,10, 100 , 30);p5.add(p5_l1);
        p5_t1.setBounds(30,40, 100 , 30);p5.add(p5_t1);
    
        p5_l2.setBounds(170,10, 100 , 30);p5.add(p5_l2);
        p5_t2.setBounds(150,40, 100 , 30);p5.add(p5_t2);
    
        p5_l3.setBounds(290,10, 100 , 30);p5.add(p5_l3);
        p5_t3.setBounds(270,40, 100 , 30);p5.add(p5_t3);
        
        
        p5_b1.setBounds(500, 40, 80 ,30); p5.add(p5_b1);p5_b1.addActionListener(this);
        p5_b3.setBounds(590, 40, 80 ,30); p5.add(p5_b3);p5_b3.addActionListener(this);
        p5_b2.setBounds(680, 40, 80 ,30); p5.add(p5_b2);p5_b2.addActionListener(this);
        p5_b4.setBounds(770, 40, 100 ,30); p5.add(p5_b4);p5_b4.addActionListener(this);
        
        p5_b5.setBounds(733, 300, 150 ,30); p5.add(p5_b5);p5_b5.addActionListener(this);
        
 
                       String [][] authors = { 
       
        };
        String[] aheader={"author_id","First name","Last name"}; 
        t5 = new DefaultTableModel (authors,aheader);
        p5_table = new JTable(t5);
        p5_scroll =new JScrollPane(p5_table);  
        p5.add(p5_scroll);
        p5_scroll.setBounds(30, 100, 700, 900);
       
        
        
        
        //authors books
        
        p6.setBounds(200, 0, 900, 630);
        parentpanel.add(p6);
        p6.setLayout(null);
        
             
        p6_l1.setBounds(50,10, 100 , 30);p6.add(p6_l1);
        p6_t1.setBounds(30,40, 100 , 30);p6.add(p6_t1);
    
        p6_l2.setBounds(170,10, 100 , 30);p6.add(p6_l2);
        p6_t2.setBounds(150,40, 100 , 30);p6.add(p6_t2);
  
         
        p6_b1.setBounds(500, 40, 80 ,30); p6.add(p6_b1);p6_b1.addActionListener(this);
        p6_b3.setBounds(590, 40, 80 ,30); p6.add(p6_b3);p6_b3.addActionListener(this);
        p6_b2.setBounds(680, 40, 80 ,30); p6.add(p6_b2);p6_b2.addActionListener(this);
        p6_b4.setBounds(770, 40, 100 ,30); p6.add(p6_b4);p6_b4.addActionListener(this);
        
      
        
                String [][] Authors_books = { 
      
        };
        String[] aheader_books={"ISBN","authors ID"}; 
      t6 = new DefaultTableModel (Authors_books,aheader_books);
        p6_table = new JTable(t6);
        p6_scroll =new JScrollPane(p6_table);    
        p6.add(p6_scroll);
        p6_scroll.setBounds(30, 100, 700, 900);
        
        
        //subjects
        
        p7.setBounds(200, 0, 900, 630);
        parentpanel.add(p7);
        p7.setLayout(null);
        
        p7_l1.setBounds(40,10, 100 , 30);p7.add(p7_l1);
        p7_t1.setBounds(30,40, 100 , 30);p7.add(p7_t1);
    
        p7_l2.setBounds(170,10, 100 , 30);p7.add(p7_l2);
        p7_t2.setBounds(150,40, 100 , 30);p7.add(p7_t2);
        
        p7_b1.setBounds(500, 40, 80 ,30); p7.add(p7_b1);p7_b1.addActionListener(this);
        p7_b3.setBounds(590, 40, 80 ,30); p7.add(p7_b3);p7_b3.addActionListener(this);
        p7_b2.setBounds(680, 40, 80 ,30); p7.add(p7_b2);p7_b2.addActionListener(this);
        p7_b4.setBounds(770, 40, 100 ,30); p7.add(p7_b4);p7_b4.addActionListener(this);
        
                        String [][] subjects = { 
      
        };
        String[] sheader={"subject id","subject"}; 
       t7 = new DefaultTableModel (subjects,sheader);
        p7_table = new JTable(t7);
        p7_scroll =new JScrollPane(p7_table);    
        p7.add(p7_scroll);
        p7_scroll.setBounds(30, 100, 700, 900);
        
        //search for book
        
        p8.setBounds(200, 0, 900, 630);
        parentpanel.add(p8);
        p8.setLayout(null);
        
        p8_l1.setBounds(40, 40 , 100 , 30);
        
        p8.add(p8_l1);
        
        r1.setBounds(140,40, 100 , 30);
        
        r2.setBounds(250,40, 100 , 30);
        
        r3.setBounds(350,40, 100 , 30);
        
        g1.add(r1);g1.add(r2);g1.add(r3);
        
        p8.add(r1);r1.addActionListener(this);
        p8.add(r2);r2.addActionListener(this);
        p8.add(r3);r3.addActionListener(this);
        
        p8_t1.setBounds(480, 40, 100, 30); p8.add(p8_t1);
        
       
      ////////////////////////////////////////////  
        
    }
    
    
    public void connect(){
                 
                      
         String url = "jdbc:sqlserver://localhost:1433;databaseName=E_book_store"; // اتأكد من اسم الداتابيز بتاعتك صح
    String username ="alpha";// اتأكد من اليوزر 
    String password ="123456"; // اتأكد من الباسورد
     try{

       con = DriverManager.getConnection(url, username,password);
 
       ss =con.createStatement();
 
       System.out.println("Database CONNECTED");

     }
     catch ( SQLException e){ 
     System.out.println(e);
     }
 
        
        
    }
    public static void main(String[] args) {
        

        application a1 = new application();
 
} 
        
      
       
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        String text1,text2,text3,text4,text5,text6 ; 
        
        
        //author table 
        //insert
        if(e.getSource()==p5_b1){
          if (p5_t1.getText().equals("")||p5_t2.getText().equals("")&&p5_t3.getText().equals("")){
          
            JOptionPane.showMessageDialog(this, "please enter author id and name");
          
          }
          else{
          try {
              
          text1= p5_t1.getText();
          text2= p5_t2.getText();
          text3= p5_t3.getText();
                     
         query = "insert into author values(N'"+text1+"',N'"+text2+"',N'"+text3+"')";
        
              ss.executeUpdate(query);
              
              JOptionPane.showMessageDialog(this, "Data added successfully");
              
                  p5_t1.setText("");
                  p5_t2.setText("");
                  p5_t3.setText("");
              
            } catch (SQLException ex) {
                 JOptionPane.showMessageDialog(this, ex);
                //Logger.getLogger(application.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
        
        }
        //update
        if(e.getSource()==p5_b3){
        
         if (p5_t1.getText().equals("")){
          
            JOptionPane.showMessageDialog(this, "please enter author id");
          
          }
          else{
          try {
              
          text1= p5_t1.getText();
          text2= p5_t2.getText();
          text3= p5_t3.getText();
                     
         query = "update author set Fname = N'"+text2+"',Lname = N'"+text3+"'where author_id = N'"+text1+"'";
        
              ss.executeUpdate(query);
              
              JOptionPane.showMessageDialog(this, "Data Updated successfully");
              
                  p5_t1.setText("");
                  p5_t2.setText("");
                  p5_t3.setText("");
              
            } catch (SQLException ex) {
                  JOptionPane.showMessageDialog(this, ex);
               // Logger.getLogger(application.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
        }
        
        
        //delete
         if(e.getSource()==p5_b2){
        
         if (p5_t1.getText().equals("")){
          
            JOptionPane.showMessageDialog(this, "please enter author id");
          
          }
          else{
          try {
              
          text1= p5_t1.getText();
         query = "delete from author where author_id = N'"+text1+"'";
        
              ss.executeUpdate(query);
              
              JOptionPane.showMessageDialog(this, "Data deleted successfully");
              
                  p5_t1.setText("");
                  p5_t2.setText("");
                  p5_t3.setText("");
              
            } catch (SQLException ex) {
                     JOptionPane.showMessageDialog(this, ex);
                //Logger.getLogger(application.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
        }
        
        
        //show on table
             if(e.getSource()==p5_b4){
                 
          try {
              
                  query = "select * from author";
        
             
                   rs = ss.executeQuery(query);
                   
                   
               
               t5.setRowCount(0);
              while(rs.next()){
              
                String author_id = rs.getString("author_id");  
                String Fname = rs.getString("Fname");  
                String Lname = rs.getString("Lname");
                
                String data [] = {author_id ,Fname, Lname};
               
                 t5.addRow(data);
              }
              
              JOptionPane.showMessageDialog(this, "Data imported sucssfully");
              
            } catch (SQLException ex) {
                  JOptionPane.showMessageDialog(this, ex);
                //Logger.getLogger(application.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
        
       /////////////////////////publishers/////////////////////////////////////////////
        //insert
        
            if(e.getSource()==p3_b1){
          if (p3_t1.getText().equals("")||p3_t2.getText().equals("")){
          
            JOptionPane.showMessageDialog(this, "please enter publisher id and name");
          
          }
          else{
          try {
              
          text1= p3_t1.getText();
          text2= p3_t2.getText();
          text3= p3_t3.getText();
                     
         query = "insert into publisher values(N'"+text1+"',N'"+text2+"',N'"+text3+"')";
        
              ss.executeUpdate(query);
              
              JOptionPane.showMessageDialog(this, "Data added successfully");
              
                  p3_t1.setText("");
                  p3_t2.setText("");
                  p3_t3.setText("");
              
            } catch (SQLException ex) {
                 JOptionPane.showMessageDialog(this, ex);
                //Logger.getLogger(application.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
        
        }
        
        //update
        if(e.getSource()==p3_b3){
        
         if (p3_t1.getText().equals("")){
          
            JOptionPane.showMessageDialog(this, "please enter publisher id");
          
          }
          else{
          try {
              
          text1= p3_t1.getText();
          text2= p3_t2.getText();
          text3= p3_t3.getText();
                     
         query = "update publisher set name = N'"+text2+"',city = N'"+text3+"'where publisher_id = N'"+text1+"'";
        
              ss.executeUpdate(query);
              
              JOptionPane.showMessageDialog(this, "Data Updated successfully");
              
                  p3_t1.setText("");
                  p3_t2.setText("");
                  p3_t3.setText("");
              
            } catch (SQLException ex) {
                  JOptionPane.showMessageDialog(this, ex);
               // Logger.getLogger(application.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
        }
                //delete
         if(e.getSource()==p3_b2){
        
         if (p3_t1.getText().equals("")){
          
            JOptionPane.showMessageDialog(this, "please enter Publisher id");
          
          }
          else{
          try {
              
          text1= p3_t1.getText();
         query = "delete from publisher where publisher_id = N'"+text1+"'";
        
              ss.executeUpdate(query);
              
              JOptionPane.showMessageDialog(this, "Data deleted successfully");
              
                  p5_t1.setText("");
                  p5_t2.setText("");
                  p5_t3.setText("");
              
            } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, ex);
               // Logger.getLogger(application.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
        }
    //show on table
             if(e.getSource()==p3_b4){
                 
          try {
              
                  query = "select * from publisher";
        
             
                   rs = ss.executeQuery(query);
                   
                   
               
               t3.setRowCount(0);
              while(rs.next()){
              
                String publisher_id = rs.getString("publisher_id");  
                String name = rs.getString("name");  
                String city = rs.getString("city");
                
                String data [] = {publisher_id,name, city};
               
                 t3.addRow(data);
              }
              
              JOptionPane.showMessageDialog(this, "Data imported sucssfully");
              
            } catch (SQLException ex) {
                  JOptionPane.showMessageDialog(this, ex);
               // Logger.getLogger(application.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
/////////////////////////////////subjects/////////////////////////////////////////////////////////////////////        
      //insert
      
         if(e.getSource()==p7_b1){
          if (p7_t1.getText().equals("")||p7_t2.getText().equals("")){
          
            JOptionPane.showMessageDialog(this, "please enter subject id and subject");
          
          }
          else{
          try {
              
          text1= p7_t1.getText();
          text2= p7_t2.getText();
                     
         query = "insert into subjects values(N'"+text1+"',N'"+text2+"')";
        
              ss.executeUpdate(query);
              
              JOptionPane.showMessageDialog(this, "Data added successfully");
              
                  p7_t1.setText("");
                  p7_t2.setText("");
                 
              
            } catch (SQLException ex) {
                 JOptionPane.showMessageDialog(this, ex);
                //Logger.getLogger(application.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
        
        }
         //update
         if(e.getSource()==p7_b3){
        
         if (p7_t1.getText().equals("")){
          
            JOptionPane.showMessageDialog(this, "please enter subject id");
          
          }
          else{
          try {
              
          text1= p7_t1.getText();
          text2= p7_t2.getText();
        
                     
         query = "update subjects set subjects = N'"+text2+"' where subjects_id = N'"+text1+"'";
        
              ss.executeUpdate(query);
              
              JOptionPane.showMessageDialog(this, "Data Updated successfully");
              
                  p7_t1.setText("");
                  p7_t2.setText("");
              
            } catch (SQLException ex) {
                  JOptionPane.showMessageDialog(this, ex);
               // Logger.getLogger(application.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
        }
                  //delete
         if(e.getSource()==p7_b2){
        
         if (p7_t1.getText().equals("")){
          
            JOptionPane.showMessageDialog(this, "please enter subjects_id");
          
          }
          else{
          try {
              
          text1= p7_t1.getText();
         query = "delete from subjects where subjects_id = N'"+text1+"'";
        
              ss.executeUpdate(query);
              
              JOptionPane.showMessageDialog(this, "Data deleted successfully");
              
                  p7_t1.setText("");
                  p7_t2.setText("");
              
            } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, ex);
                //Logger.getLogger(application.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
        }
         //show on table
          if(e.getSource()==p7_b4){
                 
          try {
              
                  query = "select * from subjects";
        
             
                   rs = ss.executeQuery(query);
                   
                   
               
               t7.setRowCount(0);
              while(rs.next()){
              
                String subjects_id = rs.getString("subjects_id");  
                String subjects = rs.getString("subjects");  
                
                String data [] = {subjects_id,subjects};
               
                 t7.addRow(data);
              }
              
              JOptionPane.showMessageDialog(this, "Data imported sucssfully");
              
            } catch (SQLException ex) {
                  JOptionPane.showMessageDialog(this, ex);
                //Logger.getLogger(application.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
 ////////////////////////////////books/////////////////////////////////////////////////////////////////////////
   if(e.getSource()==p2_b1){
          if (p2_t1.getText().equals("")||p2_t2.getText().equals("")||p2_t3.getText().equals("")||p2_t4.getText().equals("")||p2_t5.getText().equals("")||p2_t6.getText().equals("")){
          
            JOptionPane.showMessageDialog(this, "please enter all data");
          
          }
          else{
          try {
              
          text1= p2_t1.getText();
          text2= p2_t2.getText();
          text3= p2_t3.getText();
          text4= p2_t4.getText();
          text5= p2_t5.getText();
          text6= p2_t6.getText();
                     
         query = "insert into book values(N'"+text1+"',N'"+text2+"','"+text3+"','"+text4+"',N'"+text5+"',N'"+text6+"')";
        
              ss.executeUpdate(query);
              
              JOptionPane.showMessageDialog(this, "Data added successfully");
              
                  p2_t1.setText("");
                  p2_t2.setText("");
                  p2_t3.setText("");
                  p2_t4.setText("");
                  p2_t5.setText("");
                  p2_t6.setText("");
              
            } catch (SQLException ex) {
                 JOptionPane.showMessageDialog(this, ex);
                //Logger.getLogger(application.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
        
        }
        //update
        if(e.getSource()==p2_b3){
        
         if (p2_t1.getText().equals("")){
          
            JOptionPane.showMessageDialog(this, "please enter ISBN");
          
          }
          else{
          try {
              
          text1= p2_t1.getText();
          text2= p2_t2.getText();
          text3= p2_t3.getText();
          text4= p2_t4.getText();
          text5= p2_t5.getText();
          text6= p2_t6.getText();
                     
         query = "update book set title = N'"+text2+"',page_count ='"+text3+"',price ='"+text4+"',subjects_id =N'"+text5+"',publisher_id =N'"+text6+"' where ISBN = N'"+text1+"'";
        
              ss.executeUpdate(query);
              
              JOptionPane.showMessageDialog(this, "Data Updated successfully");
              
                  p2_t1.setText("");
                  p2_t2.setText("");
                  p2_t3.setText("");
                  p2_t4.setText("");
                  p2_t5.setText("");
                  p2_t6.setText("");
              
            } catch (SQLException ex) {
                  JOptionPane.showMessageDialog(this, ex);
                //Logger.getLogger(application.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
        }
        
        
        //delete
         if(e.getSource()==p2_b2){
        
         if (p2_t1.getText().equals("")){
          
            JOptionPane.showMessageDialog(this, "please enter ISBN");
          
          }
          else{
          try {
              
          text1= p2_t1.getText();
          
         query = "delete from book where ISBN = N'"+text1+"'";
        
              ss.executeUpdate(query);
              
              JOptionPane.showMessageDialog(this, "Data deleted successfully");
              
                  p2_t1.setText("");
                  p2_t2.setText("");
                  p2_t3.setText("");
                  p2_t4.setText("");
                  p2_t5.setText("");
                  p2_t6.setText("");
              
            } catch (SQLException ex) {
                     JOptionPane.showMessageDialog(this, ex);
               // Logger.getLogger(application.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
        }
        
        
        //show on table
             if(e.getSource()==p2_b4){
                 
          try {
              
                  query = "select b.ISBN , b.title , b.page_count,b.price,s.subjects ,b.publisher_id  from book b left outer join subjects s  on s.subjects_id =b.subjects_id;";
        
             
                   rs = ss.executeQuery(query);
                   
                   
               
               t2.setRowCount(0);
              while(rs.next()){
              
                String ISBN = rs.getString("ISBN");  
                String title = rs.getString("title");  
                String page_count = String.valueOf(rs.getInt("page_count"));
                String price = String.valueOf(rs.getInt("price"));
                String subjects = rs.getString("subjects");
                String publisher_id = rs.getString("publisher_id");
                String data [] = {ISBN ,title, page_count,price,subjects,publisher_id};
               
                 t2.addRow(data);
              }
              
              JOptionPane.showMessageDialog(this, "Data imported sucssfully");
              
            } catch (SQLException ex) {
                  JOptionPane.showMessageDialog(this, ex);
               // Logger.getLogger(application.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
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


//////////////////////////////////authors books///////////////////////////////////////////////////////////////
 if(e.getSource()==p6_b1){
          if (p6_t1.getText().equals("")||p6_t2.getText().equals("")){
          
            JOptionPane.showMessageDialog(this, "please enter all data");
          
          }
          else{
          try {
              
          text1= p6_t1.getText();
          text2= p6_t2.getText();          
         query = "insert into authors_books values(N'"+text1+"',N'"+text2+"')";
        
              ss.executeUpdate(query);
              
              JOptionPane.showMessageDialog(this, "Data added successfully");
              
                  p6_t1.setText("");
                  p6_t2.setText("");
         
              
            } catch (SQLException ex) {
                 JOptionPane.showMessageDialog(this, ex);
                //Logger.getLogger(application.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
        
        }
        //update
        if(e.getSource()==p6_b3){
        
         if (p6_t2.getText().equals("")||p6_t2.getText().equals("")){
          
            JOptionPane.showMessageDialog(this, "please enter all data");
          
          }
          else{
          try {
              
          text1= p6_t1.getText();
          text2= p6_t2.getText();

                     
         query = "update authors_books set author_id = N'"+text2+"' where ISBN = N'"+text1+"'";
        
              ss.executeUpdate(query);
              
              JOptionPane.showMessageDialog(this, "Data Updated successfully");
              
                  p6_t1.setText("");
                  p6_t2.setText("");

              
            } catch (SQLException ex) {
                  JOptionPane.showMessageDialog(this, ex);
                //Logger.getLogger(application.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
        }
        
        
        //delete
         if(e.getSource()==p6_b2){
        
         if (p6_t2.getText().equals("")||p6_t2.getText().equals("")){
          
            JOptionPane.showMessageDialog(this, "please enter All Data");
          
          }
          else{
          try {
              
          text1= p6_t1.getText();
          text2= p6_t2.getText();
          
         query = "delete from authors_books where ISBN = N'"+text1+"'and author_id = N'"+text2+"'";
        
              ss.executeUpdate(query);
              
              JOptionPane.showMessageDialog(this, "Data deleted successfully");
              
                  p6_t1.setText("");
                  p6_t2.setText("");

            } catch (SQLException ex) {
                     JOptionPane.showMessageDialog(this, ex);
               // Logger.getLogger(application.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
        }
        
        
        //show on table
             if(e.getSource()==p6_b4){
                 
          try {
              
                  query = "select * from authors_books";
        
             
                   rs = ss.executeQuery(query);
                   
                   
               
               t6.setRowCount(0);
              while(rs.next()){
              
                String ISBN = rs.getString("ISBN");  
                String author_id = rs.getString("author_id");  
                String data [] = {ISBN ,author_id};
               
                 t6.addRow(data);
              }
              
              JOptionPane.showMessageDialog(this, "Data imported sucssfully");
              
            } catch (SQLException ex) {
                  JOptionPane.showMessageDialog(this, ex);
               // Logger.getLogger(application.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
/////////////////////////////////search for book////////////////////////////////////////////////////////////////////////////

    if(e.getSource()==r1 ){                 
            if (p8_t1.getText().equals("")){
          
            JOptionPane.showMessageDialog(this, "please enter ISBN");
          
          }
          else{     
                      String [][] search = { 
       
        };
        String[] sbooks={"ISBN","title","page_count","price","subjects","publisher_id"}; 
        DefaultTableModel t8 = new DefaultTableModel (search,sbooks);
        p8_table = new JTable(t8);
        p8_scroll =new JScrollPane(p8_table);  
        p8.add(p8_scroll);
        p8_scroll.setBounds(30, 100, 700, 900);
        
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
      if(e.getSource()==r3 ){                 
            if (p8_t1.getText().equals("")){
          
            JOptionPane.showMessageDialog(this, "please enter subject id");
          
          }
          else{     
                      String [][] search = { 
       
        };
        String[] sbooks={"ISBN","title","page_count","price","subjects","publisher_id"}; 
        DefaultTableModel t8_3 = new DefaultTableModel (search,sbooks);
        p8_table3 = new JTable(t8_3);
        p8_scroll3 =new JScrollPane(p8_table3);  
        p8.add(p8_scroll3);
        p8_scroll3.setBounds(30, 100, 700, 900);
        
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
        if(e.getSource()==r2 ){                 
            if (p8_t1.getText().equals("")){
          
            JOptionPane.showMessageDialog(this, "please enter author id");
          
          }
          else{     
                      String [][] search = { 
       
        };
        String[] sbooks={"ISBN","title","page_count","price","subjects","publisher_id","author_id"}; 
        DefaultTableModel t8_2 = new DefaultTableModel (search,sbooks);
        p8_table2 = new JTable(t8_2);
        p8_scroll2 =new JScrollPane(p8_table2);  
        p8.add(p8_scroll2);
        p8_scroll2.setBounds(30, 100, 700, 900);
        
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
///////////////////////////////  general ///////////////////////////////////////////////////////////////////////
        if(e.getSource()==p1_b6){
            try {
                con.close();
                ss.close();
                
                System.out.println("database closed");
                System.exit(0);
            } catch (SQLException ex) {
                  JOptionPane.showMessageDialog(this, ex);
               // Logger.getLogger(application.class.getName()).log(Level.SEVERE, null, ex);
            }

          }
     
         
         
    if(e.getSource() == p1_b1 ){
  
        parentpanel.removeAll();
         parentpanel.add(p2);
         parentpanel.repaint();
         parentpanel.revalidate();
  
    }
    
      if(e.getSource() == p1_b2 ){
       
         parentpanel.removeAll();
         parentpanel.add(p3);
         parentpanel.repaint();
         parentpanel.revalidate();
    }
          if(e.getSource() == p1_b5 ){
        
        parentpanel.removeAll();
         parentpanel.add(p8);
         parentpanel.repaint();
         parentpanel.revalidate();
  
    }
      
    if(e.getSource() == p3_b5 ){
       
         parentpanel.removeAll();
         parentpanel.add(p4);
         parentpanel.repaint();
         parentpanel.revalidate();
    }
   if(e.getSource() == p1_b3){
       
         parentpanel.removeAll();
         parentpanel.add(p5);
         parentpanel.repaint();
         parentpanel.revalidate();
    }
     if(e.getSource() == p5_b5){
       
         parentpanel.removeAll();
         parentpanel.add(p6);
         parentpanel.repaint();
         parentpanel.revalidate();
    }  
     
    if(e.getSource() == p1_b4){
       
         parentpanel.removeAll();
         parentpanel.add(p7);
         parentpanel.repaint();
         parentpanel.revalidate();
    }
        //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

