package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controlador.MainController;

public class MainView extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenuBar main_menuBar;
	private JMenu main_menuTipoBien;
	private JMenuItem main_itemInsertTipoBien, main_itemUpdateTipoBien, main_itemDeleteTipoBien,
			main_itemSelectTipoBien;
	private MainController mainController;

	public MainView(MainController mainController) {

		main_menuBar = new JMenuBar();

		main_menuTipoBien = new JMenu("Tipo Bien");

		main_itemInsertTipoBien = new JMenuItem("Insertar Tipo Bien");
		main_itemUpdateTipoBien = new JMenuItem("Modificar Tipo Bien");
		main_itemDeleteTipoBien = new JMenuItem("Borrar Tipo Bien");
		main_itemSelectTipoBien = new JMenuItem("Consultar Tipo Bien");

	}

	public void loadWindow() {
		this.mainController = new MainController();

		this.setTitle("Libro Amortizaciones");
		this.setSize(640, 480);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(true);
		this.setLocationRelativeTo(null);

		main_menuTipoBien.add(main_itemSelectTipoBien);
		main_menuTipoBien.add(main_itemInsertTipoBien);
		main_menuTipoBien.add(main_itemUpdateTipoBien);
		main_menuTipoBien.add(main_itemDeleteTipoBien);

		main_itemSelectTipoBien.addActionListener(this);
		main_itemInsertTipoBien.addActionListener(this);
		main_itemDeleteTipoBien.addActionListener(this);
		main_itemUpdateTipoBien.addActionListener(this);

		main_menuBar.add(main_menuTipoBien);

		this.setJMenuBar(main_menuBar);
	}

	public void showWindow() {
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		switch (evt.getActionCommand()) {

		case "Insertar Bien Amortizable": {
			mainController.openInsertDialog();
			break;
		}
		case "Modificar Bien Amortizable": {
			mainController.openUpdateDialog();
			break;
		}

		case "Borrar Bien Amortizable": {
			mainController.openDeleteDialog();
			break;
		}
		case "Consultar Bien Amortizable": {

			break;
		}

		}
	}

}
