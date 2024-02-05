package vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controlador.ConsultasBD;
import modelo.Usuario;
import utiles.Texto;

public class Editar extends JFrame {

	int id_usuario;
	
	private JPanel contentPane, panelX;
	
	private JTextField txtNombre, txtApellidos, txtCorreo, txtTelefono, txtDireccion, txtUsername, txtPassword;
	private KeyStroke atajo;
	
	
	private JLabel lblBack;

	/**
	 * Launch the application.


	/**
	 * Create the frame.
	 */
	public Editar(int id_usuario) {
		
		this.id_usuario=id_usuario;
		
		 setResizable(false);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setBounds(100, 100, 1400, 700);

	        setUndecorated(true);

	        contentPane = new JPanel();
	        contentPane.setBackground(new Color(10, 27, 5));
	        
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	        setContentPane(contentPane);
	        contentPane.setLayout(null);

	        JPanel panel = new JPanel();
	        //panel.setBackground(new Color(30, 33, 57));
	        panel.setBackground(new Color(10, 27, 5));
	        panel.setBounds(0, 0, 1400, 700);
	        contentPane.add(panel);
	        panel.setLayout(null);

	        // 
	        
	        JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/imagenes/logo (1).png")));
			lblNewLabel.setBounds(1104, 399, 240, 196);
			panel.add(lblNewLabel);
	        
	        JLabel lblInicioSesion = new JLabel("EDITAR PERFIL");
			lblInicioSesion.setHorizontalAlignment(SwingConstants.CENTER);
			lblInicioSesion.setForeground(new Color(243, 235, 219));
			lblInicioSesion.setFont(new Font("Roboto", Font.PLAIN, 23));
			lblInicioSesion.setBounds(550, 30, 226, 33);
			panel.add(lblInicioSesion);
		
		panelX = new JPanel();
		panelX.setBackground(new Color(10, 27, 5));
		panelX.setBounds(0, 0, 33, 45);
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
				Color colorFondo = new Color(10, 27, 5);
				panelX.setBackground(colorFondo);
			}
		});
		lblX.setBounds(0, 0, 33, 45);
		panelX.add(lblX);
		lblX.setForeground(new Color(216, 200, 187));
		lblX.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // cursor que cuando pasa por encima cambia al icono de la mano en el raton.
		lblX.setFont(new Font("Roboto Black", Font.PLAIN, 20));
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		
		
		
		
		final JPanel panel_ = new JPanel();
		panel_.setLayout(null);
		panel_.setBackground(new Color(10, 27, 5));
		panel_.setBounds(35, 0, 33, 45);
		panel.add(panel_);
		
		JLabel lbl_ = new JLabel("_");
		lbl_.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_.setBackground(new Color(10, 27, 5));
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
		
		//Componentes de registro 
		
        JLabel lblNombre = new JLabel("Nombre");
        lblNombre.setForeground(new Color(243, 235, 219));
        lblNombre.setFont(new Font("Roboto Medium", Font.PLAIN, 20));
        lblNombre.setBounds(92, 122, 177, 24);
        panel.add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setForeground(new Color(243, 235, 219));
        txtNombre.setBackground(new Color(10, 27, 5));
        txtNombre.setBorder(null);
        txtNombre.setFont(new Font("Roboto Light", Font.PLAIN, 15));
        txtNombre.setBounds(279, 106, 390, 22);
        panel.add(txtNombre);
        txtNombre.setColumns(10);

        JSeparator separatorNombre = new JSeparator();
        separatorNombre.setBackground(new Color(155, 253, 202));
        separatorNombre.setBounds(279, 138, 390, 8);
        panel.add(separatorNombre);

        JLabel lblApellidos = new JLabel("Apellidos");
        lblApellidos.setForeground(new Color(243, 235, 219));
        lblApellidos.setFont(new Font("Roboto Medium", Font.PLAIN, 20));
        lblApellidos.setBounds(92, 195, 177, 24);
        panel.add(lblApellidos);

        txtApellidos = new JTextField();
        txtApellidos.setForeground(new Color(243, 235, 219));
        txtApellidos.setBackground(new Color(10, 27, 5));
        txtApellidos.setBorder(null);
        txtApellidos.setFont(new Font("Roboto Light", Font.PLAIN, 15));
        txtApellidos.setBounds(279, 179, 390, 22);
        panel.add(txtApellidos);
        txtApellidos.setColumns(10);

        JSeparator separatorApellidos = new JSeparator();
        separatorApellidos.setBackground(new Color(155, 253, 202));
        separatorApellidos.setBounds(279, 211, 390, 8);
        panel.add(separatorApellidos);

        JLabel lblCorreo = new JLabel("Correo Electrónico");
        lblCorreo.setForeground(new Color(243, 235, 219));
        lblCorreo.setFont(new Font("Roboto Medium", Font.PLAIN, 20));
        lblCorreo.setBounds(92, 266, 177, 24);
        panel.add(lblCorreo);

        txtCorreo = new JTextField();
        txtCorreo.setForeground(new Color(243, 235, 219));
        txtCorreo.setBackground(new Color(10, 27, 5));
        txtCorreo.setBorder(null);
        txtCorreo.setFont(new Font("Roboto Light", Font.PLAIN, 15));
        txtCorreo.setBounds(279, 269, 390, 22);
        panel.add(txtCorreo);
        txtCorreo.setColumns(10);

        JSeparator separatorCorreo = new JSeparator();
        separatorCorreo.setBackground(new Color(155, 253, 202));
        separatorCorreo.setBounds(279, 301, 390, 8);
        panel.add(separatorCorreo);

        JLabel lblTelefono = new JLabel("Teléfono");
        lblTelefono.setForeground(new Color(243, 235, 219));
        lblTelefono.setFont(new Font("Roboto Medium", Font.PLAIN, 20));
        lblTelefono.setBounds(92, 351, 177, 24);
        panel.add(lblTelefono);

        txtTelefono = new JTextField();
        txtTelefono.setForeground(new Color(243, 235, 219));
        txtTelefono.setBackground(new Color(10, 27, 5));
        txtTelefono.setBorder(null);
        txtTelefono.setFont(new Font("Roboto Light", Font.PLAIN, 15));
        txtTelefono.setBounds(279, 354, 390, 22);
        panel.add(txtTelefono);
        txtTelefono.setColumns(10);

        JSeparator separatorTelefono = new JSeparator();
        separatorTelefono.setBackground(new Color(155, 253, 202));
        separatorTelefono.setBounds(279, 386, 390, 8);
        panel.add(separatorTelefono);

        JLabel lblDireccion = new JLabel("Dirección");
        lblDireccion.setForeground(new Color(243, 235, 219));
        lblDireccion.setFont(new Font("Roboto Medium", Font.PLAIN, 20));
        lblDireccion.setBounds(751, 122, 110, 24);
        panel.add(lblDireccion);

        txtDireccion = new JTextField();
        txtDireccion.setForeground(new Color(243, 235, 219));
        txtDireccion.setBackground(new Color(10, 27, 5));
        txtDireccion.setBorder(null);
        txtDireccion.setFont(new Font("Roboto Light", Font.PLAIN, 15));
        txtDireccion.setBounds(871, 106, 390, 22);
        panel.add(txtDireccion);
        txtDireccion.setColumns(10);

        JSeparator separatorDireccion = new JSeparator();
        separatorDireccion.setBackground(new Color(155, 253, 202));
        separatorDireccion.setBounds(936, 224, 390, 8);
        panel.add(separatorDireccion);
        
        JLabel lblPassword = new JLabel("Contraseña");
        lblPassword.setForeground(new Color(243, 235, 219));
        lblPassword.setFont(new Font("Roboto Medium", Font.PLAIN, 20));
        lblPassword.setBounds(751, 266, 127, 24);
        panel.add(lblPassword);

        txtPassword = new JTextField();
        txtPassword.setForeground(new Color(243, 235, 219));
        txtPassword.setBackground(new Color(10, 27, 5));
        txtPassword.setBorder(null);
        txtPassword.setFont(new Font("Roboto Light", Font.PLAIN, 15));
        txtPassword.setBounds(878, 257, 390, 22);
        panel.add(txtPassword);
        txtUsername.setColumns(10);

        JSeparator separatorPassword = new JSeparator();
        separatorPassword.setBackground(new Color(155, 253, 202));
        separatorPassword.setBounds(858, 138, 390, 8);
        panel.add(separatorPassword);

        
        
        //botones para registrarse y volver
        JButton btnRegistrarse = new JButton("Registrarse");
        btnRegistrarse.setBackground(new Color(254, 250, 192));
        btnRegistrarse.setBounds(606, 552, 220, 33);
        panel.add(btnRegistrarse);
        btnRegistrarse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	Usuario u = new Usuario();
            	
            	u.setUsername(txtUsername.getText());
            	u.setContrasena(txtPassword.getText());
            	u.setCorreo_electronico(txtCorreo.getText());
            	u.setDireccion(txtDireccion.getText());
            	u.setNombre(txtNombre.getText());
            	u.setApellidos(txtApellidos.getText());
            	u.setTelefono(txtTelefono.getText());
            	
            	ConsultasBD.guardarUsuario(u);
            	borrarCampos();
            	
                
            }
        });

       
        
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
		lblBack.setBounds(35, 532, 54, 53);
		panel.add(lblBack);

        
        
      //TooltipText Registro
        txtNombre.setToolTipText(Texto.toolName);
        txtApellidos.setToolTipText(Texto.toolSurnames);
        txtCorreo.setToolTipText(Texto.toolEmail);
        txtTelefono.setToolTipText(Texto.toolPhone);
        txtDireccion.setToolTipText(Texto.toolAdress);
        txtUsername.setToolTipText(Texto.toolNameUser);
        txtPassword.setToolTipText(Texto.toolPass);
        lblNewLabel.setToolTipText(Texto.toolLogo);
        lblX.setToolTipText(Texto.toolCerrar);
        lbl_.setToolTipText(Texto.toolMinimizar);
        btnRegistrarse.setToolTipText(Texto.toolBotonRegister);
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
	
	public void borrarCampos(){
		txtUsername.setText("");
		txtNombre.setText("");
		txtApellidos.setText("");
		txtPassword.setText("");
		txtCorreo.setText("");
		txtTelefono.setText("");
		txtDireccion.setText("");
		
	}
	

}
