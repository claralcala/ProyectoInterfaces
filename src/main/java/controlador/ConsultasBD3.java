package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.Producto;

public class ConsultasBD3 {
	
	public static boolean crearPedido(int userId) {
		
		PreparedStatement pstInsertPedido = null;
		ResultSet generatedKeys = null;
		int nuevoPedidoId = 0;
		Conexion con = new Conexion();
		 
        Connection conexion = null;
        boolean exito = false;

        try {
        	conexion = con.conectar();

            //Insertar un nuevo registro en la tabla pedido
            String sqlInsertPedido = "INSERT INTO pedido (user_id, fecha) VALUES (?, ?)";
            pstInsertPedido = conexion.prepareStatement(sqlInsertPedido, Statement.RETURN_GENERATED_KEYS);
            pstInsertPedido.setInt(1, userId);
            pstInsertPedido.setDate(2, java.sql.Date.valueOf(LocalDate.now())); // Usamos la fecha actual
            int affectedRows = pstInsertPedido.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("La creación del pedido falló, no se afectaron filas");
            }

            //conseguimos el id del pedido que se acaba de generar
            generatedKeys = pstInsertPedido.getGeneratedKeys();
            if (generatedKeys.next()) {
                nuevoPedidoId = generatedKeys.getInt(1);
            } else {
                throw new SQLException("La creación del pedido falló, no se obtuvo el ID.");
            }

            //obtenemos productos del carrito y los metemos en pedido_tiene_productos
            String sqlCarritoDetalle = "SELECT product_id, cantidad FROM carrito_detalle WHERE carrito_id = (SELECT carrito_id FROM carrito WHERE user_id = ?)";
            PreparedStatement pstCarritoDetalle = conexion.prepareStatement(sqlCarritoDetalle);
            pstCarritoDetalle.setInt(1, userId);
            ResultSet rs = pstCarritoDetalle.executeQuery();

            while (rs.next()) {
                int productId = rs.getInt("product_id");
                int cantidad = rs.getInt("cantidad");

                String sqlInsertDetallePedido = "INSERT INTO pedido_tiene_productos (pedido_id, product_id, cantidad) VALUES (?, ?, ?)";
                PreparedStatement pstInsertDetallePedido = conexion.prepareStatement(sqlInsertDetallePedido);
                pstInsertDetallePedido.setInt(1, nuevoPedidoId);
                pstInsertDetallePedido.setInt(2, productId);
                pstInsertDetallePedido.setInt(3, cantidad);
                pstInsertDetallePedido.executeUpdate();
            }

            exito = true;
            if (exito) {
            	JOptionPane.showMessageDialog(null, "El pedido se ha creado correctamente");
            String sqlVaciarCarritoPorUsuario = "DELETE cd FROM carrito_detalle cd " +
                    "JOIN carrito c ON cd.carrito_id = c.carrito_id " +
                    "WHERE c.user_id = ?";
            		PreparedStatement pstVaciarCarritoPorUsuario = conexion.prepareStatement(sqlVaciarCarritoPorUsuario);
            		pstVaciarCarritoPorUsuario.setInt(1, userId);
            		pstVaciarCarritoPorUsuario.executeUpdate();
            		
            }
        } catch (SQLException e) {
            System.out.println("Error al crear el pedido: " + e.getMessage());
            exito = false;
        } finally {
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException e) {
                    System.out.println("Error al cerrar la conexión: " + e.getMessage());
                }
            }
            
            if (generatedKeys != null) {
                try {
                    generatedKeys.close();
                } catch (SQLException e) {
                    System.out.println("Error al cerrar ResultSet: " + e.getMessage());
                }
            }
            
            if (pstInsertPedido != null) {
                try {
                    pstInsertPedido.close();
                } catch (SQLException e) {
                    System.out.println("Error al cerrar PreparedStatement: " + e.getMessage());
                }
            }
            
        }

        return exito;
    }
	
	
	
	public static boolean eliminarProductoDelCarrito(int userId, int productId) {
	    Conexion con = new Conexion();
	    Connection conexion = null;
	    boolean eliminado = false;

	    try {
	        conexion = con.conectar();
	        
	        // se obtiene el id del carrito a traves del user_id
	        String sqlObtenerCarrito = "SELECT carrito_id FROM carrito WHERE user_id = ?";
	        PreparedStatement pstObtenerCarrito = conexion.prepareStatement(sqlObtenerCarrito);
	        pstObtenerCarrito.setInt(1, userId);
	        ResultSet rsCarrito = pstObtenerCarrito.executeQuery();
	        
	        if (rsCarrito.next()) {
	            int carritoId = rsCarrito.getInt("carrito_id");
	            
	            // se elimina el producto del carrito_detalle
	            String sqlEliminarProducto = "DELETE FROM carrito_detalle WHERE carrito_id = ? AND product_id = ?";
	            PreparedStatement pstEliminarProducto = conexion.prepareStatement(sqlEliminarProducto);
	            pstEliminarProducto.setInt(1, carritoId);
	            pstEliminarProducto.setInt(2, productId);
	            
	            int filasAfectadas = pstEliminarProducto.executeUpdate();
	            if (filasAfectadas > 0) {
	                eliminado = true;
	            } else {
	                System.out.println("No se encontró el producto en el carrito o ya fue eliminado.");
	            }
	        } else {
	            System.out.println("No se encontró un carrito para el usuario especificado.");
	        }
	    } catch (SQLException e) {
	        System.out.println("Error al eliminar el producto del carrito: " + e.getMessage());
	    } finally {
	        if (conexion != null) {
	            try {
	                conexion.close();
	            } catch (SQLException e) {
	                System.out.println("Error al cerrar la conexión: " + e.getMessage());
	            }
	        }
	    }

	    return eliminado;
	}
	
	public static ArrayList<Producto> buscarProductosEnCarritoPorNombre(int userId, String nombre) {
	    ArrayList<Producto> productos = new ArrayList<Producto>();
	    Conexion con = new Conexion();
	    Connection conexion = null;

	    try {
	        conexion = con.conectar();
	        
	        // Consulta para buscar productos por nombre en el carrito de un usuario específico
	        String sql = "SELECT p.* FROM producto p " +
	                     "JOIN carrito_detalle cd ON p.product_id = cd.product_id " +
	                     "JOIN carrito c ON cd.carrito_id = c.carrito_id " +
	                     "WHERE c.user_id = ? AND p.nombre LIKE ?";
	        
	        PreparedStatement pst = conexion.prepareStatement(sql);
	        pst.setInt(1, userId); // Configurar el user_id
	        pst.setString(2, "%" + nombre + "%"); // Configurar el parámetro de búsqueda por nombre
	        
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
	        System.out.println("Error al buscar los productos en el carrito: " + e.getMessage());
	    } finally {
	        if (conexion != null) {
	            try {
	                conexion.close();
	            } catch (SQLException e) {
	                System.out.println("Error al cerrar la conexión: " + e.getMessage());
	                System.out.println("hola");
	            }
	        }
	    }

	    return productos;
	}
	
}


