package org.edu.epo.gui.formulaire;

import org.edu.epo.database.SingletonConnection;
import org.edu.epo.gui.menu.submenu.MenuFilm;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

public class FilmForm extends JFrame {
    Connection con = SingletonConnection.getConnection();


    JTable table1;
    Statement pst;
    ResultSet rs;
    JTextField txttitre, txtdure;
    JScrollPane scroll1;

    public void init() {
        table1 = new JTable();
        scroll1  = new JScrollPane();
        scroll1.setBounds(10, 230, 770, 130);
        scroll1.setViewportView(table1);
    }

    public FilmForm() {

        super("Formulaire");
        super.setSize(800, 450);
        super.setLocationRelativeTo(null);
        super.setResizable(true);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel pn = new JPanel();
        pn.setLayout(null);
        add(pn);
        pn.setBackground(new Color(220, 210, 220));

        //Partie Titre
        JLabel lblTitre = new JLabel("Ajouter un films");
        lblTitre.setBounds(250, 10, 800, 30);
        lblTitre.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitre.setForeground(new Color(0, 0, 205));
        pn.add(lblTitre);

        // id films

        //titre films
        JLabel lbltitre = new JLabel("Titre");
        lbltitre.setBounds(120, 80, 50, 30);
        lbltitre.setFont(new Font ("Arial", Font.BOLD, 16));
        lbltitre.setForeground(new Color (0, 0, 0));
        pn.add(lbltitre);

        txttitre = new JTextField();
        txttitre.setBounds (220, 80, 200, 30);
        txttitre.setFont(new Font("Arial", Font.PLAIN, 14));
        pn.add(txttitre);

        // dure films
        JLabel lbldure = new JLabel("Dure");
        lbldure.setBounds(120,130,50,30);
        lbldure.setFont(new Font("Arial",Font.BOLD,16));
        lbldure.setForeground(new Color(0,0,0));
        pn.add(lbldure);

        txtdure = new JTextField();
        txtdure.setBounds (220, 130, 200, 30);
        txtdure.setFont(new Font("Arial", Font.PLAIN, 14));
        pn.add(txtdure);

        JButton btn = new JButton("Valider");
        btn.setBounds(220, 180, 80, 30);

        btn.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent ev){
                String titrefilm, dureefilm;

                titrefilm = txttitre.getText();
                dureefilm = txtdure.getText();


                String rq = "insert into film(titrefilm,dureefilm) values (?,?)";
                try {
                    PreparedStatement ps = con.prepareStatement(rq);
                    ps.setString(1, titrefilm);
                    ps.setString(2, dureefilm);
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Film enregistre !", null, JOptionPane.INFORMATION_MESSAGE);
                    con.close();
                }catch(SQLException ex){
                    JOptionPane.showMessageDialog(null, "Erreur !" + ex.getMessage(), null, JOptionPane.ERROR_MESSAGE);
                }
                dispose();
                FilmForm form = new FilmForm();
                form.setVisible(true);
            }
        });
        pn.add(btn);

        JButton btnr = new JButton("Retour");
        btnr.setBounds(340, 180, 80, 30);
        btnr.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                MenuFilm lien = new MenuFilm();
                lien.setVisible(true);
                dispose();
            }
        });
        pn.add(btnr);

        //Listes des films
        DefaultTableModel model = new DefaultTableModel();
        init();
        pn.add(scroll1);
        model.addColumn("Identifiant");
        model.addColumn("Titre du film");
        model.addColumn("Durée du film");

        //pn.add(table1);
        table1.setModel(model);
        String sql = "select * from film order by numfilm desc";
        try {
            pst = con.createStatement();
            rs = pst.executeQuery(sql);
            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getString("numfilm"),
                        rs.getString("titrefilm"),
                        rs.getString("dureefilm")
                });
            }
            //con.maconnection().close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur !", null, JOptionPane.INFORMATION_MESSAGE);
        }

        table1.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent evt) {
                table1MouseReleased(evt);
            }
        });


    }
    private void table1MouseReleased(MouseEvent evt) {
        int selectionner = table1.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        //lblid.setText(model.getValueAt(selectionner, 0).toString());
        txttitre.setText(model.getValueAt(selectionner, 0).toString());
        txtdure.setText(model.getValueAt(selectionner, 1).toString());

    }

}

