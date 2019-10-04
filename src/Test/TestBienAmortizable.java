package Test;

import java.math.BigDecimal;

import modelo.BienAmortizable;
import modelo.Conexion;

public class TestBienAmortizable {
	
	public TestBienAmortizable() {
		Conexion conn = new Conexion();
		
		BienAmortizable bien = new BienAmortizable("BA0001","Toyota", "EP0001", new BigDecimal(1999.99), new BigDecimal(40), 8, 2019);
		bien.insert(conn.devolverConexion());
	}
}
