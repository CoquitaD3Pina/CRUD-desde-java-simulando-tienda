package tienda.service;

import tienda.repository.*;
import tienda.model.*;
import java.util.List;


public class ClienteServicio {

    private ClienteRepositorio repositorio = new ClienteRepositorio();

    public void agregar(Cliente cliente) {
        repositorio.agregar(cliente);
    }
    
    public List<Cliente> listar() {
        return repositorio.listar();
    }

    public void eliminar(int id) {
        repositorio.eliminar(id);
    }
    
    public void actualizar(Cliente cliente) {
        repositorio.actualizar(cliente);
    }

}
