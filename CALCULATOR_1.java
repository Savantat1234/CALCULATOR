/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.calculator_1;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author savan
 */
public class CALCULATOR_1 implements ActionListener  {
    
    JFrame frame;
    JTextField textField;
    JButton [] numberButton = new JButton[10];    // 10 digits require 10 butttons
    JButton [] functionButton = new JButton[9];
    JButton addButton, subButton, mulButton, divButton;    //function button
    JButton decimalButton, delButton, clrButton, equalButton, negButton;    //function button
    JPanel panel;
    Font myFont = new Font("Arial", Font.BOLD, 35);
    
    double operand_1 = 0;
    double operand_2 = 0;
    double result = 0;
    char operator;
    
    CALCULATOR_1(){
    frame = new JFrame("Calculator");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     //frame is our..bt..exit_on_close operation is of JFrame class only
    frame.setSize(400,550);
    frame.setLayout(null);
    
    textField = new JTextField();
    textField.setBounds(50, 25, 300, 50);    //resizes... x->> new  coordinate of this component
    // similarly y... from top-left corner only
    //width & height -->> new size of this component..
    textField.setFont(myFont);   //as it already created..
    textField.setEditable(false);    // textField cant b resized..
    
    addButton = new JButton("+");       
    subButton = new JButton("-");
    mulButton = new JButton("*");
    divButton = new JButton("/");
    delButton = new JButton("del");   //initialized all 9 function buttons..
    clrButton = new JButton("clr");
    decimalButton = new JButton(".");
    negButton = new JButton("(-)");
    equalButton = new JButton("=");
    
    functionButton[0] = addButton;
    functionButton[1] = subButton;
    functionButton[2] = mulButton;
    functionButton[3] = divButton;
    functionButton[4] = decimalButton;    //values are putted in functionButton array
    functionButton[5] = equalButton;
    functionButton[6] = delButton;
    functionButton[7] = clrButton;
    functionButton[8] = negButton;
    
    for(int i=0; i<9; i++){
        functionButton[i].addActionListener(this);
        functionButton[i].setFont(myFont);
        functionButton[i].setFocusable(false);
    }
    for(int i=0; i<10; i++){
        numberButton[i] = new JButton(String.valueOf(i));   //same values of i are given to each numberButton from 0 to 9..
        numberButton[i].addActionListener(this);
        numberButton[i].setFont(myFont);
        numberButton[i].setFocusable(false);
    }
    
    //every button has some default size ..bt these three buttons hv their different size that we r creating..
    negButton.setBounds(50, 430,100 ,50 );    
    
    delButton.setBounds(150, 430,100 ,50 );   
    clrButton.setBounds(250, 430, 100, 50);
    
    panel = new JPanel();
    
    panel.setBounds(50, 100, 300,300);   // x & y are the top left corner , and from that the height & width takes place..
    panel.setLayout(new GridLayout(4,4,10,10));
    // setLayout(new GridLayout) -->  create a grid(ie. matrix type)  layout with specified no of rows & columns..
    //with all components given equal size..
    //in addition the horizontal & vertical gaps are set to the specified values..
    
        panel.add(numberButton[7]);
        panel.add(numberButton[8]);
        panel.add(numberButton[9]);
        panel.add(addButton);
        panel.add(numberButton[4]);
        panel.add(numberButton[5]);     
        panel.add(numberButton[6]);
        panel.add(subButton);
        panel.add(numberButton[1]);
        panel.add(numberButton[2]);
        panel.add(numberButton[3]);
        panel.add(mulButton);
        panel.add(decimalButton);
        panel.add(numberButton[0]);
        panel.add(equalButton);       
        panel.add(divButton);  //added all button on panel ... except below three
        
        
        frame.add(panel);      // panel is added on the frame
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);  //these three buttons are directly added on the fame
        frame.add(textField);   // textfield also added on the frame
        frame.setVisible(true);    //to make sure perticular thing is visible on the screen..without this nothing will b visible
        
        
    }
   
    
    
    public static void main(String[] args) {
        CALCULATOR_1 Calculator1 = new CALCULATOR_1(); 
    }
    @Override
    public void actionPerformed(ActionEvent e){
     for(int i = 0; i<10; i++){
     
         if(e.getSource() == numberButton[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
     }
 }
     if(e.getSource() == decimalButton){ // getSource is used inb action performed to know which button is clicked..
                textField.setText(textField.getText().concat("."));
            }
         
         if(e.getSource() == addButton){
               operand_1 = Double.parseDouble(textField.getText());
               operator = '+';
               textField.setText(""); // ater first operand is entered , we made textfield empty...
            }
         
         if(e.getSource() == subButton){
                operand_1 = Double.parseDouble(textField.getText());
               operator = '-';
               textField.setText("");
            }
         if(e.getSource() == mulButton){
               operand_1 = Double.parseDouble(textField.getText());
               operator = '*';
               textField.setText("");
            }
         if(e.getSource() == divButton){
               operand_1 = Double.parseDouble(textField.getText());
               operator = '/';
               textField.setText("");
            }
         if(e.getSource() == equalButton){
               operand_2 = Double.parseDouble(textField.getText());
               
               switch(operator){
                   case '+':
                       result = operand_1 + operand_2 ;
                       break ;
                       
                         case '-':
                       result = operand_1 - operand_2 ;
                       break ;
                       
                         case '*':
                       result = operand_1 * operand_2 ;
                       break ;
                       
                         case '/':
                       result = operand_1 / operand_2 ;
                       break ;
                       
               }
               textField.setText(String.valueOf(result));
               operand_1 = result ;     // reference for thr further calculations.
            }
         if(e.getSource() == clrButton){
             textField.setText("");   // will clear all the textfield data..
         }
         if(e.getSource() == delButton){     //  if clicked buttton is delete button
             String temp = textField.getText();   // take the whole string whatever on the textfield in temp variable..
             textField.setText("");   // and remove the textfield data ..& make it empty
             for(int i=0; i<temp.length()-1; i++){    // if 456
                                                      //i=0;i<2;i++              
                textField.setText(textField.getText() + temp.charAt(i));   // it takes charAt(i) only till i<2
                                                                                // in this way last char is removed
             }
            
         }
          if(e.getSource() == negButton){
             double temp = Double.parseDouble(textField.getText());    // Double.parseDouble : this is for for mul operation string to double conversion
             temp *= -1 ;                                               // multiply with -1;
             textField.setText(String.valueOf(temp));
          }
    }
 
     

}
