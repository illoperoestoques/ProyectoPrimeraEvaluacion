package Vista;

public class vista {
	public static void luchadores(String luchador1, String luchador2) {
		System.out.println(luchador1 + " vs " + luchador2);
	}
	public static void da�o(String nombre, int da�o) {
		System.out.println(nombre + " ha recibido un da�o de " + da�o);
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
