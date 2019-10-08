package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexion {

	Connection connection;

	private static final String DB_URL = "jdbc:postgresql://localhost/postgres";
	private static final String USER = "usuario";
	private static final String PASS = "10164DAW2";

	public Conexion() {
		try {
			Class.forName("org.postgresql.Driver");

			connection = DriverManager.getConnection(DB_URL, USER, PASS);

			JOptionPane.showMessageDialog(null, "Conexión realizada correctamente en " + DB_URL);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection devolverConexion() {
		return connection;
	}

	public void cerrarConexion() throws SQLException {
		connection.close();
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void finalize() throws Throwable {
		cerrarConexion();
		super.finalize();
	}

}
