package controlador;

import java.math.BigDecimal;
import java.sql.SQLException;

import javax.swing.JFrame;

import Utils.PostgreSQLHandler;
import modelo.BienAmortizable;
import modelo.Conexion;
import vista.UpdateBAView;

public class UpdateBAController {

	private UpdateBAView upBA;
	private Conexion conexion;

	public void init(JFrame parent) {
		upBA = new UpdateBAView(parent, this);
		upBA.loadWindow();
		upBA.showWindow();
	}

	public void updateBA() {
		BienAmortizable bienAmortizable = new BienAmortizable();
		bienAmortizable.setId(upBA.getUpBA_tfId());
		try {
			conexion = new Conexion();

			switch (upBA.getUpBA_cbParam()) {
			case "nombre": {
				bienAmortizable.setNombre(upBA.getUpBA_tfValue());
				bienAmortizable.update(conexion.devolverConexion(), "nombre");

				break;
			}

			case "precio": {
				bienAmortizable.setPrecio(new BigDecimal(upBA.getUpBA_tfValue()));
				bienAmortizable.update(conexion.devolverConexion(), "precio");
				break;
			}

			case "porcentaje": {
				bienAmortizable.setPorcent_amort(new BigDecimal(upBA.getUpBA_tfValue()));
				bienAmortizable.update(conexion.devolverConexion(), "porcentaje");
				break;
			}

			case "tiempo": {
				bienAmortizable.setTiempo_amort(Integer.parseInt(upBA.getUpBA_tfValue()));
				bienAmortizable.update(conexion.devolverConexion(), "tiempo");
				break;
			}

			case "año": {
				bienAmortizable.setAnyo_adquisicion(Integer.parseInt(upBA.getUpBA_tfValue()));
				bienAmortizable.update(conexion.devolverConexion(), "nombre");
				break;
			}
			}

			upBA.showMessage("Transacción realizada correctamente");
			upBA.dispose();
		} catch (SQLException e) {
			PostgreSQLHandler handler = new PostgreSQLHandler(e);
			upBA.showMessage(handler.safeErrorHandling());
		} catch (Exception e) {
			upBA.showMessage(e.getMessage());
		} finally {
			conexion.cerrarConexion();
		}
	}

}
