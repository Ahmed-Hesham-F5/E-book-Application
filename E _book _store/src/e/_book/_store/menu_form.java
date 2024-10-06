/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package e._book._store;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class menu_form extends JPanel implements ActionListener {

    JButton Books_form_btn = new JButton("Books");
    JButton Publishers_form_btn = new JButton("Publishers");
    JButton Authors_form_btn = new JButton("Authors");
    JButton Subjects_form_btn = new JButton("Subjects");
    JButton Search_for_book_form_name = new JButton("Search for book");
    JButton Exit = new JButton("Exit");
    application application;

    public menu_form(application _application) {

        application = _application;
        setBounds(0, 0, 200, 600);
        application.add(this);
        setLayout(new GridLayout(6, 0));

        add(Books_form_btn);
        add(Publishers_form_btn);
        add(Authors_form_btn);
        add(Subjects_form_btn);
        add(Search_for_book_form_name);
        add(Exit);

        Books_form_btn.addActionListener(this);
        Publishers_form_btn.addActionListener(this);
        Exit.addActionListener(this);
        Authors_form_btn.addActionListener(this);
        Subjects_form_btn.addActionListener(this);
        Search_for_book_form_name.addActionListener(this);
        Search_for_book_form_name.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

        if (e.getSource() == Books_form_btn) {

            application.parentpanel.removeAll();
            application.parentpanel.add(application.book_form);
            application.parentpanel.repaint();
            application.parentpanel.revalidate();
        }

        if (e.getSource() == Publishers_form_btn) {

            application.parentpanel.removeAll();
            application.parentpanel.add(application.publisher_form);
            application.parentpanel.repaint();
            application.parentpanel.revalidate();
        }
        if (e.getSource() == Search_for_book_form_name) {

            application.parentpanel.removeAll();
            application.parentpanel.add(application.search_for_book_form);
            application.parentpanel.repaint();
            application.parentpanel.revalidate();

        }

        if (e.getSource() == Authors_form_btn) {

            application.parentpanel.removeAll();
            application.parentpanel.add(application.authors_form);
            application.parentpanel.repaint();
            application.parentpanel.revalidate();
        }

        if (e.getSource() == Subjects_form_btn) {

            application.parentpanel.removeAll();
            application.parentpanel.add(application.subjects_form);
            application.parentpanel.repaint();
            application.parentpanel.revalidate();
        }
        if (e.getSource() == Exit) {
            try {
                application.con.close();
                application.ss.close();

                System.out.println("database closed");
                System.exit(0);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(application, ex);
                // Logger.getLogger(application.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

}
