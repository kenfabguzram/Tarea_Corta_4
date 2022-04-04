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
//actionPerformed
    @Override
    public void actionPerformed(ActionEvent e){
    //--------------------------------------------------------------------------------------------------------------
    //ActionPerformed para el boton1
        if(e.getSource().equals(boton1)){
            try{
                if (clicks!=0){
                    throw new IOException();
                }
                else{
                    clicks++;
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
    //ActionPerformed para el boton2
        if(e.getSource().equals(boton2)){
            try{
                if (clicks!=1){
                    throw new IOException();
                }
                else{
                    clicks++;
                }
            }
            catch(IOException ex){
                clicks=0;
                JDialog dialogo=new JDialog(ventana,"Orden incorrecto");
                dialogo.setSize(new Dimension(430,100));
                dialogo.setLocation(500,200);
                dialogo.add(new JLabel("Los botones no fueron presionados en el orden correcto, debe reintentar"));
                dialogo.setVisible(true);
                
            }
        }
    //--------------------------------------------------------------------------------------------------------------
    //ActionPerformed para el boton3
        if(e.getSource().equals(boton3)){
            try{
                if (clicks!=2){
                    throw new IOException();
                }
                else{
                    clicks=0;
                }
            }
            catch(IOException ex){
                clicks=0;
                JDialog dialogo=new JDialog(ventana,"Orden incorrecto");
                dialogo.setSize(new Dimension(430,100));
                dialogo.setLocation(500,200);
                dialogo.add(new JLabel("Los botones no fueron presionados en el orden correcto, debe reintentar"),BorderLayout.CENTER);
                dialogo.setVisible(true);
            }
        }
    //--------------------------------------------------------------------------------------------------------------
    //fin del ActionPerformed
    }
//--------------------------------------------------------------------------------------------------------------
//fin del programa
}
