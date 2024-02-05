package vista;

import java.awt.EventQueue;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class Carrito extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private HashMap<String, Double> carrito;

	/**
	 * Launch the application.
	 */
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
	 * Create the frame.
	 */
	public Carrito(HashMap<String, Double> carrito) {
		this.carrito = carrito;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 877, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbProducto = new JLabel("");
		lbProducto.setBounds(143, 72, 185, 33);
		contentPane.add(lbProducto);
		
		JLabel lbPrecio = new JLabel("");
		lbPrecio.setBounds(143, 115, 189, 33);
		contentPane.add(lbPrecio);
		
		
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
            contentPane.add(labelProducto);

            JLabel labelPrecio = new JLabel(precioTexto);
            labelPrecio.setBounds(150, y, 100, 30);
            contentPane.add(labelPrecio);

            // Actualizar la posición en el eje Y para la siguiente entrada
            y += 30;
        }
	}

//	public Carrito(HashMap<String, Double> carrito) {
//		this.carrito = carrito;
//	}
}
