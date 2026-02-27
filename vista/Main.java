package tienda.vista;

import java.sql.Connection;
import java.util.Scanner;
import tienda.database.ConexionBD;
import tienda.model.*;
import tienda.service.*;

public class Main {
    public static void main(String[] args) {

        ProductoServicio productoServicio = new ProductoServicio();
        ClienteServicio clienteServicio = new ClienteServicio();
        VentaServicio ventaServicio = new VentaServicio();
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        System.out.println("=== Bienvenido a SQL desde java ===");
        System.out.println("Probando la conexion a la base de datos...");
        
        Connection con = ConexionBD.obtenerConexion();
        if (con != null) {
            System.out.println("Conexion exitosa!");
        } else {
            System.out.println("Fallo la conexion");
        }
        
        while (!salir) {
            System.out.println("Menu principal:");
            System.out.println("1. Gestionar productos");
            System.out.println("2. Gestionar clientes");        
            System.out.println("3. Gestionar ventas");
            System.out.println("4. Salir");
            System.out.println("Seleccione una opcion: ");
            System.out.println("================================");
            int opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    System.out.println("========Gestionar productos=========");
                    System.out.println("Productos");
                    System.out.println("1. Agregar producto");
                    System.out.println("2. Eliminar producto");   
                    System.out.println("3. Listar productos");
                    System.out.println("4. Actualizar producto");
                    System.out.println("5. Volver al menu principal");
                    System.out.print("Seleccione una opcion: ");
                    int opcionProducto = scanner.nextInt();
                    
                    while (opcionProducto != 5) {
                    switch (opcionProducto) {
                        case 1:
                            scanner.nextLine(); // Limpiar el buffer
                            System.out.println("Agregar producto");
                            System.out.println("================================");
                            System.out.print("Ingrese el nombre del producto: ");
                            String nombre = scanner.nextLine();    
                            System.out.print("Ingrese el precio del producto: ");
                            double precio = scanner.nextDouble();
                            System.out.print("Ingrese el stock del producto: ");
                            int stock = scanner.nextInt();
                            if (nombre != null && !nombre.isEmpty() && precio > 0 && stock >= 0) {
                                Producto nuevoProducto = new Producto(0, nombre, precio, stock);
                                productoServicio.agregar(nuevoProducto);
                                System.out.println("Producto guardado correctamente!");    
                            } else {
                                System.out.println("Error al agregar el producto. Verifique los datos ingresados.");
                            }
                            break;
                        case 2:
                            System.out.println("Eliminar producto");
                            System.out.println("================================");
                            System.out.print("Ingrese el ID del producto a eliminar: ");
                            int idEliminar = scanner.nextInt();
                            productoServicio.eliminar(idEliminar);
                            if(idEliminar > 0) {
                                System.out.println("Producto eliminado correctamente!");
                            } else {
                                System.out.println("Error al eliminar el producto. Verifique el ID ingresado.");
                            }
                            break;
                        case 3:
                            System.out.println("Listar productos"); 
                            System.out.println("================================");
                            for (Producto p : productoServicio.listar()) {
                                System.out.println("ID: " + p.getId() + ", Nombre: " + p.getNombre() + ", Precio: " + p.getPrecio() + ", Stock: " + p.getStock());
                            }
                            break;
                        case 4:
                            System.out.println("Actualizar producto");
                            System.out.println("================================");
                            System.out.print("Ingrese el ID del producto a actualizar: ");
                            int idActualizar = scanner.nextInt();
                            scanner.nextLine(); // Limpiar el buffer
                            System.out.print("Ingrese el nuevo nombre del producto: ");
                            String nuevoNombre = scanner.nextLine();
                            System.out.print("Ingrese el nuevo precio del producto: ");
                            double nuevoPrecio = scanner.nextDouble();
                            System.out.print("Ingrese el nuevo stock del producto: ");
                            int nuevoStock = scanner.nextInt();
                            if (idActualizar > 0 && nuevoNombre != null && !nuevoNombre.isEmpty() && nuevoPrecio > 0 && nuevoStock >= 0) {
                                Producto productoActualizado = new Producto(idActualizar, nuevoNombre, nuevoPrecio, nuevoStock);
                                productoServicio.actualizar(productoActualizado);
                                System.out.println("Producto actualizado correctamente!");
                            } else {
                                System.out.println("Error al actualizar el producto. Verifique los datos ingresados.");
                            }
                            break;
                        case 5:
                            System.out.println("Volviendo al menu principal...");
                            break;
                        default:
                            System.out.println("Opcion invalida. Intente de nuevo.");
                        }
                        System.out.print("Seleccione una opcion: ");
                        opcionProducto = scanner.nextInt();
                    }
                    break;
                
                case 2:
                    System.out.println("Gestionar clientes");
                    System.out.println("================================");
                    System.out.println("Clientes");
                    System.out.println("1. Agregar cliente");
                    System.out.println("2. Eliminar cliente");   
                    System.out.println("3. Listar clientes");
                    System.out.println("4. Actualizar cliente");
                    System.out.println("5. Volver al menu principal");
                    System.out.print("Seleccione una opcion: ");
                    int opcionCliente = scanner.nextInt();

                    while (opcionCliente != 5) {
                        switch (opcionCliente) {
                            case 1:
                                scanner.nextLine();
                                System.out.println("Agregar cliente");
                                System.out.println("================================");
                                System.out.print("Ingrese el nombre del cliente: ");
                                String nombre = scanner.nextLine();    
                                System.out.print("Ingrese el email del cliente: ");
                                String email = scanner.nextLine();
                                System.out.print("Ingrese el telefono del cliente: ");
                                String telefono = scanner.nextLine();
                                if (nombre != null && !nombre.isEmpty() && email != null && !email.isEmpty() && telefono != null && !telefono.isEmpty()) {
                                Cliente nuevoCliente = new Cliente(0, nombre,email,telefono);
                                clienteServicio.agregar(nuevoCliente);
                                System.out.println("Cliente guardado correctamente!");    
                                } else {
                                System.out.println("Error al agregar el cliente. Verifique los datos ingresados.");
                                }
                            break;
                            case 2:
                                System.out.println("Eliminar cliente");
                                System.out.println("================================");
                                System.out.print("Ingrese el ID del cliente a eliminar: ");
                                int idEliminar = scanner.nextInt();
                                clienteServicio.eliminar(idEliminar);
                                if(idEliminar > 0) {
                                    System.out.println("Cliente eliminado correctamente!");
                                } else {
                                    System.out.println("Error al eliminar el cliente. Verifique el ID ingresado.");
                                }
                                break;
                            case 3:
                                System.out.println("Listar clientes");
                                System.out.println("================================");
                                for (Cliente c : clienteServicio.listar()) {
                                    System.out.println("ID: " + c.getId() + ", Nombre: " + c.getNombre() + ", Email: " + c.getEmail() + ", Telefono: " + c.getTelefono());
                                }
                                break;
                            case 4:
                                System.out.println("Actualizar cliente");
                                System.out.println("================================");
                                System.out.print("Ingrese el ID del cliente a actualizar: ");
                                int idActualizar = scanner.nextInt();
                                scanner.nextLine(); // Limpiar el buffer
                                System.out.print("Ingrese el nuevo nombre del cliente: ");
                                String nuevoNombre = scanner.nextLine();    
                                System.out.print("Ingrese el nuevo email del cliente: ");
                                String nuevoEmail = scanner.nextLine();
                                System.out.print("Ingrese el nuevo telefono del cliente: ");
                                String nuevoTelefono = scanner.nextLine();
                                if (idActualizar > 0 && nuevoNombre != null && !nuevoNombre.isEmpty() && nuevoEmail != null && !nuevoEmail.isEmpty() && nuevoTelefono != null && !nuevoTelefono.isEmpty()) {
                                    Cliente clienteActualizado = new Cliente(idActualizar, nuevoNombre, nuevoEmail, nuevoTelefono);
                                    clienteServicio.actualizar(clienteActualizado);
                                    System.out.println("Cliente actualizado correctamente!");
                                } else {
                                    System.out.println("Error al actualizar el cliente. Verifique los datos ingresados.");
                                }
                                break;
                            case 5:
                                System.out.println("Volviendo al menu principal...");   
                                break; 
                            default:
                                System.out.println("Opcion invalida. Intente de nuevo.");
                        }
                        System.out.print("Seleccione una opcion: ");
                        opcionCliente = scanner.nextInt();
                    }
                    break;
                case 3:
                    System.out.println("Gestionar ventas");
                    System.out.println("================================");
                    System.out.println("1. Agregar venta");
                    System.out.println("2. Eliminar venta");   
                    System.out.println("3. Listar ventas");
                    System.out.println("4. Actualizar venta");
                    System.out.println("5. Volver al menu principal");
                    System.out.print("Seleccione una opcion: ");
                    int opcionVentas = scanner.nextInt();

                    while (opcionVentas != 5) {
                        switch (opcionVentas) {
                            case 1:
                                scanner.nextLine();
                                System.out.println("Agregar venta");
                                System.out.println("================================");
                                System.out.println("Agrege id de cliente");
                                int idCliente = scanner.nextInt();
                                System.out.println("Agrege el total de la venta");
                                double total = scanner.nextDouble();
                                if (idCliente > 0 && total > 0) {
                                    Venta nuevaVenta = new Venta(0, idCliente, null, total);
                                    ventaServicio.agregar(nuevaVenta);
                                    System.out.println("Venta guardada correctamente!");    
                                } else {
                                    System.out.println("Error al agregar la venta. Verifique los datos ingresados.");
                                }

                                break;
                            case 2:
                                System.out.println("Eliminar venta");
                                System.out.println("================================");
                                System.out.print("Ingrese el ID de la venta a eliminar: ");
                                int idEliminar = scanner.nextInt(); 
                                ventaServicio.eliminar(idEliminar);
                                if(idEliminar > 0) {    
                                    System.out.println("Venta eliminada correctamente!");
                                } else {
                                    System.out.println("Error al eliminar la venta. Verifique el ID ingresado.");
                                }
                                break;
                            case 3:
                                System.out.println("Listar ventas");
                                System.out.println("================================");
                                for (Venta v : ventaServicio.listar()) {
                                    System.out.println("ID: " + v.getId() + ", Cliente ID: " + v.getClienteId() + ", Fecha: " + v.getFecha() + ", Total: " + v.getTotal());
                                }
                                break;
                            case 4:
                                System.out.println("Actualizar venta");
                                System.out.println("================================");
                                System.out.print("Ingrese el ID de la venta a actualizar: ");
                                int idActualizar = scanner.nextInt();   
                                System.out.print("Ingrese el nuevo ID del cliente: ");
                                int nuevoIdCliente = scanner.nextInt();
                                System.out.print("Ingrese el nuevo total de la venta: ");
                                double nuevoTotal = scanner.nextDouble();
                                if (idActualizar > 0 && nuevoIdCliente > 0 && nuevoTotal > 0) {
                                    Venta ventaActualizada = new Venta(idActualizar, nuevoIdCliente, null, nuevoTotal);
                                    ventaServicio.actualizar(ventaActualizada);
                                    System.out.println("Venta actualizada correctamente!");
                                } else {
                                    System.out.println("Error al actualizar la venta. Verifique los datos ingresados.");
                                }   
                                break;
                            case 5:
                                System.out.println("Volviendo al menu principal...");    
                                break;
                            default:
                                System.out.println("Opcion invalida. Intente de nuevo.");
                        }
                        System.out.print("Seleccione una opcion: ");
                        opcionVentas = scanner.nextInt();
                    }
                    break;
                case 4:
                    salir = true;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opcion invalida. Intente de nuevo.");
            }
        }
        
        scanner.close();
    }

    
}


