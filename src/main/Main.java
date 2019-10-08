package main;

import controlador.MainController;
import modelo.Conexion;

public class Main {

	public static void main(String[] args) {
		
		Conexion conexion = new Conexion();
		
		MainController controller = new MainController();
		controller.init(conexion);
		
	}
}
