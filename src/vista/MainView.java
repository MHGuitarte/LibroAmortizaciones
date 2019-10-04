package vista;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenuBar main_menuBar;
	private JMenu main_menuTipoBien;
	private JMenuItem main_itemInsertTipoBien, main_itemUpdateTipoBien, main_itemDeleteTipoBien,
			main_itemSelectTipoBien;

	public MainView() {
		this.setTitle("Libro Amortizaciones");
		this.setSize(640, 480);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(true);

		main_menuBar = new JMenuBar();

		main_menuTipoBien = new JMenu("Tipo Bien");

		main_itemInsertTipoBien = new JMenuItem("Insertar Tipo Bien");
		main_itemUpdateTipoBien = new JMenuItem("Modificar Tipo Bien");
		main_itemDeleteTipoBien = new JMenuItem("Borrar Tipo Bien");
		main_itemSelectTipoBien = new JMenuItem("Consultar Tipo Bien");

		main_menuTipoBien.add(main_itemSelectTipoBien);
		main_menuTipoBien.add(main_itemInsertTipoBien);
		main_menuTipoBien.add(main_itemUpdateTipoBien);
		main_menuTipoBien.add(main_itemDeleteTipoBien);

		main_menuBar.add(main_menuTipoBien);

		this.setJMenuBar(main_menuBar);

	}

	public JMenuItem getMain_itemInsertTipoBien() {
		return main_itemInsertTipoBien;
	}

	public JMenuItem getMain_itemUpdateTipoBien() {
		return main_itemUpdateTipoBien;
	}

	public JMenuItem getMain_itemDeleteTipoBien() {
		return main_itemDeleteTipoBien;
	}

	public JMenuItem getMain_itemSelectTipoBien() {
		return main_itemSelectTipoBien;
	}
	
	

}
