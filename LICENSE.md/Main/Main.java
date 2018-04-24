package Main;

import Dao.DAOManager;
import Dao.DepartamentoDao;
import Dao.EmpleadoDao;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import prac2.Modelo.Departamento;
import prac2.Modelo.Empleado;

public class Main {

	public static void main(String[] args) {
		SimpleDateFormat df = new SimpleDateFormat();
		DepartamentoDao depDAO = DAOManager.getDepDAO();
		EmpleadoDao empDAO = DAOManager.getEmpDAO();



		int codigoEmp = 2;

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
		Date date1 = null;
		try {
			date1 = sdf.parse("01/02/2018");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		Empleado empleado2dir = new Empleado(3, "ada", "programado", null, null, 10, 1, 10);

		Empleado empleadoadd = new Empleado(2, "SANCHEZ", "programado", empleado2dir, date1, 10, 1, 10);
		Empleado empleadoup = new Empleado(2, "caca", "papa", empleado2dir, date1, 100, 10, 10);
		Departamento dep1 = new Departamento(50, "programacion", "barcelona");
		String separador = "-----------------------------------------------------";


		try {
			System.out.println("Consulta de departaments");
			for (Departamento departamento : depDAO.getDepartamentos()) {
				System.out.println(departamento);
			}
			System.out.println(separador);

			System.out.println("Mostrarà els empleats agrupats per departament");

			for (Empleado empleado: empDAO.getEmpleadosAgrupadosPorDepartamentos()){
				System.out.println(empleado);
			}
			System.out.println(separador);

			System.out.println("Consulta d’empleats per codi de departament");
			for (Empleado empleado : empDAO.getEmpleadoByDepartamento(10)) {
				System.out.println(empleado);
			}
			System.out.println(separador);

			System.out.println("Consulta d’empleats per cognom:");
			for (Empleado empleado : empDAO.getEmpleadoByApellido("SAN%")) {
				System.out.println(empleado);
			}
			System.out.println(separador);

			System.out.println("Consulta d’empleats per ofici");
			//SIN HACER
			System.out.println(separador);

			System.out.println("Alta d’empleat");
			empDAO.addEmpleado(empleadoadd);
			System.out.println(separador);

			System.out.println("Esborrat d’empleat per codi");
			empDAO.delEmpleado(empleadoadd);

			//quedan por hacer



			//tests
			//System.out.println(empDAO.getEmpleadoById(codigoEmp).toString());
			//empDAO.addEmpleado(empleadoadd);
			//empDAO.updateEmpleado(empleadoup);
			//empDAO.delEmpleado(empleadoup);

			//for (Empleado empleado : empDAO.getEmpleadoByApellido("SANCHEZ")) {
				//System.out.println(empleado);
			//}
			//for (Empleado empleado : empDAO.getEmpleados()) {
			//	System.out.println(empleado);
			//}


			//depDAO.addDepartamento(dep1);
			//System.out.println(depDAO.getDepartamentoById(50));


			//System.out.println(depDAO.delDepartamento(dep1));


		} catch (SQLException e) {
			if (e.getErrorCode() == 1062){
				System.out.println("clave duplicada");
			}else{
				e.printStackTrace();
			}




		} catch (NullPointerException e) {
			System.out.println("Empleado con codigo " + codigoEmp + " no existe");
		}





	}

}
