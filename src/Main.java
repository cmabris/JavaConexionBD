import java.sql.*;
import java.util.List;

import datos.Conexion;
import datos.EmpleadoDAO;
import domain.Empleado;

public class Main {
    public static void main(String[] args) {

        EmpleadoDAO empleadoDao = new EmpleadoDAO();

        List<Empleado> empleados = empleadoDao.seleccionar();

        /*for(Empleado empleado: empleados) {
            System.out.println(empleado);
        }*/

        empleados.forEach(empleado -> {
            System.out.println(empleado);
        });

    }
}