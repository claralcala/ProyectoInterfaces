package vista;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Producto;

import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Carrito extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ArrayList<Producto> carrito;
	private ArrayList<Integer> cantidad;

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
	 * Constructor de la ventana donde se va a visualizar el contenido del carrito.
	 * 
	 * @param carrito carrito que viene con el producto y precio.
	 */
	public Carrito(ArrayList<Producto> carrito, ArrayList<Integer> cantidad) {
		this.carrito = carrito;
		this.cantidad = cantidad;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 852, 567);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(10, 27, 5));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbProducto = new JLabel("");
		lbProducto.setBackground(new Color(255, 255, 255));
		lbProducto.setForeground(new Color(10, 27, 5));
		lbProducto.setBounds(10, 72, 185, 33);
		contentPane.add(lbProducto);
		
		JLabel lbPrecio = new JLabel("");
		lbPrecio.setBounds(10, 123, 189, 33);
		contentPane.add(lbPrecio);
		
		JLabel lbTotal = new JLabel("precio:");
		lbTotal.setHorizontalAlignment(SwingConstants.LEFT);
		lbTotal.setForeground(Color.WHITE);
		lbTotal.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbTotal.setBounds(10, 50, 260, 123);
		contentPane.add(lbTotal);
		
		Double total = 0.0;
		// Iterar sobre las entradas del HashMap y mostrar la información
        int y = 50; // Posición inicial en el eje Y
        for (Map.Entry<String, Double> entry : carrito.entrySet()) {
            String producto = entry.getKey();
            Double precio = entry.getValue();

            // Crear cadenas de texto con la información
            String productoTexto = producto;
            String precioTexto = String.valueOf(precio);

            // Crear JLabels para mostrar la información
            JLabel labelProducto = new JLabel(productoTexto);
            labelProducto.setBounds(20, y, 200, 30);
            labelProducto.setBackground(new Color(10, 27, 5));
            labelProducto.setForeground(new Color(255, 255, 255));
            labelProducto.setFont(new Font("Tahoma", Font.BOLD, 20));
            contentPane.add(labelProducto);

            JLabel labelPrecio = new JLabel(precioTexto + "€");
            labelPrecio.setBounds(150, y, 100, 30);
            labelPrecio.setBackground(new Color(10, 27, 5));
            labelPrecio.setForeground(new Color(255, 255, 255));
            labelPrecio.setFont(new Font("Tahoma", Font.BOLD, 20));
            contentPane.add(labelPrecio);
            // Actualizar la posición en el eje Y para la siguiente entrada
            y += 30;
            
            total += entry.getValue();
        }
        y += 50; //bajo un poco la estructura del label del precio total.
        lbTotal.setText("Precio total: " + String.valueOf(total) + "€");
        lbTotal.setBounds(20, y, 250, 30);
        JPanel panel = new JPanel();
        panel.setBounds(343, 397, 185, 44);
        contentPane.add(panel);
	}
}
