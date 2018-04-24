package Dao;

import java.sql.SQLException;
import java.util.LinkedList;

import prac2.Modelo.Empleado;

public interface EmpleadoDao {
		//crud
	public void addEmpleado(Empleado empleado) throws SQLException;

	public Empleado getEmpleadoById(int codigo_emp) throws SQLException;
	public LinkedList<Empleado> getEmpleados() throws SQLException;

	public void updateEmpleado(Empleado empleado) throws SQLException;

	public int delEmpleado(Empleado empleado) throws SQLException;

	//prac

	public LinkedList<Empleado> getEmpleadoByApellido(String cognom) throws SQLException;
	public LinkedList<Empleado> getEmpleadoByDepartamento(int cod_dep) throws SQLException;
	public LinkedList<Empleado> getEmpleadosAgrupadosPorDepartamentos() throws SQLException;

}
