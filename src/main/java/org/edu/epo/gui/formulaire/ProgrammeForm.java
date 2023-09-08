package org.edu.epo.gui.formulaire;

import org.edu.epo.database.SingletonConnection;
import org.edu.epo.gui.menu.submenu.MenuProgramme;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

public class ProgrammeForm extends JFrame {

    Connection con = SingletonConnection.getConnection();

    JTable table1;
    Statement pst;
    ResultSet rs;
    JTextField txtt;
    JScrollPane scroll1;
    JComboBox comboidc, comboidf, comboids;

    public void init() {
        table1 = new JTable();
        scroll1  = new JScrollPane();
        scroll1.setBounds(10, 280, 770, 130);
        scroll1.setViewportView(table1);
    }

    public ProgrammeForm() {

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
        JLabel lblTitre = new JLabel("Ajouter un programme de diffusion");
        lblTitre.setBounds(250, 10, 800, 30);
        lblTitre.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitre.setForeground(new Color(0, 0, 205));
        pn.add(lblTitre);



        //id creneau
        JLabel lblidcr = new JLabel("Numero du créneau");
        lblidcr.setBounds(120, 60, 150, 30);
        lblidcr.setFont(new Font ("Arial", Font.BOLD, 16));
        lblidcr.setForeground(new Color (0, 0, 0));
        pn.add(lblidcr);

        comboidc = new JComboBox();
        comboidc.setBounds (280, 60, 200, 30);
        comboidc.setFont(new Font("Arial", Font.PLAIN, 14));

        pn.add(comboidc);

        // id film
        JLabel lblidf = new JLabel("Numero film");
        lblidf.setBounds(120,100,100,30);
        lblidf.setFont(new Font("Arial",Font.BOLD,16));
        lblidf.setForeground(new Color(0,0,0));
        pn.add(lblidf);

        comboidf = new JComboBox();
        comboidf.setBounds (280, 100, 200, 30);
        comboidf.setFont(new Font("Arial", Font.PLAIN, 14));
        pn.add(comboidf);

        // id salle
        JLabel lblids = new JLabel("Numero salle");
        lblids.setBounds(120,140,100,30);
        lblids.setFont(new Font("Arial",Font.BOLD,16));
        lblids.setForeground(new Color(0,0,0));
        pn.add(lblids);

        comboids = new JComboBox();
        comboids.setBounds (280, 140, 200, 30);
        comboids.setFont(new Font("Arial", Font.PLAIN, 14));
        pn.add(comboids);

        // tarif
        JLabel lblt = new JLabel("Tarif film");
        lblt.setBounds(120,180,80,30);
        lblt.setFont(new Font("Arial",Font.BOLD,16));
        lblt.setForeground(new Color(0,0,0));
        pn.add(lblt);

        txtt = new JTextField();
        txtt.setBounds (280, 180, 200, 30);
        txtt.setFont(new Font("Arial", Font.PLAIN, 14));
        pn.add(txtt);

        JButton btn = new JButton("Valider");
        btn.setBounds(280, 220, 80, 30);

        btn.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent ev){
                String numcren, numfilm, numsalle,tarif;

                numcren = comboidc.getSelectedItem().toString();
                numfilm = comboidf.getSelectedItem().toString();
                numsalle = comboids.getSelectedItem().toString();
                tarif = txtt.getText();


                String rq = "insert into projeter(idcr,idf,ids,tarif) values (?,?,?,?)";
                try {
                    PreparedStatement ps = con.prepareStatement(rq);
                    ps.setString(1, numcren);
                    ps.setString(2, numfilm);
                    ps.setString(3, numsalle);
                    ps.setString(4, tarif);
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Programme enregistré !", null, JOptionPane.INFORMATION_MESSAGE);
                    con.close();
                }catch(SQLException ex){
                    JOptionPane.showMessageDialog(null, "Erreur !" + ex.getMessage(), null, JOptionPane.ERROR_MESSAGE);
                }
                dispose();

            }
        });
        pn.add(btn);

        JButton btnr = new JButton("Retour");
        btnr.setBounds(400, 220, 80, 30);
        btnr.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                MenuProgramme lien = new MenuProgramme();
                lien.setVisible(true);
                dispose();
            }
        });
        pn.add(btnr);

        //Listes des programmes
        DefaultTableModel model = new DefaultTableModel();
        init();
        pn.add(scroll1);
        model.addColumn("Id creneau");
        model.addColumn("Id film");
        model.addColumn("Id salle");
        model.addColumn("Tarif");

        table1.setModel(model);
        String sql = "select * from projeter";
        try {
            pst = con.createStatement();
            rs = pst.executeQuery(sql);
            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getString("numcren"),
                        rs.getString("numfilm"),
                        rs.getString("numsalle"),
                        rs.getString("tarif"),
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
        txtt.setText(model.getValueAt(selectionner, 1).toString());

    }
}
