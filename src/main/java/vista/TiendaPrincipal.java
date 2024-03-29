package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import controlador.ConsultasBD2;
import modelo.Producto;
import utiles.Texto;

public class TiendaPrincipal extends JFrame {

	private JPanel contentPane;
	
	private JPanel panelX;
	
	private JButton addToCartButton;
	private int id_usuario;
	
	ArrayList<Producto> productos; 
	
	Producto prod;
	
	JTextField searchField;
	
	JPanel mainPanel;
	
	JLabel minimizeLabel;
	
	private Login loginWindow;
	
	JButton btnGenerarPDF;
	
	JLabel closeLabel;
	
	ConsultasBD2 consultasBD;
	
	

	private KeyStroke atajo;
	
	JButton logoutButton;
	
	
	ArrayList<Producto> carrito;
	ArrayList<Integer> cantidadZap;

	int cantidad;
	

	/**
	 * Create the frame.
	 */
	public TiendaPrincipal(final int id_usuario) {
		
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
        
        int spacerWidth = 10; 
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
        int leftMargin = 30;
        topPanel.add(Box.createHorizontalStrut(leftMargin));
        topPanel.setBackground(new Color(186, 201, 92));

        // Panel para los elementos a la izquierda (como la barra de búsqueda y lupa)
        JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
        leftPanel.setBackground(new Color(186, 201, 92));
         searchField = new JTextField(20);
        leftPanel.add(searchField);
        leftPanel.setBackground(new Color(186, 201, 92));
        JLabel searchLabel = new JLabel();
        searchLabel.setIcon(new ImageIcon(TiendaPrincipal.class.getResource("/imagenes/lupadef.png"))); 
        leftPanel.add(searchLabel);
        
        searchLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                buscarYMostrarProductos();
            }
        });
        
        btnGenerarPDF = new JButton("Generar PDF");
        leftPanel.add(btnGenerarPDF);
        btnGenerarPDF.addActionListener(new ActionListener() {
        	
            public void actionPerformed(ActionEvent e) {
                generarPDFDeBusqueda(searchField.getText());
            }
        });
        
        
        
        
        topPanel.add(leftPanel);

        // Panel para el centro (espaciado)
        JPanel centerPanel = new JPanel();
        centerPanel.setOpaque(false);
        topPanel.add(centerPanel, BorderLayout.CENTER);

        // Panel para los elementos a la derecha (carrito, botón de logout y etiqueta de volver)
        JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 5, 5));
        rightPanel.setBackground(new Color(186, 201, 92));

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
        cartLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                abrirCarrito(id_usuario);
            }
        });

        logoutButton = new JButton("Logout");
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
	        
	         productos = new ArrayList();
	        
	        
	        productos= ConsultasBD2.recuperarProductos();

	        for (final Producto prod : productos) {
	            // Panel para cada producto
	            JPanel productPanel = new JPanel(new BorderLayout());
	            productPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	            productPanel.setBackground(new Color(249, 248, 113));

	            // Etiqueta para el nombre del producto
	            JLabel nameLabel = new JLabel(prod.getNombre(), JLabel.CENTER);
	            nameLabel.setToolTipText(Texto.nombreProducto);
	            productPanel.add(nameLabel, BorderLayout.NORTH);
	            nameLabel.addMouseListener(new MouseAdapter() {
	                @Override
	                public void mouseClicked(MouseEvent e) {
	                    abrirDetallesProducto(prod);
	                }
	            });

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
	            imageLabel.setToolTipText(Texto.imgProducto);
	            
	            innerPanel.add(imageLabel);
	            
	         // Panel para contener el JTextField y el botón
	            JPanel quantityAndButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

	            // Configuración del JTextField para la cantidad
	            final JTextField txtCantidad = new JTextField();
	            txtCantidad.setPreferredSize(new Dimension(50, 20)); 

	            txtCantidad.setToolTipText(Texto.cantidad);
	            quantityAndButtonPanel.add(new JLabel("Cantidad:"));
	            quantityAndButtonPanel.add(txtCantidad);

	            // Configuración del JButton para añadir al carrito
	            JButton addToCartButton = new JButton("Añadir al Carrito");
	            quantityAndButtonPanel.add(addToCartButton);
	            addToCartButton.setToolTipText(Texto.anadir_carro);

	            // ActionListener para el botón
	            addToCartButton.addActionListener(new ActionListener() {
	                public void actionPerformed(ActionEvent e) {
	                	
	                	String textoCantidad = txtCantidad.getText().trim(); //usamos trim para eliminar espacios en blanco al inicio y al final

	                    if (textoCantidad.isEmpty()) {
	                        JOptionPane.showMessageDialog(null, "Por favor, ingrese una cantidad");
	                        return; 
	                    }

	                    try {
	                        cantidad = Integer.parseInt(textoCantidad);
	                        System.out.println(prod.getProduct_id());
	                        boolean resultado = ConsultasBD2.anadirProductoAlCarrito(id_usuario, prod.getProduct_id(), cantidad);
	                        JOptionPane.showMessageDialog(null, "¡Producto añadido al carrito!");
	                    } catch (NumberFormatException ex) {
	                        JOptionPane.showMessageDialog(null, "Por favor, ingrese una cantidad válida.");
	                    }
	                	
	                    
	                }
	            });

	            
	         // Añadir el panel que contiene el JTextField y el botón al innerpanel
	            innerPanel.add(quantityAndButtonPanel);

	            // Añadir el panel interno al panel del producto
	            productPanel.add(innerPanel, BorderLayout.CENTER);

	            // Etiqueta para el precio
	            JLabel priceLabel = new JLabel("Precio: " + prod.getPrecio() + " €", JLabel.CENTER);
	            productPanel.add(priceLabel, BorderLayout.SOUTH);
	            priceLabel.setToolTipText(Texto.precio);


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
	        
	        // Tooltips
	        closeLabel.setToolTipText(Texto.toolCerrar);
	        minimizeLabel.setToolTipText(Texto.toolMinimizar);
	        searchField.setToolTipText(Texto.barraBusqueda);
	        searchLabel.setToolTipText(Texto.lupa);
	        editProfileLabel.setToolTipText(Texto.editarPerfil);
	        cartLabel.setToolTipText(Texto.carrito);
	        logoutButton.setToolTipText(Texto.logout);
	        
	        // ATAJO DE TECLADO CTRL + T PARA DESLOGUEARSE
	        atajo = KeyStroke.getKeyStroke(KeyEvent.VK_T, KeyEvent.CTRL_DOWN_MASK);
			getRootPane().registerKeyboardAction(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
				  logout();
				}
			}, atajo, JComponent.WHEN_IN_FOCUSED_WINDOW);
	        

	     
	    }
	
	 private void setLabelStyle(JLabel label) {
	        label.setFont(new Font("Roboto Black", Font.PLAIN, 20));
	        label.setForeground(Color.BLACK);
	        label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	        label.setHorizontalAlignment(SwingConstants.CENTER);
	    }
	 
	 public void buscarYMostrarProductos() {
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
		    for (final Producto prod : productosEncontrados) {
		    	 JPanel productPanel = new JPanel(new BorderLayout());
		            productPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		            productPanel.setBackground(new Color(249, 248, 113));

		            // Etiqueta para el nombre del producto
		            JLabel nameLabel = new JLabel(prod.getNombre(), JLabel.CENTER);
		            productPanel.add(nameLabel, BorderLayout.NORTH);
		            nameLabel.addMouseListener(new MouseAdapter() {
		                @Override
		                public void mouseClicked(MouseEvent e) {
		                    abrirDetallesProducto(prod);
		                }
		            });

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
		            
		         //panel para el spinner y el botón con flowLayout para asegurar disposición horizontal
		            JPanel panelCantidadYBoton = new JPanel(new FlowLayout(FlowLayout.LEFT));

		            SpinnerNumberModel spinnerModel = new SpinnerNumberModel(1, 1, 100, 1);
		            JSpinner spinnerCantidad = new JSpinner(spinnerModel);
		            spinnerCantidad.setPreferredSize(new Dimension(50, 20));

		            panelCantidadYBoton.add(new JLabel("Cantidad:"));
		            panelCantidadYBoton.add(spinnerCantidad);

		            JButton addToCartButton = new JButton("Añadir al Carrito");
		            panelCantidadYBoton.add(addToCartButton);
		            panelCantidadYBoton.setBackground(new Color(249, 248, 113));

		           
		            innerPanel.add(panelCantidadYBoton);

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

		    // Actualiza interfaz después de añadir todos los productos
		    mainPanel.revalidate();
		    mainPanel.repaint();
		}

	 
	 private void logout() {
		    // Cierra la ventana actual
		    this.dispose();
		    
		    // Abre la ventana de login
		    if (this.loginWindow != null) {
		        this.loginWindow.setVisible(true); // Muestra la ventana de login
		    }
		}
	 
	 
	 private void abrirEditarPerfil() {
		    Editar editarPerfil = new Editar(id_usuario); // Usamos el ID del usuario almacenado y nos lo llevamos a la ventana de editar
		    editarPerfil.setVisible(true);
		    
		}
	 
	 
	  private void abrirDetallesProducto(Producto p) {
		    Details detalles = new Details(id_usuario,p, this);
		    detalles.setVisible(true);
		    this.setVisible(false);
		    
		    
		}
	 private void abrirCarrito(int id_usuario) {
		   //logica de abrir la ventana del carrito
		    Carrito carritoView = new Carrito(id_usuario);
		    setVisible(false);
		    carritoView.setVisible(true);
		}
	 
	 
	 public void generarPDFDeBusqueda(String textoBusqueda) {
		 ArrayList<Producto> productosEncontrados = ConsultasBD2.buscarProductosPorNombre(textoBusqueda);
		    
		    PDDocument document = new PDDocument();
		    PDPage page = new PDPage();
		    document.addPage(page);
		    PDPageContentStream contentStream = null;

		    try {
		        contentStream = new PDPageContentStream(document, page);
		        contentStream.beginText();
		        contentStream.setFont(PDType1Font.HELVETICA, 12);
		        contentStream.setLeading(14.5f);
		        contentStream.newLineAtOffset(25, 725);
		        contentStream.showText("Resultados de la búsqueda. Productos encontrados al buscar por: " +textoBusqueda);
		        contentStream.newLine();
		        // Añadimos una linea por cada producto con nombre, salto de linea y el precio
		        for (Producto producto : productosEncontrados) {
		            contentStream.showText("Nombre: ");
		            contentStream.newLine();
		        	contentStream.showText(producto.getNombre());
		            contentStream.newLine();
		            contentStream.showText("Precio unitario: ");
		            contentStream.showText(String.valueOf(producto.getPrecio()));
		            contentStream.newLine();
		            
		            
		            
		        }
		        
		        contentStream.endText();
		        contentStream.close(); 
		    } catch (IOException e) {
		        System.err.println("Error al generar el PDF: " + e.getMessage());
		        if(contentStream != null) {
		            try {
		                contentStream.close();
		            } catch (IOException ex) {
		                System.err.println("Error al cerrar el PDPageContentStream: " + ex.getMessage());
		            }
		        }
		    }

		    try {
		        document.save("ResultadosBusqueda.pdf");
		        JOptionPane.showMessageDialog(null, "PDF generado correctamente");
		    } catch (IOException e) {
		        System.err.println("Error al guardar el PDF: " + e.getMessage());
		    } finally {
		        try {
		            if (document != null) {
		                document.close();
		            }
		        } catch (IOException e) {
		            System.err.println("Error al cerrar el PDDocument: " + e.getMessage());
		        }
		    }
	 

	}

	public JButton getLogoutButton() {
		return logoutButton;
	}
	
	
	
	
	

	public void setConsultasBD(ConsultasBD2 consultasBD) {
	    this.consultasBD = consultasBD;
	}

	public Login getLoginWindow() {
		return loginWindow;
	}

	public void setLoginWindow(Login loginWindow) {
		this.loginWindow = loginWindow;
	}

	public JButton getBtnGenerarPDF() {
		return btnGenerarPDF;
	}

	public void setBtnGenerarPDF(JButton btnGenerarPDF) {
		this.btnGenerarPDF = btnGenerarPDF;
	}
	
	
	
	
	

	
	 
	 

	
	 
}