package org.edu.epo.gui.menu.submenu;

import org.edu.epo.gui.formulaire.SalleForm;
import org.edu.epo.gui.menu.MenuUpdate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuSalle extends JFrame {
    public MenuSalle(){
        Container c = this.getContentPane();
        c.setLayout(new BorderLayout());
        c.setBackground(new Color(245, 245, 220));

        super.setTitle("Salle");
        super.setSize(800, 450);
        super.setLocationRelativeTo(null);
        super.setResizable(true);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel pn = new JPanel();
        pn.setLayout(new FlowLayout());
        JPanel pCenter = new JPanel();
        pCenter.setLayout(new FlowLayout());

        JPanel pgrid = new JPanel();
        pgrid.setLayout(new GridLayout(6,1));

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


        JLabel l1 = new JLabel("Mise à jour de la base de données des salles");
        Font police = new Font ("Tahoma", Font.BOLD,26);
        l1.setFont(police);
        //JLabel lvide = new JLabel("");

        Font pol = new Font("Calibri",Font.PLAIN, 19);

        JButton btn1 = new JButton("Ajouter une salle");
        btn1.setPreferredSize(new Dimension(250,50));
        btn1.setFont(pol);
        btn1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                SalleForm lien = new SalleForm();
                lien.setVisible(true);
                dispose();
            }
        });


        JButton btn2 = new JButton("Modifier une salle");
        btn2.setPreferredSize(new Dimension(250,50));
        btn2.setFont(pol);

        JButton btn3 = new JButton("Supprimer une salle");
        btn3.setPreferredSize(new Dimension(250,50));
        btn3.setFont(pol);

        JButton btn4 = new JButton("Retour");
        btn4.setPreferredSize(new Dimension(100,25));
        btn4.setFont(pol);
        btn4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                MenuUpdate lien = new MenuUpdate();
                lien.setVisible(true);
                dispose();
            }
        });


        pg1.add(l1);
        //pg2.add(lvide);
        pg3.add(btn1);
        pg4.add(btn2);
        pg5.add(btn3);
        pg6.add(btn4);


        pgrid.add(pg1);
        //pgrid.add(pg2);
        pgrid.add(pg3);
        pgrid.add(pg4);
        pgrid.add(pg5);
        pgrid.add(pg6);

        pCenter.add(pgrid);

        c.add(pCenter, BorderLayout.CENTER);
    }

}
