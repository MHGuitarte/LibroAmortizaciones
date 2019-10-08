package controlador;

import vista.MainView;

//import java.sql.Connection;

public class MainController {

	private MainView view;

	public void init(/* Connection conn */) {
		view = new MainView(this);
		view.setVisible(true);
	}

	public void openInsertDialog() {
		InsertBAController baController = new InsertBAController();
		baController.init(view);
	}

	public void openUpdateDialog() {

	}

	public void openDeleteDialog() {

	}

	public void openSelectDialog() {

	}
}
