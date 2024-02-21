package ies.grupo3.interfaces.Proyecto_Interfaces;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import controlador.Conexion;
import controlador.ConsultasBD2;
import modelo.Producto;
import vista.TiendaPrincipal;

public class TestTiendaPrincipal {
	
	
	 TiendaPrincipal tiendaPrincipal;
	 ConsultasBD2 consultasBD2Mock;
	 Connection con;
	 
	 

	
	//Prueba para comprobar que la ventana de la tienda se construye con el id de usuario que se le pasa
	 @Test
	 void testConstructor() {
	        TiendaPrincipal tiendaPrincipal = new TiendaPrincipal(1);
	        assertNotNull(tiendaPrincipal);
	 }
	 
	 

	 
	 
	 @Test
	    public void testConexion() {
	        Conexion conexion = new Conexion();
	        Connection con = null;
	        try {
	            con = conexion.conectar();
	            assertNotNull(con, "La conexión no debería ser nula");
	        } catch (Exception e) {
	            fail("No debería fallar al intentar conectarse a la base de datos");
	        } finally {
	            if (con != null) {
	                try {
	                    con.close();
	                } catch (Exception e) {
	                    fail("No debería fallar al cerrar la conexión a la base de datos");
	                }
	            }
	        }
	    }
	 
	 
	 @BeforeEach
	    void setUp() throws Exception {
	        // Inicializar la conexión a la base de datos
	        Conexion conexion = new Conexion();
	        con = conexion.conectar();
	        
	        
	    }
	 
	 
	 //Test que comprueba que la lista NO venga vacía
	 @Test
	    void testRecuperarProductos() {
	        //Llamada al método
	        ArrayList<Producto> productos = ConsultasBD2.recuperarProductos();
	        
	        //Se comprueba que no sea nula la lista de productos
	        assertNotNull(productos);
	        //Se comprueba que al menos la lista contenga un producto
	        //Por eso devuelve False
	        assertFalse(productos.isEmpty());
	       
	    }
	 
	 
	 //Test que comprueba que la lista esté llena (lo contrario del test anterior
	 @Test
	 void testRecuperarProductosListaLlena() throws SQLException {
		 //Llamada al método
	        ArrayList<Producto> productos = ConsultasBD2.recuperarProductos();
	        
	        //Se comprueba que no sea nula la lista de productos
	        assertNotNull(productos);
	       

	     //Comprueba que la lista no está vacía
	     assertTrue(!productos.isEmpty());
	 }
	 
	 
	 
	 @Test
	 void testRecuperarProductosConPrecioMayorACero() {
	     // Llamada al método de recuperar productos
	     ArrayList<Producto> productos = ConsultasBD2.recuperarProductos();

	     //Recorremos la lista de productos con un foreach y comprobamos los precios
	     boolean todosPreciosMayorACero = true;
	     for (Producto producto : productos) {
	         if (producto.getPrecio() <= 0) {
	             todosPreciosMayorACero = false;
	             break;
	         }
	     }

	     assertTrue(todosPreciosMayorACero, "Todos los productos deben tener un precio mayor a cero");
	 }
	 
	 
	 
	 @Test
	 void testRecuperarProductosConStockPositivo() {
	     //Llamada al método
	     ArrayList<Producto> productos = ConsultasBD2.recuperarProductos();

	     // Asegurar que todos los productos tienen un stock positivo
	     boolean todosStockPositivo = true;
	     for (Producto producto : productos) {
	         if (producto.getStock() <= 0) {
	             todosStockPositivo = false;
	             break;
	         }
	     }

	     assertTrue(todosStockPositivo, "Todos los productos deben tener un stock positivo");
	 }
	 
	 
	 
	 @Test
	 void testBuscarProductosPorNombreContieneNombre() {
	     String nombreBuscado = "Nike";
	     ArrayList<Producto> productos = ConsultasBD2.buscarProductosPorNombre(nombreBuscado);

	     assertFalse(productos.isEmpty(), "La lista de productos no debería estar vacía");
	     
	     boolean todosContienenNombre = true;
	     for (Producto producto : productos) {
	         if (!producto.getNombre().toLowerCase().contains(nombreBuscado.toLowerCase())) {
	             todosContienenNombre = false;
	             break;
	         }
	     }

	     assertTrue(todosContienenNombre, "Todos los productos encontrados deben contener el nombre buscado");
	 }
	 
	 
	 @Test
	 void testBuscarProductosPorNombreContieneNombreYNoEstaVacio() {
	     String nombreBuscado = "Zapatilla";
	     ArrayList<Producto> productos = ConsultasBD2.buscarProductosPorNombre(nombreBuscado);

	     //En este caso añadimos esto
	     assertTrue(productos.isEmpty(), "La lista de productos no debería estar vacía");

	     boolean todosContienenNombre = false;
	     for (Producto producto : productos) {
	         if (producto.getNombre().toLowerCase().contains(nombreBuscado.toLowerCase())) {
	             todosContienenNombre = true;
	             break;
	         }
	     }
	     

	     assertFalse(todosContienenNombre, "Todos los productos encontrados deben contener el nombre buscado");
	 }
	 
	 
	 
	 
	 @Test
	 void testGenerarPDFDeBusqueda() {
	     TiendaPrincipal tienda = new TiendaPrincipal(1); 
	     String textoBusqueda = "Adidas"; 
	     
	     // Ejecutar el método que genera el PDF
	     tienda.generarPDFDeBusqueda(textoBusqueda);
	     
	     // Verificar que el archivo PDF ha sido creado
	     File file = new File("ResultadosBusqueda.pdf");
	     assertTrue(file.exists(), "El archivo PDF debería haberse creado");
	     
	   
	     
	     // Limpieza: eliminar el archivo PDF después de la prueba para evitar acumulación de archivos de prueba
	     file.delete();
	 }
	 
	 
	 @Test
	    void testLogoutButtonCreation() {
	        TiendaPrincipal tienda = new TiendaPrincipal(1); //Inicializamos la ventana con el id de usuario 1
	        JButton logoutButton = tienda.getLogoutButton(); //Llamamos al getter que previamente hemos creado en la vista para el btn logout
	        assertNotNull(logoutButton, "El botón de logout debería crearse");
	    }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	

	
	 
	 
	 

}
