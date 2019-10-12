package controlador;

import vista.MainView;

//import java.sql.Connection;

public class MainController {

	private MainView view;

	public void init() {
		view = new MainView(this);
		view.loadWindow();
		view.showWindow();
	}

	public void openInsertDialog() {
		InsertBAController baInsController = new InsertBAController();
		baInsController.init(view);
	}

	public void openUpdateDialog() {
		UpdateBAController baUpController = new UpdateBAController();
		baUpController.init(view);
	}

	public void openDeleteDialog() {
		DeleteBAController baDelController = new DeleteBAController();
		baDelController.init(view);
	}

	public void openSelectDialog() {

	}
}
