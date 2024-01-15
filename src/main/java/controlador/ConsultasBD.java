package controlador;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import modelo.Usuario;

public class ConsultasBD {
	
	
	public void guardarUsuario(Usuario usuario) {
        Conexion con = new Conexion();

        // Encriptar la contraseña antes de almacenarla
        String hashedPassword = hashPassword(usuario.getContrasena());

        String sql = "INSERT INTO usuario(username, contrasena) VALUES (?, ?)";
        try (Connection conexion = db.conectar();
             PreparedStatement pst = conexion.prepareStatement(sql)) {

            // Comprobar si el usuario ya existe
            if (usuarioExistente(usuario.getUsername())) {
                JOptionPane.showMessageDialog(null, "El nombre de usuario ya está en uso. Por favor, elige otro.");
                return;
            }

            pst.setString(1, usuario.getUsername());
            pst.setString(2, hashedPassword);

            int rs = pst.executeUpdate();

            if (rs > 0) {
                JOptionPane.showMessageDialog(null, "Guardado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar el usuario");
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
	
	private byte[] hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            return md.digest(password.getBytes());

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error al encriptar la contraseña", e);
        }
    }

    private boolean verificarPassword(String inputPassword, byte[] storedPassword) {
        byte[] hashedInputPassword = hashPassword(inputPassword);
        return MessageDigest.isEqual(hashedInputPassword, storedPassword);
    }

}
