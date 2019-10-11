package controlador;

import java.sql.SQLException;

import javax.swing.JFrame;

import Utils.PostgreSQLHandler;
import modelo.BienAmortizable;
import modelo.Conexion;
import vista.InsertBAView;

public class InsertBAController {

	private InsertBAView insBA;
	private Conexion conexion;

	public void init(JFrame parent) {

		insBA = new InsertBAView(parent, this);
		insBA.loadWindow();
		insBA.showWindow();
	}

	public void insertBA() {
		BienAmortizable bienAmortizable = new BienAmortizable(insBA.getInsBA_tfId(), insBA.getInsBA_tfNombre(),
				insBA.getInsBA_tfTipoBien(), insBA.getInsBA_tfPrecio(), insBA.getInsBA_tfPorcentaje(),
				insBA.getInsBA_tfAnyo(), insBA.getInsBA_tfTiempo());

		try {
			// TODO: Controlar los datos bien antes de insertarlos. Lo hacemos aquí o en la
			// vista???

			conexion = new Conexion();
			bienAmortizable.insert(conexion.devolverConexion());

			insBA.showMessage("Transacción realizada correctamente");
			insBA.dispose();

		} catch (SQLException e) {
			PostgreSQLHandler handler = new PostgreSQLHandler(e);
			insBA.showMessage(handler.safeErrorHandling());
		} finally {
			conexion.cerrarConexion();
		}
	}

}
