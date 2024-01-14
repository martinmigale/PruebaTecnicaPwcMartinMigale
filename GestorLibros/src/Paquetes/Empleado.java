package Paquetes;

public class Empleado extends Persona {
	private int añoIncorporado;
	private Sector sector;
	public Empleado(String nombre, int numeroIdentificacion, EstadoCivil estado,int añoIncorporado,Sector sector) {
		super(nombre, numeroIdentificacion, estado);
		this.añoIncorporado=añoIncorporado;
		this.sector=sector;
		
		// TODO Auto-generated constructor stub
	}

}
