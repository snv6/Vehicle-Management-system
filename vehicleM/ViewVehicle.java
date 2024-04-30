package org.example;

import net.proteanit.sql.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewVehicle extends JFrame implements ActionListener {

    JTable table;
    Choice cvehicleId;
    JButton search, update, back;
    ViewVehicle(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel searchlbl = new JLabel("Search by Vehicle Reg no");
        searchlbl.setBounds(20, 20, 150, 20);
        add(searchlbl);

        cvehicleId = new Choice();
        cvehicleId.setBounds(180, 20, 150, 20);
        add(cvehicleId);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from vehicle");
            while(rs.next()) {
                cvehicleId.add(rs.getString("vregno"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        table = new JTable();

        /*try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from vehicle");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 900, 600);
        add(jsp);

        search = new JButton("Search");
        search.setBounds(120, 70, 80, 20);
        search.addActionListener(this);
        add(search);

        update = new JButton("Update");
        update.setBounds(220,70,80,20);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBounds(320, 70, 80, 20);
        back.addActionListener(this);
        add(back);

        setSize(900,700);
        setLocation(300,100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search) {
            String query = "select * from vehicle where vregno = '"+ cvehicleId.getSelectedItem()+"'";
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == update) {
            setVisible(false);
            new UpdateVehicle(cvehicleId.getSelectedItem());
        } else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[]args){
        new ViewVehicle();
    }
}