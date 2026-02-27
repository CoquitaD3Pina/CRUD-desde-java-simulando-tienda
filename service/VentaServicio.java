package tienda.service;

import tienda.repository.*;
import tienda.model.*;
import java.util.List;

public class VentaServicio {

    private VentaRepositorio repositorio = new VentaRepositorio();

    public void agregar(Venta venta) {
        repositorio.agregar(venta);
    }   
    public List<Venta> listar() {
        return repositorio.listar();
    }
    public void eliminar(int id) {
        repositorio.eliminar(id);
    }
    public void actualizar(Venta venta) {
        repositorio.actualizar(venta);
    }
    
}
