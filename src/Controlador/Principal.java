package Controlador;
import java.util.InputMismatchException;
import java.util.Scanner;

import Vista.vista;

public class Principal {
	/**
	 * se pasa dos numeros enteros y devuelve un numero aleatorio entre esos 2
	 * @param min numero minimo
	 * @param max numero maximo 
	 * @return un entero aletorio
	 */
	public static int numeroAleatorio (int min, int max) {
		int n = (int)(Math.random()*((max+1)-min)+min);
		return n;
	}
	/**
	 * el programa espera los segundos que le pasen.
	 * @param segundos numero de segundos de espera
	 */
	public static void esperar(int segundos){
        try {
            Thread.sleep(segundos * 1000);
         } catch (Exception e) {
            System.out.println(e);
         }
    }   
	/**
	 * devuelve un entero que escribe el usuario
	 * @param f el texto que se muestra al usuario
	 * @return devuelve un entero 
	 */
	public static int leeEntero(String f) {
		Scanner teclado = new Scanner (System.in);
		int numero=-1;
		boolean valid=false;//variable para terminar el bucle cuando el valor sea correcto
        do{
           try{
                System.out.println(f);
                numero=teclado.nextInt();
                valid=true;

           }catch(InputMismatchException ex){
                System.out.println("Numero entero no valido.");
                teclado.next();
                
           }
        }while(!valid);
        return numero;
	}
	/**
	 * el jugador inserta el numero de personaje que quiere, no puede ser otro que haya elegido
	 * otro jugador o que sea menor que 0 o mayor que 9
	 * @param nombre nombre del jugador
	 * @param u1 es el numero de personaje del jugador 1
	 * @param u2 es el numero de personaje del jugador 2
	 * @param u3 es el numero de personaje del jugador 3
	 * @param u4 es el numero de personaje del jugador 4
	 * @return devuelve el numero
	 * el numero de personajes esta predifindo a -1 
	 */
	public static int seleccionaPersonaje(String nombre, int u1,int u2,int u3,int u4) {
		int usu=-1;
		boolean valid=false;
        do{
           try{
                usu=leeEntero(nombre + ", escoge Personaje:");
                if(usu>=0 && usu<=9 && usu!=u1 && usu!=u2 && usu!=u3 && usu!=u4) {
                valid=true;
                }
           }catch(InputMismatchException ex){
                vista.imprimir("Tienes que introducir un numero entre 0 y 9.");
           }
        }while(!valid);
        return usu;
	}
	/**
	 * el usuario elije el numero de jugadores que sera de 1 a 4
	 * @return devuelve el numero de jugadores que van a jugar 
	 */
	public static int seleccionaJugadores() {
		int usu=-1;
		boolean valid=false;
        do{
           try{
                usu=leeEntero("Introduce un numero de 1 a 4 jugadores:");
                if(usu>=1 && usu<=4 ) {
                valid=true;
                }
           }catch(InputMismatchException ex){
                System.out.println("Tienes que introducir un numero entre 1 y 4.");
                
           }
        }while(!valid);
        return usu;
	}
		
}
