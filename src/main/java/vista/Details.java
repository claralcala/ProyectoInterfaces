package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ConsultasBD2;
import controlador.Eventos;
import modelo.Producto;
import utiles.Texto;


import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import java.awt.event.MouseEvent;

public class Details extends JFrame {
	
	private int id_producto;
	private int	id_user;
	private TiendaPrincipal vistaTienda;

	private Producto p;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JTextField textFieldCantidad;
	
	int cantidad;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
	    EventQueue.invokeLater(new Runnable() {
	        public void run() {
	            try {
	                // Pasa valores de id_producto e id_user al constructor
	                Details frame = new Details(123, 456,); // Reemplaza 123 y 456 con valores adecuados
	                frame.setVisible(true);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    });
	}
	*/

	/**
	 * Create the frame.
	 */

	
	public Details(final int id_user, Producto p , TiendaPrincipal vistaTienda) {
	
	}
	
	
		


	public Details(final int id_user, Producto p) {
		

		this.p=p;
		this.id_user = id_user; 
		this.vistaTienda = vistaTienda;
	

			
		
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 947, 757);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(10, 27, 5));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(274, 132, 128, 31);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblNewLabel);
		
		JLabel lblNombre = new JLabel();
		lblNombre.setBounds(526, 132, 331, 31);
		lblNombre.setForeground(new Color(255, 255, 255));
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNombre.setText(p.getNombre());
		lblNombre.setToolTipText(Texto.toolNameProduct); //Tool
		contentPane.add(lblNombre);
		
		JLabel lblNewLabel_2 = new JLabel("Description");
		lblNewLabel_2.setBounds(274, 193, 115, 31);
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblDescripcion = new JLabel();
		lblDescripcion.setBounds(526, 193, 331, 121);
		lblDescripcion.setForeground(new Color(255, 255, 255));
		lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDescripcion.setText("<html>" + p.getDescripcion() + "</html>");
		lblDescripcion.setToolTipText(Texto.toolDescriptionDetils);
		contentPane.add(lblDescripcion);
		
		JLabel lblNewLabel_4 = new JLabel("Stock");
		lblNewLabel_4.setBounds(274, 345, 69, 29);
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblNewLabel_4);
		
		JLabel lblStock = new JLabel();
		lblStock.setBounds(538, 347, 265, 25);
		lblStock.setForeground(new Color(255, 255, 255));
		lblStock.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblStock.setText(String.valueOf(p.getStock())  + " " + "Unidades disponibles");
		lblStock.setToolTipText(Texto.toolStock);
		contentPane.add(lblStock);
		
		JLabel lblNewLabel_6 = new JLabel("Precio");
		lblNewLabel_6.setBounds(271, 412, 72, 27);
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblNewLabel_6);
		
		JLabel lblPrecio = new JLabel();
		lblPrecio.setBounds(536, 413, 104, 25);
		lblPrecio.setForeground(new Color(255, 255, 255));
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPrecio.setText(String.valueOf(p.getPrecio()) + " " + "€");
		lblPrecio.setToolTipText(Texto.toolPrice);
		contentPane.add(lblPrecio);
		
		// Carga la imagen como un ImageIcon
        ImageIcon originalIcon = new ImageIcon(Details.class.getResource("/imagenes/" + p.getImagen()+".png"));

        // Escala la imagen al tamaño deseado
        Image scaledImage = originalIcon.getImage().getScaledInstance(210, 210, Image.SCALE_SMOOTH);

        // Crea un nuevo ImageIcon con la imagen escalada
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        
		JLabel lblImagen = new JLabel();
		lblImagen.setToolTipText(Texto.toolImage);
		lblImagen.setIcon(scaledIcon);
		lblImagen.setBounds(341, 463, 386, 226);
		lblImagen.setForeground(new Color(255, 255, 255));		
		contentPane.add(lblImagen);
		
		JLabel lblDetails = new JLabel("Detalles Producto");
		lblDetails.setBounds(0, 0, 931, 88);
		lblDetails.setForeground(new Color(255, 255, 255));
		lblDetails.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblDetails.setToolTipText(Texto.toolDetails);
		
		 lblDetails.setHorizontalAlignment(SwingConstants.CENTER); //Centrado del texto
		contentPane.add(lblDetails);
		JLabel lblCarrito = new JLabel("");
		lblCarrito.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String textoCant =  textFieldCantidad.getText().trim();
			if(textoCant.isEmpty()) {
				 JOptionPane.showMessageDialog(null, "Por favor, ingrese una cantidad.");
                 return; // Sale del método sin realizar más acciones
			}
			try {
				cantidad = Integer.parseInt(textoCant);
				System.out.println(p.getProduct_id());
				
				boolean result = ConsultasBD2.anadirProductoAlCarrito(id_user, p.getProduct_id(), cantidad);
				
				 JOptionPane.showMessageDialog(null, "¡Producto añadido al carrito!");
				
			}catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese una cantidad válida.");
            }
			}
		});
		
		lblCarrito.setToolTipText(Texto.toolCarrito);
		lblCarrito.setBackground(new Color(255, 255, 255));
		lblCarrito.setBounds(765, 573, 143, 116);
		contentPane.add(lblCarrito);
		
		
		ImageIcon icono = new ImageIcon(Details.class.getResource("/imagenes/carrito.png"));
		Image imagen = icono.getImage();
		Image nuevaImagen = imagen.getScaledInstance(128, 116, Image.SCALE_SMOOTH);
		lblCarrito.setIcon(new ImageIcon(nuevaImagen));

		JLabel btnBack = new JLabel("New label");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				
		    	
		    	vistaTienda.setVisible(true);
		    	dispose();
			}
		});

		btnBack.setToolTipText(Texto.toolBackDetails);
		btnBack.setIcon(new ImageIcon(Details.class.getResource("/imagenes/back-2_icon-icons.com_62858 (1).png")));
		btnBack.setBounds(30, 603, 64, 56);
		contentPane.add(btnBack);
		
		textFieldCantidad = new JTextField();
		textFieldCantidad.setBounds(831, 526, 57, 20);
		contentPane.add(textFieldCantidad);
		textFieldCantidad.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Cantidad");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(765, 532, 76, 14);
		lblNewLabel_3.setToolTipText(Texto.toolCant);
		contentPane.add(lblNewLabel_3);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(111, 99, 708, 2);
		contentPane.add(separator);
	}
}
