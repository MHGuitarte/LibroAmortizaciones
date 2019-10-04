package vista;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InsertBienAmort extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel insBA_lId, insBA_lTipoBien, insBA_lNombre, insBA_lPrecio, insBA_lPorcentaje, insBA_lTiempo,
			insBA_lAnyo;
	private JTextField insBA_tfId, insBA_tfTipoBien, insBA_tfNombre, insBA_tfPrecio, insBA_tfPorcentaje, insBA_tfTiempo,
			insBA_tfAnyo;

	private JPanel insBA_panel;

	private GridLayout gdl = new GridLayout(7, 2);

	public InsertBienAmort(JFrame parent) {
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

		this.insBA_panel = new JPanel();

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

		this.setTitle("Insertar Bien Amortizable");
		this.setSize(640, 480);
		this.setResizable(true);
		this.add(insBA_panel);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public JTextField getInsBA_tfId() {
		return insBA_tfId;
	}

	public JTextField getInsBA_tfTipoBien() {
		return insBA_tfTipoBien;
	}

	public JTextField getInsBA_tfNombre() {
		return insBA_tfNombre;
	}

	public JTextField getInsBA_tfPrecio() {
		return insBA_tfPrecio;
	}

	public JTextField getInsBA_tfPorcentaje() {
		return insBA_tfPorcentaje;
	}

	public JTextField getInsBA_tfTiempo() {
		return insBA_tfTiempo;
	}

	public JTextField getInsBA_tfAnyo() {
		return insBA_tfAnyo;
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		
	}

}
