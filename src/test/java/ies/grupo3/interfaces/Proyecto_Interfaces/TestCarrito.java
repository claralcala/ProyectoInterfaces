package ies.grupo3.interfaces.Proyecto_Interfaces;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
	//
	private Carrito carrito;
	//
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

	/**
	 * Configuración inicial antes de cada prueba.
	 */
	@BeforeEach
	public void setUp() {
		//
		carrito = new Carrito(1);
		//
		System.setOut(new PrintStream(outputStreamCaptor));
	}

	/**
	 * 
	 */
	@AfterEach
	public void tearDown() {
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
		ArrayList<Producto> productosStub = new ArrayList<>();
		productosStub.add(new Producto(1, "Producto", 10.0));

		// Mockito de la llamada estática
		mockStatic(ConsultasBD3.class);
		when(ConsultasBD3.buscarProductosEnCarritoPorNombre(1, nombreABuscar)).thenReturn(productosStub);

		// llamamos a la funcion que vamos a probar.
		carrito.buscarYMostrarProductos();

		// AssertEquals
		// Verificar que se hayan añadido un JLabels correctamente en la clase "Carrito"
		assertEquals(1, carrito.getComponentCount());
	}

	/**
	 * Prueba para verificar que se obtienen productos del carrito correctamente.
	 */
	@Test
	public void testObtenerProductosDelCarrito() {
		// Arrange
		ArrayList<Producto> productosStub = new ArrayList<>();
		productosStub.add(new Producto(1, "Producto", 10.0));

		// Mockito de la llamada estática
		mockStatic(ConsultasBD2.class);
		when(ConsultasBD2.obtenerProductosDelCarrito(1)).thenReturn(productosStub);

		// Act
		carrito.obtenerProductoDelCarrito();

		// Assert
		// Verificar que se hayan añadido los JLabels correctamente
		assertEquals(1, carrito.getComponentCount());
	}

	/**
	 * Prueba para verificar que el ajuste de precio del producto se calcula
	 * correctamente.
	 */
	@Test
	public void testAjustePrecioProducto() {
		// Arrange
		int cantidad = 3;
		double precio = 5.0;

		// Act
		double precioProducto = carrito.calcularPrecioProducto(cantidad, precio);

		// Assert
		// Verificar que el precio del producto se haya calculado correctamente
		assertEquals(15.0, precioProducto);
	}

	/**
	 * Prueba para verificar que se agrega un producto al carrito correctamente.
	 */
	@Test
	public void testAgregarProductoAlCarrito() {
		// Arrange
		Producto producto = new Producto(1, "Producto1", 10.0);

		// Act
		carrito.agregarProducto(producto);

		// Assert
		// Verificar que el producto se haya agregado correctamente al carrito
		assertTrue(carrito.getCarrito().contains(producto));
		// Verificar que la interfaz de usuario se haya actualizado correctamente
		assertEquals(1, carrito.getComponentCount());
	}

	/**
	 * 
	 */
	@Test
	public void testRealizarCompra() {
		// Preparar los datos de prueba
		int id_usuario = 1;

		// Mockear la clase ConsultasBD3
		ConsultasBD3 consultasMock = mock(ConsultasBD3.class);

		// Llamar al método a probar
		carrito.realizarCompra(id_usuario);

		verify(consultasMock);
		// Verificar que se llamó a ConsultasBD3.crearPedido con el id correcto
		ConsultasBD3.crearPedido(id_usuario);

		// Verificar que se imprimió "Compra realizada"
		assertTrue(outputStreamCaptor.toString().contains("Compra realizada"));
	}

}
