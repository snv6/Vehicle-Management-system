package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class RemoveVehicle extends JFrame implements ActionListener {

    Choice cEmpId;
    JButton delete, back;

    RemoveVehicle() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel labelvehicleId = new JLabel("Vehicle Reg No");
        labelvehicleId.setBounds(50, 50, 100, 30);
        add(labelvehicleId);

        cEmpId = new Choice();
        cEmpId.setBounds(200, 50, 150, 30);
        add(cEmpId);

        try {
            Conn c = new Conn();
            String query = "select * from vehicle";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                cEmpId.add(rs.getString("vregno"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Conn c = new Conn();
            String query = "select * from vehicle where vregno = '"+cEmpId.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);

        } catch (Exception e) {
            e.printStackTrace();
        }

        cEmpId.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c = new Conn();
                    String query = "select * from vehicle where vregno = '"+cEmpId.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        delete = new JButton("Delete");
        delete.setBounds(80, 200, 100,30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);

        back = new JButton("Back");
        back.setBounds(220, 200, 100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setSize(600, 500);
        setLocation(300, 150);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == delete) {
            try {
                Conn c = new Conn();
                String query = "delete from vehicle where vregno = '"+cEmpId.getSelectedItem()+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Vehicle Information Deleted Sucessfully");
                setVisible(false);
                new Home();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new RemoveVehicle();
    }
}