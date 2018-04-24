package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import prac2.Modelo.Departamento;

public class DepartamentoDaoImpl implements DepartamentoDao {
	private Connection conexion;


	public DepartamentoDaoImpl(){
		conexion = GestorConnexions.obtenirConnexio();
	}

	@Override
	public void addDepartamento(Departamento departamento) throws SQLException {
		conexion = GestorConnexions.obtenirConnexio();

		String sql = "insert into departamentos values (?,?,?)";
		PreparedStatement sentencia = conexion.prepareStatement(sql);
		sentencia.setInt(1, departamento.getCodi_dep());
		sentencia.setString(2, departamento.getNombre());
		sentencia.setString(3, departamento.getLocalizacion());

		sentencia.executeUpdate();
	}


	@Override
	public Departamento getDepartamentoById(int codi_dep) throws SQLException {
		conexion = GestorConnexions.obtenirConnexio();

		Departamento departamento= null;

		String sql = "SELECT * FROM departamentos WHERE dept_no = ?";
		PreparedStatement sentencia = conexion.prepareStatement(sql);
		sentencia.setInt(1, codi_dep);
		ResultSet resultat = sentencia.executeQuery();

		while (resultat.next()){
			departamento = new Departamento(resultat.getInt(1), resultat.getString(2), resultat.getString(3));
		}

		return departamento;
	}




	@Override
	public LinkedList<Departamento> getDepartamentos() throws SQLException {
		conexion = GestorConnexions.obtenirConnexio();


		LinkedList<Departamento> departamentos = new LinkedList<Departamento>();

		Statement sentencia = conexion.createStatement();
		String sql = "SELECT * FROM departamentos";

		ResultSet resultat = sentencia.executeQuery(sql);

		while (resultat.next()){
			departamentos.add(new Departamento(resultat.getInt(1), resultat.getString(2), resultat.getString(3)));
		}

		return departamentos;
	}

	@Override
	public void updateDepartamento(Departamento departamento) throws SQLException {
		conexion = GestorConnexions.obtenirConnexio();

		String sql = "update departamentos set dnombre=?,loc=? where dept_no= ?";

		PreparedStatement sentencia = conexion.prepareStatement(sql);

		sentencia.setString(1, departamento.getNombre());
		sentencia.setString(2, departamento.getLocalizacion());

		sentencia.setInt(3, departamento.getCodi_dep());
		sentencia.executeUpdate();
	}

	@Override
	public int delDepartamento(Departamento departamento) throws SQLException {
		String sql = "delete from departamentos where = ?";

		PreparedStatement sentencia = conexion.prepareStatement(sql);
		sentencia.setInt(1, departamento.getCodi_dep());
		return sentencia.executeUpdate();

	}




}
