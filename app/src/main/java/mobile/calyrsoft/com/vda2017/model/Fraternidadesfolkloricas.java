package mobile.calyrsoft.com.vda2017.model;

/**
 * <p> The Fraternidadesfolkloricas class </p>
 * <p> Nuevatel PCS de Bolivia S.A. (c) 2017. </p>
 * @author Roberto Carlos Callisaya Mamani
 * @version 1.0
 */
public class Fraternidadesfolkloricas {
    private String categoria;

    public Fraternidadesfolkloricas(String categoria, String nombre, String horarioingreso, String descripcion) {
        this.categoria = categoria;
        this.nombre = nombre;
        this.horarioingreso = horarioingreso;
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHorarioingreso() {
        return horarioingreso;
    }

    public void setHorarioingreso(String horarioingreso) {
        this.horarioingreso = horarioingreso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    private String nombre;
    private String horarioingreso;
    private String descripcion;

}

