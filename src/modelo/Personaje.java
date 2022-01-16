package modelo;

public class Personaje {
	private String nombre;
	private int vida;
	private int ataque;
	private int defensa;
	
	public Personaje() {
		this.nombre=null;
		this.vida=-1;
		this.ataque=-1;
		this.defensa=-1;
	}
	
	public Personaje(String nombre, int vida, int ataque, int defensa) {
		this.nombre=nombre;
		this.vida=vida;
		this.ataque=ataque;
		this.defensa=defensa;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		this.vida = vida;
	}
	public int getAtaque() {
		return ataque;
	}
	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}
	public int getDefensa() {
		return defensa;
	}
	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}
	@Override
	public String toString() {
		return "\nNombre= " + nombre + "\nVida= " + vida + "\nAtaque= " + ataque + "\nDefensa= " + defensa;
	}
	
}