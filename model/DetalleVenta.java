package tienda.model;

public class DetalleVenta {
    
    private int id, ventaId, productoId, cantidad;
    private double precioUnitario;

    public DetalleVenta(){

    }
    public DetalleVenta(int id, int ventaId, int productoId, int cantidad, double precioUnitario){

        this.id=id;
        this.ventaId=ventaId;
        this.productoId=productoId;
        this.cantidad=cantidad;
        this.precioUnitario=precioUnitario;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getVentaId() {
        return ventaId;
    }
    public void setVentaId(int ventaId) {
        this.ventaId = ventaId;
    }
    public int getProductoId() {
        return productoId;
    }
    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public double getPrecioUnitario() {
        return precioUnitario;
    }
    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
    

}
