package Dao;

public class DAOManager {
	private static DepartamentoDao depDAO;
	private static EmpleadoDao empDAO;

	public static DepartamentoDao getDepDAO() {
		if(depDAO == null){
			depDAO = new DepartamentoDaoImpl();
		}
		return depDAO;
	}

	public static EmpleadoDao getEmpDAO() {
		if(empDAO == null){
			empDAO = new EmpleadoDaoImpl();
		}
		return empDAO;
	}
}
