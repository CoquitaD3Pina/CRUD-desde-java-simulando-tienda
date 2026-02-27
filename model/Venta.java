package tienda.model;

import java.time.LocalDateTime;

public class Venta {

    private int id, clienteId;
    private LocalDateTime fecha;
    private double total;

    public Venta(){

    }
    public Venta(int id, int clienteId, LocalDateTime fecha, double total){

        this.id=id;
        this.clienteId=clienteId;
        this.fecha=fecha;
        this.total=total;

    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getClienteId() {
        return clienteId;
    }
    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }
    public LocalDateTime getFecha() {
        return fecha;
    }
    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
    public double getTotal() {
        return total;
    }
    public void setTotal(double total) {
        this.total = total;
    }

    

}
