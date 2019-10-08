package controlador;

import javax.swing.JFrame;

import vista.InsertBAView;

public class InsertBAController {

	private InsertBAView ins_BA;

	public void init(JFrame parent) {
		ins_BA = new InsertBAView(parent);
		ins_BA.setVisible(true);
	}

}
