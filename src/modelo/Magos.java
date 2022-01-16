package modelo;

public class Magos extends Personaje {
	private int defensaEspecial;
	public Magos(String nombre, int vida, int ataque, int defensa, int defensaEspecial) {
		super(nombre, vida,ataque,defensa);
		this.defensaEspecial=defensaEspecial;
	}
	public Magos() {
		super();
		this.defensaEspecial=0;
	}
	
	public int getDefensaEspecial() {
		return defensaEspecial;
	}

	public void setDefensaEspecial(int defensaEspecial) {
		this.defensaEspecial = defensaEspecial;
	}

	@Override
	public String toString() {
		return "Mago:" + super.toString() +"\nDefensa Especial= " + defensaEspecial+"\n-----------------";
	}
	
	
}
