package tienda.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tienda.database.ConexionBD;
import tienda.model.Venta;

public class VentaRepositorio {
   
    Connection connection = ConexionBD.obtenerConexion();


    public void agregar(Venta venta) {
    String sql = "INSERT INTO ventas (cliente_id, total) VALUES (?, ?)";
    try (PreparedStatement ps = connection.prepareStatement(sql)){
        ps.setInt(1, venta.getClienteId());
        ps.setDouble(2, venta.getTotal());
        ps.executeUpdate();
    }catch (Exception e){
        e.printStackTrace();
        }

    }
    public List <Venta> listar() {
        List <Venta> ventas = new ArrayList<>();
        String sql = "SELECT * FROM ventas";
        try(PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery()) {
              while (rs.next()){
              Venta p = new Venta();
                p.setId(rs.getInt("id"));
                p.setClienteId(rs.getInt("cliente_id"));
                p.setFecha(rs.getTimestamp("fecha").toLocalDateTime());
                p.setTotal(rs.getDouble("total"));
                ventas.add(p);
              }            
        } catch (Exception e) {
        }
        return ventas ;
    }
    public void eliminar(int id){
        String sql = "DELETE FROM ventas WHERE id = ? ";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
        ps.setInt(1, id);
        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    }
    public void actualizar(Venta venta){
        String sql = "UPDATE ventas SET cliente_id = ?, total = ? WHERE id = ? ";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
        ps.setInt(1, venta.getClienteId());
        ps.setDouble(2, venta.getTotal());
        ps.setInt(3, venta.getId());
        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    }
    
}
