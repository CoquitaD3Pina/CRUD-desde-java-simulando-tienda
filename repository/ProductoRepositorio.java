package tienda.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tienda.database.ConexionBD;
import tienda.model.Producto;

public class ProductoRepositorio {

    Connection connection = ConexionBD.obtenerConexion();


    public void agregar(Producto producto) {
    String sql = "INSERT INTO productos (nombre, precio, stock) VALUES (?, ?, ?)";
    try (PreparedStatement ps = connection.prepareStatement(sql)){
        ps.setString(1, producto.getNombre());
        ps.setDouble(2, producto.getPrecio());
        ps.setInt(3, producto.getStock());
        ps.executeUpdate();
    }catch (Exception e){
        e.printStackTrace();
        }

    }
    public List <Producto> listar() {
        List <Producto> productos = new ArrayList<>();
        String sql = "SELECT * FROM productos";
        try(PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery()) {
              while (rs.next()){
              Producto p = new Producto();
                p.setId(rs.getInt("id"));
                p.setNombre(rs.getString("nombre"));
                p.setPrecio(rs.getDouble("precio"));
                p.setStock(rs.getInt("stock"));
                productos.add(p);
              }            
        } catch (Exception e) {
        }
        return productos;
    }
    public void eliminar(int id){
        String sql = "DELETE FROM productos WHERE id = ? ";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
        ps.setInt(1, id);
        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    }
    public void actualizar(Producto producto){
        String sql = "UPDATE productos SET nombre = ?, precio = ?, stock = ? WHERE id = ? ";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
        ps.setString(1, producto.getNombre());
        ps.setDouble(2, producto.getPrecio());
        ps.setInt(3, producto.getStock());
        ps.setInt(4, producto.getId());
        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    }
}
