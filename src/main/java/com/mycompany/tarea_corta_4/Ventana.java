/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tarea_corta_4;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

/**
 *
 * @author Kendall_Guzmán
 */
public class Ventana implements ActionListener{
//Se inicializan los atributos de la clase principal
    JFrame ventana;
    JButton boton1;
    JButton boton2;
    JButton boton3;
    int clicks;
//--------------------------------------------------------------------------------------------------------------
//Se crea el constructor de la clase principal Ventana

    public Ventana(){
        clicks=0;
        ventana=new JFrame("Tarea Corta 4");
        ventana.setLocation(400,400);
        ventana.setLayout(new BorderLayout());
        
        boton1=new JButton("Boton 1");
        ventana.add(boton1,BorderLayout.WEST);
        
        boton2=new JButton("Boton 2");
        ventana.add(boton2,BorderLayout.CENTER);
        
        boton3=new JButton("Boton 3");
        ventana.add(boton3,BorderLayout.EAST);
        
        agregarListeners();  
        ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ventana.setPreferredSize(new Dimension(300,100));
        ventana.pack();
    }
//--------------------------------------------------------------------------------------------------------------
//Clase para agregar los listener a los botones
    public void agregarListeners(){
        boton1.addActionListener(this);
        boton2.addActionListener(this);
        boton3.addActionListener(this);
    }
//--------------------------------------------------------------------------------------------------------------
//Clase para validar la cantidad de clicks y mandar un mensaje en caso de que los botones no se presionen en el
//orden correcto
    public void validarClicks(int clicksValidos){
        try{
            if (clicks!=clicksValidos){
                throw new IOException();
            }
            else{
                clicks=(clicks+1)%3;
            }
        }
        catch(IOException ex){
            clicks=0;
            JDialog dialogo=new JDialog(ventana,"Orden incorrecto");
            dialogo.setSize(new Dimension(430,100));
            dialogo.setLocation(500,200);
            dialogo.add(new JLabel("Los botones no fueron presionados en el orden correcto, debe reintentar"), BorderLayout.CENTER);
            dialogo.setVisible(true);

        }
    }
//--------------------------------------------------------------------------------------------------------------
//actionPerformed
    @Override
    public void actionPerformed(ActionEvent e){
    //--------------------------------------------------------------------------------------------------------------
    //ActionPerformed para el boton1
        if(e.getSource().equals(boton1)){
            validarClicks(0);
        }
    //--------------------------------------------------------------------------------------------------------------
    //ActionPerformed para el boton2
        if(e.getSource().equals(boton2)){
            validarClicks(1);
        }
    //--------------------------------------------------------------------------------------------------------------
    //ActionPerformed para el boton3
        if(e.getSource().equals(boton3)){
            validarClicks(2);
        }
    //--------------------------------------------------------------------------------------------------------------
    //fin del ActionPerformed
    }
//--------------------------------------------------------------------------------------------------------------
//fin del programa
}
