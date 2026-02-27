package tienda.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tienda.database.ConexionBD;
import tienda.model.DetalleVenta;

public class DetalleVentaRepositorio {

    Connection connection = ConexionBD.obtenerConexion();

    public void agregar(DetalleVenta detalle) {
        String sql = "INSERT INTO detalle_venta (venta_id, producto_id, cantidad, precio_unitario) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, detalle.getVentaId());
            ps.setInt(2, detalle.getProductoId());
            ps.setInt(3, detalle.getCantidad());
            ps.setDouble(4, detalle.getPrecioUnitario());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<DetalleVenta> listar() {
        List<DetalleVenta> detalles = new ArrayList<>();
        String sql = "SELECT * FROM detalle_venta";
        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                DetalleVenta d = new DetalleVenta();
                d.setId(rs.getInt("id"));
                d.setVentaId(rs.getInt("venta_id"));
                d.setProductoId(rs.getInt("producto_id"));
                d.setCantidad(rs.getInt("cantidad"));
                d.setPrecioUnitario(rs.getDouble("precio_unitario"));
                detalles.add(d);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return detalles;
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM detalle_venta WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizar(DetalleVenta detalle) {
        String sql = "UPDATE detalle_venta SET venta_id = ?, producto_id = ?, cantidad = ?, precio_unitario = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, detalle.getVentaId());
            ps.setInt(2, detalle.getProductoId());
            ps.setInt(3, detalle.getCantidad());
            ps.setDouble(4, detalle.getPrecioUnitario());
            ps.setInt(5, detalle.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}