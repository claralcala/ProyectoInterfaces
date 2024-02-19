package ies.grupo3.interfaces.Proyecto_Interfaces;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import javax.swing.JButton;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import controlador.ConsultasBD2;
import modelo.Producto;
import vista.TiendaPrincipal;

public class TestTiendaPrincipal {
	
	
	 TiendaPrincipal tiendaPrincipal;
	 ConsultasBD2 consultasBD2Mock;
	
	//Prueba para comprobar que la ventana de la tienda se construye con el id de usuario que se le pasa
	 @Test
	 void testConstructor() {
	        TiendaPrincipal tiendaPrincipal = new TiendaPrincipal(1);
	        assertNotNull(tiendaPrincipal);
	 }
	 
	 
	
	 
	 
	 @Test
	    void testLogoutButtonCreation() {
	        TiendaPrincipal tienda = new TiendaPrincipal(1); //Inicializamos la ventana con el id de usuario 1
	        JButton logoutButton = tienda.getLogoutButton(); //Llamamos al getter que previamente hemos creado en la vista para el btn logout
	        assertNotNull(logoutButton, "El botón de logout debería crearse");
	    }
	 
	 
	 
	 @Test
	    void testAddProductToCart() {
	        // Simulación de la interacción con la base de datos
	        ConsultasBD2 consultasMock = mock(ConsultasBD2.class);
	        when(consultasMock.anadirProductoAlCarrito(anyInt(), anyInt(), anyInt())).thenReturn(true);

	        TiendaPrincipal tienda = new TiendaPrincipal(1);
	        tienda.setConsultasBD(consultasMock);

	        

	        //Verificar que el método de añadir se llama con los parámetros correctos
	        verify(consultasMock).anadirProductoAlCarrito(1, 1, 3);
	    }
	 
	 
	 
	 
	 
	 
	

	
	 
	 
	 

}
