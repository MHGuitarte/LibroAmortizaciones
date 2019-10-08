package controlador;

import modelo.Conexion;
import vista.MainView;

//import java.sql.Connection;

public class MainController {

	private MainView view;
	private Conexion conexion;
	
	public void init(Conexion conexion) {
		this.conexion = conexion;
		
		view = new MainView(this);
		view.loadWindow();
		view.showWindow();
	}

	public void openInsertDialog() {
		InsertBAController baController = new InsertBAController();
		baController.init(view, conexion);
	}

	public void openUpdateDialog() {

	}

	public void openDeleteDialog() {

	}

	public void openSelectDialog() {

	}
}
