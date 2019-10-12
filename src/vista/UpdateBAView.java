package vista;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.UpdateBAController;

public class UpdateBAView extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel upBA_lId, upBA_lParam, upBA_lValue;
	private JComboBox<String> upBA_cbParam;
	private JTextField upBA_tfId, upBA_tfValue;

	private JButton upBA_btnConfirm, upBA_btnCancel;

	private JPanel upBA_panel;

	private GridLayout gdl;

	private UpdateBAController baController;

	public UpdateBAView(JFrame parent, UpdateBAController updateBAController) {

		baController = updateBAController;

		upBA_lId = new JLabel("Id objetivo");
		upBA_lParam = new JLabel("Valor a alterar");
		upBA_lValue = new JLabel("Nuevo valor");

		upBA_cbParam = new JComboBox<String>();

		String[] params = { "nombre", "precio", "porcentaje", "tiempo", "año" };
		for (String param : params) {
			upBA_cbParam.addItem(param);
		}

		upBA_tfId = new JTextField(6);
		upBA_tfValue = new JTextField();

		upBA_btnConfirm = new JButton("Modificar");
		upBA_btnCancel = new JButton("Cancelar");

		upBA_panel = new JPanel();
		gdl = new GridLayout(4, 2);

	}

	public void loadWindow() {
		upBA_panel.setLayout(gdl);

		upBA_panel.add(upBA_lId);
		upBA_panel.add(upBA_tfId);

		upBA_panel.add(upBA_lParam);
		upBA_panel.add(upBA_cbParam);

		upBA_panel.add(upBA_lValue);
		upBA_panel.add(upBA_tfValue);

		upBA_panel.add(upBA_btnCancel);
		upBA_panel.add(upBA_btnConfirm);

		upBA_btnCancel.addActionListener(this);
		upBA_btnConfirm.addActionListener(this);

		this.setTitle("Modificar Bien Amortizable");
		this.setResizable(true);
		this.add(upBA_panel);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(super.getParent());
		this.setModal(true);
	}

	public void showWindow() {
		this.pack();
		this.setVisible(true);
	}

	public String getUpBA_cbParam() {
		return upBA_cbParam.getSelectedItem().toString();
	}

	public String getUpBA_tfId() {
		return upBA_tfId.getText();
	}

	public String getUpBA_tfValue() {
		return upBA_tfValue.getText();
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		switch (evt.getActionCommand()) {
		case "Modificar": {
			baController.updateBA();
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
