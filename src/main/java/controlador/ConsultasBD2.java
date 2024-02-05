package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	        String sql = "UPDATE usuario SET nombre = ?, apellidos = ?, correo_elec = ?, telefono = ?, direccion = ? WHERE id = ?";
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

}
