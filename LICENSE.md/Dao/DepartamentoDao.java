package Dao;

import java.sql.SQLException;
import java.util.LinkedList;

import prac2.Modelo.Departamento;

public interface DepartamentoDao {
		//crud
	public void addDepartamento(Departamento departamento) throws SQLException;
	public Departamento getDepartamentoById(int codi_dep) throws SQLException;
	public LinkedList<Departamento> getDepartamentos() throws SQLException;

	public void updateDepartamento(Departamento departamento) throws SQLException;

	public int delDepartamento(Departamento departamento) throws SQLException;





}
