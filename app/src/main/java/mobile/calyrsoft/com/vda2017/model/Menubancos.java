package mobile.calyrsoft.com.vda2017.model;

/**
 * <p> The Menubancos class </p>
 * <p> Nuevatel PCS de Bolivia S.A. (c) 2017. </p>
 * @author Roberto Carlos Callisaya Mamani
 * @version 1.0
 */
public class Menubancos {
    public Menubancos(int imagenId) {
        this.imagenId = imagenId;
    }

    public int getImagenId() {
        return imagenId;
    }

    public void setImagenId(int imagenId) {
        this.imagenId = imagenId;
    }

    private int imagenId;
}

