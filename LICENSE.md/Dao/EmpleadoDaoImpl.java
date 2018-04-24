package Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import prac2.Modelo.Departamento;
import prac2.Modelo.Empleado;

public class EmpleadoDaoImpl implements EmpleadoDao{
	private Connection conexion;

	public EmpleadoDaoImpl() {
		this.conexion = GestorConnexions.obtenirConnexio();
	}

	@Override
	public void addEmpleado (Empleado empleado) throws SQLException {
		conexion = GestorConnexions.obtenirConnexio();

		String sql = "insert into empleados values (?,?,?,?,?,?,?,?)";
		PreparedStatement sentencia = conexion.prepareStatement(sql);
		sentencia.setInt(1, empleado.getEmp_no());
		sentencia.setString(2, empleado.getApellido());
		sentencia.setString(3, empleado.getOficio());
		sentencia.setInt(4, empleado.getDirector().getEmp_no());
		sentencia.setDate(5, new Date(empleado.getFecha_alt().getTime()));
		sentencia.setDouble(6, empleado.getSalario());
		sentencia.setInt(7, empleado.getComision());
		sentencia.setInt(8, empleado.getDept_no());

		sentencia.executeUpdate();
	}

	@Override
	public Empleado getEmpleadoById(int codigo_emp) throws SQLException{//modificar para empleado no existente
		conexion = GestorConnexions.obtenirConnexio();

		Empleado empleado= null;

		String sql = "SELECT * FROM empleados WHERE emp_no = ?";
		PreparedStatement sentencia = conexion.prepareStatement(sql);
		sentencia.setInt(1, codigo_emp);
		ResultSet resultat = sentencia.executeQuery();

		while (resultat.next()){
			empleado = new Empleado(resultat.getInt(1), resultat.getString(2), resultat.getString(3), getEmpleadoById(resultat.getInt(4)), resultat.getDate(5), resultat.getInt(6), resultat.getInt(7), resultat.getInt(8));
		}

		return empleado;
	}

	@Override
	public LinkedList<Empleado> getEmpleados() throws SQLException {
		conexion = GestorConnexions.obtenirConnexio();

		String sql = "SELECT emp_no FROM empleados";
		PreparedStatement sentencia = conexion.prepareStatement(sql);

		ResultSet resultat = sentencia.executeQuery();

		LinkedList<Empleado> listaempleados = new LinkedList<>();
		while (resultat.next()){
			listaempleados.add(this.getEmpleadoById(resultat.getInt(1)));
		}
		return listaempleados;
	}

	@Override
	public void updateEmpleado(Empleado empleado) throws SQLException {
		String sql = "update empleados set emp_no=?,apellido=?,oficio=?,dir=?,fecha_alt=?,salario=?,comision=?,dept_no=? where emp_no= ?";

		PreparedStatement sentencia = conexion.prepareStatement(sql);
		sentencia.setInt(1, empleado.getEmp_no());
		sentencia.setString(2, empleado.getApellido());
		sentencia.setString(3, empleado.getOficio());
		sentencia.setInt(4, empleado.getDirector().getEmp_no());
		sentencia.setDate(5, new Date(empleado.getFecha_alt().getTime()));
		sentencia.setDouble(6, empleado.getSalario());
		sentencia.setInt(7, empleado.getComision());
		sentencia.setInt(8, empleado.getDept_no());

		sentencia.setInt(9, empleado.getEmp_no());

		sentencia.executeUpdate();
	}

	@Override
	public int delEmpleado(Empleado empleado) throws SQLException {
		String sql = "delete from empleados where emp_no= ?";

		PreparedStatement sentencia = conexion.prepareStatement(sql);
		sentencia.setInt(1, empleado.getEmp_no());

		return sentencia.executeUpdate();
	}

	public LinkedList<Empleado> getEmpleadoByApellido(String cognom) throws SQLException{
		conexion = GestorConnexions.obtenirConnexio();

		Empleado empleado= null;

		String sql = "SELECT emp_no FROM empleados WHERE apellido like ?";
		PreparedStatement sentencia = conexion.prepareStatement(sql);
		sentencia.setString(1, cognom);

		ResultSet resultat = sentencia.executeQuery();

		LinkedList<Empleado> listaempleados = new LinkedList<>();
		while (resultat.next()){
			listaempleados.add(this.getEmpleadoById(resultat.getInt(1)));
		}
		return listaempleados;
	}

	public LinkedList<Empleado> getEmpleadoByDepartamento(int cod_dep) throws SQLException{
		conexion = GestorConnexions.obtenirConnexio();

		Empleado empleado= null;

		String sql = "SELECT * FROM empleados WHERE dept_no = ?";
		PreparedStatement sentencia = conexion.prepareStatement(sql);
		sentencia.setInt(1, cod_dep);

		ResultSet resultat = sentencia.executeQuery();

		LinkedList<Empleado> listaempleados = new LinkedList<>();
		while (resultat.next()){
			listaempleados.add(this.getEmpleadoById(resultat.getInt(1)));
		}
		return listaempleados;

	}

	public LinkedList<Empleado> getEmpleadosAgrupadosPorDepartamentos() throws SQLException{
		DepartamentoDao depDAO = DAOManager.getDepDAO();


		LinkedList<Empleado> listaempleados = new LinkedList<>();

		for (Departamento departameto : depDAO.getDepartamentos()) {
			for (Empleado  empleado: this.getEmpleadoByDepartamento(departameto.getCodi_dep())) {
				listaempleados.add(empleado);
			}
		}
		return listaempleados;
	}





}
