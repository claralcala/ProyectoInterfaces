package ies.grupo3.interfaces.Proyecto_Interfaces;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import controlador.ConsultasBD2;
import vista.Editar;

public class TestPerfil {
	
	private Editar editar;
    
    @BeforeEach
    	void setUp() {
        	editar = new Editar(1);
    }
	
    
	 @Test
	    void testInicializacionCampos() {
		 
		 	editar.borrarCampos();
	        // Act
	        String nombre = editar.txtNombre.getText();
	        String apellidos = editar.txtApellidos.getText();
	        String correo = editar.txtCorreo.getText();
	        String telefono = editar.txtTelefono.getText();
	        String direccion = editar.txtDireccion.getText();
	        String contrasena = editar.txtPassword.getText();
	        
	        // Assert
	        assertEquals("", nombre);
	        assertEquals("", apellidos);
	        assertEquals("", correo);
	        assertEquals("", telefono);
	        assertEquals("", direccion);
	        assertEquals("", contrasena);
	    }
	    
	    @Test
	    void testActualizarUsuario() {
	        // Arrange
	        Editar editar = new Editar(1);
	        editar.txtNombre.setText("Jesus");
	        editar.txtApellidos.setText("Bautista");
	        editar.txtCorreo.setText("jbaupar475@iescarrillo.es");
	        editar.txtTelefono.setText("123456789");
	        editar.txtDireccion.setText("Lora del rio");
	        editar.txtPassword.setText("1234");
	        
	        // Act
	        editar.metodoBtnAceptar();
	        
	        // Assert
	        assertTrue(editar.logoutInvocado);
	    }
	    
	    @Test
	    void testContraseñaVacia() {
	        // Arrange
	        Editar editar = new Editar(1);
	        editar.txtNombre.setText("Jesus");
	        editar.txtApellidos.setText("Bautista");
	        editar.txtCorreo.setText("jbaupar475@iescarrillo.es");
	        editar.txtTelefono.setText("123456789");
	        editar.txtDireccion.setText("Lora del rio");
	        editar.txtPassword.setText("");
	        
	        // Act
	        editar.metodoBtnAceptar();;
	        
	        // Assert
	        assertFalse(editar.logoutInvocado);
	    }
	    
	    @Test
	    void testNumeroInvalido() {
	        // Arrange
	        Editar editar = new Editar(1);
	        editar.txtNombre.setText("Jesus");
	        editar.txtApellidos.setText("Bautista");
	        editar.txtCorreo.setText("jbaupar475@iescarrillo.es");
	        editar.txtTelefono.setText("123789");
	        editar.txtDireccion.setText("Lora del rio");
	        editar.txtPassword.setText("1234");
	        
	        // Act
	        editar.metodoBtnAceptar();;
	        
	        // Assert
	        assertFalse(editar.logoutInvocado);
	    }
	    
	    @Test
	    void testNumeroVacio() {
	        // Arrange
	        Editar editar = new Editar(1);
	        editar.txtNombre.setText("Jesus");
	        editar.txtApellidos.setText("Bautista");
	        editar.txtCorreo.setText("jbaupar475@iescarrillo.es");
	        editar.txtTelefono.setText("");
	        editar.txtDireccion.setText("Lora del rio");
	        editar.txtPassword.setText("1234");
	        
	        // Act
	        editar.metodoBtnAceptar();;
	        
	        // Assert
	        assertFalse(editar.logoutInvocado);
	    }
	    
	    @Test
	    void testNumeroString() {
	        // Arrange
	        Editar editar = new Editar(1);
	        editar.txtNombre.setText("Jesus");
	        editar.txtApellidos.setText("Bautista");
	        editar.txtCorreo.setText("jbaupar475@iescarrillo.es");
	        editar.txtTelefono.setText("adc");
	        editar.txtDireccion.setText("Lora del rio");
	        editar.txtPassword.setText("1234");
	        
	        // Act
	        editar.metodoBtnAceptar();;
	        
	        // Assert
	        assertFalse(editar.logoutInvocado);
	    }
	    
	    @Test
	    void testApellidoVacio() {
	        // Arrange
	        Editar editar = new Editar(1);
	        editar.txtNombre.setText("Jesus");
	        editar.txtApellidos.setText("");
	        editar.txtCorreo.setText("jbaupar475@iescarrillo.es");
	        editar.txtTelefono.setText("123789");
	        editar.txtDireccion.setText("Lora del rio");
	        editar.txtPassword.setText("1234");
	        
	        // Act
	        editar.metodoBtnAceptar();;
	        
	        // Assert
	        assertFalse(editar.logoutInvocado);
	    }
	    
	    @Test
	    void testEmailVacio() {
	        // Arrange
	        Editar editar = new Editar(1);
	        editar.txtNombre.setText("Jesus");
	        editar.txtApellidos.setText("Bautista");
	        editar.txtCorreo.setText("");
	        editar.txtTelefono.setText("123789");
	        editar.txtDireccion.setText("Lora del rio");
	        editar.txtPassword.setText("1234");
	        
	        // Act
	        editar.metodoBtnAceptar();;
	        
	        // Assert
	        assertFalse(editar.logoutInvocado);
	    }
	    
	    @Test
	    void testDireccionVacio() {
	        // Arrange
	        Editar editar = new Editar(1);
	        editar.txtNombre.setText("Jesus");
	        editar.txtApellidos.setText("Bautista");
	        editar.txtCorreo.setText("jbaupar475@iescarrillo.es");
	        editar.txtTelefono.setText("123789");
	        editar.txtDireccion.setText("");
	        editar.txtPassword.setText("1234");
	        
	        // Act
	        editar.metodoBtnAceptar();;
	        
	        // Assert
	        assertFalse(editar.logoutInvocado);
	    }
	    
	    @Test
	    void testEsNumericoConValorNumerico() {
	        // Arrange
	        String valor = "123";

	        // Act
	        boolean resultado = editar.esNumerico(valor);

	        // Assert
	        assertTrue(resultado);
	    }

	    @Test
	    void testEsNumericoConString() {
	        // Arrange
	        String valor = "abc";

	        // Act
	        boolean resultado = editar.esNumerico(valor);

	        // Assert
	        assertFalse(resultado);
	    }

	    @Test
	    void testEsNumericoConValorNulo() {
	        // Arrange
	        String valor = null;

	        // Act
	        boolean resultado = editar.esNumerico(valor);

	        // Assert
	        assertFalse(resultado);
	    }

	    @Test
	    void testEsNumericoConValorVacio() {
	        // Arrange
	        String valor = "";

	        // Act
	        boolean resultado = editar.esNumerico(valor);

	        // Assert
	        assertFalse(resultado);
	    }
	    
	}
	

