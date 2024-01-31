package vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import controlador.ConsultasBD;
import controlador.Eventos;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import java.*;
import utiles.Texto;

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
	private KeyStroke atajo;
	
	private JLabel lblBack;
	
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
				// javax.swing.JOptionPane.showMessageDialog(Login.this, "Te has logueado con Usuario: " + txtIngreseUsuario.getText() + " con la contraseña: " + String.valueOf(pwdcontra.getPassword()), "Información", javax.swing.JOptionPane.INFORMATION_MESSAGE);
				//Esto hay que cambiarlo para meter la función de la base de datos
		
				if (ConsultasBD.consultarUsuario(txtIngreseUsuario.getText(), pwdcontra.getText())==true){
					((Login) SwingUtilities.getWindowAncestor(panelEntrar)).dispose();
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
		
		Eventos.botonX(lblX, panelX, this);
		
		lblX.setBounds(0, 0, 33, 45);
		panelX.add(lblX);
		lblX.setForeground(new Color(216, 200, 187));
		lblX.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // cursor que cuando pasa por encima cambia al icono de la mano en el raton.
		lblX.setFont(new Font("Roboto Black", Font.PLAIN, 20));
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		
		final JLabel lblNoTeSabes = new JLabel("Registrate aquí.");
		
		Eventos.noTeSabesLaContrasenia(lblNoTeSabes, this);
		
		lblNoTeSabes.setHorizontalAlignment(SwingConstants.CENTER);
		lblNoTeSabes.setForeground(new Color(243, 235, 219));
		lblNoTeSabes.setFont(new Font("Roboto", Font.PLAIN, 12));
		lblNoTeSabes.setBounds(398, 468, 113, 33);
		panel.add(lblNoTeSabes);
		
		JSeparator separator1_1_1 = new JSeparator();
		separator1_1_1.setBackground(new Color(255, 255, 255));
		separator1_1_1.setBounds(302, 493, 201, 8);
		panel.add(separator1_1_1);
		
		final JPanel panel_ = new JPanel();
		panel_.setLayout(null);
		panel_.setBackground(new Color(10, 27, 5));
		panel_.setBounds(35, 0, 33, 45);
		panel.add(panel_);
		
		JLabel lbl_ = new JLabel("_");
		
		Eventos.botonMinimiza(lbl_, panel_, this);
		
		lbl_.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // cursor que cuando pasa por encima cambia al icono de la mano en el raton.
		lbl_.setForeground(new Color(216, 200, 187));
		lbl_.setFont(new Font("Roboto Black", Font.PLAIN, 20));
		lbl_.setBounds(0, 0, 33, 45);
		panel_.add(lbl_);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(Login.class.getResource("/imagenes/logo (1).png")));
		lblLogo.setBounds(293, 85, 240, 196);
		panel.add(lblLogo);
		
		 lblBack = new JLabel("");
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
				ventanaPrincipal.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		lblBack.setIcon(new ImageIcon(Login.class.getResource("/imagenes/back-2_icon-icons.com_62858.png")));
		lblBack.setBounds(35, 564, 54, 53);
		panel.add(lblBack);
		
		JLabel lblNoTienesCuenta = new JLabel("¿No tienes cuenta?");
		lblNoTienesCuenta.setHorizontalAlignment(SwingConstants.CENTER);
		lblNoTienesCuenta.setForeground(new Color(243, 235, 219));
		lblNoTienesCuenta.setFont(new Font("Roboto", Font.PLAIN, 12));
		lblNoTienesCuenta.setBounds(297, 468, 113, 33);
		panel.add(lblNoTienesCuenta);
		
		//ToolTipText Login
		
				lblLogo.setToolTipText(Texto.toolLogo);
				txtIngreseUsuario.setToolTipText(Texto.toolUser);
				pwdcontra.setToolTipText(Texto.toolPass);
				lblNoTeSabes.setToolTipText(Texto.toolNewAccount);
				lblEntrar.setToolTipText(Texto.toolEntrar);
				lbl_.setToolTipText(Texto.toolMinimizar);
				lblX.setToolTipText(Texto.toolCerrar);
				lblBack.setToolTipText(Texto.toolVolver);
				
				//Atajos
				
				atajo = KeyStroke.getKeyStroke(KeyEvent.VK_T, KeyEvent.CTRL_DOWN_MASK);
		        getRootPane().registerKeyboardAction(new ActionListener() {
		            
		            public void actionPerformed(ActionEvent e) {
		            	VentanaPrincipal ventana = new VentanaPrincipal();
		                ventana.setVisible(true);
		                dispose();
		            }
		        }, atajo, JComponent.WHEN_IN_FOCUSED_WINDOW);
		
		
	}
}