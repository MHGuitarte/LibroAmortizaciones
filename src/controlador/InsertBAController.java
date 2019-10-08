package controlador;

import javax.swing.JFrame;

import modelo.BienAmortizable;
import modelo.Conexion;
import vista.InsertBAView;

public class InsertBAController {

	private InsertBAView insBA;
	private Conexion conexion;

	public void init(JFrame parent, Conexion conexion) {
		this.conexion = conexion;

		insBA = new InsertBAView(parent, this);
		insBA.loadWindow();
		insBA.showWindow();
	}

	public void insertBA() {
		BienAmortizable bienAmortizable = new BienAmortizable(insBA.getInsBA_tfId(), insBA.getInsBA_tfNombre(),
				insBA.getInsBA_tfTipoBien(), insBA.getInsBA_tfPrecio(), insBA.getInsBA_tfPorcentaje(),
				insBA.getInsBA_tfAnyo(), insBA.getInsBA_tfTiempo());

		System.out.println(bienAmortizable.toString());

		try {
			// TODO: Esto da puntero nulo; no se por qué
			bienAmortizable.insert(conexion.devolverConexion());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
