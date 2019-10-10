package vista;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.InsertBAController;

public class InsertBAView extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel insBA_lId, insBA_lTipoBien, insBA_lNombre, insBA_lPrecio, insBA_lPorcentaje, insBA_lTiempo, insBA_lAnyo;
	private JTextField insBA_tfId, insBA_tfTipoBien, insBA_tfNombre, insBA_tfPrecio, insBA_tfPorcentaje, insBA_tfTiempo, insBA_tfAnyo;
	private JButton insBA_btnConfirm, insBA_btnCancel;

	private JPanel insBA_panel;

	private GridLayout gdl = new GridLayout(8, 2);

	private InsertBAController baController;

	public InsertBAView(JFrame parent, InsertBAController baController) {
		super(parent);

		this.baController = baController;

		this.insBA_lId = new JLabel("Id");
		this.insBA_lTipoBien = new JLabel("Tipo Bien");
		this.insBA_lNombre = new JLabel("Nombre");
		this.insBA_lPrecio = new JLabel("Precio");
		this.insBA_lPorcentaje = new JLabel("Porcentaje Amortización");
		this.insBA_lTiempo = new JLabel("Tiempo Amortización");
		this.insBA_lAnyo = new JLabel("Año de compra");

		this.insBA_tfId = new JTextField();
		this.insBA_tfTipoBien = new JTextField();
		this.insBA_tfNombre = new JTextField();
		this.insBA_tfPrecio = new JTextField();
		this.insBA_tfPorcentaje = new JTextField();
		this.insBA_tfTiempo = new JTextField();
		this.insBA_tfAnyo = new JTextField();

		this.insBA_btnConfirm = new JButton("Insertar");
		this.insBA_btnCancel = new JButton("Cancelar");

		this.insBA_panel = new JPanel();
	}

	public void loadWindow() {
		insBA_panel.setLayout(gdl);

		insBA_panel.add(insBA_lId);
		insBA_panel.add(insBA_tfId);

		insBA_panel.add(insBA_lTipoBien);
		insBA_panel.add(insBA_tfTipoBien);

		insBA_panel.add(insBA_lNombre);
		insBA_panel.add(insBA_tfNombre);

		insBA_panel.add(insBA_lPrecio);
		insBA_panel.add(insBA_tfPrecio);

		insBA_panel.add(insBA_lPorcentaje);
		insBA_panel.add(insBA_tfPorcentaje);

		insBA_panel.add(insBA_lTiempo);
		insBA_panel.add(insBA_tfTiempo);

		insBA_panel.add(insBA_lAnyo);
		insBA_panel.add(insBA_tfAnyo);

		insBA_panel.add(insBA_btnCancel);
		insBA_panel.add(insBA_btnConfirm);

		insBA_btnConfirm.addActionListener(this);
		insBA_btnCancel.addActionListener(this);

		this.setTitle("Insertar Bien Amortizable");
		this.setSize(640, 480);
		this.setResizable(true);
		this.add(insBA_panel);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}

	public void showWindow() {
		this.setVisible(true);
	}

	public String getInsBA_tfId() {
		return insBA_tfId.getText();
	}

	public String getInsBA_tfTipoBien() {
		return insBA_tfTipoBien.getText();
	}

	public String getInsBA_tfNombre() {
		return insBA_tfNombre.getText();
	}

	public BigDecimal getInsBA_tfPrecio() {
		return new BigDecimal(insBA_tfPrecio.getText());
	}

	public BigDecimal getInsBA_tfPorcentaje() {
		return new BigDecimal(insBA_tfPorcentaje.getText());
	}

	public int getInsBA_tfTiempo() {
		return Integer.parseInt(insBA_tfTiempo.getText());
	}

	public int getInsBA_tfAnyo() {
		return Integer.parseInt(insBA_tfAnyo.getText());
	}

	@Override
	public void actionPerformed(ActionEvent evt) {

		switch (evt.getActionCommand()) {
		case "Insertar": {
			baController.insertBA();

			break;
		}

		case "Cancelar": {
			this.dispose();
		}
		}
	}

	public void showMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
	}
}
