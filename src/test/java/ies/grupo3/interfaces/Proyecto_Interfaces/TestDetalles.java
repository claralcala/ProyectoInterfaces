package ies.grupo3.interfaces.Proyecto_Interfaces;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JTextField;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import controlador.ConsultasBD2;
import modelo.Producto;
import vista.Details;
import vista.TiendaPrincipal;

public class TestDetalles {

    // Se crea una instancia de la clase Details para realizar pruebas
    Details details = new Details();

    // Producto utilizado para las pruebas
    private Producto p;

    // Este método de prueba verifica que el constructor de la clase Details no sea nulo
    @Test
    void testConstructor() {
        assertNotNull(details);
    }

    // Este método de prueba verifica que se pueda añadir un producto al carrito
    @Test
    void testAnadirProductoAlCarrito() {
        
        int userId = 1;
        int productId = 14;
        int cantidad = 2;

       
        boolean resultado = ConsultasBD2.anadirProductoAlCarrito(userId, productId, cantidad);

        
        assertTrue(resultado, "El producto debería ser añadido al carrito");
    }

    // Este método de prueba verifica que no se pueda añadir un producto no existente al carrito
    @Test
    void testAnadirProductoAlCarritoConProductoNoExistente() {
        
        int userId = 1;
        int productId = -1; // Producto no existente
        int cantidad = 2;

        
        boolean resultado = ConsultasBD2.anadirProductoAlCarrito(userId, productId, cantidad);

        
        assertFalse(resultado, "No debería ser posible añadir un producto no existente al carrito");
    }

    // Este método de prueba verifica que no se pueda añadir un producto con un usuario no válido
    @Test
    void testAnadirProductoAlCarritoConUsuarioInvalido() {
        
        int userId = -1; // Usuario no válido
        int productId = 14;
        int cantidad = 2;

        
        boolean resultado = ConsultasBD2.anadirProductoAlCarrito(userId, productId, cantidad);

       
        assertFalse(resultado, "No debería ser posible añadir un producto con un usuario no válido");
    }

    // Este método de prueba verifica que el método esNumero funcione correctamente con un número
    @Test
    void testEsNumeroConNumero() {
        
        JLabel lblPrecio = mock(JLabel.class);
        when(lblPrecio.getText()).thenReturn("123");

        
        boolean resultado = details.esNumero("12");

        
        assertTrue(resultado, "El contenido de lblPrecio debería ser un número");
    }

    // Este método de prueba verifica que el método esNumero funcione correctamente con texto no numérico
    @Test
    void testEsNumeroConTextoNoNumerico() {
     
        JLabel lblPrecio = mock(JLabel.class);
        when(lblPrecio.getText()).thenReturn("abc");

      
        boolean resultado = details.esNumero("abc");

      
        assertFalse(resultado, "El contenido de lblPrecio no debería ser un número");
    }

    // Este método de prueba verifica que el método comprobarCantidad funcione correctamente con una cantidad válida
    @Test
    public void testComprobarCantidad_CantidadValida() {
        
        JTextField textFieldCantidad = new JTextField("10");
        Details details = new Details(textFieldCantidad);

        
        details.comprobarCantidad();

        
        assertEquals("¡Producto añadido al carrito!", details.getMensajeDeDialogo());
    }

    // Este método de prueba verifica que el método comprobarCantidad funcione correctamente con una cantidad no válida
    @Test
    public void testComprobarCantidad_CantidadInvalida() {
        
        JTextField textFieldCantidad = new JTextField("prueba");
        Details details = new Details(textFieldCantidad);

        
        details.comprobarCantidad();

        
        assertEquals("Por favor, ingrese una cantidad válida.", details.getMensajeDeDialogo());
    }
}
