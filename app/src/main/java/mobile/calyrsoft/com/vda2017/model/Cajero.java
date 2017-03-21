package mobile.calyrsoft.com.vda2017.model;

/**
 * <p> The Cajero class </p>
 * <p> Nuevatel PCS de Bolivia S.A. (c) 2017. </p>
 * @author Roberto Carlos Callisaya Mamani
 * @version 1.0
 */
public class Cajero {
    private double latitud;
    private double longitud;
    private String title;
    private String description;

    public Cajero(double latitud, double longitud, String title, String description) {
        this.latitud = latitud;
        this.longitud = longitud;
        this.title = title;
        this.description = description;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
