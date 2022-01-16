package modelo;
import Controlador.*;
import Vista.vista;
public class Partida {	
	public static void main(String[] args) {
		/**
		 * El array personajes contiene todos los personajes que van a pelear
		 * y podran seleccionar los jugadores
		 */
		Personaje [] personajes = new Personaje [10];
		
		//Personaje del juego
		Magos p1 = new Magos ("Harry",30,25,15,5);
		Magos p2 = new Magos ("Gandalf",30,26,15,4);
		Magos p3 = new Magos ("Grifindor",40,13,13,5);
		Magos p4 = new Magos ("Scarlet",25,25,10,8);
		Magos p5 = new Magos ("Laxas",25,25,12,6);
		Guerreros p6 = new Guerreros("Natsu",35, 20, 15, 5);
		Guerreros p7 = new Guerreros("Grey", 30, 20, 15, 8);
		Guerreros p8 = new Guerreros("Elfman", 20, 35, 15, 3);
		Guerreros p9 = new Guerreros("Kratos", 30, 20, 10, 5);
		Guerreros p10 = new Guerreros("Loki", 20, 25, 10, 7);
		
		//aqui se implementan los personajes en el array
		personajes[0]=p1;
		personajes[1]=p6;
		personajes[2]=p2;
		personajes[3]=p7;
		personajes[4]=p3;
		personajes[5]=p8;
		personajes[6]=p4;
		personajes[7]=p9;
		personajes[8]=p5;
		personajes[9]=p10;
		
		
		//Da la bienvenida al juego
		vista.imprimir("Bienvenido a Magos vs Guerreros");
		/**
		 * jugadores sera el numero de jugadores, podra ser de 1 a 4 jugadores.
		 */
		int jugadores = Principal.seleccionaJugadores();
		
		/**
		 * personaje1,2,3 y 4 son los personajes por defecto de cada jugador 
		 * con nada de vida, ataque, defensa y el nombre a null
		 */
		Personaje personaje1 = new Personaje();
		Personaje personaje2 = new Personaje();
		Personaje personaje3 = new Personaje();
		Personaje personaje4 = new Personaje();
		/**
		 * usu es el numero de personaje que escoge cada jugador
		 */
		int usu1=-1;
		int usu2=-1;
		int usu3=-1;
		int usu4=-1;
		
		/**
		 * Muestra los personajes disponibles, el jugador elige personaje y el 
		 * personaje del jugador apunta al personaje que ha escogido.
		 * Segun el numero de jugadores, los jugadores 2, 3 y 4 podran seleccionar un personaje
		 */
		muestraPersonajes(personajes,usu1,usu2,usu3,usu4);
		usu1=Principal.seleccionaPersonaje("Jugador 1",usu1,usu2,usu3,usu4);
		personaje1= personajes[usu1];
			
		if(jugadores>=2) {
			muestraPersonajes(personajes,usu1,usu2,usu3,usu4);
			usu2=Principal.seleccionaPersonaje("Jugador 2",usu1,usu2,usu3,usu4);
			personaje2= personajes[usu2];
		}
		if(jugadores>=3) {
			muestraPersonajes(personajes,usu1,usu2,usu3,usu4);
			usu3=Principal.seleccionaPersonaje("Jugador 3",usu1,usu2,usu3,usu4);
			personaje3= personajes[usu3];
		}
		if(jugadores==4) {
			muestraPersonajes(personajes,usu1,usu2,usu3,usu4);
			usu4=Principal.seleccionaPersonaje("Jugador 4",usu1,usu2,usu3,usu4);
			personaje4= personajes[usu4];
		}
		
		/**
		 * el bucle se repita mientras uno de los 4 personajes de los jugadores sigan vivos 
		 * y haya mas de 2 personajes con vida
		 */
		do {
			//si el personaje tiene vida se ejecuta
			if(personaje1.getVida()>0) {
				//Busca un rival contra quien luchar
				int rival=buscaLucha(personajes, personaje1);
				//Muestra los personajes que van a luchar
				vista.luchadores(personaje1.getNombre(),personajes[rival].getNombre());
				//Se ejecuta el metodo lucha
				lucha(personaje1,personajes[rival]);
			}
			if(personaje2.getVida()>0) {
				int rival=buscaLucha(personajes, personaje2);
				vista.luchadores(personaje2.getNombre(),personajes[rival].getNombre());
				lucha(personaje2,personajes[rival]);
							
			}
			if(personaje3.getVida()>0) {
				int rival=buscaLucha(personajes, personaje3);
				vista.luchadores(personaje3.getNombre(),personajes[rival].getNombre());
				lucha(personaje3,personajes[rival]);			
			}
			if(personaje4.getVida()>0) {
				int rival=buscaLucha(personajes, personaje4);
				vista.luchadores(personaje4.getNombre(),personajes[rival].getNombre());
				lucha(personaje4,personajes[rival]);
			}
		}while(numeroPersonajes(personajes)==true && jugadoresVivos(personaje1, personaje2, personaje3, personaje4)==true);
		
		

	}
	
