package vista;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.DeleteBAController;

public class DeleteBAView extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel delBA_lId;
	private JTextField delBA_tfId;
	private JButton delBA_btnConfirm, delBA_btnCancel;

	private JPanel delBA_panel;

	private GridLayout gdl;

	private DeleteBAController delController;

	public DeleteBAView(JFrame parent, DeleteBAController deleteBAController) {
		super(parent);

		this.delController = deleteBAController;

		this.gdl = new GridLayout(2, 2);

		this.delBA_lId = new JLabel("ID bien amortizable (Compruebe que no dispone de amortizaciones)");
		this.delBA_tfId = new JTextField(6);

		this.delBA_btnConfirm = new JButton("Eliminar");
		this.delBA_btnCancel = new JButton("Cancelar");

		this.delBA_panel = new JPanel();
	}

	public void loadWindow() {
		delBA_panel.setLayout(gdl);

		delBA_panel.add(delBA_lId);
		delBA_panel.add(delBA_tfId);

		delBA_panel.add(delBA_btnCancel);
		delBA_panel.add(delBA_btnConfirm);

		delBA_btnConfirm.addActionListener(this);
		delBA_btnCancel.addActionListener(this);

		this.setTitle("Eliminar Bien Amortizable");
		this.setResizable(false);
		this.add(delBA_panel);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);

	}

	public void showWindow() {
		this.pack();
		this.setVisible(true);
	}

	public String getDelBA_tfId() {
		return delBA_tfId.getText();
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		System.out.println(evt.getActionCommand());
		switch (evt.getActionCommand()) {
		case "Eliminar": {
			delController.deleteBA();
			break;
		}

		case "Cancelar": {
			this.dispose();
			break;
		}
		}
	}

	public void showMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
	}

}
