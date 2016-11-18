/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aulaserver;

import aularesources.Componente;
import aularesources.EstadoComponente;
import aularesources.TipoComponente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author The Worst One
 */
public class ConexionSQLite {
    
     String url = "C:\\Users\\Toshiba\\Desktop\\AULA.db";
    Connection connect;
    
    public void connect(){
    try {
        connect = DriverManager.getConnection("jdbc:sqlite:"+url);
        if (connect!=null) {
            System.out.println("Conectado");
        }
    }catch (SQLException ex) {
        System.err.println("No se ha podido conectar a la base de datos\n"+ex.getMessage());
    }
   }
    public void close(){
           try {
               connect.close();
           } catch (SQLException ex) {
               Logger.getLogger(ConexionSQLite.class.getName()).log(Level.SEVERE, null, ex);
           }
    }
    
    public void saveComponente(Componente componente){
        try {
            PreparedStatement st = connect.prepareStatement("insert into Componentes (id, nombre, tipoComponente) values (?,?,?)");
            st.setString(1, componente.getId());
            st.setString(2, componente.getNombre());
            st.setBoolean(3, (componente.getTipoComponente()==TipoComponente.AULA));
            st.execute();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public void saveEstadoHorario(Componente componente){
        try {
            PreparedStatement st = connect.prepareStatement("insert into estadoHorario (a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, aa, bb, cc, dd, ee, ff, gg, hh, ii) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            //PreparedStatement st = connect.prepareStatement("insert into estadoHorario (a,b) values (?,?)");
            EstadoComponente [][] estadoHorario = componente.getEstadoHorario();
            st.setBoolean(1, estadoHorario[0][0]==EstadoComponente.LIBRE);
            st.setBoolean(2, estadoHorario[0][1]==EstadoComponente.LIBRE);
            st.setBoolean(3, estadoHorario[0][2]==EstadoComponente.LIBRE);
            st.setBoolean(4, estadoHorario[0][3]==EstadoComponente.LIBRE);
            st.setBoolean(5, estadoHorario[0][4]==EstadoComponente.LIBRE); //
            st.setBoolean(6, estadoHorario[1][0]==EstadoComponente.LIBRE);
            st.setBoolean(7, estadoHorario[1][1]==EstadoComponente.LIBRE);
            st.setBoolean(8, estadoHorario[1][2]==EstadoComponente.LIBRE);
            st.setBoolean(9, estadoHorario[1][3]==EstadoComponente.LIBRE);
            st.setBoolean(10, estadoHorario[1][4]==EstadoComponente.LIBRE); //
            st.setBoolean(11, estadoHorario[2][0]==EstadoComponente.LIBRE);
            st.setBoolean(12, estadoHorario[2][1]==EstadoComponente.LIBRE);
            st.setBoolean(13, estadoHorario[2][2]==EstadoComponente.LIBRE);
            st.setBoolean(14, estadoHorario[2][3]==EstadoComponente.LIBRE);
            st.setBoolean(15, estadoHorario[2][4]==EstadoComponente.LIBRE); //
            st.setBoolean(16, estadoHorario[3][0]==EstadoComponente.LIBRE);
            st.setBoolean(17, estadoHorario[3][1]==EstadoComponente.LIBRE);
            st.setBoolean(18, estadoHorario[3][2]==EstadoComponente.LIBRE);
            st.setBoolean(19, estadoHorario[3][3]==EstadoComponente.LIBRE);
            st.setBoolean(20, estadoHorario[3][4]==EstadoComponente.LIBRE); //
            st.setBoolean(21, estadoHorario[4][0]==EstadoComponente.LIBRE);
            st.setBoolean(22, estadoHorario[4][1]==EstadoComponente.LIBRE);
            st.setBoolean(23, estadoHorario[4][2]==EstadoComponente.LIBRE);
            st.setBoolean(24, estadoHorario[4][3]==EstadoComponente.LIBRE);
            st.setBoolean(25, estadoHorario[4][4]==EstadoComponente.LIBRE); //
            st.setBoolean(26, estadoHorario[5][0]==EstadoComponente.LIBRE);
            st.setBoolean(27, estadoHorario[5][1]==EstadoComponente.LIBRE);
            st.setBoolean(28, estadoHorario[5][2]==EstadoComponente.LIBRE);
            st.setBoolean(29, estadoHorario[5][3]==EstadoComponente.LIBRE);
            st.setBoolean(30, estadoHorario[5][4]==EstadoComponente.LIBRE); //
            st.setBoolean(31, estadoHorario[6][0]==EstadoComponente.LIBRE);
            st.setBoolean(32, estadoHorario[6][1]==EstadoComponente.LIBRE);
            st.setBoolean(33, estadoHorario[6][2]==EstadoComponente.LIBRE);
            st.setBoolean(34, estadoHorario[6][3]==EstadoComponente.LIBRE);
            st.setBoolean(35, estadoHorario[6][4]==EstadoComponente.LIBRE); // 
            st.execute(); 
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public void saveAsignatura(Componente componente){
        try {
            PreparedStatement st = connect.prepareStatement("insert into Asignaturas (a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, aa, bb, cc, dd, ee, ff, gg, hh, ii) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            
            String [][] Asignaturas = componente.getAsignaturas();
            
            st.setString(1, Asignaturas[0][0]);
            st.setString(2, Asignaturas[0][1]);
            st.setString(3, Asignaturas[0][2]);
            st.setString(4, Asignaturas[0][3]);
            st.setString(5, Asignaturas[0][4]); //
            st.setString(6, Asignaturas[1][0]);
            st.setString(7, Asignaturas[1][1]);
            st.setString(8, Asignaturas[1][2]);
            st.setString(9, Asignaturas[1][3]);
            st.setString(10, Asignaturas[1][4]); //
            st.setString(11, Asignaturas[2][0]);
            st.setString(12, Asignaturas[2][1]);
            st.setString(13, Asignaturas[2][2]);
            st.setString(14, Asignaturas[2][3]);
            st.setString(15, Asignaturas[2][4]); //
            st.setString(16, Asignaturas[3][0]);
            st.setString(17, Asignaturas[3][1]);
            st.setString(18, Asignaturas[3][2]);
            st.setString(19, Asignaturas[3][3]);
            st.setString(20, Asignaturas[3][4]); //
            st.setString(21, Asignaturas[4][0]);
            st.setString(22, Asignaturas[4][1]);
            st.setString(23, Asignaturas[4][2]);
            st.setString(24, Asignaturas[4][3]);
            st.setString(25, Asignaturas[4][4]); //
            st.setString(26, Asignaturas[5][0]);
            st.setString(27, Asignaturas[5][1]);
            st.setString(28, Asignaturas[5][2]);
            st.setString(29, Asignaturas[5][3]);
            st.setString(30, Asignaturas[5][4]); //
            st.setString(31, Asignaturas[6][0]);
            st.setString(32, Asignaturas[6][1]);
            st.setString(33, Asignaturas[6][2]);
            st.setString(34, Asignaturas[6][3]);
            st.setString(35, Asignaturas[6][4]); //
            st.execute();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public void deleteComponente(Componente componente)
    {
        try {
            PreparedStatement st = connect.prepareStatement("delete from Componentes WHERE id = "+componente.getId());
            st.execute();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public void deleteAll()
    {
        try {
            PreparedStatement st = connect.prepareStatement("delete from Componentes");
            st.execute();
            st = connect.prepareStatement("delete from estadoHorario");
            st.execute();
            st = connect.prepareStatement("delete from Asignaturas");
            st.execute();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
        
    public void loadComponente (ArrayList<Componente> todosComponentes){
        ResultSet basic = null;
        ResultSet horarios = null;
        ResultSet asignaturas = null;
        
            try {
                PreparedStatement st = connect.prepareStatement("select * from Componentes");
                PreparedStatement st2 = connect.prepareStatement("Select * from estadoHorario");
                PreparedStatement st3 = connect.prepareStatement("Select * from Asignaturas");
                basic = st.executeQuery();
                horarios = st2.executeQuery();
                asignaturas = st3.executeQuery();
                while (basic.next() && horarios.next() && asignaturas.next()) {
                    Componente componente = new Componente(basic.getString("nombre"), 
                            basic.getString("id"), (basic.getBoolean("tipoComponente")==true)? TipoComponente.AULA : TipoComponente.LABORATORIO );
                    
                    EstadoComponente [][] estadoHorario = new EstadoComponente[7][5];
                    String [][] Asignaturas = new String[7][5];
                    
                    estadoHorario[0][0] = (horarios.getBoolean("a"))?EstadoComponente.LIBRE:EstadoComponente.OCUPADO;
                    estadoHorario[0][1] = (horarios.getBoolean("b"))?EstadoComponente.LIBRE:EstadoComponente.OCUPADO;
                    estadoHorario[0][2] = (horarios.getBoolean("c"))?EstadoComponente.LIBRE:EstadoComponente.OCUPADO;
                    estadoHorario[0][3] = (horarios.getBoolean("d"))?EstadoComponente.LIBRE:EstadoComponente.OCUPADO;
                    estadoHorario[0][4] = (horarios.getBoolean("e"))?EstadoComponente.LIBRE:EstadoComponente.OCUPADO;//
                    estadoHorario[1][0] = (horarios.getBoolean("f"))?EstadoComponente.LIBRE:EstadoComponente.OCUPADO;
                    estadoHorario[1][1] = (horarios.getBoolean("g"))?EstadoComponente.LIBRE:EstadoComponente.OCUPADO;
                    estadoHorario[1][2] = (horarios.getBoolean("h"))?EstadoComponente.LIBRE:EstadoComponente.OCUPADO;
                    estadoHorario[1][3] = (horarios.getBoolean("i"))?EstadoComponente.LIBRE:EstadoComponente.OCUPADO;
                    estadoHorario[1][4] = (horarios.getBoolean("j"))?EstadoComponente.LIBRE:EstadoComponente.OCUPADO;//
                    estadoHorario[2][0] = (horarios.getBoolean("k"))?EstadoComponente.LIBRE:EstadoComponente.OCUPADO;
                    estadoHorario[2][1] = (horarios.getBoolean("l"))?EstadoComponente.LIBRE:EstadoComponente.OCUPADO;
                    estadoHorario[2][2] = (horarios.getBoolean("m"))?EstadoComponente.LIBRE:EstadoComponente.OCUPADO;
                    estadoHorario[2][3] = (horarios.getBoolean("n"))?EstadoComponente.LIBRE:EstadoComponente.OCUPADO;
                    estadoHorario[2][4] = (horarios.getBoolean("o"))?EstadoComponente.LIBRE:EstadoComponente.OCUPADO;//
                    estadoHorario[3][0] = (horarios.getBoolean("p"))?EstadoComponente.LIBRE:EstadoComponente.OCUPADO;
                    estadoHorario[3][1] = (horarios.getBoolean("q"))?EstadoComponente.LIBRE:EstadoComponente.OCUPADO;
                    estadoHorario[3][2] = (horarios.getBoolean("r"))?EstadoComponente.LIBRE:EstadoComponente.OCUPADO;
                    estadoHorario[3][3] = (horarios.getBoolean("s"))?EstadoComponente.LIBRE:EstadoComponente.OCUPADO;
                    estadoHorario[3][4] = (horarios.getBoolean("t"))?EstadoComponente.LIBRE:EstadoComponente.OCUPADO;//
                    estadoHorario[4][0] = (horarios.getBoolean("u"))?EstadoComponente.LIBRE:EstadoComponente.OCUPADO;
                    estadoHorario[4][1] = (horarios.getBoolean("v"))?EstadoComponente.LIBRE:EstadoComponente.OCUPADO;
                    estadoHorario[4][2] = (horarios.getBoolean("w"))?EstadoComponente.LIBRE:EstadoComponente.OCUPADO;
                    estadoHorario[4][3] = (horarios.getBoolean("x"))?EstadoComponente.LIBRE:EstadoComponente.OCUPADO;
                    estadoHorario[4][4] = (horarios.getBoolean("y"))?EstadoComponente.LIBRE:EstadoComponente.OCUPADO;//
                    estadoHorario[5][0] = (horarios.getBoolean("z"))?EstadoComponente.LIBRE:EstadoComponente.OCUPADO;
                    estadoHorario[5][1] = (horarios.getBoolean("aa"))?EstadoComponente.LIBRE:EstadoComponente.OCUPADO;
                    estadoHorario[5][2] = (horarios.getBoolean("bb"))?EstadoComponente.LIBRE:EstadoComponente.OCUPADO;
                    estadoHorario[5][3] = (horarios.getBoolean("cc"))?EstadoComponente.LIBRE:EstadoComponente.OCUPADO;
                    estadoHorario[5][4] = (horarios.getBoolean("dd"))?EstadoComponente.LIBRE:EstadoComponente.OCUPADO;//
                    estadoHorario[6][0] = (horarios.getBoolean("ee"))?EstadoComponente.LIBRE:EstadoComponente.OCUPADO;
                    estadoHorario[6][1] = (horarios.getBoolean("ff"))?EstadoComponente.LIBRE:EstadoComponente.OCUPADO;
                    estadoHorario[6][2] = (horarios.getBoolean("gg"))?EstadoComponente.LIBRE:EstadoComponente.OCUPADO;
                    estadoHorario[6][3] = (horarios.getBoolean("hh"))?EstadoComponente.LIBRE:EstadoComponente.OCUPADO;
                    estadoHorario[6][4] = (horarios.getBoolean("ii"))?EstadoComponente.LIBRE:EstadoComponente.OCUPADO;//
                    
                    Asignaturas[0][0] = asignaturas.getString("a");
                    Asignaturas[0][1] = asignaturas.getString("b");
                    Asignaturas[0][2] = asignaturas.getString("c");
                    Asignaturas[0][3] = asignaturas.getString("d");
                    Asignaturas[0][4] = asignaturas.getString("e");
                    Asignaturas[1][0] = asignaturas.getString("f");
                    Asignaturas[1][1] = asignaturas.getString("g");
                    Asignaturas[1][2] = asignaturas.getString("h");
                    Asignaturas[1][3] = asignaturas.getString("i");
                    Asignaturas[1][4] = asignaturas.getString("j");
                    Asignaturas[2][0] = asignaturas.getString("k");
                    Asignaturas[2][1] = asignaturas.getString("l");
                    Asignaturas[2][2] = asignaturas.getString("m");
                    Asignaturas[2][3] = asignaturas.getString("n");
                    Asignaturas[2][4] = asignaturas.getString("o");
                    Asignaturas[3][0] = asignaturas.getString("p");
                    Asignaturas[3][1] = asignaturas.getString("q");
                    Asignaturas[3][2] = asignaturas.getString("r");
                    Asignaturas[3][3] = asignaturas.getString("s");
                    Asignaturas[3][4] = asignaturas.getString("t");
                    Asignaturas[4][0] = asignaturas.getString("u");
                    Asignaturas[4][1] = asignaturas.getString("v");
                    Asignaturas[4][2] = asignaturas.getString("w");
                    Asignaturas[4][3] = asignaturas.getString("x");
                    Asignaturas[4][4] = asignaturas.getString("y");
                    Asignaturas[5][0] = asignaturas.getString("z");
                    Asignaturas[5][1] = asignaturas.getString("aa");
                    Asignaturas[5][2] = asignaturas.getString("bb");
                    Asignaturas[5][3] = asignaturas.getString("cc");
                    Asignaturas[5][4] = asignaturas.getString("dd");
                    Asignaturas[6][0] = asignaturas.getString("ee");
                    Asignaturas[6][1] = asignaturas.getString("ff");
                    Asignaturas[6][2] = asignaturas.getString("gg");
                    Asignaturas[6][3] = asignaturas.getString("hh");
                    Asignaturas[6][4] = asignaturas.getString("ii");
                    
                    componente.setAsignaturas(Asignaturas);
                    componente.setEstadoHorario(estadoHorario);
                    
                    todosComponentes.add(componente);
                }
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }
    }
    
}
