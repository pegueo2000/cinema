package org.edu.epo.gui.menu;

import org.edu.epo.Cinema;
import org.edu.epo.gui.liste.ListeCreneaux;
import org.edu.epo.gui.liste.ListeFilms;
import org.edu.epo.gui.liste.ListeProjections;
import org.edu.epo.gui.liste.ListeSalles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuList extends JFrame {
    JTable table;

    public void init(){
        table = new JTable();
    }
    public MenuList() {
        Container c = this.getContentPane();
        c.setLayout(new BorderLayout());
        c.setBackground(new Color(245, 245, 220));

        super.setTitle("Listes ");
        super.setSize(800, 450);
        super.setLocationRelativeTo(null);
        super.setResizable(true);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel pn = new JPanel();
        pn.setLayout(new FlowLayout());
        JPanel pCenter = new JPanel();
        pCenter.setLayout(new FlowLayout());

        JPanel pgrid = new JPanel();
        pgrid.setLayout(new GridLayout(7,1));

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

        JPanel pg6 = new JPanel();
        pg6.setLayout(new FlowLayout());

        JPanel pg7 = new JPanel();
        pg7.setLayout(new FlowLayout());

        JLabel l1 = new JLabel("Vos différentes listes");
        Font police = new Font ("Tahoma", Font.BOLD,26);
        l1.setFont(police);
        JLabel lvide = new JLabel("");

        Font pol = new Font("Calibri",Font.PLAIN, 19);

        JButton btn1 = new JButton("Listes des créneaux");
        btn1.setPreferredSize(new Dimension(250,50));
        btn1.setFont(pol);
       btn1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                ListeCreneaux lc = new ListeCreneaux();
                lc.setVisible(true);
                dispose();
            }
        });

        JButton btn2 = new JButton("Listes des films");
        btn2.setPreferredSize(new Dimension(250,50));
        btn2.setFont(pol);
        btn2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                ListeFilms lf = new ListeFilms();
                lf.setVisible(true);
                dispose();
            }
        });

        JButton btn3 = new JButton("Listes des salles");
        btn3.setPreferredSize(new Dimension(250,50));
        btn3.setFont(pol);
        btn3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                ListeSalles ls = new ListeSalles();
                ls.setVisible(true);
                dispose();
            }
        });

        JButton btn4 = new JButton("Listes des projections");
        btn4.setPreferredSize(new Dimension(250,50));
        btn4.setFont(pol);
        btn4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                ListeProjections lp = new ListeProjections();
                lp.setVisible(true);
                dispose();
            }
        });

        JButton btn5 = new JButton("Retour");
        btn5.setPreferredSize(new Dimension(100,25));
        btn5.setFont(pol);btn5.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Cinema lien = new Cinema();
                lien.setVisible(true);
                dispose();
            }
        });

        pg1.add(l1);
        pg2.add(lvide);
        pg3.add(btn1);
        pg4.add(btn2);
        pg5.add(btn3);
        pg6.add(btn4);
        pg7.add(btn5);

        pgrid.add(pg1);
        pgrid.add(pg2);
        pgrid.add(pg3);
        pgrid.add(pg4);
        pgrid.add(pg5);
        pgrid.add(pg6);
        pgrid.add(pg7);

        pCenter.add(pgrid);

        c.add(pCenter, BorderLayout.CENTER);


    }
}
