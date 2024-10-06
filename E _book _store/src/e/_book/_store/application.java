package e._book._store;

import java.awt.*;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class application extends JFrame {

    //connection
    public static Connection con;
    public static Statement ss;
    public static String query;
    public static ResultSet rs;

    menu_form menu_form;
    //parent panel
    public JPanel parentpanel = new JPanel();

    public book_form book_form;

    public publisher_form publisher_form;
    public publisher_phones_form publisher_phones_form;
    public authors_form authors_form;
    public authors_books_form authors_books_form;
    public subjects_form subjects_form;
    public search_for_book_form search_for_book_form;

    ////////////////////////////////
    application() {
        //conection

        connect();

        //frame
        setTitle("e-book store");
        setBounds(100, 100, 1100, 630);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setResizable(false);

        menu_form = new menu_form(this);
        //parent panel

        parentpanel.setBounds(200, 0, 900, 630);
        parentpanel.setLayout(new CardLayout());
        this.add(parentpanel);

        book_form = new book_form(this);
        publisher_form = new publisher_form(this);
        publisher_phones_form = new publisher_phones_form(this);
        authors_form = new authors_form(this);
        authors_books_form = new authors_books_form(this);
        subjects_form = new subjects_form(this);
        search_for_book_form = new search_for_book_form(this);

    }

    public static void connect() {
 try {
            // Load the JDBC driver
        //    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");   


            // Create the connection string
          String url = "jdbc:sqlserver://localhost\\ALPHA:1433;databaseName=E_book_store;user=alpha;password=123456;trustServerCertificate=true;";

            // Establish the connection
            con = DriverManager.getConnection(url);
             ss =con.createStatement();
 
             System.out.println("Database CONNECTED");

           
        } catch ( SQLException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

        application a1 = new application();

    }

}
