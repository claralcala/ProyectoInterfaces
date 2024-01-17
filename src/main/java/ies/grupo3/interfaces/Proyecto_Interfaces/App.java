package ies.grupo3.interfaces.Proyecto_Interfaces;

import java.awt.EventQueue;

import vista.VentanaPrincipal;

/**
 * Clase main para ejecutar la aplicación
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					VentanaPrincipal ventana = new VentanaPrincipal();
					ventana.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
        
    }
}
