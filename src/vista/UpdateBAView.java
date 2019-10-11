package vista;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.UpdateBAController;

public class UpdateBAView extends JDialog implements ActionListener {

	private JLabel upBA_lId, upBA_lParam, upBA_lValor;
	private JComboBox upBA_cbParam;
	private JTextField upBA_tfId, upBA_tfValor;
	
	private JPanel upBA_panel;
	
	private GridLayout gdl;

	public UpdateBAView(JFrame parent, UpdateBAController updateBAController) {
//TODO:FINISH THIS
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

	}

}