	/**
	 * Se pasan los 2 personajes que van a luchar, lucharan entre ellos hasta que uno no tenga vida.
	 * Se muestra lo que pasa en la batalla, el ganador y se regenera la vida al que gana la lucha.
	 * @param p1 es el primer personaje 
	 * @param p2 es el segundo personaje
	 */
	public static void lucha (Personaje p1, Personaje p2) {
		//se guarda la vida de los personajes en dos variables para que el ganador se regenere la vida
		int vidaP1= p1.getVida();
		int vidaP2= p2.getVida();
		Magos mago1 = new Magos ();
		Guerreros guerrero1 = new Guerreros();
		Magos mago2 = new Magos ();
		Guerreros guerrero2 = new Guerreros();
		String ganador="";
		//se hace el castin de personajes a magos o guerreros
		if(p1 instanceof Magos) {
			mago1= (Magos) p1;
		}else if(p1 instanceof Guerreros) {
			guerrero1= (Guerreros) p1;
		}
		if(p2 instanceof Magos) {
			mago2= (Magos) p2;
			
		}else if(p2 instanceof Guerreros) {
			guerrero2= (Guerreros) p2;
		}
		//segun si los personajes son magos o guerreros se llama a un 
		//metodo de lucha especifico que devuelven el nombre delganador
		if(mago1.getNombre()!=null && mago2.getNombre()!=null) {
			ganador=luchaDeMagos(mago1, mago2);
		} else if(guerrero1.getNombre()!=null && guerrero2.getNombre()!=null) {
			ganador=luchaDeGuerreros(guerrero1, guerrero2);
		}else if(guerrero1.getNombre()!=null && mago2.getNombre()!=null) {
			//para que empieze a pelear primero el personaje del jugador se
			//pasa 1 o 2 (si se pasa un 1 empezara a atacar el guerrero y 2 empezara el mago)
			ganador=luchaDeGuerrerovsMagos(guerrero1, mago2, 1);
		}else if(mago1.getNombre()!=null && guerrero2.getNombre()!=null) {
			ganador=luchaDeGuerrerovsMagos(guerrero2, mago1, 2);
		}
		//el ganador se regenra la vida 
		if(ganador==p1.getNombre()) {
			p1.setVida(vidaP1);
		}else if(ganador==p2.getNombre()) {
			p2.setVida(vidaP2);
		}
		
	}
	
	/**
	 * se pasan 2 magos que luchan, el mago hace un ataque aleatorio y el otro mago se defiende de ese
	 * ataque con una defensa aleatoria que sera su poder de defensa + la defensa especial aleatoriamente,
	 * muestra lo que pasa en cada turno de la lucha y el ganador de la lucha con la vida que le queda.
	 * @param mago1 es el primer mago que lucha
	 * @param mago2 es el segundo mago que lucha
	 * @return devuelve el nombre del gannador
	 */
	public static String luchaDeMagos (Magos mago1, Magos mago2) {
		int ataque;
		int defensa;
		int resultado;
		int vida;
		String ganador="Ninguno";
		//se repite mientras ambos magos tenga mas de 0 de vida
		while(mago1.getVida()>0 && mago2.getVida()>0){
			if(mago1.getVida()>0) {
				ataque = Principal.numeroAleatorio(1, mago1.getAtaque());
				defensa = (Principal.numeroAleatorio(1, mago2.getDefensa()) + Principal.numeroAleatorio(1, mago2.getDefensaEspecial()));
				resultado= ataque-defensa;
				/**
				 * el resultado es el resultado de ataque - defensa, si el resultado es mayor que 
				 * 0, el mago que defendia se le pone la vida que tenia - el resultado. Si el resultado
				 * es menor que o igual 0 significa que lo ha bloqueado  
				 */
				if (resultado>0) {
					vida = (mago2.getVida()-resultado);
					mago2.setVida(vida);
					//se muestra el daño que le han hecho
					vista.daño(mago2.getNombre(), resultado);
				}else {
					//muestra que ha bloqueado el ataque
					vista.bloqueo(mago2.getNombre());
				}
			}
			//se repite pero el mago que defendia ahora ataca 
			if(mago2.getVida()>0) {
				ataque = Principal.numeroAleatorio(1, mago2.getAtaque());
				defensa = (Principal.numeroAleatorio(1, mago1.getDefensa()) + Principal.numeroAleatorio(1, mago1.getDefensaEspecial()));
				resultado= ataque-defensa;
				if (resultado>0) {
					vida = (mago1.getVida()-resultado);
					mago1.setVida(vida);
					vista.daño(mago1.getNombre(), resultado);
				}else {
					vista.bloqueo(mago1.getNombre());
				}
			}
		}
		//muestra el ganador de la lucha con la vida que le queda 
		if(mago1.getVida()>0) {
			vista.ganador(mago1.getNombre()+ " con " + mago1.getVida() + " de vida");
			ganador=mago1.getNombre();
		}
		if(mago2.getVida()>0) {
			vista.ganador(mago2.getNombre()+ " con " + mago2.getVida() + " de vida");
			ganador=mago2.getNombre();
		}
		return ganador;
	}
	
