/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aularesources;

import aulaserver.ConexionSQLite;

/**
 *
 * @author The Worst One
 */
public class Componente implements Comparable <Componente>{
    private final String id;
    private String nombre;
    private TipoComponente tipoComponente;
    private EstadoComponente[][] estadoHorario;
    private String[][] Asignaturas;

    public Componente(String nombre, String id, TipoComponente tipoComponente) {
        this.nombre = nombre;
        this.id = id;
        this.tipoComponente = tipoComponente;
        this.Asignaturas = new String [7][5];
        this.estadoHorario = new EstadoComponente [7][5];
        for (int i=0; i < 7;i++)
            for (int j=0; j<5;j++)
                estadoHorario[i][j]=EstadoComponente.LIBRE;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the tipoComponente
     */
    public TipoComponente getTipoComponente() {
        return tipoComponente;
    }

    /**
     * @param tipoComponente the tipoComponente to set
     */
    public void setTipoComponente(TipoComponente tipoComponente) {
        this.tipoComponente = tipoComponente;
    }

    /**
     * @return the estadoHorario
     */
    public EstadoComponente[][] getEstadoHorario() {
        return estadoHorario;
    }

    /**
     * @param estadoHorario the estadoHorario to set
     */
    public void setEstadoHorario(EstadoComponente[][] estadoHorario) {
        this.estadoHorario = estadoHorario;
    }

    /**
     * @return the Asignaturas
     */
    public String[][] getAsignaturas() {
        return Asignaturas;
    }

    /**
     * @param Asignaturas the Asignaturas to set
     */
    public void setAsignaturas(String[][] Asignaturas) {
        this.Asignaturas = Asignaturas;
    }

    @Override
    public int compareTo(Componente o) {
        return this.id.compareTo(o.getId());
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    
    public void save()
    {
        ConexionSQLite conexion = new ConexionSQLite();
        conexion.connect();
        conexion.saveComponente(this);
        conexion.saveEstadoHorario(this);
        conexion.saveAsignatura(this);
        conexion.close();
    }
    
    
    
    
}
