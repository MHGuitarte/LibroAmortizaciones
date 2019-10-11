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
		InsertBAController baController = new InsertBAController();
		baController.init(view);
	}

	public void openUpdateDialog() {
		UpdateBAController baController = new UpdateBAController();
		baController.init(view);
		//TODO: CONTINUE FROM HERE
	}

	public void openDeleteDialog() {
		DeleteBAController baController = new DeleteBAController();
		baController.init(view);
	}

	public void openSelectDialog() {

	}
}
