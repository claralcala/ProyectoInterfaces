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
import java.awt.event.MouseMotionAdapter;

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
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	int xMouse, yMouse;
	
	public Login() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 986, 615);
		
		setUndecorated(true);  // Quitar la barra de título y la decoración (barra superior del programa).
		
		contentPane = new JPanel();
		
		contentPane.setBackground(new Color(254, 250, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		
		panel.setBackground(new Color(30, 33, 57));
		panel.setBounds(0, 0, 986, 615);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblInicioSesion = new JLabel("INICIAR SESIÓN");
		lblInicioSesion.setHorizontalAlignment(SwingConstants.CENTER);
		lblInicioSesion.setForeground(new Color(243, 235, 219));
		lblInicioSesion.setFont(new Font("Roboto", Font.PLAIN, 23));
		lblInicioSesion.setBounds(371, 79, 226, 33);
		panel.add(lblInicioSesion);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setForeground(new Color(243, 235, 219));
		lblUsuario.setFont(new Font("Roboto Medium", Font.PLAIN, 20));
		lblUsuario.setBounds(274, 158, 177, 33);
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
		txtIngreseUsuario.setBackground(new Color(30, 33, 57));
		txtIngreseUsuario.setBorder(null);
		txtIngreseUsuario.setText("Ingrese su nombre de usuario");
		txtIngreseUsuario.setFont(new Font("Roboto Light", Font.PLAIN, 15));
		txtIngreseUsuario.setBounds(274, 201, 390, 22);
		panel.add(txtIngreseUsuario);
		txtIngreseUsuario.setColumns(10);
		
		JSeparator separator1 = new JSeparator();
		separator1.setBackground(new Color(155, 253, 202));
		separator1.setBounds(274, 233, 390, 8);
		panel.add(separator1);
		
		lblContrasea = new JLabel("Contraseña");
		lblContrasea.setForeground(new Color(243, 235, 219));
		lblContrasea.setFont(new Font("Roboto Medium", Font.PLAIN, 20));
		lblContrasea.setBounds(274, 251, 177, 24);
		panel.add(lblContrasea);
		
		JSeparator separator1_1 = new JSeparator();
		separator1_1.setBackground(new Color(155, 253, 202));
		separator1_1.setBounds(274, 317, 390, 8);
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
		pwdcontra.setBackground(new Color(30, 33, 57));
		pwdcontra.setText("****************");
		pwdcontra.setBounds(274, 285, 390, 22);
		pwdcontra.setBorder(null);
		panel.add(pwdcontra);
		
		panelEntrar = new JPanel();
		panelEntrar.setBackground(new Color(254, 250, 192));
		panelEntrar.setBounds(447, 523, 113, 33);
		panel.add(panelEntrar);
		panelEntrar.setLayout(null);
		
		lblEntrar = new JLabel("Entrar");
		lblEntrar.setBounds(0, 0, 113, 33);
		panelEntrar.add(lblEntrar);
		lblEntrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Color colorFondo = new Color(155, 253, 202);
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
		panelX.setBackground(new Color(30, 33, 57));
		panelX.setBounds(0, 0, 50, 45);
		panel.add(panelX);
		panelX.setLayout(null);
		
		
		JLabel lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
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
				Color colorFondo = new Color(55, 26, 44);
				panelX.setBackground(colorFondo);
			}
		});
		lblX.setBounds(0, 0, 50, 45);
		panelX.add(lblX);
		lblX.setForeground(new Color(216, 200, 187));
		lblX.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // cursor que cuando pasa por encima cambia al icono de la mano en el raton.
		lblX.setFont(new Font("Roboto Black", Font.PLAIN, 20));
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		
		final JLabel lblNoTeSabes = new JLabel("No te sabes la contraseña? pincha aquí.");
		lblNoTeSabes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				javax.swing.JOptionPane.showMessageDialog(Login.this, "Usuario: usuario \n"
						+ "Contrasenia: usuario ", "Informacion", javax.swing.JOptionPane.INFORMATION_MESSAGE);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				 lblNoTeSabes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				 lblNoTeSabes.setForeground(Color.cyan);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNoTeSabes.setForeground(new Color(216, 200, 187));
			}
		});
		lblNoTeSabes.setHorizontalAlignment(SwingConstants.CENTER);
		lblNoTeSabes.setForeground(new Color(243, 235, 219));
		lblNoTeSabes.setFont(new Font("Roboto", Font.PLAIN, 12));
		lblNoTeSabes.setBounds(371, 401, 229, 33);
		panel.add(lblNoTeSabes);
		
		JSeparator separator1_1_1 = new JSeparator();
		separator1_1_1.setBackground(new Color(255, 255, 255));
		separator1_1_1.setBounds(371, 426, 226, 8);
		panel.add(separator1_1_1);
	}
}