package vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Event;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.sun.java.swing.plaf.windows.resources.windows;

import controlador.Eventos;

import java.awt.event.MouseMotionAdapter;
import javax.swing.ImageIcon;

public class Login extends JFrame {

	public static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JTextField txtIngreseUsuario;
	public JPasswordField pwdcontra;
	public JPanel panelX;
	public JLabel lblEntrar;
	public JPanel panelEntrar;
	public JLabel lblContrasea;
	public Component lblNoTeSabes;

	/**
	 * Launch the application.
	 */
	

	int xMouse, yMouse;
	//Eventos eventos = new Eventos();
	
	public Login() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 822, 654);
		
		setUndecorated(true);  // Quitar la barra de título y la decoración (barra superior del programa).
		
		contentPane = new JPanel();
		
		contentPane.setBackground(new Color(254, 250, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		
		panel.setBackground(new Color(10, 27, 5));
		panel.setBounds(0, 0, 822, 654);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblInicioSesion = new JLabel("INICIAR SESIÓN");
		lblInicioSesion.setHorizontalAlignment(SwingConstants.CENTER);
		lblInicioSesion.setForeground(new Color(243, 235, 219));
		lblInicioSesion.setFont(new Font("Roboto", Font.PLAIN, 23));
		lblInicioSesion.setBounds(293, 42, 226, 33);
		panel.add(lblInicioSesion);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setForeground(new Color(243, 235, 219));
		lblUsuario.setFont(new Font("Roboto Medium", Font.PLAIN, 20));
		lblUsuario.setBounds(233, 291, 177, 33);
		panel.add(lblUsuario);
		
		txtIngreseUsuario = new JTextField();
		txtIngreseUsuario.addMouseListener(new MouseAdapter() {
			// Verificar si el campo de texto de usuario contiene el texto predeterminado.
			@Override
			public void mousePressed(MouseEvent e) {
				if(txtIngreseUsuario.getText().equals("Ingrese su nombre de usuario")) {
					// Si es así, borrar el texto para que el usuario pueda ingresar su nombre de usuario.
					txtIngreseUsuario.setText("");
				}// Verificar si el campo de contraseña está vacío.
				if(String.valueOf(pwdcontra.getPassword()).isEmpty()) {
					// Si es así, establecer un texto predeterminado para ocultar la contraseña.
					pwdcontra.setText("****************");
				}
			}
		});
		txtIngreseUsuario.setForeground(new Color(243, 235, 219));
		txtIngreseUsuario.setBackground(new Color(10, 27, 5));
		txtIngreseUsuario.setBorder(null);
		txtIngreseUsuario.setText("Ingrese su nombre de usuario");
		txtIngreseUsuario.setFont(new Font("Roboto Light", Font.PLAIN, 15));
		txtIngreseUsuario.setBounds(233, 334, 390, 22);
		panel.add(txtIngreseUsuario);
		txtIngreseUsuario.setColumns(10);
		
		JSeparator separator1 = new JSeparator();
		separator1.setBackground(new Color(243, 235, 219));
		separator1.setBounds(233, 366, 390, 8);
		panel.add(separator1);
		
		lblContrasea = new JLabel("Contraseña");
		lblContrasea.setForeground(new Color(243, 235, 219));
		lblContrasea.setFont(new Font("Roboto Medium", Font.PLAIN, 20));
		lblContrasea.setBounds(233, 384, 177, 24);
		panel.add(lblContrasea);
		
		JSeparator separator1_1 = new JSeparator();
		separator1_1.setBackground(new Color(243, 235, 219));
		separator1_1.setBounds(233, 450, 390, 8);
		panel.add(separator1_1);
		
		pwdcontra = new JPasswordField();
		pwdcontra.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
			    // Verificar si el campo de contraseña muestra el texto predeterminado.
			    if (String.valueOf(pwdcontra.getPassword()).equals("****************")) {
			        // Si es así, borrar el texto para que el usuario pueda ingresar la contraseña.
			        pwdcontra.setText("");
			    }
			    
			    // Verificar si el campo de usuario está vacío.
			    if (txtIngreseUsuario.getText().isEmpty()) {
			        // Si es así, establecer el texto predeterminado "Ingrese su nombre de usuario".
			        txtIngreseUsuario.setText("Ingrese su nombre de usuario");
			    }
			}
		});
		pwdcontra.setForeground(new Color(243, 235, 219));
		pwdcontra.setToolTipText("");
		pwdcontra.setFont(new Font("Roboto Light", Font.PLAIN, 15));
		pwdcontra.setBackground(new Color(10, 27, 5));
		pwdcontra.setText("****************");
		pwdcontra.setBounds(233, 418, 390, 22);
		pwdcontra.setBorder(null);
		panel.add(pwdcontra);
		
		panelEntrar = new JPanel();
		panelEntrar.setBackground(new Color(254, 250, 192));
		panelEntrar.setBounds(347, 576, 113, 33);
		panel.add(panelEntrar);
		panelEntrar.setLayout(null);
		
		lblEntrar = new JLabel("Entrar");
		lblEntrar.setBounds(0, 0, 113, 33);
		panelEntrar.add(lblEntrar);
		lblEntrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Color colorFondo = Color.green;
				panelEntrar.setBackground(colorFondo);
				lblEntrar.setForeground(Color.BLACK);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Color colorFondo = new Color(243, 235, 219);//155, 253, 202
				panelEntrar.setBackground(colorFondo);
				Color colorFondo2 = new Color(0, 64, 128);
				lblEntrar.setForeground(colorFondo2);
			}
			// Muesta un cuadro de diálogo informativo con los datos de inicio de sesión.
			@Override
			public void mouseClicked(MouseEvent e) {
				 javax.swing.JOptionPane.showMessageDialog(Login.this, "Te has logueado con Usuario: " + txtIngreseUsuario.getText() + " con la contraseña: " + String.valueOf(pwdcontra.getPassword()), "Información", javax.swing.JOptionPane.INFORMATION_MESSAGE);
				//Esto hay que cambiarlo para meter la función de la base de datos
				 if(txtIngreseUsuario.getText().equals("usuario") && String.valueOf(pwdcontra.getPassword()).equals("usuario")) {
					 setVisible(false);
					 VentanaPrincipal menu = new VentanaPrincipal();
					 menu.setVisible(true);
					 
				 } 
			}
		});
		
		
		lblEntrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEntrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // cursor que cuando pasa por encima cambia al icono de la mano en el raton.
		lblEntrar.setFont(new Font("Roboto", Font.PLAIN, 20));
		lblEntrar.setForeground(new Color(0, 64, 128));
		
		panelX = new JPanel();
		panelX.setBackground(new Color(10, 27, 5));
		panelX.setBounds(0, 0, 33, 45);
		panel.add(panelX);
		panelX.setLayout(null);
		
		
		JLabel lblX = new JLabel("X");
		
		//Eventos.botonX(lblX, panelX);
		
		/**lblX.addMouseListener(new MouseAdapter() {
			//mouseClick en un Jlabel ya que he quitado la barra superior.
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
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
		});*/
		lblX.setBounds(0, 0, 33, 45);
		panelX.add(lblX);
		lblX.setForeground(new Color(216, 200, 187));
		lblX.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // cursor que cuando pasa por encima cambia al icono de la mano en el raton.
		lblX.setFont(new Font("Roboto Black", Font.PLAIN, 20));
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		
		final JLabel lblNoTeSabes = new JLabel("No te sabes la contraseña? pincha aquí.");
		
		//Eventos.noTeSabesLaContrasenia(lblNoTeSabes);
		
		/*lblNoTeSabes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				javax.swing.JOptionPane.showMessageDialog(Login.this, "Usuario: usuario \n"
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
		});*/
		lblNoTeSabes.setHorizontalAlignment(SwingConstants.CENTER);
		lblNoTeSabes.setForeground(new Color(243, 235, 219));
		lblNoTeSabes.setFont(new Font("Roboto", Font.PLAIN, 12));
		lblNoTeSabes.setBounds(293, 468, 229, 33);
		panel.add(lblNoTeSabes);
		
		JSeparator separator1_1_1 = new JSeparator();
		separator1_1_1.setBackground(new Color(255, 255, 255));
		separator1_1_1.setBounds(302, 500, 217, 8);
		panel.add(separator1_1_1);
		
		final JPanel panel_ = new JPanel();
		panel_.setLayout(null);
		panel_.setBackground(new Color(10, 27, 5));
		panel_.setBounds(35, 0, 33, 45);
		panel.add(panel_);
		
		JLabel lbl_ = new JLabel("_");
		lbl_.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_.setBackground(Color.blue);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				setExtendedState(JFrame.ICONIFIED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Color colorFondo = new Color(10, 27, 5);
				panel_.setBackground(colorFondo);
			}
		});
		lbl_.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // cursor que cuando pasa por encima cambia al icono de la mano en el raton.
		lbl_.setForeground(new Color(216, 200, 187));
		lbl_.setFont(new Font("Roboto Black", Font.PLAIN, 20));
		lbl_.setBounds(0, 0, 33, 45);
		panel_.add(lbl_);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/imagenes/logo (1).png")));
		lblNewLabel.setBounds(293, 85, 240, 196);
		panel.add(lblNewLabel);
	}
}