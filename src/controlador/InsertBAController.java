package controlador;

import javax.swing.JFrame;

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
		try {
//TODO: Controlar los datos bien antes de insertarlos. Lo hacemos aquí o en la vista???
			BienAmortizable bienAmortizable = new BienAmortizable(insBA.getInsBA_tfId(), insBA.getInsBA_tfNombre(),
					insBA.getInsBA_tfTipoBien(), insBA.getInsBA_tfPrecio(), insBA.getInsBA_tfPorcentaje(),
					insBA.getInsBA_tfAnyo(), insBA.getInsBA_tfTiempo());

			conexion = new Conexion();
			bienAmortizable.insert(conexion.devolverConexion());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			conexion.cerrarConexion();
		}
	}

}
