package modelo;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Utils.PostgreSQLHandler;

public class Amortizacion {

	private String bien_amortizable;
	private int anyo;
	private BigDecimal valor_amort, valor_acum;
	private PreparedStatement st;
	private ResultSet res;

	public Amortizacion() {
	}

	public Amortizacion(String bien_amortizable, int anyo, BigDecimal valor_amort, BigDecimal valor_acum) {

		this.bien_amortizable = bien_amortizable;
		this.anyo = anyo;
		this.valor_amort = valor_amort;
		this.valor_acum = valor_acum;
	}

	// Getter & Setter

	public String getBien_amortizable() {
		return bien_amortizable;
	}

	public void setBien_amortizable(String bien_amortizable) {
		this.bien_amortizable = bien_amortizable;
	}

	public int getAnyo() {
		return anyo;
	}

	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}

	public BigDecimal getValor_amort() {
		return valor_amort;
	}

	public void setValor_amort(BigDecimal valor_amort) {
		this.valor_amort = valor_amort;
	}

	public BigDecimal getValor_acum() {
		return valor_acum;
	}

	public void setValor_acum(BigDecimal valor_acum) {
		this.valor_acum = valor_acum;
	}

	// CRUD -----------------------

	public void insert(Connection conn) {

		try {
			st = conn.prepareStatement(
					"INSERT INTO amortizacion(bien_amortizable, anio, valor_amor, valor_acumulado) VALUES (?, ?, ?, ?)");

			st.setString(1, this.bien_amortizable);
			st.setInt(2, this.anyo);
			st.setBigDecimal(3, this.valor_amort);
			st.setBigDecimal(4, this.valor_acum);

		} catch (SQLException e) {
			PostgreSQLHandler handler = new PostgreSQLHandler(e);
			System.out.println(handler.safeErrorHandling());
		}
	}

	public void delete(Connection conn) {

		try {
			st = conn.prepareStatement("DELETE FROM amortizacion WHERE bien_amortizable = ? AND anio = ?");
			st.setString(1, this.bien_amortizable);
			st.setInt(2, this.anyo);

			st.execute();
		} catch (SQLException e) {
			PostgreSQLHandler handler = new PostgreSQLHandler(e);
			System.out.println(handler.safeErrorHandling());
		}
	}

	public void update(Connection conn, String row) {

		try {
			st = conn.prepareStatement("UPDATE amortizacion SET ? = ? WHERE bien_amortizable = ? AND anio = ?");

			switch (row.toLowerCase()) {

			// TODO: FINISH WITH CRUD METHODS

			case "valor_amort": {
				st.setString(1, "valor_amort");
				st.setBigDecimal(2, this.valor_amort);
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
			if (this.id != null && this.id != "") {
				st = conn.prepareStatement("SELECT * FROM amortizacion WHERE bien_amortizable = ? AND anio = ?");
				st.setString(1, this.id);

			} else {
				st = conn.prepareStatement("SELECT * FROM amortizacion LIMIT 1");
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
			if (this.id != null && this.id != "") {
				st = conn.prepareStatement("SELECT * FROM amortizacion WHERE bien_amortizable = ? AND anio = ?");
				st.setString(1, this.id);

			} else {
				st = conn.prepareStatement(
						"SELECT * FROM amortizacion WHERE bien_amortizable = 'BA0001' GROUP BY bien_amortizable LIMIT 1");
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
