package Utils;

import java.sql.SQLException;

public class PostgreSQLHandler {

	private SQLException error;

	public PostgreSQLHandler(SQLException e) {
		this.error = e;
	}

	public String safeErrorHandling() {
		String responseStatement = "";

		switch (error.getSQLState()) {

		case "08000": {
			responseStatement = "Error Code (80000): No se ha encontrado una conexión activa.";
			break;
		}

		case "22000": {
			// Esto se puede amplificar con los tipos de datos incorrectos
			responseStatement = "Error Code (22000): Error encontrado en la inserción de datos. Por favor, revise los datos e inténtelo de nuevo.";
			break;
		}

		case "23502": {
			responseStatement = "Error Code (23502): Se ha introducido un valor nulo en un campo no nulo. Por favor, revise su consulta e inténtelo de nuevo.";
			break;
		}

		case "23503": {
			responseStatement = "Error Code (23503):Se ha introducido un valor en un campo con clave foránea, pero no se han encontrado claves primarias coincidentes.";
			break;
		}

		default: {
			responseStatement = "Error Code (0): Error no encontrado.";
		}

		// TODO: Finish Error Code Handling
		}

		return responseStatement;
	}

}
