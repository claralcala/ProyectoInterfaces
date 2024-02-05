package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controlador.ConsultasBD2;
import modelo.Producto;

public class TiendaPrincipal extends JFrame {
	
	private int id_usuario;

	private JPanel contentPane;
	
	private JPanel panelX;
	
	private JButton addToCartButton;
	
	JTextField searchField;
	
	JPanel mainPanel;
	
	JLabel minimizeLabel;
	JLabel closeLabel;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public TiendaPrincipal(int id_usuario) {
		
		this.id_usuario=id_usuario;
		
		
		setTitle("URBAN STRIDE");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 700);
        setUndecorated(true);
        setLocationRelativeTo(null); // Centrar ventana

        // Panel superior
        
        JPanel topPanel = new JPanel();
        topPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        topPanel.setBackground(new Color(186, 201, 92));
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));

        // Etiqueta para cerrar
        closeLabel = new JLabel("X");
        closeLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                dispose();
            }
            public void mouseEntered(MouseEvent e) {
                closeLabel.setForeground(Color.RED);
            }
            public void mouseExited(MouseEvent e) {
                closeLabel.setForeground(Color.BLACK);
            }
        });
        setLabelStyle(closeLabel);
        topPanel.add(closeLabel);
        
        int spacerWidth = 10; // Ajusta este valor según sea necesario
        topPanel.add(Box.createHorizontalStrut(spacerWidth));
        
        
     // Etiqueta para minimizar
       minimizeLabel = new JLabel("_");
        minimizeLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                setExtendedState(JFrame.ICONIFIED);
            }
            public void mouseEntered(MouseEvent e) {
                minimizeLabel.setForeground(Color.GRAY);
            }
            public void mouseExited(MouseEvent e) {
                minimizeLabel.setForeground(Color.BLACK);
            }
        });
        setLabelStyle(minimizeLabel);
        topPanel.add(minimizeLabel);
        
        

       

        
        
     // Espaciador para mover el panel izquierdo hacia la derecha
        int leftMargin = 30; // Ajusta este valor según sea necesario
        topPanel.add(Box.createHorizontalStrut(leftMargin));

        // Panel para los elementos a la izquierda (como la barra de búsqueda y lupa)
        JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
         searchField = new JTextField(20);
        leftPanel.add(searchField);
        leftPanel.setBackground(new Color(186, 201, 92));
        JLabel searchLabel = new JLabel();
        searchLabel.setIcon(new ImageIcon(TiendaPrincipal.class.getResource("/imagenes/lupadef.png"))); 
        
        
        searchLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                buscarYMostrarProductos();
            }
        });
        leftPanel.add(searchLabel);
        topPanel.add(leftPanel);

        // Panel para el centro (espaciado)
        JPanel centerPanel = new JPanel();
        centerPanel.setOpaque(false);
        topPanel.add(centerPanel, BorderLayout.CENTER);

        // Panel para los elementos a la derecha (carrito, botón de logout y etiqueta de volver)
        JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 5, 5));

        rightPanel.setBackground(new Color(186, 201, 92));
        JLabel editProfileLabel = new JLabel("Editar perfil");
        editProfileLabel.setIcon(new ImageIcon(TiendaPrincipal.class.getResource("/imagenes/perfil.png"))); 
        rightPanel.add(editProfileLabel);
        editProfileLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                abrirEditarPerfil();
            }
        });

        JLabel cartLabel = new JLabel("Carrito");
        cartLabel.setIcon(new ImageIcon(TiendaPrincipal.class.getResource("/imagenes/carritodef.png")));
        rightPanel.add(cartLabel);

        JButton logoutButton = new JButton("Logout");
        rightPanel.add(logoutButton);
        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                logout();
            }
        });

        

        topPanel.add(rightPanel, BorderLayout.EAST);

        getContentPane().add(topPanel, BorderLayout.NORTH);
        

        getContentPane().setBackground(new Color(10, 27, 5));
        
        

        // Panel principal con GridBagLayout
      mainPanel = new JPanel(new GridBagLayout());
        JScrollPane scrollPane = new JScrollPane(mainPanel);
        mainPanel.setBackground(new Color(10, 27, 5));
        scrollPane.setBackground(new Color(10, 27, 5));
        scrollPane.getVerticalScrollBar().setUnitIncrement(10);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
	      
	    
	        
	        

	        // Simulación de productos obtenidos de la base de datos
	       //String[] productos = {"Zapatilla 1", "Zapatilla 2", "Zapatilla 3", "Zapatilla 4", "Zapatilla 5", "Zapatilla 6", "Zapatilla 7", "Zapatilla 8", "Zapatilla 9", "Zapatilla 10", "Zapatilla 11", "Zapatilla 12", "Zapatilla 13", "Zapatilla 14", "Zapatilla 15", "Zapatilla 16"};
	       // double[] precios = {100.0, 120.0, 90.0, 110.0, 130.0, 85.0, 5.6, 7.7, 8.8, 9.9, 100.9, 322.0, 22.0, 23.0, 22.0, 90.0};
	        
	        GridBagConstraints gbc = new GridBagConstraints();
	        gbc.gridwidth = 1;
	        gbc.gridheight = 1;
	        gbc.insets = new Insets(10, 10, 10, 10); // Espaciado entre celdas
	        gbc.fill = GridBagConstraints.BOTH;

	        int column = 0;
	        int row = 0;
	        
	        ArrayList<Producto> productos = new ArrayList();
	        
	        
	        productos= ConsultasBD2.recuperarProductos();

	        for (Producto prod : productos) {
	            // Panel para cada producto
	            JPanel productPanel = new JPanel(new BorderLayout());
	            productPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	            productPanel.setBackground(new Color(249, 248, 113));

	            // Etiqueta para el nombre del producto
	            JLabel nameLabel = new JLabel(prod.getNombre(), JLabel.CENTER);
	            productPanel.add(nameLabel, BorderLayout.NORTH);

	            // Panel interno para la imagen y el botón
	            JPanel innerPanel = new JPanel();
	            innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.Y_AXIS));
	            innerPanel.setBackground(new Color(249, 248, 113));
	            
	            
	         // Carga la imagen como un ImageIcon
	            ImageIcon originalIcon = new ImageIcon(TiendaPrincipal.class.getResource("/imagenes/" + prod.getImagen()+".png"));

	            // Escala la imagen al tamaño deseado
	            Image scaledImage = originalIcon.getImage().getScaledInstance(210, 210, Image.SCALE_SMOOTH);

	            // Crea un nuevo ImageIcon con la imagen escalada
	            ImageIcon scaledIcon = new ImageIcon(scaledImage);


	            // Etiqueta para la imagen
	            JLabel imageLabel = new JLabel();
	            imageLabel.setIcon(scaledIcon);
	            
	            innerPanel.add(imageLabel);
	            
	            
	            JPanel buttonPanel = new JPanel(); // Usa FlowLayout por defecto, que centra los componentes
	            JButton addToCartButton = new JButton("Añadir al Carrito");
	            buttonPanel.add(addToCartButton);
	            innerPanel.add(buttonPanel);
	            buttonPanel.setBackground(new Color(249, 248, 113));

	            // Botón para añadir al carrito
	           
	            addToCartButton.addActionListener(new ActionListener() {
	                public void actionPerformed(ActionEvent e) {
	                    // LOGICA PARA AÑADIR AL CARRITO 
	                    JOptionPane.showMessageDialog(TiendaPrincipal.this, "¡Producto añadido al carrito!");
	                }
	            });

	            // Añadir el panel interno al panel del producto
	            productPanel.add(innerPanel, BorderLayout.CENTER);

	            // Etiqueta para el precio
	            JLabel priceLabel = new JLabel("Precio: " + prod.getPrecio() + " €", JLabel.CENTER);
	            productPanel.add(priceLabel, BorderLayout.SOUTH);


	            gbc.gridx = column;
	            gbc.gridy = row;

	            // Añadir el panel del producto al panel principal
	            mainPanel.add(productPanel, gbc);

	            // Actualizar la posición para el próximo panel
	            column++;
	            if (column == 3) { // Cambiar de fila después de 3 columnas
	                column = 0;
	                row++;
	            }
	        }

	     
	    }
	
	 private void setLabelStyle(JLabel label) {
	        label.setFont(new Font("Roboto Black", Font.PLAIN, 20));
	        label.setForeground(Color.BLACK);
	        label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	        label.setHorizontalAlignment(SwingConstants.CENTER);
	    }
	 
	 private void buscarYMostrarProductos() {
		    String nombre = searchField.getText();
		    ArrayList<Producto> productosEncontrados = ConsultasBD2.buscarProductosPorNombre(nombre);

		    //Limpia el panel principal antes de añadir los nuevos productos
		    mainPanel.removeAll();
		    mainPanel.revalidate();
		    mainPanel.repaint();
		    
		    GridBagConstraints gbc = new GridBagConstraints();
	        gbc.gridwidth = 1;
	        gbc.gridheight = 1;
	        gbc.insets = new Insets(10, 10, 10, 10); // Espaciado entre celdas
	        gbc.fill = GridBagConstraints.BOTH;

	        int column = 0;
	        int row = 0;

		    // Añade los productos al panel
		    for (Producto prod : productosEncontrados) {
		    	 JPanel productPanel = new JPanel(new BorderLayout());
		            productPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		            productPanel.setBackground(new Color(249, 248, 113));

		            // Etiqueta para el nombre del producto
		            JLabel nameLabel = new JLabel(prod.getNombre(), JLabel.CENTER);
		            productPanel.add(nameLabel, BorderLayout.NORTH);

		            // Panel interno para la imagen y el botón
		            JPanel innerPanel = new JPanel();
		            innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.Y_AXIS));
		            innerPanel.setBackground(new Color(249, 248, 113));
		            
		            
		         // Carga la imagen como un ImageIcon
		            ImageIcon originalIcon = new ImageIcon(TiendaPrincipal.class.getResource("/imagenes/" + prod.getImagen()+".png"));

		            // Escala la imagen al tamaño deseado
		            Image scaledImage = originalIcon.getImage().getScaledInstance(210, 210, Image.SCALE_SMOOTH);

		            // Crea un nuevo ImageIcon con la imagen escalada
		            ImageIcon scaledIcon = new ImageIcon(scaledImage);


		            // Etiqueta para la imagen
		            JLabel imageLabel = new JLabel();
		            imageLabel.setIcon(scaledIcon);
		            
		            innerPanel.add(imageLabel);
		            
		            
		            JPanel buttonPanel = new JPanel(); // Usa FlowLayout por defecto, que centra los componentes
		            JButton addToCartButton = new JButton("Añadir al Carrito");
		            buttonPanel.add(addToCartButton);
		            innerPanel.add(buttonPanel);
		            buttonPanel.setBackground(new Color(249, 248, 113));

		            // Botón para añadir al carrito
		           
		            addToCartButton.addActionListener(new ActionListener() {
		                public void actionPerformed(ActionEvent e) {
		                    // LOGICA PARA AÑADIR AL CARRITO 
		                    JOptionPane.showMessageDialog(TiendaPrincipal.this, "¡Producto añadido al carrito!");
		                }
		            });

		            // Añadir el panel interno al panel del producto
		            productPanel.add(innerPanel, BorderLayout.CENTER);

		            // Etiqueta para el precio
		            JLabel priceLabel = new JLabel("Precio: " + prod.getPrecio() + " €", JLabel.CENTER);
		            productPanel.add(priceLabel, BorderLayout.SOUTH);


		            gbc.gridx = column;
		            gbc.gridy = row;

		            // Añadir el panel del producto al panel principal
		            mainPanel.add(productPanel, gbc);

		            // Actualizar la posición para el próximo panel
		            column++;
		            if (column == 3) { // Cambiar de fila después de 3 columnas
		                column = 0;
		                row++;
		            }
		        
		    }

		    // Actualiza el UI después de añadir todos los productos
		    mainPanel.revalidate();
		    mainPanel.repaint();
		}
	 
	 private void logout() {
		    // Cierra la ventana actual
		    this.dispose();
		    
		    // Abre la ventana de login
		    Login loginWindow = new Login();
		    loginWindow.setVisible(true);
		}
	 
	 
	 private void abrirEditarPerfil() {
		    Editar editarPerfil = new Editar(id_usuario); // Usa el ID del usuario almacenado
		    editarPerfil.setVisible(true);
		    
		}
	}


