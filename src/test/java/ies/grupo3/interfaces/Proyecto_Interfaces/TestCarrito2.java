package ies.grupo3.interfaces.Proyecto_Interfaces;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controlador.ConsultasBD3;
import modelo.Producto;
import vista.Carrito;

public class TestCarrito2 {
	
	private Carrito carrito;
	// Inicializo la clase donde va a dirigir la salida de la consola.
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
	 * Prueba para verificar que el ajuste de precio del producto se calcula
	 * correctamente.
	 */
	@Test
	public void testAjustePrecioProducto() {
		// iniciliazo cantidad y precio que voy a introducir.
		int cantidad = 3;
		double precio = 5.0;

		// Realizo la consulta.
		double precioProducto = carrito.calcularPrecioProducto(cantidad, precio);

		// Verificar que el precio del producto se haya calculado correctamente.
		assertEquals(15.0, precioProducto);
	}
	
	
	/**
	 * Prueba para verificar que se agrega un producto al carrito correctamente.
	 */
	@Test
	public void testAgregarProductoAlCarrito() {
		//
		Producto producto = new Producto(1, "Producto1", 10.0);

		//
		carrito.agregarProducto(producto);

		// Verificar que el producto se haya agregado correctamente al carrito
		assertTrue(carrito.getCarrito().contains(producto));

		// Verificar que la interfaz de usuario se haya actualizado correctamente
		assertEquals(1, carrito.getComponentCount());
	}
	
	@Test
	public void testRealizarCompra() {
	    // Preparar los datos de prueba
	    int id_usuario = 4;
	    
	    // Mockear la clase ConsultasBD3
	    ConsultasBD3 consultasMock3 = mock(ConsultasBD3.class);
	    
	    // Llamar al método a probar
	    carrito.realizarCompra(id_usuario);
	    
	    // Verificar que se llamó a ConsultasBD3.crearPedido con el id correcto
	    verify(consultasMock3).crearPedido(id_usuario);
	    
	    // Verificar que se imprimió "Compra realizada"
	    assertTrue(outputStreamCaptor.toString().contains("Compra realizada"));
	}
	
}
