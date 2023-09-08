package org.edu.epo.gui.formulaire;

import org.edu.epo.database.SingletonConnection;
import org.edu.epo.gui.menu.submenu.MenuCreneau;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

public class CreneauForm extends JFrame {
    Connection con = SingletonConnection.getConnection();

    JTable table1;
    Statement pst;
    ResultSet rs;
    JTextField txtdate, txtdure;
    JScrollPane scroll1;

    public void init() {
        table1 = new JTable();
        scroll1  = new JScrollPane();
        scroll1.setBounds(10, 230, 770, 130);
        scroll1.setViewportView(table1);
    }

    public CreneauForm() {

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
        JLabel lblTitre = new JLabel("Ajouter un créneau");
        lblTitre.setBounds(250, 10, 800, 30);
        lblTitre.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitre.setForeground(new Color(0, 0, 205));
        pn.add(lblTitre);

        // id

        //date creneau
        JLabel lbldate = new JLabel("Date");
        lbldate.setBounds(120, 80, 50, 30);
        lbldate.setFont(new Font ("Arial", Font.BOLD, 16));
        lbldate.setForeground(new Color (0, 0, 0));
        pn.add(lbldate);

        //DateFormat dateFormat = DateFormat.getInstance();
        //JFormattedTextField date = new JFormattedTextField();
        //date.setValue(new Date());
        //date.setFocusLostBehavior(JFormattedTextField.REVERT);

        txtdate = new JTextField();
        txtdate.setBounds (220, 80, 200, 30);
        txtdate.setFont(new Font("Arial", Font.PLAIN, 14));
        pn.add(txtdate);

        // heure creneau
        JLabel lbldure = new JLabel("Heure");
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
                String datecren, heuredebutcren;

                datecren = txtdate.getText();
                heuredebutcren = txtdure.getText();


                String rq = "insert into creneaux(datecren,heuredebutcren) values (?,?)";
                try {
                    PreparedStatement ps = con.prepareStatement(rq);
                    ps.setString(1, datecren);
                    ps.setString(2, heuredebutcren);
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Creneau enregistre !", null, JOptionPane.INFORMATION_MESSAGE);
                    con.close();
                }catch(SQLException ex){
                    JOptionPane.showMessageDialog(null, "Erreur !" + ex.getMessage(), null, JOptionPane.ERROR_MESSAGE);
                }
                dispose();

            }
        });
        pn.add(btn);

        JButton btnr = new JButton("Retour");
        btnr.setBounds(340, 180, 80, 30);
        btnr.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                MenuCreneau lien = new MenuCreneau();
                lien.setVisible(true);
                dispose();
            }
        });
        pn.add(btnr);

        //Listes des creneaux
        DefaultTableModel model = new DefaultTableModel();
        init();
        pn.add(scroll1);
        model.addColumn("Identifiant");
        model.addColumn("Date du creneau");
        model.addColumn("Heure du creneau");

        table1.setModel(model);
        String sql = "select * from creneaux order by numcren desc";
        try {
            pst = con.createStatement();
            rs = pst.executeQuery(sql);
            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getString("numcren"),
                        rs.getString("datecren"),
                        rs.getString("heuredebutcren")
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
        txtdate.setText(model.getValueAt(selectionner, 0).toString());
        txtdure.setText(model.getValueAt(selectionner, 1).toString());

    }
}
