package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

import controlador.ConsultasBD2;
import modelo.Producto;
import utiles.Texto;




/*
 * Pantalla de detalles, esta pantalla de detalles es la encargada de mostrar todos los detalles de un producto que seleccionamos anteriormente de la lista de la tienda
 * Aqui podemos volver a la tienda principal con el atajo CTRL + T y podemos añadir un producto al carriño con el comando F3
 */
public class Details extends JFrame {
	
	//Aqui declaramos todas las variables

    private int id_producto;
    private int id_user;
    private TiendaPrincipal vistaTienda;

    private Producto p;
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    private JTextField textFieldCantidad;
	private KeyStroke atajo;
	private KeyStroke atajo2;
	
	private String textoCant;
	
	JLabel minimizeLabel;
	JLabel closeLabel;
	
	private JPanel panelX;

    int cantidad;

    public Details(final int id_user, Producto p, TiendaPrincipal vistaTienda) {
        super(); // Llama al constructor de la clase base JFrame
        this.p = p;
        this.id_user = id_user;
        this.vistaTienda = vistaTienda;

        setResizable(false);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 947, 757);
        
        contentPane = new JPanel();
        
        contentPane.setBackground(new Color(10, 27, 5));
        
        contentPane.setBorder(new javax.swing.border.EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        
        contentPane.setLayout(null);


        JPanel panel = new JPanel();
        //panel.setBackground(new Color(30, 33, 57));
        panel.setBackground(new Color(10, 27, 5));
        panel.setBounds(0, 0, 1400, 700);
        contentPane.add(panel);
        panel.setLayout(null);
       
		
      //Aqui declaramos todos los JLabel que usamos en la ventana
        
        JLabel lblNewLabel = new JLabel("Nombre");
        lblNewLabel.setBounds(274, 132, 128, 31);
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel.add(lblNewLabel);

        JLabel lblNombre = new JLabel();
        lblNombre.setBounds(526, 132, 331, 31);
        lblNombre.setForeground(new Color(255, 255, 255));
        lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNombre.setText(p.getNombre());
        lblNombre.setToolTipText(Texto.toolNameProduct);
        panel.add(lblNombre);

        JLabel lblNewLabel_2 = new JLabel("Description");
        lblNewLabel_2.setBounds(274, 193, 115, 31);
        lblNewLabel_2.setForeground(new Color(255, 255, 255));
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel.add(lblNewLabel_2);

        JLabel lblDescripcion = new JLabel();
        lblDescripcion.setBounds(526, 193, 331, 121);
        lblDescripcion.setForeground(new Color(255, 255, 255));
        lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblDescripcion.setText("<html>" + p.getDescripcion() + "</html>");
        lblDescripcion.setToolTipText(Texto.toolDescriptionDetils);
        panel.add(lblDescripcion);

        JLabel lblNewLabel_4 = new JLabel("Stock");
        lblNewLabel_4.setBounds(274, 345, 69, 29);
        lblNewLabel_4.setForeground(new Color(255, 255, 255));
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel.add(lblNewLabel_4);

        JLabel lblStock = new JLabel();
        lblStock.setBounds(538, 347, 265, 25);
        lblStock.setForeground(new Color(255, 255, 255));
        lblStock.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblStock.setText(String.valueOf(p.getStock()) + " " + "Unidades disponibles");
        lblStock.setToolTipText(Texto.toolStock);
        panel.add(lblStock);

        JLabel lblNewLabel_6 = new JLabel("Precio");
        lblNewLabel_6.setBounds(271, 412, 72, 27);
        lblNewLabel_6.setForeground(new Color(255, 255, 255));
        lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel.add(lblNewLabel_6);

        JLabel lblPrecio = new JLabel();
        lblPrecio.setBounds(536, 413, 104, 25);
        lblPrecio.setForeground(new Color(255, 255, 255));
        lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblPrecio.setText(String.valueOf(p.getPrecio()) + " " + "€");
        lblPrecio.setToolTipText(Texto.toolPrice);
        panel.add(lblPrecio);

        // Aqui introducimos la imagen que no la traemos de la lista y la  introducimos en el JLabel
        ImageIcon originalIcon = new ImageIcon(Details.class.getResource("/imagenes/" + p.getImagen() + ".png"));
        Image scaledImage = originalIcon.getImage().getScaledInstance(210, 210, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        JLabel lblImagen = new JLabel();
        lblImagen.setToolTipText(Texto.toolImage);
        lblImagen.setIcon(scaledIcon);
        lblImagen.setBounds(341, 463, 386, 226);
        lblImagen.setForeground(new Color(255, 255, 255));
        panel.add(lblImagen);

        //Aqui encontramos la cabecera de la ventana
        JLabel lblDetails = new JLabel("Detalles Producto");
        lblDetails.setBounds(0, 32, 931, 56);
        lblDetails.setForeground(new Color(255, 255, 255));
        lblDetails.setFont(new Font("Tahoma", Font.BOLD, 36));
        lblDetails.setToolTipText(Texto.toolDetails);
        lblDetails.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(lblDetails);

        
        //Aqui le damos funcion al boton del carrito que al hacer clic añadira al carrito el producto seleccionado junto con la cantidad que hemos introducido en el textField 
        JLabel lblCarrito = new JLabel("");
        lblCarrito.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               textoCant = textFieldCantidad.getText().trim();
                if (textoCant.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese una cantidad.");
                    return;
                }
                try {
                    cantidad = Integer.parseInt(textoCant);
                    System.out.println(p.getProduct_id());
                    boolean result = ConsultasBD2.anadirProductoAlCarrito(id_user, p.getProduct_id(), cantidad);
                    JOptionPane.showMessageDialog(null, "¡Producto añadido al carrito!");

                    // Cierra la ventana actual
                    dispose();

                    // Muestra la ventana anterior (vistaTienda)
                    vistaTienda.setVisible(true);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese una cantidad válida.");
                }
            }
        });

        lblCarrito.setToolTipText(Texto.toolCarrito);
        lblCarrito.setBackground(new Color(255, 255, 255));
        lblCarrito.setBounds(765, 573, 143, 116);
        panel.add(lblCarrito);

        
        //Aqui introducimos la imagen del carrito en el Jlabel y la adaptamos 
        ImageIcon icono = new ImageIcon(Details.class.getResource("/imagenes/carrito.png"));
        Image imagen = icono.getImage();
        Image nuevaImagen = imagen.getScaledInstance(128, 116, Image.SCALE_SMOOTH);
        lblCarrito.setIcon(new ImageIcon(nuevaImagen));

        JLabel btnBack = new JLabel("New label");
        btnBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                vistaTienda.setVisible(true);
                dispose();
            }
        });

        btnBack.setToolTipText(Texto.toolBackDetails);
        btnBack.setIcon(new ImageIcon(Details.class.getResource("/imagenes/back-2_icon-icons.com_62858 (1).png")));
        btnBack.setBounds(30, 603, 64, 56);
        panel.add(btnBack);

        
        //Aqui declaramos un TextField que esto indicará la cantidad que añadiremos a la cesta del producto que estemos visualizando
        textFieldCantidad = new JTextField();
        textFieldCantidad.setBounds(831, 526, 57, 20);
        panel.add(textFieldCantidad);
        textFieldCantidad.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("Cantidad");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_3.setForeground(new Color(255, 255, 255));
        lblNewLabel_3.setBounds(765, 532, 76, 14);
        lblNewLabel_3.setToolTipText(Texto.toolCant);
        panel.add(lblNewLabel_3);

        JSeparator separator = new JSeparator();
        separator.setBounds(111, 99, 708, 2);
        panel.add(separator);
        

     //Barra superior
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
        
        //Atajos de teclado
        
        
        //Atajo volver
    	atajo = KeyStroke.getKeyStroke(KeyEvent.VK_T, KeyEvent.CTRL_DOWN_MASK);
		getRootPane().registerKeyboardAction(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				VentanaPrincipal ventana = new VentanaPrincipal();
				vistaTienda.setVisible(true);
				dispose();
			}
		}, atajo, JComponent.WHEN_IN_FOCUSED_WINDOW);
		
		// Atajo para añadir al carrito (cambiado a F3)
		atajo2 = KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0); // 0 representa ningún modificador
		getRootPane().registerKeyboardAction(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        textoCant = textFieldCantidad.getText().trim();
		        if (textoCant.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Por favor, ingrese una cantidad.");
		            return;
		        }
		        try {
		            cantidad = Integer.parseInt(textoCant);
		            System.out.println(p.getProduct_id());
		            boolean result = ConsultasBD2.anadirProductoAlCarrito(id_user, p.getProduct_id(), cantidad);
		            JOptionPane.showMessageDialog(null, "¡Producto añadido al carrito!");

		            // Cierra la ventana actual
		            dispose();

		            // Muestra la ventana anterior (vistaTienda)
		            vistaTienda.setVisible(true);
		        } catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(null, "Por favor, ingrese una cantidad válida.");
		        }
		    }
		}, atajo2, JComponent.WHEN_IN_FOCUSED_WINDOW);
    }
    }

