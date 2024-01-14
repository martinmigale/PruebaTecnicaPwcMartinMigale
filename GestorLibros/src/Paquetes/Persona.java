package Paquetes;

public class Persona {
	private String nombre;
	private int numeroIdentificacion;
	private EstadoCivil estado;
	
	public Persona(String nombre,int numeroIdentificacion,EstadoCivil estado) {
		this.validarNombre(nombre);
		this.validarNumeroIdentificacion(numeroIdentificacion);
		this.estado=estado;
		}
	
	private void validarNombre(String nombre) {
		if(nombre.isEmpty()||nombre==null) {
			throw new IllegalArgumentException("El nombre ingresado es nulo o esta vacio");
		}
		this.nombre=nombre;
	}
	public String getNombre() {
		return this.nombre;
	}
	private void validarNumeroIdentificacion(int numero) {
		if(numero<=0) {
			throw new IllegalArgumentException("El numero de identificacion no puede ser menor o igual a 0");
		}
		this.numeroIdentificacion=numero;
	}
	public int getNumeroIdentificacion() {
		// TODO Auto-generated method stub
		return this.numeroIdentificacion;
	}

	public void mostrar() {
		System.out.println("Nombre:"+nombre);
		System.out.println("Dni:"+numeroIdentificacion);
		System.out.println("Estado civil:"+estado);
		
			// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		return " [nombre=" + nombre + ", numeroIdentificacion=" + numeroIdentificacion + ", estado=" + estado
				+ "]";
	}
	
}
