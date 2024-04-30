package org.example;

import javax.swing.*;
import javax.swing.text.View;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame implements ActionListener {

    JButton add,view,update,remove;
    Home(){
        setLayout(null);

        JLabel heading = new JLabel("Vehicle Management System");
        heading.setBounds(165,100,500,70);
        heading.setFont((new Font("",Font.BOLD,25)));
        add(heading);

        add = new JButton("Register Vehicle");
        add.setBounds(155,170,150,40);
        add(add);
        add.addActionListener(this);

        view = new JButton("Vehicle Details");
        view.setBounds(360,170,150,40);
        add(view);
        view.addActionListener(this);

        update = new JButton("Update Vehicle detai");
        update.setBounds(155,230,150,40);
        add(update);
        update.addActionListener(this);

        remove = new JButton("Remove Vehicle");
        remove.setBounds(360,230,150,40);
        add(remove);
        remove.addActionListener(this);

        setSize(800,500);
        setLocation(250,100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == add){
            setVisible(false);
            new AddVehicle();
        } else if (ae.getSource() == view) {
            setVisible(false);
            new ViewVehicle();
        }else if (ae.getSource() == update){
            setVisible(false);
            new ViewVehicle();
        }else {
            setVisible(false);
            new RemoveVehicle();
        }
    }
    public static void main(String[]args){
        new Home();
    }
}