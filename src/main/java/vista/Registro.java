package vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Registro extends JFrame {

	private JPanel contentPane;
	
	private JTextField txtNombre, txtApellidos, txtCorreo, txtTelefono, txtDireccion;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro frame = new Registro();
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
	public Registro() {
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 986, 615);

        setUndecorated(true);

        contentPane = new JPanel();
        contentPane.setBackground(new Color(254, 250, 192));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(30, 33, 57));
        panel.setBounds(0, 0, 986, 615);
        contentPane.add(panel);
        panel.setLayout(null);

        // 
        
        JLabel lblInicioSesion = new JLabel("REGISTRARSE");
		lblInicioSesion.setHorizontalAlignment(SwingConstants.CENTER);
		lblInicioSesion.setForeground(new Color(243, 235, 219));
		lblInicioSesion.setFont(new Font("Roboto", Font.PLAIN, 23));
		lblInicioSesion.setBounds(371, 79, 226, 33);
		panel.add(lblInicioSesion);

        // Nuevos componentes para campos de registro
        JLabel lblNombre = new JLabel("Nombre");
        lblNombre.setForeground(new Color(243, 235, 219));
        lblNombre.setFont(new Font("Roboto Medium", Font.PLAIN, 20));
        lblNombre.setBounds(274, 289, 177, 24);
        panel.add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setForeground(new Color(243, 235, 219));
        txtNombre.setBackground(new Color(30, 33, 57));
        txtNombre.setBorder(null);
        txtNombre.setFont(new Font("Roboto Light", Font.PLAIN, 15));
        txtNombre.setBounds(274, 323, 390, 22);
        panel.add(txtNombre);
        txtNombre.setColumns(10);

        JSeparator separatorNombre = new JSeparator();
        separatorNombre.setBackground(new Color(155, 253, 202));
        separatorNombre.setBounds(274, 355, 390, 8);
        panel.add(separatorNombre);

        JLabel lblApellidos = new JLabel("Apellidos");
        lblApellidos.setForeground(new Color(243, 235, 219));
        lblApellidos.setFont(new Font("Roboto Medium", Font.PLAIN, 20));
        lblApellidos.setBounds(274, 371, 177, 24);
        panel.add(lblApellidos);

        txtApellidos = new JTextField();
        txtApellidos.setForeground(new Color(243, 235, 219));
        txtApellidos.setBackground(new Color(30, 33, 57));
        txtApellidos.setBorder(null);
        txtApellidos.setFont(new Font("Roboto Light", Font.PLAIN, 15));
        txtApellidos.setBounds(274, 405, 390, 22);
        panel.add(txtApellidos);
        txtApellidos.setColumns(10);

        JSeparator separatorApellidos = new JSeparator();
        separatorApellidos.setBackground(new Color(155, 253, 202));
        separatorApellidos.setBounds(274, 437, 390, 8);
        panel.add(separatorApellidos);

        JLabel lblCorreo = new JLabel("Correo Electrónico");
        lblCorreo.setForeground(new Color(243, 235, 219));
        lblCorreo.setFont(new Font("Roboto Medium", Font.PLAIN, 20));
        lblCorreo.setBounds(274, 453, 177, 24);
        panel.add(lblCorreo);

        txtCorreo = new JTextField();
        txtCorreo.setForeground(new Color(243, 235, 219));
        txtCorreo.setBackground(new Color(30, 33, 57));
        txtCorreo.setBorder(null);
        txtCorreo.setFont(new Font("Roboto Light", Font.PLAIN, 15));
        txtCorreo.setBounds(274, 487, 390, 22);
        panel.add(txtCorreo);
        txtCorreo.setColumns(10);

        JSeparator separatorCorreo = new JSeparator();
        separatorCorreo.setBackground(new Color(155, 253, 202));
        separatorCorreo.setBounds(274, 519, 390, 8);
        panel.add(separatorCorreo);

        JLabel lblTelefono = new JLabel("Teléfono");
        lblTelefono.setForeground(new Color(243, 235, 219));
        lblTelefono.setFont(new Font("Roboto Medium", Font.PLAIN, 20));
        lblTelefono.setBounds(274, 535, 177, 24);
        panel.add(lblTelefono);

        txtTelefono = new JTextField();
        txtTelefono.setForeground(new Color(243, 235, 219));
        txtTelefono.setBackground(new Color(30, 33, 57));
        txtTelefono.setBorder(null);
        txtTelefono.setFont(new Font("Roboto Light", Font.PLAIN, 15));
        txtTelefono.setBounds(274, 569, 390, 22);
        panel.add(txtTelefono);
        txtTelefono.setColumns(10);

        JSeparator separatorTelefono = new JSeparator();
        separatorTelefono.setBackground(new Color(155, 253, 202));
        separatorTelefono.setBounds(274, 601, 390, 8);
        panel.add(separatorTelefono);

        JLabel lblDireccion = new JLabel("Dirección");
        lblDireccion.setForeground(new Color(243, 235, 219));
        lblDireccion.setFont(new Font("Roboto Medium", Font.PLAIN, 20));
        lblDireccion.setBounds(274, 617, 177, 24);
        panel.add(lblDireccion);

        txtDireccion = new JTextField();
        txtDireccion.setForeground(new Color(243, 235, 219));
        txtDireccion.setBackground(new Color(30, 33, 57));
        txtDireccion.setBorder(null);
        txtDireccion.setFont(new Font("Roboto Light", Font.PLAIN, 15));
        txtDireccion.setBounds(274, 651, 390, 22);
        panel.add(txtDireccion);
        txtDireccion.setColumns(10);

        JSeparator separatorDireccion = new JSeparator();
        separatorDireccion.setBackground(new Color(155, 253, 202));
        separatorDireccion.setBounds(274, 683, 390, 8);
        panel.add(separatorDireccion);

        // Botones de registro y volver
        final JPanel panelRegistrar = new JPanel();
        panelRegistrar.setBackground(new Color(254, 250, 192));
        panelRegistrar.setBounds(447, 723, 113, 33);
        panel.add(panelRegistrar);
        panelRegistrar.setLayout(null);

        final JLabel lblRegistrar = new JLabel("Registrar");
        lblRegistrar.setBounds(0, 0, 113, 33);
        panelRegistrar.add(lblRegistrar);
        lblRegistrar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                Color colorFondo = new Color(155, 253, 202);
                panelRegistrar.setBackground(colorFondo);
                lblRegistrar.setForeground(Color.BLACK);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Color colorFondo = new Color(243, 235, 219);
                panelRegistrar.setBackground(colorFondo);
                Color colorFondo2 = new Color(0, 64, 128);
                lblRegistrar.setForeground(colorFondo2);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                // Lógica para registrar el usuario aquí
                // Puedes acceder a los datos ingresados con txtNombre.getText(), txtApellidos.getText(), etc.
                // Implementa la lógica de registro según tus necesidades.
            }
        });
        lblRegistrar.setHorizontalAlignment(SwingConstants.CENTER);
        lblRegistrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblRegistrar.setFont(new Font("Roboto", Font.PLAIN, 20));
        lblRegistrar.setForeground(new Color(0, 64, 128));

        final JPanel panelVolver = new JPanel();
        panelVolver.setBackground(new Color(254, 250, 192));
        panelVolver.setBounds(274, 723, 113, 33);
        panel.add(panelVolver);
        panelVolver.setLayout(null);

        final JLabel lblVolver = new JLabel("Volver");
        lblVolver.setBounds(0, 0, 113, 33);
        panelVolver.add(lblVolver);
        lblVolver.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                Color colorFondo = new Color(155, 253, 202);
                panelVolver.setBackground(colorFondo);
                lblVolver.setForeground(Color.BLACK);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Color colorFondo = new Color(243, 235, 219);
                panelVolver.setBackground(colorFondo);
                Color colorFondo2 = new Color(0, 64, 128);
                lblVolver.setForeground(colorFondo2);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                
                dispose(); // Cerrar la ventana actual
                Login frame = new Login(); // Crear una nueva instancia de la ventana de inicio de sesión
                frame.setVisible(true); // Hacer visible la nueva ventana
            }
        });
        lblVolver.setHorizontalAlignment(SwingConstants.CENTER);
        lblVolver.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblVolver.setFont(new Font("Roboto", Font.PLAIN, 20));
        lblVolver.setForeground(new Color(0, 64, 128));

       
    }

}
