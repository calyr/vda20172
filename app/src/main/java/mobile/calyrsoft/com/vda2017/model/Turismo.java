package mobile.calyrsoft.com.vda2017.model;

/**
 * <p> The Turismo class </p>
 * <p> Nuevatel PCS de Bolivia S.A. (c) 2017. </p>
 * @author Roberto Carlos Callisaya Mamani
 * @version 1.0
 */
public class Turismo {
    private String titulo;

    private String descripcion;

    public Turismo(String titulo, String descripcion, String comollegar, String quellevar, int imagenId) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.comollegar = comollegar;
        this.quellevar = quellevar;
        this.imagenId = imagenId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getComollegar() {
        return comollegar;
    }

    public void setComollegar(String comollegar) {
        this.comollegar = comollegar;
    }

    public String getQuellevar() {
        return quellevar;
    }

    public void setQuellevar(String quellevar) {
        this.quellevar = quellevar;
    }

    private String comollegar;
    private String quellevar;
    private int imagenId;

    public int getImagenId() {
        return imagenId;
    }

    public void setImagenId(int imagenId) {
        this.imagenId = imagenId;
    }
}

