package ar.edu.usal.programacion.tp1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Validador {

	public static boolean hayEspacioDisponible(Object[] arrayAnalizado){
		int indiceNull = 0;
		while(indiceNull<arrayAnalizado.length){
			if(arrayAnalizado[indiceNull]==null){
				return true;
			}
			else{
				indiceNull++;
			}
		}
		return false;
	}

	public static void insertarEnArray(Object[] arr, Object obj){

		// Busco la primera posicion vacia donde setear el nuevo vehiculo
		for(int i=0; i<arr.length; i++) {

			if(arr[i] == null) {

				arr[i] = obj;
				System.out.println("DATOS INGRESADOS CORRECTAMENTE.");
				break;
			}
		}	
	}

	public static boolean arrayVacio(Object[] arrayAnalizado) {

		int indiceNull = 0;
		while(indiceNull<arrayAnalizado.length){
			if(!(arrayAnalizado[indiceNull]==null)){
				return false;
			}
			else{
				indiceNull++;
			}
		}
		return true;

	}

	public static boolean insertBooleanSyN(String mensaje){

		Scanner s = new Scanner(System.in);
		boolean datosOK = false;
		String sYn = ""; 
		boolean booleanValidado = false;

		do {

			datosOK = true;
			System.out.println(mensaje);

			if(s.hasNextLine()) {

				sYn = s.nextLine();

				if(sYn.isEmpty() || (!sYn.equalsIgnoreCase("s") && !sYn.equalsIgnoreCase("n"))) 

					datosOK = false;
				else{

					if(sYn.equalsIgnoreCase("s"))

						booleanValidado = true;
				}
			}

			if(!datosOK) {

				System.out.println("CARACTER NO VALIDO.");
			}

		} while(!datosOK);

		return booleanValidado;
	}

	public static String insertString(String mensaje){

		Scanner s = new Scanner(System.in);
		boolean datosOK = false;
		String stringValidada = "";

		do {

			datosOK = true;
			System.out.println();
			System.out.println(mensaje);

			if(s.hasNextLine()) {

				stringValidada = s.nextLine();

				if(stringValidada.isEmpty())
					datosOK = false;
			}

			if(!datosOK) {

				System.out.println("VALOR INGRESADO NO VALIDO.");
			}

		} while(!datosOK);

		return stringValidada;
	}

	public static double insertDouble(String mensaje, boolean mayorCero){

		double doubleValidado = 0.0;
		boolean datosOk = false;
		Scanner s = new Scanner(System.in);

		do {

			datosOk = true;
			System.out.println(mensaje);

			if(s.hasNextDouble()) {

				doubleValidado = s.nextDouble();

				if(mayorCero && doubleValidado <= 0.0){ 
					datosOk = false;
					System.out.println("EL VALOR DEBE SER MAYOR A 0.");
				}
			} else {

				datosOk = false;
				s.nextLine();
				System.out.println("VALOR INGRESADO NO VALIDO.");
			}

		} while(!datosOk);

		return doubleValidado;
	}

	public static int insertAnio(String mensaje, String mensajeError, int antiguedadMax) {

		Scanner s = new Scanner(System.in);
		boolean fechaOK = false;						
		int anio = Calendar.getInstance().get(Calendar.YEAR);
		int anioValidado = 0;
		System.out.println();

		do {
			boolean anioAceptado = true;
			System.out.println(mensaje);

			if(s.hasNextInt()) {

				anioValidado = s.nextInt();

				if((anio >= 1000 && anio <= 9999) && ((anioValidado >= (anio - antiguedadMax)) || antiguedadMax == 0)) {

					fechaOK = true;

				} else {
					anioAceptado = false;
					fechaOK = false;
					s.nextLine();
				}

			} else {

				fechaOK = false;
				s.nextLine();
			}

			if(!fechaOK && anioAceptado) 
				System.out.println("A�O INGRESADO NO VALIDO.");
			else if(!anioAceptado)
				System.out.println(mensajeError);

		} while(!fechaOK);

		return anioValidado;
	}

	public static Calendar insertFecha(String mensaje) {

		Scanner s = new Scanner(System.in);
		boolean datosOK = false;						
		Calendar fechaValidada = Calendar.getInstance();
		int dia = 0;
		int mes = 0;
		int anio = 0;

		System.out.println(mensaje);
		do {

			System.out.println("Ingresar dia: ");

			if(s.hasNextInt()) {

				dia = s.nextInt();

				if(dia > 0 && dia <= 31) {

					datosOK = true;

				} else {

					datosOK = false;
					s.nextLine();

				}

			} else {

				datosOK = false;
				s.nextLine();

			}

			if(!datosOK) 
				System.out.println("DIA INGRESADO INVALIDO.");

		} while(!datosOK);

		s.nextLine();

		do {

			System.out.println("Ingresar mes: ");

			if(s.hasNextInt()) {

				mes = s.nextInt();
				if(mes > 0 && mes <= 12) {

					mes--;
					datosOK = true;

				} else {

					datosOK = false;
					s.nextLine();

				}

			} else {

				datosOK = false;
				s.nextLine();

			}

			if(!datosOK) 
				System.out.println("MES INGRESADO INVALIDO.");

		} while(!datosOK);

		s.nextLine();

		do {

			System.out.println("Ingresar a�o (AAAA): ");

			if(s.hasNextInt()) {

				anio = s.nextInt();
				if(anio >= 1000 && anio <= 9999) {

					datosOK = true;

				} else {

					datosOK = false;
					s.nextLine();

				}

			} else {

				datosOK = false;
				s.nextLine();

			}

			if(!datosOK) 
				System.out.println("A�O INGRESADO INVALIDO.");

		} while(!datosOK);

		fechaValidada.set(anio, mes, dia);
		s.nextLine();

		return fechaValidada;
	}

	public static int insertInt(String mensaje, Integer limiteInferior, Integer limiteSuperior, boolean menorCeroTambien) {

		Scanner s = new Scanner(System.in);
		boolean intOk = false;
		int intValidado = 0;

		do {
			intOk = true;
			System.out.println(mensaje);

			if(s.hasNextInt()) {

				intValidado = s.nextInt();

				if((intValidado>=0) || menorCeroTambien) {

					if((limiteInferior != null) && (intValidado >= limiteInferior)){

						if((limiteSuperior != null) && (intValidado <= limiteSuperior)){
							intOk = true;	
						}else if(limiteSuperior == null){
							intOk = true;
						}else{
							intOk = false;
							System.out.println("EL VALOR DEBE SER MENOR O IGUAL A " + limiteSuperior);
						}
					}else if(limiteInferior == null){

						if((limiteSuperior != null) && (intValidado <= limiteSuperior)){
							intOk = true;	
						}else if(limiteSuperior == null){
							intOk = true;
						}else{
							intOk = false;
							System.out.println("EL VALOR DEBE SER MENOR O IGUAL A " + limiteSuperior);
						}
					}else{

						intOk = false;
						System.out.println("EL VALOR DEBE SER MAYOR O IGUAL A " + limiteInferior);
					}

				}else{

					intOk = false;
					s.nextLine();
					System.out.println("DEBE SER MAYOR A CERO.");
				}

			}else{

				System.out.println("VALOR NO VALIDO.");
				intOk = false;
				s.nextLine();
			}
		}while(!intOk);

		return intValidado;
	}

	public static void insertHora(String mensaje, Calendar fechaLlegada) {

		int horaTmp = insertInt("Ingresar Hora (0-23): ", 0, 24, false);
		int hora;

		if(horaTmp == 0 || horaTmp == 24){
			hora = 0;
			fechaLlegada.set(Calendar.AM_PM, Calendar.AM);
		}else if(horaTmp >= 12){

			hora = (horaTmp + 12) - 24;
			fechaLlegada.set(Calendar.AM_PM, Calendar.PM);
		}else{
			hora = horaTmp;
			fechaLlegada.set(Calendar.AM_PM, Calendar.AM);
		}

		fechaLlegada.set(Calendar.HOUR, hora);


		int minutos = insertInt("Ingresar minutos(0-59): ", 0, 59, false);

		fechaLlegada.set(Calendar.MINUTE, minutos);
	}

	public static int calcularDiasEntreFechas(Calendar fechaPartida, Calendar fechaLlegada){

		Date fechaP = fechaPartida.getTime();
		Date fechaL = fechaLlegada.getTime();		

		return (int)( (fechaL.getTime() - fechaP.getTime()) / (1000 * 60 * 60 * 24));
	}

	public static int generarEnteroRandom(int min, int max){

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}

	public static String darFormatoFechaCalendar(Calendar fecha){

		Date fechaDate = fecha.getTime();
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		return formatter.format(fechaDate);
	}
}
