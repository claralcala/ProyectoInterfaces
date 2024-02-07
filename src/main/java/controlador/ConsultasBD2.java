package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.Producto;

public class ConsultasBD2 {
	
	public static ArrayList<Producto> recuperarProductos() {
        ArrayList<Producto> productos = new ArrayList<Producto>();
        Conexion con = new Conexion();
        Connection conexion = null;

        try {
            String sql = "SELECT * FROM producto";
            conexion = con.conectar();
            PreparedStatement pst = conexion.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Producto producto = new Producto();
                producto.setProduct_id(rs.getInt("product_id"));
                producto.setNombre(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setStock(rs.getInt("stock"));
                producto.setPrecio(rs.getFloat("precio"));
                producto.setImagen(rs.getString("imagen"));

                productos.add(producto);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al recuperar los productos: " + e.getMessage());
        } finally {
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + e.getMessage());
                }
            }
        }

        return productos;
    }
	
	
	
	public static ArrayList<Producto> buscarProductosPorNombre(String nombre) {
        ArrayList<Producto> productos = new ArrayList<Producto>();
        Conexion con = new Conexion();
        Connection conexion = null;

        try {
            String sql = "SELECT * FROM producto WHERE nombre LIKE ?";
            conexion = con.conectar();
            PreparedStatement pst = conexion.prepareStatement(sql);
            
            // Configurar el parámetro de la consulta SQL
            pst.setString(1, "%" + nombre + "%");
            
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Producto producto = new Producto();
                producto.setProduct_id(rs.getInt("product_id"));
                producto.setNombre(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setStock(rs.getInt("stock"));
                producto.setImagen(rs.getString("imagen"));
               

                productos.add(producto);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar los productos: " + e.getMessage());
        } finally {
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + e.getMessage());
                }
            }
        }

        return productos;
    }
	
	
	public static boolean actualizarUsuarioPorId(int idUsuario, String nombre, String apellidos, String correoElectronico, String telefono, String direccion) {
	    Conexion con = new Conexion();
	    Connection conexion = null;
	    boolean actualizado = false;

	    try {
	        String sql = "UPDATE usuario SET nombre = ?, apellidos = ?, correo_elec = ?, telefono = ?, direccion = ? WHERE user_id = ?";
	        conexion = con.conectar();
	        PreparedStatement pst = conexion.prepareStatement(sql);

	      
	        pst.setString(1, nombre);
	        pst.setString(2, apellidos);
	        pst.setString(3, correoElectronico);
	        pst.setString(4, telefono);
	        pst.setString(5, direccion);
	        pst.setInt(6, idUsuario);

	        int rowsUpdated = pst.executeUpdate();
	        if (rowsUpdated > 0) {
	            actualizado = true;
	            System.out.println("El usuario ha sido actualizado correctamente.");
	        }
	    } catch (SQLException e) {
	        System.out.println("Error al actualizar el usuario: " + e.getMessage());
	    } finally {
	        if (conexion != null) {
	            try {
	                conexion.close();
	            } catch (SQLException e) {
	                System.out.println("Error al cerrar la conexión: " + e.getMessage());
	            }
	        }
	    }

	    return actualizado;
	}
	
	
	public static boolean anadirProductoAlCarrito(int userId, int productId, int cantidad) {
	    Conexion con = new Conexion();
	    Connection conexion = null;
	    boolean agregado = false;

	    try {
	        conexion = con.conectar();
	        // Verificar si el usuario ya tiene un carrito
	        String sqlCarrito = "SELECT carrito_id FROM carrito WHERE user_id = ?";
	        PreparedStatement pstCarrito = conexion.prepareStatement(sqlCarrito);
	        pstCarrito.setInt(1, userId);
	        ResultSet rsCarrito = pstCarrito.executeQuery();
	        int carritoId;

	        if (!rsCarrito.next()) {
	            // Si no tiene carrito, se crea uno nuevo
	            String sqlInsertCarrito = "INSERT INTO carrito (user_id) VALUES (?)";
	            PreparedStatement pstInsertCarrito = conexion.prepareStatement(sqlInsertCarrito, Statement.RETURN_GENERATED_KEYS);
	            pstInsertCarrito.setInt(1, userId);
	            pstInsertCarrito.executeUpdate();
	            ResultSet generatedKeys = pstInsertCarrito.getGeneratedKeys();
	            if (generatedKeys.next()) {
	                carritoId = generatedKeys.getInt(1);
	            } else {
	                throw new SQLException("Fallo al crear el carrito");
	            }
	        } else {
	            carritoId = rsCarrito.getInt("carrito_id");
	        }

	        // Añadir o actualizar el producto en el detalle del carrito
	        String sqlDetalle = "SELECT cantidad FROM carrito_detalle WHERE carrito_id = ? AND product_id = ?";
	        PreparedStatement pstDetalle = conexion.prepareStatement(sqlDetalle);
	        pstDetalle.setInt(1, carritoId);
	        pstDetalle.setInt(2, productId);
	        ResultSet rsDetalle = pstDetalle.executeQuery();

	        if (rsDetalle.next()) {
	            // Si el producto ya está en el detalle del carrito, actualiza la cantidad
	            int nuevaCantidad = rsDetalle.getInt("cantidad") + cantidad;
	            String sqlUpdateDetalle = "UPDATE carrito_detalle SET cantidad = ? WHERE carrito_id = ? AND product_id = ?";
	            PreparedStatement pstUpdateDetalle = conexion.prepareStatement(sqlUpdateDetalle);
	            pstUpdateDetalle.setInt(1, nuevaCantidad);
	            pstUpdateDetalle.setInt(2, carritoId);
	            pstUpdateDetalle.setInt(3, productId);
	            pstUpdateDetalle.executeUpdate();
	        } else {
	            // Si el producto no está en el detalle, inserta un nuevo registro
	            String sqlInsertDetalle = "INSERT INTO carrito_detalle (carrito_id, product_id, cantidad) VALUES (?, ?, ?)";
	            PreparedStatement pstInsertDetalle = conexion.prepareStatement(sqlInsertDetalle);
	            pstInsertDetalle.setInt(1, carritoId);
	            pstInsertDetalle.setInt(2, productId);
	            pstInsertDetalle.setInt(3, cantidad);
	            pstInsertDetalle.executeUpdate();
	        }
	        agregado = true;
	    } catch (SQLException e) {
	        System.out.println("Error al añadir el producto al carrito: " + e.getMessage());
	    } finally {
	        if (conexion != null) {
	            try {
	                conexion.close();
	            } catch (SQLException e) {
	                System.out.println("Error al cerrar la conexión: " + e.getMessage());
	            }
	        }
	    }

	    return agregado;
	}

}
