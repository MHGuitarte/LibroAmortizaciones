package modelo;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Utils.PostgreSQLHandler;

public class TipoBien {

	private String id, elem_patr;
	private int tiempo_limite;
	private BigDecimal porcentaje_max;
	private PreparedStatement st;
	private ResultSet res;

	// Constructors

	public TipoBien() {
	}

	public TipoBien(String id, String elem_patr, int tiempo_limite, BigDecimal porcentaje_max) {
		this.id = id;
		this.elem_patr = elem_patr;
		this.tiempo_limite = tiempo_limite;
		this.porcentaje_max = porcentaje_max;
	}

	// Getter & Setter

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getElem_patr() {
		return elem_patr;
	}

	public void setElem_patr(String elem_patr) {
		this.elem_patr = elem_patr;
	}

	public int getTiempo_limite() {
		return tiempo_limite;
	}

	public void setTiempo_limite(int tiempo_limite) {
		this.tiempo_limite = tiempo_limite;
	}

	public BigDecimal getPorcentaje_max() {
		return porcentaje_max;
	}

	public void setPorcentaje_max(BigDecimal porcentaje_max) {
		this.porcentaje_max = porcentaje_max;
	}

	// CRUD -----------------------

	public void insert(Connection conn) {

		try {
			st = conn.prepareStatement(
					"INSERT INTO tipo_bien(id, elem_patr, tiempo_limite, porcentaje_max) VALUES (?, ?, ?, ?)");

			st.setString(1, this.id);
			st.setString(2, this.elem_patr);
			st.setInt(3, this.tiempo_limite);
			st.setBigDecimal(4, this.porcentaje_max);

		} catch (SQLException e) {
			PostgreSQLHandler handler = new PostgreSQLHandler(e);
			System.out.println(handler.safeErrorHandling());
		}
	}

	public void delete(Connection conn) {

		try {
			st = conn.prepareStatement("DELETE FROM tipo_bien WHERE id = ?");
			st.setString(1, this.id);

			st.execute();
		} catch (SQLException e) {
			PostgreSQLHandler handler = new PostgreSQLHandler(e);
			System.out.println(handler.safeErrorHandling());
		}
	}

	public void update(Connection conn, String row) {

		try {
			st = conn.prepareStatement("UPDATE tipo_bien SET ? = ? WHERE id = ?");

			switch (row.toLowerCase()) {

			case "elem_patr": {
				st.setString(1, "elem_patr");
				st.setString(2, this.elem_patr);
				st.setString(3, this.id);

				break;
			}

			case "tiempo_limite": {
				st.setString(1, "tiempo_limite");
				st.setInt(2, this.tiempo_limite);
				st.setString(3, this.id);

				st.execute();
				break;
			}

			case "porcentaje_max": {
				st.setString(1, "porcentaje_max");
				st.setBigDecimal(2, this.porcentaje_max);
				st.setString(3, this.id);

				break;
			}

			default: {
				System.out.println(
						"El campo al que trata de acceder no es actualizable " + "o no se encuentra en esta tabla.");

				break;
			}

			}

			st.execute();
		} catch (SQLException e) {
			PostgreSQLHandler handler = new PostgreSQLHandler(e);
			System.out.println(handler.safeErrorHandling());
		}

	}

	public void selectOne(Connection conn) {
		try {

			// Comprobamos si el usuario ha introducido la id para la selección, si no,
			// seleccionamos el primer valor de la tabla
			if (this.id != null || this.id != "") {
				st = conn.prepareStatement("SELECT * FROM tipo_bien WHERE id = ?");
				st.setString(1, this.id);

			} else {
				st = conn.prepareStatement("SELECT * FROM tipo_bien LIMIT 1");
			}

			res = st.executeQuery();

			// Devolvemos toda la selección dentro del mismo objeto que la llama

			this.id = res.getString("id");
			this.elem_patr = res.getString("elem_patr");
			this.tiempo_limite = res.getInt("tiempo_limite");
			this.porcentaje_max = res.getBigDecimal("porcentaje_max");

		} catch (SQLException e) {
			PostgreSQLHandler handler = new PostgreSQLHandler(e);
			System.out.println(handler.safeErrorHandling());
		}
	}

	public void selectNext(Connection conn) {
		try {

			// Repetimos el proceso de selectOne, pero si esta vez no encuentra id en el
			// objeto, mostrará la segunda entrada de la tabla (next from first).
			if (this.id != null || this.id != "") {
				st = conn.prepareStatement("SELECT * FROM tipo_bien WHERE id > ? ORDER BY id LIMIT 1");
				st.setString(1, this.id);

			} else {
				st = conn.prepareStatement("SELECT * FROM tipo_bien WHERE id > 'EP0001' ORDER BY id LIMIT 1");
			}

			res = st.executeQuery();

			// Devolvemos toda la selección dentro del mismo objeto que la llama
			// TODO: ¿Esto es más óptimo que devolver el ResultSet?

			this.id = res.getString("id");
			this.elem_patr = res.getString("elem_patr");
			this.tiempo_limite = res.getInt("tiempo_limite");
			this.porcentaje_max = res.getBigDecimal("porcentaje_max");

		} catch (SQLException e) {
			PostgreSQLHandler handler = new PostgreSQLHandler(e);
			System.out.println(handler.safeErrorHandling());
		}
	}

}
