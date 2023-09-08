package org.edu.epo;

import org.edu.epo.database.SingletonConnection;
import org.edu.epo.gui.menu.MenuImpression;
import org.edu.epo.gui.menu.MenuList;
import org.edu.epo.gui.menu.MenuUpdate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class Cinema extends JFrame {
    JTable table;

    public void init(){
        table = new JTable();
    }
    public Cinema() {
        Container c = this.getContentPane();
        c.setLayout(new BorderLayout());
        c.setBackground(new Color(245, 245, 220));

        super.setTitle(" Bienvenue dans Niadja");
        super.setSize(800, 450);
        super.setLocationRelativeTo(null);
        super.setResizable(true);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel pn = new JPanel();
        pn.setLayout(new FlowLayout());
        JPanel pCenter = new JPanel();
        pCenter.setLayout(new FlowLayout());

        JPanel pgrid = new JPanel();
        pgrid.setLayout(new GridLayout(5,1));

        JPanel pg1 = new JPanel();
        pg1.setLayout(new FlowLayout());

        JPanel pg2 = new JPanel();
        pg2.setLayout(new FlowLayout());

        JPanel pg3 = new JPanel();
        pg3.setLayout(new FlowLayout());

        JPanel pg4 = new JPanel();
        pg4.setLayout(new FlowLayout());

        JPanel pg5 = new JPanel();
        pg5.setLayout(new FlowLayout());


        JLabel l1 = new JLabel("Menu général");
        Font police = new Font ("Tahoma", Font.BOLD,26);
        l1.setFont(police);
        JLabel lvide = new JLabel("");

        Font pol = new Font("Calibri",Font.PLAIN, 19);

        JButton listeBtn= new JButton("Voir listes");
        listeBtn.setPreferredSize(new Dimension(250,50));
        listeBtn.setFont(pol);
        listeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuList list = new MenuList();
                list.setVisible(true);
                dispose();
            }
        });


        JButton updateBtn = new JButton("Mise à jour");
        updateBtn.setPreferredSize(new Dimension(250,50));
        updateBtn.setFont(pol);
        updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               MenuUpdate menuUpdate = new MenuUpdate();
                menuUpdate.setVisible(true);
                dispose();
            }
        });

        JButton etatBtn = new JButton("Etat");
        etatBtn.setPreferredSize(new Dimension(250,50));
        etatBtn.setFont(pol);
        etatBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuImpression imp = new MenuImpression();
                imp.setVisible(true);
                dispose();
            }
        });


        pg1.add(l1);
        pg2.add(lvide);
        pg3.add(listeBtn);
        pg4.add(updateBtn);
        pg5.add(etatBtn);


        pgrid.add(pg1);
        pgrid.add(pg2);
        pgrid.add(pg3);
        pgrid.add(pg4);
        pgrid.add(pg5);

        pCenter.add(pgrid);

        c.add(pCenter, BorderLayout.CENTER);


    }

    public static void main(String[] args) {
        Connection conn = SingletonConnection.getConnection();
        Cinema cinema = new Cinema();
        cinema.setVisible(true);
        }
    }
