package vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Editar extends JFrame {

	
	private JPanel contentPane, panelX;
	
	private JTextField txtNombre, txtApellidos, txtCorreo, txtTelefono, txtDireccion, txtUsername, txtPassword;
	private KeyStroke atajo;
	
	
	private JLabel lblBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Editar frame = new Editar();
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
	public Editar() {
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
	}

}
