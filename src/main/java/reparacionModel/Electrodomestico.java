package reparacionModel;

public class Electrodomestico {

	private int id;
	private String tipo;
	
	
	public Electrodomestico() {
		super();
	}


	public Electrodomestico(int id, String tipo) {
		super();
		this.id = id;
		this.tipo = tipo;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
	
	
	
}
