package Paquetes;

import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
	private String nombre;
	private ArrayList<Libro>libros;
	private ArrayList<Persona>personas;
	public Biblioteca(String nombre) {
		this.nombre=nombre;
		this.libros=new ArrayList<Libro>();
		this.personas=new ArrayList<Persona>();
	}
	
	public void agregarLibro(String titulo,Genero genero,String autor,int añoPublicacion) {
		Libro agregar=this.buscarLibro(titulo);
		if(agregar!=null) {
			throw new IllegalArgumentException("Hay un libro ya registrado con ese mismo titulo => "+titulo);
		}
		libros.add(new Libro(titulo,genero,autor,añoPublicacion));
		System.out.println("Libro Con el titulo:"+titulo+" Agregado correctamente");
		
	}
	public void darDeAlta(Persona persona) {
		personas.add(persona);
	}
	public void darDeAltaEmpleado(String nombre, int numeroIdentificacion, EstadoCivil estado,int añoIncorporado,Sector sector) {
		Persona persona=buscarPersona(numeroIdentificacion);
		this.lanzarExcepcionPersonaExiste(persona);
		this.darDeAlta(new Empleado(nombre,numeroIdentificacion,estado,añoIncorporado,sector));
		System.out.println("Empleado:"+nombre+" Dado de alta");

	}
	public void darDeAltaUsuario(String nombre,int numeroIdentificacion,EstadoCivil estado) {
		Persona persona=buscarPersona(numeroIdentificacion);
		this.lanzarExcepcionPersonaExiste(persona);
		this.darDeAlta(new Usuario(nombre,numeroIdentificacion,estado));
		System.out.println("Usuario:"+nombre+" Dado de alta");
		
	}
	private void lanzarExcepcionPersonaExiste(Persona persona) {
		if(persona!=null) {
			throw new IllegalArgumentException("Ya hay una persona registrada con ese numero de identificacion => "+persona.getNumeroIdentificacion());
		}
		
	}
	private void lanzarExcepcionPersonaNoExiste(Persona persona) {
		if(persona==null) {
			throw new IllegalArgumentException("No hay una persona registrada con ese numero de identificacion");
		}
	}
	

	private Persona buscarPersona(int numeroIdentificacion) {
		Persona encontrado=null;
		int i=0;
		while(i<this.personas.size()&&encontrado==null) {
			Persona buscar=this.personas.get(i);
			if(buscar.getNumeroIdentificacion()==numeroIdentificacion) {
				
				encontrado=buscar;
			}else {
				i++;
			}
			
		}
		return encontrado;
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
	
	public void realizarPrestamo(int numeroIdentificacion,String tituloLibro) {
		Libro libro=this.buscarLibro(tituloLibro);
		Persona persona=this.buscarPersona(numeroIdentificacion);
		
		this.lanzarExcepcionPersonaNoExiste(persona);
		if(persona instanceof Usuario) {
			this.lanzarExcepcionLibroNoExiste(libro);
				if(libro.getEstado()) {
					((Usuario) persona).alquilarLibro(libro);
				}else {
					throw new IllegalArgumentException("El libro no se encuentra disponible");
				}
			
			
		}else {
			throw new IllegalArgumentException("El numero de identificacion no corresponde a un usuario");
		}}
	
	
	public void devolverLibro(int numeroIdentificacion,String titulo) {
		Libro libro=this.buscarLibro(titulo);
		Persona persona=this.buscarPersona(numeroIdentificacion);
		this.lanzarExcepcionPersonaNoExiste(persona);
		this.lanzarExcepcionLibroNoExiste(libro);
		if(persona instanceof Usuario) {
			Usuario usuario=(Usuario)persona;
			usuario.devolverLibro(libro);
		}
		
	}
	private void lanzarExcepcionLibroNoExiste(Libro libro) {
		// TODO Auto-generated method stub
		if(libro==null) {
			throw new IllegalArgumentException("Libro con ese titulo inexistente");
		}
		
		
	}
	private ArrayList<Libro> obtenerLibrosPrestados() {
		ArrayList<Libro>librosPrestados=new ArrayList<Libro>();
		for(Libro libro:this.libros) {
			if(!libro.estado()) {
				librosPrestados.add(libro);
				
			}
			
		}
		return librosPrestados;
	}
	public void mostrarLibrosPrestados() {
		ArrayList<Libro>librosMostrables=this.obtenerLibrosPrestados();
		System.out.println("Libros prestados hasta el momento:");
		
		this.mostrarLista(librosMostrables);
		
	}
	private void mostrarLista(ArrayList<?>lista) {
		for(Object objeto:lista) {
			System.out.println(objeto.toString());
		}
	}
	private ArrayList<Usuario> obtenerUsuariosConLibros() {
		ArrayList<Usuario>usuarios=new ArrayList<>();
		for(Persona usuario:this.personas) {
			if(usuario instanceof Usuario) {
				Usuario user=(Usuario)usuario;
				if(user.tieneLibros()) {
					usuarios.add(user);
				}
			}
			
		}
		return usuarios;
		
	}
	public void mostrarUsuariosConLibros() {
		ArrayList<Usuario>usuarios=this.obtenerUsuariosConLibros();
		System.out.println("Usuarios con libros Alquilados");
		
		this.mostrarLista(usuarios);
	}
	private ArrayList<Libro>filtradoLibro(Genero genero){
		ArrayList<Libro>librosFiltrados=new ArrayList<Libro>();
		for(Libro libro:this.libros) {
			if(libro.getGenero()==genero) {
				librosFiltrados.add(libro);
			}
			
		}
		return librosFiltrados;
	}
	public void mostrarLibrosPorFiltro(Genero genero) {
		System.out.println("Libros del genero:"+genero);
		ArrayList<Libro>librosFiltrados=this.filtradoLibro(genero);
		
		this.mostrarLista(librosFiltrados);
	}
}
