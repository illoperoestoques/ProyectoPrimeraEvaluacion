package modelo;

public class Guerreros extends Personaje {
	private int ataqueEspecial;
	
	public Guerreros() {
		super();
		this.ataqueEspecial=0;
	}
	
	public Guerreros(String nombre, int vida, int ataque, int defensa, int ataqueEspecial) {
		super(nombre, vida,ataque,defensa);
		this.ataqueEspecial=ataqueEspecial;
	}
	

	public int getAtaqueEspecial() {
		return ataqueEspecial;
	}


	public void setAtaqueEspecial(int ataqueEspecial) {
		this.ataqueEspecial = ataqueEspecial;
	}


	@Override
	public String toString() {
		
		return "Guerrero:" + super.toString() +"\nAtaque Especial= " + ataqueEspecial+ "\n-------------------";
	}
	
	

}
