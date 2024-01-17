package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Label;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
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
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1190, 557);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/fotillo.jpg")));
		lblNewLabel.setBounds(0, 23, 660, 495);
		contentPane.add(lblNewLabel);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 660, 22);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("New menu");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_1 = new JMenu("New menu");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("New menu item");
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("New menu item");
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_2 = new JMenu("New menu");
		menuBar.add(mnNewMenu_2);
		
		Button btnIniciarSesion = new Button("Iniciar Sesion");
		btnIniciarSesion.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnIniciarSesion.setBounds(774, 417, 131, 22);
		contentPane.add(btnIniciarSesion);
		
		Button btnRegister = new Button("Registrarse");
		btnRegister.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRegister.setBounds(983, 417, 131, 22);
		contentPane.add(btnRegister);
		
		Button btnSalir = new Button("Salir");
		btnSalir.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSalir.setBounds(860, 469, 187, 22);
		contentPane.add(btnSalir);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/logo (1).png")));
		lblNewLabel_1.setBounds(826, 0, 221, 204);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Bienvenido a Urban Stride, tu destino para zapatillas exclusivas y estilo inigualable! Sumérgete en el mundo de la moda urbana con nuestra amplia selección de calzado único que fusiona la comodidad con el diseño vanguardista.\r\n\r\nEn Urban Stride, no solo vendemos zapatillas; ofrecemos una experiencia. Cada par cuenta una historia de innovación y autenticidad, cuidadosamente seleccionado para satisfacer los gustos más exigentes.\r\n\r\nExplora nuestra colección y descubre la fusión perfecta entre la moda urbana y la funcionalidad. En Urban Stride, no solo caminas, ¡defines tu propio estilo con cada paso!\r\n\r\n¡Bienvenido a la revolución del calzado urbano! Urban Stride, donde la exclusividad y la moda se encuentran en cada esquina de la ciudad.");
		lblNewLabel_2.setBounds(670, 204, 499, 180);
		contentPane.add(lblNewLabel_2);
	}
}
