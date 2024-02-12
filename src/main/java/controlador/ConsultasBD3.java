package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

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

            // Paso 1: Insertar un nuevo registro en la tabla `pedido`
            String sqlInsertPedido = "INSERT INTO pedido (user_id, fecha) VALUES (?, ?)";
            pstInsertPedido = conexion.prepareStatement(sqlInsertPedido, Statement.RETURN_GENERATED_KEYS);
            pstInsertPedido.setInt(1, userId);
            pstInsertPedido.setDate(2, java.sql.Date.valueOf(LocalDate.now())); // Usa la fecha actual
            int affectedRows = pstInsertPedido.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("La creación del pedido falló, no se afectaron filas.");
            }

            // Paso 2: Recuperar el ID del pedido recién creado
            generatedKeys = pstInsertPedido.getGeneratedKeys();
            if (generatedKeys.next()) {
                nuevoPedidoId = generatedKeys.getInt(1);
            } else {
                throw new SQLException("La creación del pedido falló, no se obtuvo el ID.");
            }

            // Paso 3 y 4: Obtener productos del carrito y trasladarlos a `pedido_tiene_productos`
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
	
	
	
}


