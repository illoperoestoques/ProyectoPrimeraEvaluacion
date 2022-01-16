package Vista;

public class vista {
	public static void luchadores(String luchador1, String luchador2) {
		System.out.println(luchador1 + " vs " + luchador2);
	}
	public static void daño(String nombre, int daño) {
		System.out.println(nombre + " ha recibido un daño de " + daño);
	}
	public static void bloqueo(String nombre) {
		System.out.println(nombre + "ha bloqueado el ataque");
	}
	public static void imprimir(String texto) {
		System.out.println(texto);
	}
	public static void ganador(String nombre) {
		System.out.println("Ganador: " + nombre);
	}
	public static void pierde(String nombre) {
		System.out.println("El personaje del jugador " + nombre + " ha perdido");
	}
	
}
