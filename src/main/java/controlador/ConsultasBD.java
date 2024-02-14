package controlador;

import java.awt.HeadlessException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import modelo.Usuario;
import vista.Login;
import vista.TiendaPrincipal;

public class ConsultasBD {
	
	
	
	
	public static void guardarUsuario(Usuario usuario) throws HeadlessException {
		Conexion con = new Conexion();
        Connection conexion = null;

        // Encriptar la contraseña antes de almacenarla
        String hashedPassword = hashPassword(usuario.getContrasena());

        try {
            String sql = "INSERT INTO usuario(username, contrasena, nombre, APELLIDOS, CORREO_ELEC, TELEFONO, DIRECCION) VALUES (?, ?, ?, ?, ?, ?, ?)";
            conexion = con.conectar();
            PreparedStatement pst = conexion.prepareStatement(sql);

            //Comprobar si el usuario ya existe
            if (usuarioExistente(usuario.getUsername())) {
                JOptionPane.showMessageDialog(null, "El nombre de usuario ya está en uso. Por favor, elige otro");
                return;
            }

            pst.setString(1, usuario.getUsername());
            pst.setString(2, hashedPassword);
            pst.setString(3, usuario.getNombre());
            pst.setString(4, usuario.getApellidos());
            pst.setString(5, usuario.getCorreo_electronico());
            pst.setString(6, usuario.getTelefono());
            pst.setString(7, usuario.getDireccion());

            int rs = pst.executeUpdate();

            if (rs > 0) {
                JOptionPane.showMessageDialog(null, "Guardado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar el usuario");
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            // Cerrar la conexión en el bloque finally para asegurarse de que se cierre incluso en caso de excepción
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException e) {
                    System.out.println("Error al cerrar la conexión: " + e);
                }
            }
        }
        
    }
	
	
	public static boolean consultarUsuario(String username, String password) {
		Conexion con = new Conexion();
        Connection cn = null;

        try {
        	String sql = "SELECT username, contrasena FROM usuario WHERE username = ?";
            cn = con.conectar();
            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setString(1, username);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                String usernameCorrecto = rs.getString("username");
                String passCorrecto = rs.getString("contrasena");

                // Verificar la contraseña encriptada
                if (verificarPassword(password, passCorrecto)) {
                    JOptionPane.showMessageDialog(null, "Login correcto. Bienvenido " + usernameCorrecto);
                    Usuario user = obtenerUsuarioPorUsername(usernameCorrecto);
                    int id_usuario = user.getUser_id();
                    TiendaPrincipal tp = new TiendaPrincipal(id_usuario);
                    tp.setVisible(true);
                    
                    return true;
                    
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
                    return false;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Usuario no encontrado");
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e);

        } finally {
            if (cn != null) {
                try {
                    cn.close();
                } catch (SQLException e) {
                    System.out.println("Error al cerrar la conexión: " + e);
                }
            }
        }
        
        return false;
    }
	
	
	private static boolean usuarioExistente(String username) throws SQLException {
		Conexion con = new Conexion();
        Connection cn = null;

        try {
            String sql = "SELECT COUNT(*) FROM usuario WHERE username = ?";
            cn = con.conectar();
            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setString(1, username);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                return rs.getInt(1) > 0;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (cn != null) {
                try {
                    cn.close();
                } catch (SQLException e) {
                    System.out.println("Error al cerrar la conexión: " + e);
                }
            }
        }

        return false;
    }
	
	
	public static Usuario obtenerUsuarioPorUsername(String username) {
	    Conexion con = new Conexion();
	    Connection cn = null;

	    try {
	        String sql = "SELECT user_id, username, contrasena, nombre, apellidos, correo_elec, telefono, direccion FROM usuario WHERE username = ?";
	        cn = con.conectar();
	        PreparedStatement pst = cn.prepareStatement(sql);

	        pst.setString(1, username);

	        ResultSet rs = pst.executeQuery();

	        if (rs.next()) {
	            Usuario usuario = new Usuario();
	            usuario.setUser_id(rs.getInt("user_id"));
	            usuario.setUsername(rs.getString("username"));
	            usuario.setContrasena(rs.getString("contrasena")); 
	            usuario.setNombre(rs.getString("nombre"));
	            usuario.setApellidos(rs.getString("apellidos"));
	            usuario.setCorreo_electronico(rs.getString("correo_elec"));
	            usuario.setTelefono(rs.getString("telefono"));
	            usuario.setDireccion(rs.getString("direccion"));
	            
	            return usuario;
	        }
	    } catch (SQLException e) {
	        JOptionPane.showMessageDialog(null, "Error al obtener el usuario: " + e.getMessage());
	    } finally {
	        if (cn != null) {
	            try {
	                cn.close();
	            } catch (SQLException e) {
	                System.out.println("Error al cerrar la conexión: " + e);
	            }
	        }
	    }
	    
	    return null; // Retorna null si no encuentra el usuario o si hay un error
	}
	
	private static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();

            //Convertimos el array de bytes en string para devolverlo e insertarlo en la BD
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }

            return sb.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error al encriptar la contraseña", e);
        }
    }

	
    private static boolean verificarPassword(String inputPassword, String storedPassword) {
        String hashedInputPassword = hashPassword(inputPassword);
        return hashedInputPassword.equals(storedPassword);
    }
    
    
    public static Usuario obtenerUsuarioPorId(int id) {
        Conexion con = new Conexion();
        Connection cn = null;

        try {
            String sql = "SELECT user_id, username, contrasena, nombre, apellidos, correo_elec, telefono, direccion FROM usuario WHERE user_id = ?";
            cn = con.conectar();
            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setInt(1, id);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setUser_id(rs.getInt("user_id"));
                usuario.setUsername(rs.getString("username"));
  
                usuario.setContrasena(rs.getString("contrasena"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellidos(rs.getString("apellidos"));
                usuario.setCorreo_electronico(rs.getString("correo_elec"));
                usuario.setTelefono(rs.getString("telefono"));
                usuario.setDireccion(rs.getString("direccion"));
                
                return usuario;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener el usuario: " + e.getMessage());
        } finally {
            if (cn != null) {
                try {
                    cn.close();
                } catch (SQLException e) {
                    System.out.println("Error al cerrar la conexión: " + e);
                }
            }
        }
        
        return null; // Retorna null si no encuentra el usuario o si hay un error
    }

}
