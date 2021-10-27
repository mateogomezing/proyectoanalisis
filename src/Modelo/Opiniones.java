package Modelo;

/**
 *
 * @author Sara Lucía
 */
public class Opiniones {
    private int id;
    private int idHuesped;
    private int idHospedaje;
    private String calificacion;
    private String descripcion;

    public Opiniones() {
        this.id = 0;
        this.idHuesped = 0;
        this.idHospedaje = 0;
        this.calificacion = null;
        this.descripcion = null;
    }

    public Opiniones(int id, int idHuesped, int idHospedaje, String calificacion, String descripcion) {
        this.id = id;
        this.idHuesped = idHuesped;
        this.idHospedaje = idHospedaje;
        this.calificacion = calificacion;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdHuesped() {
        return idHuesped;
    }

    public void setIdHuesped(int idHuesped) {
        this.idHuesped = idHuesped;
    }

    public int getIdHospedaje() {
        return idHospedaje;
    }

    public void setIdHospedaje(int idHospedaje) {
        this.idHospedaje = idHospedaje;
    }

    public String getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
