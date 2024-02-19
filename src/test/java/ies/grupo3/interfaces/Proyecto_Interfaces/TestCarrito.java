package ies.grupo3.interfaces.Proyecto_Interfaces;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import controlador.ConsultasBD3;
import modelo.Producto;
import vista.Carrito;

public class TestCarrito {

	private Carrito carrito;
    private ConsultasBD3 consultasMock;

    @BeforeEach
    public void setUp() {
        // Mock de ConsultasBD3
        consultasMock = mock(ConsultasBD3.class);
        
        // Creamos una instancia de Carrito con el mock de ConsultasBD3
        carrito = new Carrito(1);
        carrito.setConsultasBD3(consultasMock);
    }

    @Test
    public void testBuscarYMostrarProductos() {
        // Arrange
        String nombreABuscar = "Producto";
        ArrayList<Producto> productosStub = new ArrayList<>();
        productosStub.add(new Producto(1, "Producto", 10.0));

        // Mock de la llamada estática
        Mockito.mockStatic(ConsultasBD3.class);
        Mockito.when(ConsultasBD3.buscarProductosEnCarritoPorNombre(1, nombreABuscar)).thenReturn(productosStub);
        
        // Act
        carrito.buscarYMostrarProductos();
        
        // Assert
        // Verificar que se hayan añadido los JLabels correctamente
        assertEquals(1, carrito.getComponentCount()); // Se espera que haya 2 JLabels agregados al contentPane.
    }
}
