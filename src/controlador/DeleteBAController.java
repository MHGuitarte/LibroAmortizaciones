package controlador;

import java.sql.SQLException;

import javax.swing.JFrame;

import Utils.PostgreSQLHandler;
import modelo.BienAmortizable;
import modelo.Conexion;
import vista.DeleteBAView;

public class DeleteBAController {

	private DeleteBAView delBA;
	private Conexion conexion;

	public void init(JFrame parent) {
		delBA = new DeleteBAView(parent, this);
		delBA.loadWindow();
		delBA.showWindow();
	}

	public void deleteBA() {
		BienAmortizable bienAmortizable = new BienAmortizable();
		bienAmortizable.setId(delBA.getDelBA_tfId());

		try {
			conexion = new Conexion();
			bienAmortizable.delete(conexion.devolverConexion());
			
			delBA.showMessage("Transacción relalizada correctamente");
			delBA.dispose();
		} catch (SQLException e) {
			PostgreSQLHandler handler = new PostgreSQLHandler(e);
			delBA.showMessage(handler.safeErrorHandling());
		} catch (Exception e) {
			delBA.showMessage(e.getMessage());
		} finally {
			conexion.cerrarConexion();
		}
	}

}
