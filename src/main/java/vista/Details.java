package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.w3c.dom.events.MouseEvent;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class Details extends JFrame {
	
	private int id_producto;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Details(int id_producto) {
		
		this.id_producto= id_producto;
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 947, 757);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(10, 27, 5));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(274, 133, 128, 31);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblNewLabel);
		
		JLabel lblNombre = new JLabel();
		lblNombre.setBounds(526, 133, 174, 31);
		lblNombre.setForeground(new Color(255, 255, 255));
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNombre.setText("\"\"");
		lblNombre.setToolTipText("");
		contentPane.add(lblNombre);
		
		JLabel lblNewLabel_2 = new JLabel("Description");
		lblNewLabel_2.setBounds(274, 185, 115, 31);
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblDescripcion = new JLabel();
		lblDescripcion.setBounds(526, 187, 72, 26);
		lblDescripcion.setForeground(new Color(255, 255, 255));
		lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDescripcion.setText("\"\"");
		contentPane.add(lblDescripcion);
		
		JLabel lblNewLabel_4 = new JLabel("Stock");
		lblNewLabel_4.setBounds(274, 249, 69, 29);
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblNewLabel_4);
		
		JLabel lblStock = new JLabel();
		lblStock.setBounds(526, 251, 72, 25);
		lblStock.setForeground(new Color(255, 255, 255));
		lblStock.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblStock.setText("\"\"");
		contentPane.add(lblStock);
		
		JLabel lblNewLabel_6 = new JLabel("Precio");
		lblNewLabel_6.setBounds(274, 303, 72, 27);
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblNewLabel_6);
		
		JLabel lblPrecio = new JLabel();
		lblPrecio.setBounds(526, 304, 104, 25);
		lblPrecio.setForeground(new Color(255, 255, 255));
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPrecio.setText("\"\"");
		contentPane.add(lblPrecio);
		
		JLabel lblNewLabel_8 = new JLabel("Imagen");
		lblNewLabel_8.setBounds(274, 358, 90, 31);
		lblNewLabel_8.setForeground(new Color(255, 255, 255));
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblNewLabel_8);
		
		JLabel lblImagen = new JLabel();
		lblImagen.setBounds(526, 360, 115, 27);
		lblImagen.setForeground(new Color(255, 255, 255));
		lblImagen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblImagen.setText("\"\"");
		contentPane.add(lblImagen);
		
		JLabel lblDetails = new JLabel("Detalles Producto");
		lblDetails.setBounds(0, 0, 931, 88);
		lblDetails.setForeground(new Color(255, 255, 255));
		lblDetails.setFont(new Font("Tahoma", Font.BOLD, 36));
		 lblDetails.setHorizontalAlignment(SwingConstants.CENTER); //Centrado del texto
		contentPane.add(lblDetails);
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(765, 573, 143, 116);
		contentPane.add(lblNewLabel_1);

		// Código para redimensionar la imagen y establecerla en el JLabel
		ImageIcon icono = new ImageIcon(Details.class.getResource("/imagenes/carrito.png"));
		Image imagen = icono.getImage();
		Image nuevaImagen = imagen.getScaledInstance(128, 116, Image.SCALE_SMOOTH);
		lblNewLabel_1.setIcon(new ImageIcon(nuevaImagen));
		
		JLabel btnBack = new JLabel("New label");
		btnBack.setIcon(new ImageIcon(Details.class.getResource("/imagenes/back-2_icon-icons.com_62858 (1).png")));
		btnBack.setBounds(34, 603, 60, 56);
		contentPane.add(btnBack);
	

	}
}
