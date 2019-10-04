package modelo;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@SuppressWarnings("unused")
public class BienAmortizable {

	private String id, nombre, tipo;
	private BigDecimal precio, porcent_amort;
	private int anyo_adquisicion, tiempo_amort;
	private PreparedStatement st;

	// Constructors

	public BienAmortizable() {
	}

	public BienAmortizable(String id, String nombre, String tipo, BigDecimal precio, BigDecimal porcent_amort,
			int anyo_adquisicion, int tiempo_amort) {

		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
		this.precio = precio;
		this.porcent_amort = porcent_amort;
		this.anyo_adquisicion = anyo_adquisicion;
		this.tiempo_amort = tiempo_amort;
	}

	// Getter & Setter

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public BigDecimal getPorcent_amort() {
		return porcent_amort;
	}

	public void setPorcent_amort(BigDecimal porcent_amort) {
		this.porcent_amort = porcent_amort;
	}

	public int getAnyo_adquisicion() {
		return anyo_adquisicion;
	}

	public void setAnyo_adquisicion(int anyo_adquisicion) {
		this.anyo_adquisicion = anyo_adquisicion;
	}

	public int getTiempo_amort() {
		return tiempo_amort;
	}

	public void setTiempo_amort(int tiempo_amort) {
		this.tiempo_amort = tiempo_amort;
	}

	// CRUD -----------------------

	public void insert(Connection conn) {

		try {
			st = conn.prepareStatement("INSERT INTO bien_amortizable(id, tipo_bien, nombre, precio,"
					+ "porcentaje_amor, tiempo_amor, anio_adquisicion) VALUES" + "(?, ?, ?, ?, ?, ?, ?)");

			st.setString(1, this.id);
			st.setString(2, this.tipo);
			st.setString(3, this.nombre);
			st.setBigDecimal(4, this.precio);
			st.setBigDecimal(5, this.porcent_amort);
			st.setLong(6, this.tiempo_amort);
			st.setLong(7, this.anyo_adquisicion);

			/*
			 * st.execute( "INSERT INTO bien_amortizable(id, tipo_bien, nombre, precio,
			 * porcentaje_amor, tiempo_amor, anio_adquisicion) VALUES ('" + this.id + "', '"
			 * + this.tipo + "', '" + this.nombre + "', " + this.precio + ", " +
			 * this.porcent_amort + ", " + this.tiempo_amort + ", " + this.anyo_adquisicion
			 * + ");");
			 */
		} catch (SQLException e) {
			PostgreSQLErrorHandling(e);
		}
	}

	public void delete(Connection conn) {

		try {
			st = conn.prepareStatement("DELETE FROM bien_amortizable WHERE id = ?");
			st.setString(1, this.id);

			st.execute();
		} catch (SQLException e) {
			PostgreSQLErrorHandling(e);

		}
	}

	public void update(Connection conn, String row) {
		
		//UPDATE solo controla ciertos campos que podrán alterarse, el resto no

		try {
			st = conn.prepareStatement("UPDATE bien_amortizable SET ? = ? WHERE id = ?");

			switch (row.toLowerCase()) {

			case "nombre": {
				st.setString(1, "nombre");
				st.setString(2, this.nombre);
				st.setString(3, this.id);

				break;
			}

			case "precio": {
				st.setString(1, "precio");
				st.setBigDecimal(2, this.precio);
				st.setString(3, this.id);

				st.execute();
				break;
			}

			case "porcentaje": {
				st.setString(1, "porcentaje_amor");
				st.setBigDecimal(2, this.porcent_amort);
				st.setString(3, this.id);

				break;
			}

			case "tiempo": {
				st.setString(1, "tiempo_amor");
				st.setInt(2, this.tiempo_amort);
				st.setString(3, this.id);

				break;
			}

			case "anyo": {
				st.setString(1, "anio_adquisicion");
				st.setInt(2, this.anyo_adquisicion);
				st.setString(3, this.id);

				break;
			}
			
			default: {
				System.out.println("El campo al que trata de acceder no es actualizable "
						+ "o no se encuentra en esta tabla.");
				
				break;
			}

			}

			st.execute();
		} catch (SQLException e) {
			PostgreSQLErrorHandling(e);

		}

	}

	private String PostgreSQLErrorHandling(SQLException error) {
		String responseStatement = "Error Code (0): Error no encontrado.";

		return responseStatement;
	}

}
