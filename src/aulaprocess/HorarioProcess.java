/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aulaprocess;


import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import aularesources.EstadoComponente;
import java.awt.Color;
import javax.swing.JButton;

/**
 *
 * @author The Worst One
 */
public class HorarioProcess {
    
    
    public static void addAsignatura(int row, int column, boolean op, String[][] Asignaturas)
    {
        String asignatura;
        if (op)
        {
            asignatura = (String) JOptionPane.showInputDialog(null,"Ingrese la Asignatura: ");
            if (asignatura==null)
                Asignaturas[row][column] = "Indefinido";
            else
                Asignaturas[row][column] = asignatura; 
        }
        else
            Asignaturas[row][column] = null;
    }
    
    public static void showAsignatura (String asignatura, JTextField jTextField)
    {
        jTextField.setText(asignatura);
    }
    
    public static void showEstado (EstadoComponente estado, JComboBox jComboBox)
    {
        if (estado==EstadoComponente.LIBRE)
            jComboBox.setSelectedIndex(0);
        else
            jComboBox.setSelectedIndex(1);
    }
    
    public static void safeHorario (int row, int column,EstadoComponente[][] estadoHorario ,
            String [][] Asignaturas ,JTextField jTextField, JComboBox jComboBox, JButton jButton)
    {
        
        if (jComboBox.getSelectedIndex()==0)
        {
            estadoHorario[row][column] = EstadoComponente.LIBRE;
            Asignaturas[row][column] = null;
            jTextField.setText(null);
            jButton.setBackground(new Color(153, 255, 153));
        }
        else
        {
            estadoHorario[row][column] = EstadoComponente.OCUPADO;
            jButton.setBackground(new Color(255, 51, 51));
            Asignaturas[row][column] = jTextField.getText();
        }
        
    }
    
    public static void initHorario (EstadoComponente[][] estadoHorario, JButton [][] botones)
    {
        for (int i=0; i<7;i++)
            for (int j=0; j<5; j++)
            {
                if (estadoHorario[i][j]==EstadoComponente.OCUPADO)
                    botones[i][j].setBackground(new Color(255, 51, 51));
                else
                    botones[i][j].setBackground(new Color(153, 255, 153));
            }
    }
    
    public static void setDefault (EstadoComponente[][] estadoHorario, String [][] Asignaturas, JButton [][] botones)
    {
        for (int i=0; i < 7; i++)
            for (int j=0; j < 5; j++)
            {
                estadoHorario[i][j] = EstadoComponente.LIBRE;
                Asignaturas[i][j] = null;
                botones[i][j].setBackground(new Color(153, 255, 153));
            }
    }
    
}