	/**
	 * se pasan 2 guerreros que luchan, el guerrero hace un ataque aleatorio + el ataque especial aleatorio y el otro guerrero se defiende de ese
	 * ataque con una defensa aleatoria, muestra lo que pasa en cada turno de la lucha y el ganador de la lucha con la vida que le queda.
	 * @param guerrero1 el primer guerrero que lucha
	 * @param guerrero2 el segundo querrero que lucha
	 * @return devuelve el nombre del ganador 
	 */
	public static String luchaDeGuerreros (Guerreros guerrero1, Guerreros guerrero2) {
		int ataque;
		int defensa;
		int resultado;
		int vida;
		String ganador="Ninguno";
		while(guerrero1.getVida()>0 && guerrero2.getVida()>0){
			ataque = (Principal.numeroAleatorio(1, guerrero1.getAtaque()) + Principal.numeroAleatorio(1, guerrero1.getAtaqueEspecial()));
			defensa = Principal.numeroAleatorio(1, guerrero2.getDefensa());
			resultado= ataque-defensa;
			if (resultado>0) {
				vida = (guerrero2.getVida()-resultado);
				guerrero2.setVida(vida);
				vista.daño(guerrero2.getNombre(), resultado);
			}else {
				vista.bloqueo(guerrero2.getNombre());
			}
			if(guerrero2.getVida()>0) {
				ataque = (Principal.numeroAleatorio(1, guerrero2.getAtaque()) + Principal.numeroAleatorio(1, guerrero2.getAtaqueEspecial()));
				defensa = Principal.numeroAleatorio(1, guerrero1.getDefensa());
				resultado= ataque-defensa;
				if (resultado>0) {
					vida = (guerrero1.getVida()-resultado);
					guerrero1.setVida(vida);
					vista.daño(guerrero1.getNombre(), resultado);
				}else {
					vista.bloqueo(guerrero1.getNombre());
				}
			}
		}
		if(guerrero1.getVida()>0) {
			vista.ganador(guerrero1.getNombre()+ " con " + guerrero1.getVida() + " de vida");
			ganador=guerrero1.getNombre();
		}else if(guerrero2.getVida()>0) {
			vista.ganador(guerrero2.getNombre()+ " con " + guerrero2.getVida() + " de vida");
			ganador=guerrero2.getNombre();
		}
		
		return ganador;
	}
	/**
	 * 1 guerrero y 1 mago luchan, el guerrero cuando ataque se le suma el ataque + el ataque especial aleatoriamente
	 * y el mago se le suma la defensa + la defensa especial aleatoriamente.
	 * se muestra lo que pasa en cada turno y el ganador de la lucha con la vida que le queda al ganador.
	 * @param guerrero1 el guerrero que va a luchar
	 * @param mago1 eñ mago que va a luchar
	 * @param num es un entero que se pasa para que el guerrero o mago sea el primero que ataque segun este sea 1 o 2.
	 * @return devuelve el nombre del ganador 
	 */
	public static String luchaDeGuerrerovsMagos (Guerreros guerrero1, Magos mago1, int num) {
		int ataque;
		int defensa;
		int resultado;
		int vida;
		String ganador="Ninguno";
		while(guerrero1.getVida()>0 && mago1.getVida()>0){
			if(num==1) {
				ataque = (Principal.numeroAleatorio(1, guerrero1.getAtaque()) + Principal.numeroAleatorio(1, guerrero1.getAtaqueEspecial()));
				defensa = (Principal.numeroAleatorio(1, mago1.getDefensa()) + Principal.numeroAleatorio(1, mago1.getDefensaEspecial()));
				resultado= ataque-defensa;
				if (resultado>0) {
					vida = (mago1.getVida()-resultado);
					mago1.setVida(vida);
					vista.daño(mago1.getNombre(),resultado);
				}else {
					vista.bloqueo(mago1.getNombre());
				}
			}
			if(mago1.getVida()>0) {
				ataque = Principal.numeroAleatorio(1, mago1.getAtaque());
				defensa = Principal.numeroAleatorio(1, guerrero1.getDefensa());
				resultado= ataque-defensa;
				if (resultado>0) {
					vida = (guerrero1.getVida()-resultado);
					guerrero1.setVida(vida);	
					vista.daño(guerrero1.getNombre(),resultado);
				}else {
					vista.bloqueo(guerrero1.getNombre());
				}
			}
			if(num==2 && guerrero1.getVida()>0) {
				ataque = (Principal.numeroAleatorio(1, guerrero1.getAtaque()) + guerrero1.getAtaqueEspecial());
				defensa = (Principal.numeroAleatorio(1, mago1.getDefensa()) + Principal.numeroAleatorio(1, mago1.getDefensaEspecial()));
				resultado= ataque-defensa;
				if (resultado>0) {
					vida = (mago1.getVida()-resultado);
					mago1.setVida(vida);
					vista.daño(mago1.getNombre(),resultado);
				}else {
					vista.bloqueo(mago1.getNombre());
				}
			}

		}
		if(guerrero1.getVida()>0) {
			vista.ganador(guerrero1.getNombre()+ " con " + guerrero1.getVida() + " de vida");
			ganador=guerrero1.getNombre();
		}else if(mago1.getVida()>0) {
			vista.ganador(mago1.getNombre()+ " con " + mago1.getVida() + " de vida");
			ganador=mago1.getNombre();
		}
		return ganador;
	}
		
