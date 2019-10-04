package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.InsertBienAmort;
import vista.MainView;

//import java.sql.Connection;

public class MainController {
	
	public void init(/*Connection conn*/) {
		
		MainView view = new MainView();
		view.setVisible(true);
		
		view.getMain_itemInsertTipoBien().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				InsertBienAmort ins_BA = new InsertBienAmort(view);
				ins_BA.setVisible(true);
				
			}
		});
		
	}
}
