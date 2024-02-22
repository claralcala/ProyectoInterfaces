package vista;

import java.util.ArrayList;

import javax.security.auth.Refreshable;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ConsultasBD2;
import controlador.ConsultasBD3;
import controlador.Eventos;
import modelo.Producto;

import javax.swing.JLabel;

import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;

import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;

public class Carrito extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ArrayList<Producto> carrito;
	private ArrayList<Producto> productosCarrito;
	static int id_usuario;
	private JTextField textField;
	private JLabel searchLabel, labelProducto, labelPrecio, labelCantidad, resultadoBuscar, resultadoBuscar2,
			resultadoBuscar3;
	private JLabel lbTotal;
	public static JLabel lblComprar = new JLabel("Comprar");
	private ConsultasBD3 consultasBD3;
	private ConsultasBD2 consultasBD2;
	
	private JTextField textField1; // Nuevo campo de texto
	private JTextField textField2; // Nuevo campo de texto

	/**
	 * 
	 * @param carrito
	 * @param cantidad
	 */
	public Carrito(final int id_usuario) {
		this.id_usuario = id_usuario;
		lblComprar = new JLabel("Comprar");
		setUndecorated(true); // Quitar la barra de título y la decoración (barra superior del programa).

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 989, 570);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(10, 27, 5));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lbTotal = new JLabel("precio:");
		lbTotal.setHorizontalAlignment(SwingConstants.LEFT);
		lbTotal.setForeground(Color.WHITE);
		lbTotal.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbTotal.setBounds(10, 50, 260, 123);
		contentPane.add(lbTotal);

		carrito = ConsultasBD2.obtenerProductosDelCarrito(id_usuario);

		double totalCuenta = 0.0;

		int y = 70; // Posición inicial en el eje Y
		for (Producto carrito : carrito) {

			// obtengo datos.
			final int id_producto = carrito.getProduct_id();
			String productoNombre = carrito.getNombre();
			int cantidad = carrito.getCantidad();
			double precio = carrito.getPrecio();

			// Ajustes de precios
			totalCuenta += calcularPrecioProducto(cantidad, precio);
			
			String precioTexto = String.valueOf(precio);

			// Crear JLabels para mostrar el nombre del producto
			labelProducto = new JLabel(productoNombre);
			labelProducto.setBounds(20, y, 502, 30);
			labelProducto.setBackground(new Color(10, 27, 5));
			labelProducto.setForeground(new Color(243, 235, 219));
			labelProducto.setFont(new Font("Roboto Medium", Font.PLAIN, 15));
			contentPane.add(labelProducto);

			labelPrecio = new JLabel(precioTexto + "€");
			labelPrecio.setBounds(300, y, 502, 30);
			labelPrecio.setBackground(new Color(10, 27, 5));
			labelPrecio.setForeground(new Color(243, 235, 219));
			labelPrecio.setFont(new Font("Roboto Medium", Font.PLAIN, 15));
			contentPane.add(labelPrecio);

			labelCantidad = new JLabel("+ " + String.valueOf(cantidad));
			labelCantidad.setBounds(390, y, 502, 30);
			labelCantidad.setBackground(new Color(10, 27, 5));
			labelCantidad.setForeground(new Color(243, 235, 219));
			labelCantidad.setFont(new Font("Roboto Medium", Font.PLAIN, 15));
			contentPane.add(labelCantidad);

			JButton btnDelete = new JButton("Delete");
			btnDelete.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					ConsultasBD3.eliminarProductoDelCarrito(id_usuario, id_producto);
					dispose(); // Cierra la ventana actual
					Carrito nuevaVentanaCarrito = new Carrito(id_usuario); // Crea una nueva instancia de la ventana del
																			// carrito
					nuevaVentanaCarrito.setVisible(true);
				}
			});
			btnDelete.setBounds(470, y, 75, 30);
			btnDelete.setFont(new Font("Roboto Medium", Font.BOLD, 12));
			btnDelete.setBackground(Color.red);
			contentPane.add(btnDelete);

			// Actualizar la posición en el eje Y para la siguiente entrada
			y += 30;

		}
		y += 50; // bajo un poco la estructura del label del precio total.

		lbTotal.setText("Precio total: " + String.valueOf(totalCuenta) + "€");
		lbTotal.setBounds(20, y, 250, 30);
		lbTotal.setForeground(new Color(243, 235, 219));
		JLabel lblBack = new JLabel("");

		Eventos.btnBack(lblBack, this, id_usuario);

		lblBack.setIcon(new ImageIcon(Login.class.getResource("/imagenes/back-2_icon-icons.com_62858.png")));
		lblBack.setBounds(39, 448, 54, 53);
		contentPane.add(lblBack);

		agregarBotonComprar(contentPane);

		JLabel img = new JLabel("");
		img.setIcon(new ImageIcon(Carrito.class.getResource("/imagenes/logo (1).png")));
		img.setBounds(650, 230, 225, 210);
		contentPane.add(img);

		final JPanel panelX = new JPanel();
		panelX.setBounds(0, 0, 33, 45);
		contentPane.add(panelX);
		panelX.setBackground(new Color(10, 27, 5));
		panelX.setLayout(null);

		JLabel lblX = new JLabel("X");
		lblX.setBounds(0, 0, 33, 45);
		panelX.add(lblX);
		lblX.setToolTipText("Haz clic para cerrar la aplicacion");
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setForeground(new Color(216, 200, 187));
		lblX.setFont(new Font("Roboto Black", Font.PLAIN, 20));
		lblX.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblX.addMouseListener(new MouseAdapter() {
			// mouseClick en un Jlabel ya que he quitado la barra superior.
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}

			// mouseClick segundo evento que hago que se ponga de color rojo cuando el raton
			// pasa por encima.
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

		final JPanel panel_ = new JPanel();
		panel_.setLayout(null);
		panel_.setBounds(32, 0, 33, 45);
		panel_.setBackground(new Color(10, 27, 5));
		contentPane.add(panel_);

		JLabel lbl_ = new JLabel("_");
		lbl_.setBounds(0, 0, 33, 45);
		panel_.add(lbl_);
		lbl_.setToolTipText("Haz clic para minimizar la aplicacion");
		lbl_.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_.setForeground(new Color(216, 200, 187));
		lbl_.setFont(new Font("Roboto Black", Font.PLAIN, 20));

		lbl_.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_.setBackground(Color.blue);
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

		textField = new JTextField(20);
		textField.setBackground(new Color(254, 250, 192));
		textField.setToolTipText("Búsqueda por nombre del producto en el carrito (contiene palabra introducida)");
		textField.setBounds(674, 20, 166, 19);
		contentPane.add(textField);

		searchLabel = new JLabel();
		searchLabel.setIcon(new ImageIcon(Carrito.class.getResource("/imagenes/lupadef.png")));
		searchLabel.setToolTipText("Pulsa para buscar");
		searchLabel.setBounds(845, 15, 30, 30);
		contentPane.add(searchLabel);
		searchLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				buscarYMostrarProductos();

			}
		});
	}

	public void buscarYMostrarProductos() {//test realizado
		String nombreABuscar = textField.getText();

		// Elimina los campos de texto anteriores (si es necesario)
		if (resultadoBuscar != null) {
		contentPane.remove(resultadoBuscar);
	}
		if (resultadoBuscar2 != null) {
			contentPane.remove(resultadoBuscar2);
		}
		if (resultadoBuscar3 != null) {
			contentPane.remove(resultadoBuscar3);
		}

		productosCarrito = ConsultasBD3.buscarProductosEnCarritoPorNombre(id_usuario, nombreABuscar);
		
		int y = 70;
		
		for (Producto pro : productosCarrito) {
			
			System.out.println(pro.getNombre() + "  " + pro.getPrecio());
			
			resultadoBuscar = new JLabel(pro.getNombre());
			resultadoBuscar.setBounds(590, y, 502, 30); 
			resultadoBuscar.setBackground(new Color(10, 27, 5));
			resultadoBuscar.setForeground(new Color(243, 235, 219));
			resultadoBuscar.setFont(new Font("Roboto Medium", Font.PLAIN, 15));

			String cantidad = String.valueOf(pro.getPrecio());
			resultadoBuscar2 = new JLabel(cantidad);
			resultadoBuscar2.setBounds(770, y, 502, 30);
			resultadoBuscar2.setBackground(new Color(10, 27, 5));
			resultadoBuscar2.setForeground(new Color(243, 235, 219));
			resultadoBuscar2.setFont(new Font("Roboto Medium", Font.PLAIN, 15));

			contentPane.add(resultadoBuscar);
			contentPane.add(resultadoBuscar2);
			
			// Actualizar la posición en el eje Y para la siguiente entrada
			y += 30;
			
		}

		// Vuelve a pintar el panel para que los cambios sean visibles
		contentPane.revalidate();
		contentPane.repaint();
	}
	// Método para calcular el precio total de un producto
    public double calcularPrecioProducto(int cantidad, double precioUnitario) {
        return cantidad * precioUnitario;
    }
 // Método para agregar un producto al carrito
    public void agregarProducto(Producto producto) {
        carrito.add(producto);
        // Aquí podrías agregar lógica adicional, como actualizar la interfaz de usuario
    }

    // Método para eliminar un producto del carrito
    public void eliminarProducto(Producto producto) {
        carrito.remove(producto);
        // Aquí podrías agregar lógica adicional, como actualizar la interfaz de usuario
    }

    // Método para obtener la lista de productos del carrito
    public ArrayList<Producto> getCarrito() {
        return carrito;
    }
    
	public Carrito(final int id_usuario, ConsultasBD3 consultasBD3) {
        this.id_usuario = id_usuario;
        this.consultasBD3 = consultasBD3;
        lblComprar = new JLabel("Comprar");
    }

	 public void obtenerProductoDelCarrito() {
		 carrito = ConsultasBD2.obtenerProductosDelCarrito(id_usuario);

			double precioProducto = 0.0;
			int y = 70; // Posición inicial en el eje Y
			for (Producto carrito : carrito) {

				// obtengo datos.
				final int id_producto = carrito.getProduct_id();
				String productoNombre = carrito.getNombre();
				int cantidad = carrito.getCantidad();
				double precio = carrito.getPrecio();

				// Ajustes de precios
				precioProducto = calcularPrecioProducto(cantidad, precio);
				String precioTexto = String.valueOf(precioProducto);

				// Crear JLabels para mostrar el nombre del producto
				labelProducto = new JLabel(productoNombre);
				labelProducto.setBounds(20, y, 502, 30);
				labelProducto.setBackground(new Color(10, 27, 5));
				labelProducto.setForeground(new Color(243, 235, 219));
				labelProducto.setFont(new Font("Roboto Medium", Font.PLAIN, 15));
				contentPane.add(labelProducto);

				labelPrecio = new JLabel(precioTexto + "€");
				labelPrecio.setBounds(300, y, 502, 30);
				labelPrecio.setBackground(new Color(10, 27, 5));
				labelPrecio.setForeground(new Color(243, 235, 219));
				labelPrecio.setFont(new Font("Roboto Medium", Font.PLAIN, 15));
				contentPane.add(labelPrecio);

				labelCantidad = new JLabel("+ " + String.valueOf(cantidad));
				labelCantidad.setBounds(390, y, 502, 30);
				labelCantidad.setBackground(new Color(10, 27, 5));
				labelCantidad.setForeground(new Color(243, 235, 219));
				labelCantidad.setFont(new Font("Roboto Medium", Font.PLAIN, 15));
				contentPane.add(labelCantidad);

				JButton btnDelete = new JButton("Delete");
				btnDelete.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						ConsultasBD3.eliminarProductoDelCarrito(id_usuario, id_producto);
						dispose(); // Cierra la ventana actual
						Carrito nuevaVentanaCarrito = new Carrito(id_usuario); // Crea una nueva instancia de la ventana del
																				// carrito
						nuevaVentanaCarrito.setVisible(true);
					}
				});
				btnDelete.setBounds(470, y, 75, 30);
				btnDelete.setFont(new Font("Roboto Medium", Font.BOLD, 12));
				btnDelete.setBackground(Color.red);
				contentPane.add(btnDelete);

				// Actualizar la posición en el eje Y para la siguiente entrada
				y += 30;

			}
	 }
	 public void agregarBotonComprar(Container contentPane) {
	        final JPanel panelCompra = new JPanel();
	        panelCompra.setBackground(new Color(254, 250, 192));
	        panelCompra.setBounds(340, 400, 148, 40);
	        contentPane.add(panelCompra);
	        panelCompra.setLayout(null);

	        
	        lblComprar.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseEntered(MouseEvent e) {
	                Color colorFondo = Color.green;
	                panelCompra.setBackground(colorFondo);
	                lblComprar.setForeground(Color.BLACK);
	            }

	            @Override
	            public void mouseExited(MouseEvent e) {
	                Color colorFondo = new Color(243, 235, 219);
	                panelCompra.setBackground(colorFondo);
	                Color colorFondo2 = new Color(0, 64, 128);
	                lblComprar.setForeground(colorFondo2);
	            }

	            @Override
	            public void mouseClicked(MouseEvent e) {
	            	realizarCompra(id_usuario);
	            }
	        });
	        lblComprar.setFont(new Font("Roboto", Font.PLAIN, 20));
	        lblComprar.setForeground(new Color(0, 64, 128));
	        lblComprar.setHorizontalAlignment(SwingConstants.CENTER);
	        lblComprar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	        lblComprar.setBounds(0, 0, 148, 40);
	        panelCompra.add(lblComprar);
	    }
	 public void realizarCompra(int id_usuario) {
	        ConsultasBD3.crearPedido(id_usuario);
	        System.out.println("Compra realizada");
	    }
}
