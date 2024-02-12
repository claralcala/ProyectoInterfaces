package vista;

import java.util.ArrayList;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ConsultasBD2;
import controlador.Eventos;
import modelo.Producto;

import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Carrito extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ArrayList<Producto> carrito;
	int id_usuario;

//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Carrito frame = new Carrito();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	
	/**
	 * 
	 * @param carrito
	 * @param cantidad
	 */
	public Carrito(final int id_usuario) {
		this.id_usuario = id_usuario;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 852, 567);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(10, 27, 5));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbTotal = new JLabel("precio:");
		lbTotal.setHorizontalAlignment(SwingConstants.LEFT);
		lbTotal.setForeground(Color.WHITE);
		lbTotal.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbTotal.setBounds(10, 50, 260, 123);
		contentPane.add(lbTotal);
		
		carrito = ConsultasBD2.obtenerProductosDelCarrito(id_usuario);
		
		double precioProducto = 0.0;
		double totalCuenta = 0.0;
		
		// Iterar sobre las entradas del HashMap y mostrar la información
        int y = 50; // Posición inicial en el eje Y
        for (Producto carrito : carrito) {
        	
            // obtengo datos.
        	int id_producto = carrito.getProduct_id();
            String productoNombre = carrito.getNombre();
            int cantidad = carrito.getCantidad();
            double precio = carrito.getPrecio();
            //precio
            precioProducto = cantidad * precio;
            totalCuenta += precioProducto;
            
            String precioTexto = String.valueOf(precioProducto);

            // Crear JLabels para mostrar el nombre del producto
            JLabel labelProducto = new JLabel(productoNombre);
            labelProducto.setBounds(20, y, 502, 30);
            labelProducto.setBackground(new Color(10, 27, 5));
            labelProducto.setForeground(new Color(255, 255, 255));
            labelProducto.setFont(new Font("Tahoma", Font.BOLD, 20));
            contentPane.add(labelProducto);

            JLabel labelPrecio = new JLabel(precioTexto + "€");
            labelPrecio.setBounds(250, y, 502, 30);
            labelPrecio.setBackground(new Color(10, 27, 5));
            labelPrecio.setForeground(new Color(255, 255, 255));
            labelPrecio.setFont(new Font("Tahoma", Font.BOLD, 20));
            contentPane.add(labelPrecio);
           
            JLabel labelCantidad = new JLabel("+ " + String.valueOf(cantidad));
            labelCantidad.setBounds(330, y, 502, 30);
            labelCantidad.setBackground(new Color(10, 27, 5));
            labelCantidad.setForeground(new Color(255, 255, 255));
            labelCantidad.setFont(new Font("Tahoma", Font.BOLD, 20));
            contentPane.add(labelCantidad);
            
            JButton btnDelete = new JButton("Delete");
    		btnDelete.addMouseListener(new MouseAdapter() {
    			@Override
    			public void mouseClicked(MouseEvent e) {
    				if(cantidad > 1) {
    					int cantidadBorrada = cantidad - 1;
    					ConsultasBD2.anadirProductoAlCarrito(id_usuario, id_producto, cantidadBorrada);
    				}
    			}
    		});
    		btnDelete.setBounds(360, y, 85, 21);
    		contentPane.add(btnDelete);
            
            // Actualizar la posición en el eje Y para la siguiente entrada
            y += 30;
            
        }
        y += 50; //bajo un poco la estructura del label del precio total.
        
        lbTotal.setText("Precio total: " + String.valueOf(totalCuenta) + "€");
        lbTotal.setBounds(20, y, 250, 30);
        
        JLabel lblBack = new JLabel("");

		Eventos.btnBack(lblBack, this, id_usuario);

		lblBack.setIcon(new ImageIcon(Login.class.getResource("/imagenes/back-2_icon-icons.com_62858.png")));
		lblBack.setBounds(39, 448, 54, 53);
		contentPane.add(lblBack);
		
	}
}
