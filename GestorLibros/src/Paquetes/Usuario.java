package Paquetes;

import java.util.ArrayList;

public class Usuario extends Persona{
	private static int numeroClienteActual=0;
	private ArrayList<Libro>libros;
	private int cantLibrosAlquilados;
	private int numeroCliente;
	

	public Usuario(String nombre, int numeroIdentificacion, EstadoCivil estado) {
		super(nombre, numeroIdentificacion,estado);
		
		this.libros=new ArrayList<Libro>();
		this.numeroCliente=numeroClienteActual;
		this.numeroClienteActual++;
		
		// TODO Auto-generated constructor stub
	}





	public boolean tieneLibros() {
		// TODO Auto-generated method stub
		return libros.size()>0;
	}


	public void mostrar() {
		super.mostrar();
		System.out.println("Numero De Cliente:"+this.numeroCliente);
		System.out.println("Cantidad De libros Alquilados:"+cantLibrosAlquilados);
		// TODO Auto-generated method stub
		
	}


	public void alquilarLibro(Libro libro) {
		libro.cambiarNoDisponible();
		this.libros.add(libro);
		System.out.println("Libro con el titulo:"+libro.getTitulo()+" Alquilado correctamente por:"+this.getNombre());		
		this.cantLibrosAlquilados++;
		// TODO Auto-generated method stub
		
	}


	public void devolverLibro(Libro libro) {
		Libro libr=this.buscarLibro(libro.getTitulo());
		if(libr==null) {
			throw new IllegalArgumentException("El libro a devolver no esta entre la lista de libros alquilados por el usuario");
		}else {
			this.libros.remove(libro);
			libro.cambiarDisponible();
			System.out.println("Libro con el titulo:"+libro.getTitulo()+" devuelto correctamente por:"+this.getNombre());		
			this.cantLibrosAlquilados--;
		}
		
		// TODO Auto-generated method stub
		
	}
	private Libro buscarLibro(String titulo) {
		Libro encontrado=null;
		int i=0;
		while(i<this.libros.size()&&encontrado==null) {
			Libro buscar=this.libros.get(i);
			if(buscar.getTitulo().equals(titulo)) {
				encontrado=buscar;
			}else {
				i++;
			}
			
		}
		return encontrado;
	}


	@Override
	public String toString() {
		
		return super.toString()+" [cantLibrosAlquilados=" + cantLibrosAlquilados + ", numeroCliente=" + numeroCliente + "]";
	}
	

}
