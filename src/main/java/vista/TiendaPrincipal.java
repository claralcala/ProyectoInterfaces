package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public class TiendaPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TiendaPrincipal frame = new TiendaPrincipal();
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
	public TiendaPrincipal() {
		
		
	        JFrame frame = new JFrame("Tienda de Zapatillas");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(1200, 700);

	        // Panel principal con GridBagLayout
	        JPanel mainPanel = new JPanel(new GridBagLayout());
	        JScrollPane scrollPane = new JScrollPane(mainPanel);
	        frame.add(scrollPane);

	        // Simulación de productos obtenidos de la base de datos
	        String[] productos = {"Zapatilla 1", "Zapatilla 2", "Zapatilla 3", "Zapatilla 4", "Zapatilla 5", "Zapatilla 6", "Zapatilla 7", "Zapatilla 8", "Zapatilla 9", "Zapatilla 10", "Zapatilla 11", "Zapatilla 12", "Zapatilla 13", "Zapatilla 14", "Zapatilla 15", "Zapatilla 16"};
	        double[] precios = {100.0, 120.0, 90.0, 110.0, 130.0, 85.0, 5.6, 7.7, 8.8, 9.9, 100.9, 322.0, 22.0, 23.0, 22.0, 90.0};
	        
	        GridBagConstraints gbc = new GridBagConstraints();
	        gbc.gridwidth = 1;
	        gbc.gridheight = 1;
	        gbc.insets = new Insets(10, 10, 10, 10); // Espaciado entre celdas
	        gbc.fill = GridBagConstraints.BOTH;

	        int column = 0;
	        int row = 0;

	        for (int i = 0; i < productos.length; i++) {
	        	// Panel para cada producto
	            JPanel productPanel = new JPanel(new BorderLayout());
	            productPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

	            // Etiqueta para el nombre del producto
	            JLabel nameLabel = new JLabel(productos[i], JLabel.CENTER);
	            productPanel.add(nameLabel, BorderLayout.NORTH);

	            // Etiqueta para la imagen (usamos un icono genérico aquí)
	           // ImageIcon icon = new ImageIcon(new ImageIcon("/imagenes/logo (1).png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
	            
	            //JLabel lblNewLabel_1 = new JLabel("New label");
	    		//lblNewLabel_1.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/logo (1).png")));
	            JLabel imageLabel = new JLabel();
	            imageLabel.setIcon(new ImageIcon (TiendaPrincipal.class.getResource("/imagenes/logo (1).png")));
	            productPanel.add(imageLabel, BorderLayout.CENTER);

	            // Etiqueta para el precio
	            JLabel priceLabel = new JLabel("Precio: $" + precios[i], JLabel.CENTER);
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

	        frame.setVisible(true);
	    }
	}


