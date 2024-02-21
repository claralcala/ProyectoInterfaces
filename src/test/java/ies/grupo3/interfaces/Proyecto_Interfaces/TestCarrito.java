package ies.grupo3.interfaces.Proyecto_Interfaces;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

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
    private Carrito carritos;
    private ConsultasBD3 consultasMock;
    private ConsultasBD2 consultaMock;

    /**
     * Configuración inicial antes de cada prueba.
     */
    @BeforeEach
    public void setUp() {
        // Mock de ConsultasBD3
        consultasMock = mock(ConsultasBD3.class);
        carrito = new Carrito(1);
        carrito.setConsultasBD3(consultasMock);
        
        // Mock de ConsultasBD2
        consultaMock = mock(ConsultasBD2.class);
        carritos = new Carrito(1);
        carritos.setConsultasBD2(consultaMock);
        ConsultasBD2.obtenerProductosDelCarrito(1);
    }

    /**
     * Prueba para verificar que se buscan y muestran productos correctamente.
     */
    @Test
    public void testBuscarYMostrarProductos() {
        // Arrange
        String nombreABuscar = "Producto";
        ArrayList<Producto> productosStub = new ArrayList<>();
        productosStub.add(new Producto(1, "Producto", 10.0));

        // Mock de la llamada estática
        mockStatic(ConsultasBD3.class); // No es necesario prefijar con Mockito.
        when(ConsultasBD3.buscarProductosEnCarritoPorNombre(1, nombreABuscar)).thenReturn(productosStub);

        // Act
        carrito.buscarYMostrarProductos();

        // Assert
        // Verificar que se hayan añadido los JLabels correctamente
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

        // Mock de la llamada estática
        mockStatic(ConsultasBD2.class);
        when(ConsultasBD2.obtenerProductosDelCarrito(1)).thenReturn(productosStub);

        // Act
        carrito.obtenerProductoDelCarrito();

        // Assert
        // Verificar que se hayan añadido los JLabels correctamente
        assertEquals(1, carrito.getComponentCount());
    }

    /**
     * Prueba para verificar que el ajuste de precio del producto se calcula correctamente.
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
    
    @Test
    public void testCompraRealizadaAlHacerClic() {
        // Arrange
        JLabel lblComprar = new JLabel("Comprar");
        JPanel panelCompra = new JPanel(); // Crear un JPanel para simular el panel de compra

        // Simular el clic en lblComprar
        MouseEvent clickEvent = mock(MouseEvent.class);
        when(clickEvent.getSource()).thenReturn(lblComprar);

        // Act
        lblComprar.getMouseListeners()[0].mouseClicked(clickEvent);

        // Assert
        // Verificar que se haya llamado al método crearPedido de ConsultasBD3 con el id_usuario correcto
        verify(ConsultasBD3.class, times(1)).crearPedido(8);
    }
}
