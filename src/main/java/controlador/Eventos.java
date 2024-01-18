package controlador;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import vista.Login;



public class Eventos {

	JLabel lblNoTeSabes;
	static Login login = new Login();
	
	
	/**
	 * Funcion del JLabel "No te sabes la contraseña".
	 * 
	 * @param lblNoTeSabes 
	 */
    public static void noTeSabesLaContrasenia(JLabel lblNoTeSabes) {
        lblNoTeSabes.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                javax.swing.JOptionPane.showMessageDialog(null, "Usuario: usuario \n"
                        + "Contrasenia: usuario ", "Informacion", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                lblNoTeSabes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                lblNoTeSabes.setForeground(Color.green);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lblNoTeSabes.setForeground(new Color(216, 200, 187));
            }
        });
    }
    /**
     * 			Metodo de la funcionalidad del boton de cerrar.
     * 			Eventos dentro de la funcion son al entrar al cliquear y al salir.
     * 
     * @param lblX  JLabel al que se le da funcionalidad.
     * @param panelX Panel que contiene el JLabel.
     * @param login login  Para darle contexto a la hora de cerrar la ventana.
     */
    public static void botonX(JLabel lblX, JPanel panelX, Login login) {
    	lblX.addMouseListener(new MouseAdapter() {
			//mouseClick en un Jlabel ya que he quitado la barra superior.
			@Override
			public void mouseClicked(MouseEvent e) {
				login.dispose();
			}
			//mouseClick segundo evento que hago que se ponga de color rojo cuando el raton pasa por encima.
			@Override
			public void mouseEntered(MouseEvent e) {
				panelX.setBackground(Color.red);
			}
			// cuando sale el raton vuelve al color original.
			@Override
			public void mouseExited(MouseEvent e) {
				Color colorFondo = new Color(10, 27, 5);
				panelX.setBackground(colorFondo);
			}
		});
    }
    /**
	 * 			Metodo de la funcionalidad del boton de minimizar.
	 * 			Eventos dentro de la funcion son al entrar al cliquear y al salir.
     * 
     * @param lbl_	 JLabel al que se le da funcionalidad.
     * @param panel_ Panel que contiene el JLabel.
     * @param login  Para darle contexto a la hora de cerrar la ventana.
     */
    public static void botonMinimiza(JLabel lbl_, JPanel panel_, Login login) {
    	lbl_.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_.setBackground(Color.blue);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				login.setExtendedState(JFrame.ICONIFIED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Color colorFondo = new Color(10, 27, 5);
				panel_.setBackground(colorFondo);
			}
		});
    }
    	
 }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

