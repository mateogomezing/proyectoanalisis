
package Modelo;

import java.util.Date;

/**
 *
 * @author mateo
 */
public class ReservaHospedaje {

    private int id;
    private int idHuesped;
    private int idHabitacion;
    private Date fechaHoraReserva;
    private Date fechaHoraLlegada;
    private Date fechaHoraSalida;
    private Date fechaHoraCheckIn;
    private Date fechaHoraCheckOut;
    private String estado;
    private String estadoServicio;

    public ReservaHospedaje() {
        this.id = 0;
        this.idHuesped = 0;
        this.idHabitacion = 0;
        this.fechaHoraReserva = null;
        this.fechaHoraLlegada = null;
        this.fechaHoraSalida = null;
        this.fechaHoraCheckIn = null;
        this.fechaHoraCheckOut = null;
        this.estado = null;
        this.estadoServicio = null;
    }

    public ReservaHospedaje(int id, int idHuesped, int idHabitacion, Date fechaHoraReserva, Date fechaHoraLlegada, Date fechaHoraSalida, Date fechaHoraCheckIn, Date fechaHoraCheckOut, String estado, String estadoServicio) {
        this.id = id;
        this.idHuesped = idHuesped;
        this.idHabitacion = idHabitacion;
        this.fechaHoraReserva = fechaHoraReserva;
        this.fechaHoraLlegada = fechaHoraLlegada;
        this.fechaHoraSalida = fechaHoraSalida;
        this.fechaHoraCheckIn = fechaHoraCheckIn;
        this.fechaHoraCheckOut = fechaHoraCheckOut;
        this.estado = estado;
        this.estadoServicio = estadoServicio;
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

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public Date getFechaHoraReserva() {
        return fechaHoraReserva;
    }

    public void setFechaHoraReserva(Date fechaHoraReserva) {
        this.fechaHoraReserva = fechaHoraReserva;
    }

    public Date getFechaHoraLlegada() {
        return fechaHoraLlegada;
    }

    public void setFechaHoraLlegada(Date fechaHoraLlegada) {
        this.fechaHoraLlegada = fechaHoraLlegada;
    }

    public Date getFechaHoraSalida() {
        return fechaHoraSalida;
    }

    public void setFechaHoraSalida(Date fechaHoraSalida) {
        this.fechaHoraSalida = fechaHoraSalida;
    }

    public Date getFechaHoraCheckIn() {
        return fechaHoraCheckIn;
    }

    public void setFechaHoraCheckIn(Date fechaHoraCheckIn) {
        this.fechaHoraCheckIn = fechaHoraCheckIn;
    }

    public Date getFechaHoraCheckOut() {
        return fechaHoraCheckOut;
    }

    public void setFechaHoraCheckOut(Date fechaHoraCheckOut) {
        this.fechaHoraCheckOut = fechaHoraCheckOut;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstadoServicio() {
        return estadoServicio;
    }

    public void setEstadoServicio(String estadoServicio) {
        this.estadoServicio = estadoServicio;
    }

}
