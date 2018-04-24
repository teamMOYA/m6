package prac2.Modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Empleado {
	private Integer emp_no;
	private String apellido;
	private String oficio;
	private Empleado director;
	private Date fecha_alt;
	private double salario;
	private Integer comision;
	private Integer dept_no;



	public Empleado(Integer emp_no, String apellido, String oficio, Empleado director, Date fecha_alt, double salario,
			Integer comision, Integer dept_no) {
		super();
		this.emp_no = emp_no;
		this.apellido = apellido;
		this.oficio = oficio;
		this.director = director;
		this.fecha_alt = fecha_alt;
		this.salario = salario;
		this.comision = comision;
		this.dept_no = dept_no;
	}



	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String director = "";
		if (this.director != null){
			director = " | dir : " + this.director.apellido;
		}



		String empleado = "emp_no: " + this.emp_no + " | apellido: " + this.apellido + " | oficio: " + this.oficio +
		director + " | fecha_alt: " + sdf.format(this.fecha_alt) +" | salario: " +
		String.valueOf(this.salario) + " | comision: " + String.valueOf(this.comision) + " | dept_no: " +
		String.valueOf(this.dept_no);
		return empleado;
	}



	public Integer getEmp_no() {
		return emp_no;
	}



	public void setEmp_no(Integer emp_no) {
		this.emp_no = emp_no;
	}



	public String getApellido() {
		return apellido;
	}



	public void setApellido(String apellido) {
		this.apellido = apellido;
	}



	public String getOficio() {
		return oficio;
	}



	public void setOficio(String oficio) {
		this.oficio = oficio;
	}



	public Empleado getDirector() {
		return director;
	}



	public void setDirector(Empleado director) {
		this.director = director;
	}



	public Date getFecha_alt() {
		return fecha_alt;
	}



	public void setFecha_alt(Date fecha_alt) {
		this.fecha_alt = fecha_alt;
	}



	public double getSalario() {
		return salario;
	}



	public void setSalario(double salario) {
		this.salario = salario;
	}



	public Integer getComision() {
		return comision;
	}



	public void setComision(Integer comision) {
		this.comision = comision;
	}



	public Integer getDept_no() {
		return dept_no;
	}



	public void setDept_no(Integer dept_no) {
		this.dept_no = dept_no;
	}


}
