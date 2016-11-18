/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aulaprocess;

import javax.swing.JLabel;
import javax.swing.JTextField;

import aularesources.Componente;
import aularesources.EstadoComponente;
import aularesources.TipoComponente;
import aulaview.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;

/**
 *
 * @author The Worst One
 */
public class ComponentProcess {
    
    public static void setId (Componente componente, JLabel jLabel)
    {
        jLabel.setText(componente.getId());
    }
    
    public static void setName (Componente componente, JTextField jTextField)
    {
        jTextField.setText(componente.getNombre());
    }
    
    public static void setTipoComponente (Componente componente, JComboBox jComboBox)
    {
        if (componente.getTipoComponente()==TipoComponente.AULA)
            jComboBox.setSelectedIndex(0);
        else
            jComboBox.setSelectedIndex(1);
    }
    
    public static void setEstadoHorario (Componente componente, EstadoComponente [][] estadoHorario)
    {
        estadoHorario = componente.getEstadoHorario();
    }
    
    public static void setAsignaturas (Componente componente, String [][] Asignaturas)
    {
        Asignaturas = componente.getAsignaturas();
    }
    
    public static String getIdComponente (int todosComponentes)
    {
        if (todosComponentes<10)
            return "0"+todosComponentes;
        else
            return String.valueOf(todosComponentes);
    }
    
    public static void createHorario (Componente componente, EstadoComponente[][] estadoHorario, String[][] Asignaturas)
    {
        componente.setEstadoHorario(estadoHorario);
        componente.setAsignaturas(Asignaturas);
    }
    
    public static void updateComponent (ArrayList<Componente> todosComponentes, Componente componente)
    {
        int index = todosComponentes.indexOf(componente);
        todosComponentes.set(index, componente);
    }
    
    public static void orderAulas (ArrayList<Componente> todosComponentes, DefaultListModel orderList)
    {
        for (Componente componente : todosComponentes)
            if (componente.getTipoComponente()==TipoComponente.AULA)
                orderList.addElement(componente);
    }
    
    public static void orderLabs (ArrayList<Componente> todosComponentes, DefaultListModel orderList)
    {
        for (Componente componente : todosComponentes)
            if (componente.getTipoComponente()==TipoComponente.LABORATORIO)
                orderList.addElement(componente);
    }
    
    public static void orderLibre (int hora, int day, ArrayList<Componente> orderComponentes, DefaultListModel orderList)
    {
        orderList.clear();
        EstadoComponente[][] estadoHorario;
        for (Componente componente: orderComponentes)
        {
            estadoHorario = componente.getEstadoHorario();
            if (estadoHorario[hora][day]==EstadoComponente.LIBRE)
                orderList.addElement(componente);
        }
    }
    
    public static void orderOcupado (int hora, int day, ArrayList<Componente> orderComponentes, DefaultListModel orderList)
    {
        orderList.clear();
        EstadoComponente[][] estadoHorario;
        for (Componente componente: orderComponentes)
        {
            estadoHorario = componente.getEstadoHorario();
            if (estadoHorario[hora][day]==EstadoComponente.OCUPADO)
                orderList.addElement(componente);
        }
    }
    
    
}
