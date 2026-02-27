package tienda.dto;

import java.time.*; 

public class VentaDTO {

    private LocalDateTime fecha;
    private double total;
    private String nombreCliente;

    public VentaDTO(){

    }

    public VentaDTO(LocalDateTime fecha, double total, String nombreCliente){
        this.fecha=fecha;
        this.total=total;
        this.nombreCliente=nombreCliente;
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
    public String getNombreCliente(){
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente){
        this.nombreCliente=nombreCliente;
    }

    
    
}