	/**
	 * busca un contrincante en una array de personajes para un personaje que le pasemos 
	 * @param array es el array de personajes
	 * @param p1 es el personaje que busca una lucha
	 * @return devuelve la pocicion en el array donde se encuentra el contrincante 
	 */
	public static int buscaLucha(Personaje array[], Personaje p1) {
		int luchador=-1;
		//se repite el bucle hasta encontrar un enemigo
		do {
			//genera un numero aleatorio entre 0 y 9
			int n= Principal.numeroAleatorio(0, 9);
			//si el personaje tiene menos de 0 de vida o tiene el mismo nombre que el personaje que
			// le pasemos no sirve de enemigo.
			if(array[n].getVida()<=0 || p1.getNombre()==array[n].getNombre()) {
				//NADA
			}else {
				luchador=n;
			}
		}while(luchador==-1);
		return luchador;
	}
	/**
	 * muestra los personajes que puede elegir el jugador
	 * @param array el array con los personajes a mostrar 
	 * @param u1 es el numero de personaje que ha seleccionado el jugador1
	 * @param u2 es el numero de personaje que ha seleccionado el jugador2
	 * @param u3 es el numero de personaje que ha seleccionado el jugador3
	 * @param u4 es el numero de personaje que ha seleccionado el jugador4
	 * el numero de personaje del jugador esta predefinido a -1 para que los personajes se muestren aunque
	 * los jugadores todovia no hayan seleccionado el personaje
	 */
	public static void muestraPersonajes(Personaje array[], int u1,int u2,int u3,int u4) {
		for(int i=0;i<array.length;i++) {
			Magos mago = new Magos ();
			Guerreros guerrero = new Guerreros();
			if(array[i]!=null && i!=u1 && i!=u2 && i!=u3 && i!=u4) {
				if(array[i] instanceof Magos) {
					mago= (Magos) array[i];
				}else if(array[i] instanceof Guerreros) {
					guerrero= (Guerreros) array[i];
				}
				if(mago.getNombre()!=null ) {
					Principal.esperar(1);
					System.out.println("Personaje " + i);
					System.out.println(mago);
				}
				if(guerrero.getNombre()!=null) {
					Principal.esperar(1);
					System.out.println("Personaje " + i);
					System.out.println(guerrero);
				}
			}
		}
	}
	/**
	 * cuenta los personajes vivos que hay en el array, si hay menos de 2 devuelve false
	 * @param array es el array de personajes 
	 * @return devuelve true cuando hay 2 o mas personajes en el array
	 */
	public static boolean numeroPersonajes(Personaje array[]) {
		boolean valid= true;
		int personajes=0;
		
		for(int i=0;i<array.length;i++) {
			if(array[i].getVida()>0) {
				personajes++;
			}	
		}
		if(personajes<2) {
			valid = false;
		}
		return valid;
	}
	
	/**
	 * si todos los personajes de todos los jugadores tienen 0 o menos vida deveulve false 
	 * @param p1 personaje de jugador 1
	 * @param p2 personaje de jugador 2
	 * @param p3 personaje de jugador 3
	 * @param p4 personaje de jugador 4
	 * @return devuelve si todos sus personajes estan muertos
	 */
	public static boolean jugadoresVivos(Personaje p1,Personaje p2,Personaje p3,Personaje p4) {
		boolean valid=true;
		if(p1.getVida()<=0 && p2.getVida()<=0 && p3.getVida()<=0 && p3.getVida()<=0) {
			valid=false;
		}
		return valid;
	}

}