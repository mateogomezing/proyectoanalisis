/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author mateo
 */
public class CuentaPersonal {

    private int id;
    private int idHuesped;
    private int idReservaHospedaje;
    private String tarjetacredito;
    private String estado;
    private String valorApagar;

    public CuentaPersonal() {
        this.id = 0;
        this.idHuesped = 0;
        this.idReservaHospedaje = 0;
        this.estado = null;
        this.valorApagar = null;
    }

    public CuentaPersonal(int id, int idHuesped, int idReservaHospedaje, String tarjetacredito, String estado, String valorApagar) {
        this.id = id;
        this.idHuesped = idHuesped;
        this.idReservaHospedaje = idReservaHospedaje;
        this.tarjetacredito = tarjetacredito;
        this.estado = estado;
        this.valorApagar = valorApagar;
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

    public int getIdReservaHospedaje() {
        return idReservaHospedaje;
    }

    public void setIdReservaHospedaje(int idReservaHospedaje) {
        this.idReservaHospedaje = idReservaHospedaje;
    }

    public String getTarjetacredito() {
        return tarjetacredito;
    }

    public void setTarjetacredito(String tarjetacredito) {
        this.tarjetacredito = tarjetacredito;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getValorApagar() {
        return valorApagar;
    }

    public void setValorApagar(String valorApagar) {
        this.valorApagar = valorApagar;
    }

}
