package ies.grupo3.interfaces.Proyecto_Interfaces;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import controlador.ConsultasBD2;
import controlador.ConsultasBD3;
import modelo.Producto;
import vista.Carrito;

/**
 * Clase de prueba para la clase Carrito.
 */
public class TestCarrito {
	private Carrito carrito;
	//Inicializo la clase donde va a dirigir la salida de la consola.
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

	
	/**
	 * Configuración inicial ANTES de cada prueba.
	 */
	@BeforeEach
	public void setUp() {
		// Inicializo el carrito con el id_user 1
		carrito = new Carrito(1);
		// se redirige la salida de la consola a outputStreamCaptor y Sirve para la
		// prueba de testRealizarCompra() pueda comprobar la salida y ver si salta el
		// mensaje de "Compra realizada".
		System.setOut(new PrintStream(outputStreamCaptor));
	}

	
	/**
	 * Configuración POSTERIOR a cada prueba.
	 */
	@AfterEach
	public void tearDown() {
		// Se restaura la salida estándar de la consola
		System.setOut(System.out);
	}

	
	/**
	 * Prueba que verifica que se busca y muestra productos correctamente. Se
	 * comprueba la consulta y verifica si retorna el mismo objeto. Se comprueba que
	 * si se ha agrega JLabel en la clase "carrito" con la información.
	 */
	@Test
	public void testBuscarYMostrarProductosDelBuscador() {
		// Se inicializa el producto a buscar, se crea un array y se añade el producto.
		String nombreABuscar = "Producto";
		ArrayList<Producto> productosStub = new ArrayList<Producto>();
		productosStub.add(new Producto(1, "Producto", 10.0));

		// hace la llamada estática y simula la busqueda en la base de datos.
		mockStatic(ConsultasBD3.class);

		// Mockito intercepta la llamada y retorna "productosStub" en su lugar, sin
		// ejecutar realmente el metodo original.
		when(ConsultasBD3.buscarProductosEnCarritoPorNombre(1, nombreABuscar)).thenReturn(productosStub);

		// Verificar que se hayan añadido un JLabels correctamente en la clase "Carrito"
		assertEquals(1, carrito.getComponentCount());
	}
	
	
	/**
	 * Prueba para verificar que se obtienen productos del carrito correctamente. Se
	 * comprueba la consulta y verifica si retorna el mismo objeto. Se comprueba que
	 * si se ha agrega JLabel en la clase "carrito" con la información.
	 * 
	 */
	@Test
	public void testObtenerProductosDelCarrito() {
		ArrayList<Producto> productosStub = new ArrayList<Producto>();
		productosStub.add(new Producto(5, "Producto", 10.0));

		// Mockito hace la llamada estática.
		mockStatic(ConsultasBD2.class);
		// Mockito intercepta la llamada y retorna "productosStub" en su lugar, sin
		// ejecutar realmente el metodo original.
		when(ConsultasBD2.obtenerProductosDelCarrito(1)).thenReturn(productosStub);

		// Assert: verificar que se hayan añadido los JLabels correctamente
		assertEquals(1, carrito.getComponentCount());
	}
	

	/**
	 * Prueba para verificar que se realiza la compra correctamente y simula el
	 * pedido en la base de datos.
	 */
	@Test
	public void testBorrarProductoDelCarrito() {
	    // Preparar los datos de prueba
	    int id_usuario = 2;
	    int id_producto = 123;

	    // Mockear las clases ConsultasBD2 y ConsultasBD3
	    ConsultasBD2 consultasMock2 = mock(ConsultasBD2.class);
	    ConsultasBD3 consultasMock3 = mock(ConsultasBD3.class);

	    // Configurar el comportamiento esperado para ConsultasBD2.anadirProductoAlCarrito
	    when(consultasMock2.anadirProductoAlCarrito(id_usuario, id_producto, 1)).thenReturn(true);

	    carrito.borrarProductoDelCarrito(id_usuario, id_producto);
	    
	    // Verificar que se llamó a ConsultasBD3.eliminarProductoDelCarrito con los parámetros correctos
	    verify(consultasMock3).eliminarProductoDelCarrito(id_usuario, id_producto);
	}
}
