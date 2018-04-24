package prac2.Modelo;



public class Departamento {
	private Integer codi_dep;
	private String nombre;
	private String localizacion;
	//private LinkedList<Empleado> empleados = new LinkedList<>();


	public Departamento(Integer codi_dep, String nombre, String localizacion) {
		super();
		this.codi_dep = codi_dep;
		this.nombre = nombre;
		this.localizacion = localizacion;

	}


	public Integer getCodi_dep() {
		return codi_dep;
	}


	public void setCodi_dep(Integer codi_dep) {
		this.codi_dep = codi_dep;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getLocalizacion() {
		return localizacion;
	}


	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}


	@Override
	public String toString() {
		return "Departamento [codi_dep=" + codi_dep + ", nombre=" + nombre + ", localizacion=" + localizacion + "]";
	}








}
