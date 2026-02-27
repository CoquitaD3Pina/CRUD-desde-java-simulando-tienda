package tienda.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tienda.model.Cliente;
import tienda.database.ConexionBD;

public class ClienteRepositorio {

    Connection connection = ConexionBD.obtenerConexion();

    public void agregar (Cliente cliente){
        String sql = "INSERT INTO clientes (nombre, email, telefono) VALUES (?,?,?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)){
        ps.setString(1, cliente.getNombre());
        ps.setString(2, cliente.getEmail());
        ps.setString(3, cliente.getTelefono());
        ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List <Cliente> listar(){
        List <Cliente> clientes = new ArrayList<>();
        String sql ="Select * FROM clientes";
        try (PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){ 
                while (rs.next()) {
                    Cliente p = new Cliente();
                    p.setId(rs.getInt("id"));
                    p.setNombre(rs.getString("nombre"));
                    p.setEmail(rs.getString("email"));
                    p.setTelefono(rs.getString("telefono"));
                    clientes.add(p);
                }
                
        } catch (Exception e) {
        }
        return clientes;
    }
    public void eliminar(int id){
        String sql = "DELETE FROM clientes WHERE id = ? ";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
        ps.setInt(1, id);
        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    }
    public void actualizar(Cliente cliente){
        String sql = "UPDATE clientes SET nombre = ?, email = ?, telefono = ? WHERE id = ? ";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
        ps.setString(1, cliente.getNombre());
        ps.setString(2, cliente.getEmail());
        ps.setString(3, cliente.getTelefono());
        ps.setInt(4, cliente.getId());
        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    }

    
    
}
