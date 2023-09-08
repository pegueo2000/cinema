package org.edu.epo.gui.liste;

import org.edu.epo.database.SingletonConnection;
import org.edu.epo.gui.menu.MenuList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ListeSalles extends JFrame {
    Connection con = SingletonConnection.getConnection();
    JPanel pn;
    JTable table1;
    Statement pst;
    ResultSet rs;
    JScrollPane scroll1;
    JLabel lblTitre;

    public void init() {
        table1 = new JTable();
        scroll1  = new JScrollPane();
        scroll1.setBounds(10, 80, 770, 200);
        scroll1.setViewportView(table1);
    }

    public ListeSalles(){
        super("Liste des Salles");
        super.setSize(800, 450);
        super.setLocationRelativeTo(null);
        super.setResizable(true);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pn = new JPanel();
        pn.setLayout(null);
        add(pn);
        pn.setBackground(new Color(220, 210, 220));

        //Partie Titre
        lblTitre = new JLabel("Liste des salles");
        lblTitre.setBounds(250, 10, 800, 30);
        lblTitre.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitre.setForeground(new Color(0, 0, 205));
        pn.add(lblTitre);


        //Listes des salles
        DefaultTableModel model = new DefaultTableModel();
        init();
        pn.add(scroll1);
        model.addColumn("Identifiant de la salle");
        model.addColumn("Nom de la salle");
        model.addColumn("Capacité de la salle");

        //pn.add(table1);
        table1.setModel(model);
        String sql = "select * from salle order by numsalle asc";
        try {
            pst = con.createStatement();
            rs = pst.executeQuery(sql);
            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getString("numsalle"),
                        rs.getString("nomsalle"),
                        rs.getString("capacitesalle")
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

        // Bouton retour
        JButton btnr = new JButton("Retour");
        btnr.setBounds(340, 300, 80, 30);
        btnr.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                MenuList lien = new MenuList();
                lien.setVisible(true);
                dispose();
            }
        });
        pn.add(btnr);

    }
    private void table1MouseReleased(MouseEvent evt) {
        int selectionner = table1.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        //lblid.setText(model.getValueAt(selectionner, 0).toString());
        //txttitre.setText(model.getValueAt(selectionner, 0).toString());
        //txtdure.setText(model.getValueAt(selectionner, 1).toString());
    }
}
