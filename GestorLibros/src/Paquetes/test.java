package Paquetes;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Biblioteca biblioteca = new Biblioteca("Biblio");
		 try {
				
			        // Ejemplo de validacion de titulo vacio o nulo//
			        biblioteca.agregarLibro("", Genero.AVENTURA, "J.K. Rowling", 1997);
			       
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		try {
			
		        // Ejemplos de llamadas al método agregarLibro con distintos parámetros
		        biblioteca.agregarLibro("Harry Potter y la piedra filosofal", Genero.AVENTURA, "J.K. Rowling", 1997);
		        biblioteca.agregarLibro("Don Quijote de la Mancha", Genero.NOVELA, "Miguel de Cervantes", 1605);
		        biblioteca.agregarLibro("El código Da Vinci", Genero.HISTORIA, "Dan Brown", 2003);
		        biblioteca.agregarLibro("1984", Genero.SUSPENSO, "George Orwell", 1949);
		        biblioteca.agregarLibro("1984", Genero.SUSPENSO, "George Orwell", 1949);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		try {
			//Ejemplos de agregado de empleados y de que ocurre si se ingresan dos empleados con el mismo dni//
				biblioteca.darDeAltaEmpleado("Juan Pérez", 123456, EstadoCivil.SOLTERO, 2020, Sector.LIMPIEZA);
		        biblioteca.darDeAltaEmpleado("María Rodríguez", 789012, EstadoCivil.CASADO, 2018, Sector.REPOSITOR);
		        biblioteca.darDeAltaEmpleado("Carlos Gutiérrez", 456789, EstadoCivil.SOLTERO, 2019, Sector.RECEPCION);
		        biblioteca.darDeAltaEmpleado("Carlos Gutiérrez", 456789, EstadoCivil.SOLTERO, 2019, Sector.RECEPCION);


		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			//Ejemplos de agregado de usuarios y de que ocurre si se ingresan dos usuarios con el mismo dni//

			  	biblioteca.darDeAltaUsuario("Remit Burgos", 987654, EstadoCivil.SOLTERO);
		        biblioteca.darDeAltaUsuario("Pedro López", 543210, EstadoCivil.CASADO);
		        biblioteca.darDeAltaUsuario("Luisa Martínez", 135792, EstadoCivil.DIVORCIADO);
		        biblioteca.darDeAltaUsuario("Luisa Martínez", 135792, EstadoCivil.DIVORCIADO);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			//Ejemplos de realizacion de prestamos //
			biblioteca.realizarPrestamo(543210, "Harry Potter y la piedra filosofal");
			biblioteca.realizarPrestamo(987654, "1984");
			biblioteca.realizarPrestamo(987654, "Don Quijote de la Mancha");
			try{//Ejemplo de que ocurre si se intenta alquilar un libro no disponible//
				biblioteca.realizarPrestamo(987654, "1984");
			
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			try{//Ejemplo de que ocurre si intenta alquilar un libro un usuario inexsistente//
				biblioteca.realizarPrestamo(222, "1984");
			
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			try{//Ejemplo de que ocurre si se intenta alquilar un libro que no existe//
				biblioteca.realizarPrestamo(987654, "Harry Potter Y la Piedra Filosofal");
			
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			try{//Ejemplo de que ocurre si intenta alquilar un libro un empleado y no un usuario//
				biblioteca.realizarPrestamo(123456, "Harry Potter Y la Piedra ");
			
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
	}catch(Exception e) {
		System.out.println(e.getMessage());
	}
		try{
			//Muestra de todos los libros prestados hasta el momento//
			biblioteca.mostrarLibrosPrestados();
			//Muestra del filtrado de libros por genero//
			biblioteca.mostrarLibrosPorFiltro(Genero.AVENTURA);
			biblioteca.mostrarLibrosPorFiltro(Genero.SUSPENSO);
			//Muestra de los usuarios que al menos tienen un libro alquilado//
			biblioteca.mostrarUsuariosConLibros();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		try{//Ejemplo de devolucion de libro Exitosa//
			biblioteca.devolverLibro(543210, "Harry Potter y la piedra filosofal");
			//Muestra de listas actualizadas luego de la devolucion efectuada//
			biblioteca.mostrarLibrosPrestados();
			biblioteca.mostrarUsuariosConLibros();
			//Ejemplo de intento de devolucion cuando se intenta devolver un libro que el usuario no tiene//
			biblioteca.devolverLibro(543210, "Harry Potter y la piedra filosofal");


			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		


	}
	
	

}
