package tienda.service;

import tienda.repository.*;
import tienda.model.*;
import java.util.List;

public class ProductoServicio {

    private ProductoRepositorio repositorio = new ProductoRepositorio();

    public void agregar(Producto producto) {
        repositorio.agregar(producto);
    }
    
    public List<Producto> listar() {
        return repositorio.listar();
    }

    public void eliminar(int id) {
        repositorio.eliminar(id);
    }
    
    public void actualizar(Producto producto) {
        repositorio.actualizar(producto);
    }

}
