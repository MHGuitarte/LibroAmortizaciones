package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	Connection connection;

	private final String DB_URL = "jdbc:postgresql://localhost/postgres";
	private final String USER = "usuario";
	private final String PASS = "10164DAW2";

	public Conexion() {
		try {
			Class.forName("org.postgresql.Driver");

			connection = DriverManager.getConnection(DB_URL, USER, PASS);

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection devolverConexion() {
		System.out.println("Conexión devuelta");
		return connection;
	}

	public void cerrarConexion() {
		try {
			connection.close();
		} catch (SQLException e) {
			System.out.println("Surgió un error al cerrar la conexión, inténtelo más tarde.");
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void finalize() throws Throwable {
		cerrarConexion();
		super.finalize();
	}

}
