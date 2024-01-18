package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Label;
import java.awt.Color;



public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private Login login = new Login ();
	private Registro registro = new Registro();	
	 private static VentanaPrincipal frame;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1261, 558);
		contentPane = new JPanel();
		
		contentPane.setBackground(new Color(10, 27, 5));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		KeyStroke keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_DOWN_MASK);
        getRootPane().registerKeyboardAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login.setVisible(true);
                dispose();
            }
        }, keyStroke, JComponent.WHEN_IN_FOCUSED_WINDOW);
        
        KeyStroke keyStroke2 = KeyStroke.getKeyStroke(KeyEvent.VK_W, KeyEvent.CTRL_DOWN_MASK);
        getRootPane().registerKeyboardAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registro.setVisible(true);
                dispose();
            }
        }, keyStroke2, JComponent.WHEN_IN_FOCUSED_WINDOW);
        
        KeyStroke keyStroke3 = KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_DOWN_MASK);
        getRootPane().registerKeyboardAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
		        UIManager.put("OptionPane.yesButtonText", "Sí");
		        UIManager.put("OptionPane.noButtonText", "No");

		        int result = JOptionPane.showConfirmDialog(frame,
		                "¿Estás seguro de que quieres salir de la aplicación?", "Confirmar cierre", JOptionPane.YES_NO_OPTION);

		        if (result == JOptionPane.YES_OPTION) {
		  
		            frame.dispose();
		        }
		    }
        }, keyStroke3, JComponent.WHEN_IN_FOCUSED_WINDOW);
    
    
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/fotillo.jpg")));
		lblNewLabel.setBounds(0, 63, 660, 495);
		contentPane.add(lblNewLabel);
		
		lblNewLabel.setToolTipText("Imagen de la tienda oficial de Urban Stride");
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(10, 27, 5));
		menuBar.setBounds(0, 0, 660, 37);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Sesion");
		mnNewMenu.setForeground(new Color(255, 255, 255));
		menuBar.add(mnNewMenu);
		
		mnNewMenu.setToolTipText("Menu para realizar diferentes acciones");
		
		JMenuItem menuIniciarSesion = new JMenuItem("Iniciar Sesion");
		mnNewMenu.add(menuIniciarSesion);
		
		menuIniciarSesion.setToolTipText("Boton que te llevará a la ventana para poder iniciar sesion en Urban Stride");

		menuIniciarSesion.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	
		    	if(e.getSource() == menuIniciarSesion) {
					login.setVisible(true);
					dispose();
					
				}
		   
		    }
		});

		
		
		JMenuItem menuRegistro = new JMenuItem("Registrarse");
		mnNewMenu.add(menuRegistro);
		
		menuRegistro.setToolTipText("Boton que te llevará al registro en Urban Stride");
		
		menuRegistro.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	
		    	
				if(e.getSource() == menuRegistro) {
					registro.setVisible(true);
					dispose();
				}
		   
		    }
		});
		
		JMenuItem menuSalir = new JMenuItem("Salir");
		mnNewMenu.add(menuSalir);
		
		menuSalir.setToolTipText("Boton para cerrar la aplicacion de Urban Stride");
		
		menuSalir.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
			        UIManager.put("OptionPane.yesButtonText", "Sí");
			        UIManager.put("OptionPane.noButtonText", "No");

			        int result = JOptionPane.showConfirmDialog(frame,
			                "¿Estás seguro de que quieres salir de la aplicación?", "Confirmar cierre", JOptionPane.YES_NO_OPTION);

			        if (result == JOptionPane.YES_OPTION) {
			  
			            frame.dispose();
			        }
			    }
		});
		
		
		JMenu mnNewMenu_2 = new JMenu("Version");
		mnNewMenu_2.setForeground(new Color(255, 255, 255));
		menuBar.add(mnNewMenu_2);
		
		mnNewMenu_2.setToolTipText("Version en la que se encuentra Urban Stride");
		
		JLabel lblVersion = new JLabel("<html>La aplicación <b>URBAN STRIDE</b> se encuentra en la versión 1.0</html>");
		mnNewMenu_2.add(lblVersion);
		
		
		lblVersion.setToolTipText("Version actual de Urban Stride");
		
		JMenu menuAtajos = new JMenu("Atajos");
		menuAtajos.setForeground(new Color(255, 255, 255));
		menuBar.add(menuAtajos);
		
		JLabel lblNewLabel_3 = new JLabel("<html>Iniciar Sesion -- CTRL IZQ + Q <br> Registro -- CTRL IZQ + W <br> Salir -- CTRL IZQ + E</html>");
		menuAtajos.add(lblNewLabel_3);
		
		JButton btnIniciarSesion = new JButton("Iniciar Sesion");
		btnIniciarSesion.setFont(new Font("Dialog", Font.PLAIN, 14));

		btnIniciarSesion.setToolTipText("Botón que te llevará a la ventana para poder iniciar sesión en Urban Stride");

		btnIniciarSesion.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (e.getSource() == btnIniciarSesion) {
		            login.setVisible(true);
		            dispose();
		        }
		    }
		});

		btnIniciarSesion.setBounds(776, 434, 131, 22);
		contentPane.add(btnIniciarSesion);

		
		JButton btnRegister = new JButton("Registrarse");
		btnRegister.setFont(new Font("Dialog", Font.PLAIN, 14));
		
		btnRegister.setToolTipText("Boton que te llevará al registro en Urban Stride");
		
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource() == btnRegister) {
					registro.setVisible(true);
					dispose();
				}
				
			}
		});
		btnRegister.setBounds(986, 434, 131, 22);
		contentPane.add(btnRegister);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnSalir.setToolTipText("Botón para cerrar la aplicación de Urban Stride");


		btnSalir.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        UIManager.put("OptionPane.yesButtonText", "Sí");
		        UIManager.put("OptionPane.noButtonText", "No");

		        int result = JOptionPane.showConfirmDialog(frame,
		                "¿Estás seguro de que quieres salir de la aplicación?", "Confirmar cierre", JOptionPane.YES_NO_OPTION);

		        if (result == JOptionPane.YES_OPTION) {
		  
		            frame.dispose();
		        }
		    }
		});
		btnSalir.setBounds(868, 487, 187, 22);
		contentPane.add(btnSalir);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/logo (1).png")));
		
		lblNewLabel_1.setToolTipText("Logotipo de Urban Stride");
		
		lblNewLabel_1.setBounds(834, 0, 221, 195);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("<html>Bienvenido a Urban Stride, tu destino para zapatillas exclusivas y estilo inigualable! Sumérgete en el mundo de la moda urbana con nuestra amplia selección de calzado único que fusiona la comodidad con el diseño vanguardista.<br><br>En Urban Stride, no solo vendemos zapatillas; ofrecemos una experiencia. Cada par cuenta una historia de innovación y autenticidad, cuidadosamente seleccionado para satisfacer los gustos más exigentes.<br><br>Explora nuestra colección y descubre la fusión perfecta entre la moda urbana y la funcionalidad. En Urban Stride, no solo caminas, ¡defines tu propio estilo con cada paso!<br><br>¡Bienvenido a la revolución del calzado urbano! Urban Stride, donde la exclusividad y la moda se encuentran en cada esquina de la ciudad.</html>");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(715, 193, 499, 222);
		lblNewLabel_2.setToolTipText("Descripcion de lo que trata Urban Stride");
		
		contentPane.add(lblNewLabel_2);
		
		
		
		
		

	}
}
