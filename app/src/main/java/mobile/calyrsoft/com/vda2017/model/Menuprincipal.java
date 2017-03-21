package mobile.calyrsoft.com.vda2017.model;

/**
 * <p> The Menuprincipal class </p>
 * <p> Nuevatel PCS de Bolivia S.A. (c) 2017. </p>
 * @author Roberto Carlos Callisaya Mamani
 * @version 1.0
 */
public class Menuprincipal {
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getImagenId() {
        return imagenId;
    }

    public void setImagenId(int imagenId) {
        this.imagenId = imagenId;
    }

    private String titulo;
    private int imagenId;

    public Menuprincipal(String titulo, int imagenId) {
        this.titulo = titulo;
        this.imagenId = imagenId;
    }}
