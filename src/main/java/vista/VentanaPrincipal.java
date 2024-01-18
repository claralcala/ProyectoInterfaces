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
import utiles.Texto;



public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private Login login = new Login ();
	private Registro registro = new Registro();	
	private static VentanaPrincipal frame;
	 
	 private JMenuItem menuIniciarSesion, menuRegistro;
	 
	 KeyStroke keyStroke, keyStroke2;
	 
	 JButton btnRegister, btnIniciarSesion;
	 




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
		
		
		keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_DOWN_MASK);
        getRootPane().registerKeyboardAction(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                login.setVisible(true);
                dispose();
            }
        }, keyStroke, JComponent.WHEN_IN_FOCUSED_WINDOW);
        
        keyStroke2 = KeyStroke.getKeyStroke(KeyEvent.VK_W, KeyEvent.CTRL_DOWN_MASK);
        getRootPane().registerKeyboardAction(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                registro.setVisible(true);
                dispose();
            }
        }, keyStroke2, JComponent.WHEN_IN_FOCUSED_WINDOW);
        
        KeyStroke keyStroke3 = KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_DOWN_MASK);
        getRootPane().registerKeyboardAction(new ActionListener() {
           
            public void actionPerformed(ActionEvent e) {
		        UIManager.put("OptionPane.yesButtonText", "Sí");
		        UIManager.put("OptionPane.noButtonText", "No");

		        int result = JOptionPane.showConfirmDialog(VentanaPrincipal.this,
		                "¿Estás seguro de que quieres salir de la aplicación?", "Confirmar cierre", JOptionPane.YES_NO_OPTION);

		        if (result == JOptionPane.YES_OPTION) {
		  
		            dispose();
		        }
		    }
        }, keyStroke3, JComponent.WHEN_IN_FOCUSED_WINDOW);
    
    
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/fotillo.jpg")));
		lblNewLabel.setBounds(0, 63, 660, 495);
		contentPane.add(lblNewLabel);
		
		lblNewLabel.setToolTipText(Texto.toolImg);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(10, 27, 5));
		menuBar.setBounds(0, 0, 660, 37);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Sesion");
		mnNewMenu.setForeground(new Color(255, 255, 255));
		menuBar.add(mnNewMenu);
		
		mnNewMenu.setToolTipText(Texto.toolMenu);
		
		menuIniciarSesion = new JMenuItem("Iniciar Sesion");
		mnNewMenu.add(menuIniciarSesion);
		
		menuIniciarSesion.setToolTipText(Texto.toolIncioSesion);

		menuIniciarSesion.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	
		    	if(e.getSource() == menuIniciarSesion) {
					login.setVisible(true);
					dispose();
					
				}
		   
		    }
		});

		
		
		 menuRegistro = new JMenuItem("Registrarse");
		mnNewMenu.add(menuRegistro);
		
		menuRegistro.setToolTipText(Texto.toolRegistro);
		
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
		
		menuSalir.setToolTipText(Texto.toolSalir);
		
		menuSalir.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
			        UIManager.put("OptionPane.yesButtonText", "Sí");
			        UIManager.put("OptionPane.noButtonText", "No");

			        int result = JOptionPane.showConfirmDialog(VentanaPrincipal.this,
			                "¿Estás seguro de que quieres salir de la aplicación?", "Confirmar cierre", JOptionPane.YES_NO_OPTION);

			        if (result == JOptionPane.YES_OPTION) {
			  
			            dispose();
			        }
			    }
		});
		
		
		JMenu mnNewMenu_2 = new JMenu("Version");
		mnNewMenu_2.setForeground(new Color(255, 255, 255));
		menuBar.add(mnNewMenu_2);
		
		mnNewMenu_2.setToolTipText(Texto.toolVersion2);
		
		JLabel lblVersion = new JLabel("<html>La aplicación <b>URBAN STRIDE</b> se encuentra en la versión 1.0</html>");
		mnNewMenu_2.add(lblVersion);
		
		
		lblVersion.setToolTipText(Texto.toolVersion);
		
		JMenu menuAtajos = new JMenu("Atajos");
		menuAtajos.setForeground(new Color(255, 255, 255));
		menuBar.add(menuAtajos);
		
		JLabel lblNewLabel_3 = new JLabel("<html>Iniciar Sesion -- CTRL IZQ + Q <br> Registro -- CTRL IZQ + W <br> Salir -- CTRL IZQ + E</html>");
		menuAtajos.add(lblNewLabel_3);
		
		btnIniciarSesion = new JButton("Iniciar Sesion");
		btnIniciarSesion.setFont(new Font("Dialog", Font.PLAIN, 14));

		btnIniciarSesion.setToolTipText(Texto.toolIncioSesion);

		btnIniciarSesion.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (e.getSource() == btnIniciarSesion) {
		            login.setVisible(true);
		            dispose();
		        }
		    }
		});

		btnIniciarSesion.setBounds(745, 434, 165, 42);
		contentPane.add(btnIniciarSesion);

		
		btnRegister = new JButton("Registrarse");
		btnRegister.setFont(new Font("Dialog", Font.PLAIN, 14));
		
		btnRegister.setToolTipText(Texto.toolRegistro);
		
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource() == btnRegister) {
					registro.setVisible(true);
					dispose();
				}
				
			}
		});
		
		btnRegister.setBounds(992, 434, 165, 42);
		contentPane.add(btnRegister);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnSalir.setToolTipText(Texto.toolSalir);


		btnSalir.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        UIManager.put("OptionPane.yesButtonText", "Sí");
		        UIManager.put("OptionPane.noButtonText", "No");

		        int result = JOptionPane.showConfirmDialog(VentanaPrincipal.this,
		                "¿Estás seguro de que quieres salir de la aplicación?", "Confirmar cierre", JOptionPane.YES_NO_OPTION);

		        if (result == JOptionPane.YES_OPTION) {
		  
		            dispose();
		        }
		    }
		});
		btnSalir.setBounds(827, 498, 243, 37);
		contentPane.add(btnSalir);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/logo (1).png")));
		
		lblNewLabel_1.setToolTipText(Texto.toolLogo);
		
		lblNewLabel_1.setBounds(834, 0, 221, 195);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("<html>Bienvenido a Urban Stride, tu destino para zapatillas exclusivas y estilo inigualable! Sumérgete en el mundo de la moda urbana con nuestra amplia selección de calzado único que fusiona la comodidad con el diseño vanguardista.<br><br>En Urban Stride, no solo vendemos zapatillas; ofrecemos una experiencia. Cada par cuenta una historia de innovación y autenticidad, cuidadosamente seleccionado para satisfacer los gustos más exigentes.<br><br>Explora nuestra colección y descubre la fusión perfecta entre la moda urbana y la funcionalidad. En Urban Stride, no solo caminas, ¡defines tu propio estilo con cada paso!<br><br>¡Bienvenido a la revolución del calzado urbano! Urban Stride, donde la exclusividad y la moda se encuentran en cada esquina de la ciudad.</html>");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(715, 193, 499, 222);
		lblNewLabel_2.setToolTipText(Texto.toolDescripcion);
		
		contentPane.add(lblNewLabel_2);
		
		
		
		
		

	}
}
