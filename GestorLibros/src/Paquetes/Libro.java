package Paquetes;

public class Libro {
	private static int ANIOMINIMO=1200;
	private String titulo;
	private Genero genero;
	private String autor;
	private int añoPublicacion;
	private boolean estaDisponible;
	public Libro(String titulo, Genero genero, String autor, int añoPublicacion) {
		this.validarTitulo(titulo);
		this.genero = genero;
		this.validarAutor(autor);
		this.validarAño(añoPublicacion);
		this.estaDisponible=true;
		
	}
	private void validarTitulo(String titulo) {
		if(titulo.isEmpty()||titulo==null) {
			throw new IllegalArgumentException("El titulo ingresado es nulo o esta vacio");
		}
		this.titulo=titulo;
	}
	private void validarAutor(String autor) {
		if(autor.isEmpty()||autor==null) {
			throw new IllegalArgumentException("El autor ingresado es nulo o esta vacio");
		}
		this.autor=autor;
	}
	private void validarAño(int año) {
		if(año<=100) {
			throw new IllegalArgumentException("El año de lanzamiento no puede ser menor o igual a"+ ANIOMINIMO);
		}
		this.añoPublicacion=año;
	}
	public String getTitulo() {
		// TODO Auto-generated method stub
		return this.titulo;
	}
	public boolean estado() {
		// TODO Auto-generated method stub
		return this.estaDisponible;
	}
	public void mostrar() {
		System.out.println("Titulo:"+titulo);
		System.out.println("Genero:"+genero);
		System.out.println("Autor:"+autor);
		System.out.println("Año de Publicacion:"+añoPublicacion);
		
		// TODO Auto-generated method stub
		
	}
	public Genero getGenero() {
		// TODO Auto-generated method stub
		return genero;
	}
	public boolean getEstado() {
		// TODO Auto-generated method stub
		return estaDisponible;
	}
	public void cambiarNoDisponible() {
		this.estaDisponible=false;
	}
	public void cambiarDisponible() {
		this.estaDisponible=true;
	}
	@Override
	public String toString() {
		return "Libro [titulo=" + titulo + ", genero=" + genero + ", autor=" + autor + ", añoPublicacion="
				+ añoPublicacion + ", estaDisponible=" + estaDisponible + "]";
	}
	
	
	
}
