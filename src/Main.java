import java.sql.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

import datos.Conexion;
import datos.EmpleadoDAO;
import domain.Empleado;

public class Main {
    public static void main(String[] args) {

        EmpleadoDAO empleadoDao = new EmpleadoDAO();

        Empleado empleadoNuevo = new Empleado("11.000.111", "Pepe Sánchez", 'V', new Date(TimeUnit.SECONDS.toMillis(971171357)), new Date(TimeUnit.SECONDS.toMillis(971171357)), 20000, 2000, "Pringao", "11.111.111", "4000");

        empleadoDao.insertar(empleadoNuevo);

        //Empleado empleadoModificar = new Empleado("11.000.111", "José Sánchez", 'V', Date.valueOf("2000-10-10"), Date.valueOf("2022-10-10"), 20000, 2000, "Pringao", "11.111.111", "4000");

        //empleadoDao.actualizar(empleadoModificar);

        List<Empleado> empleados = empleadoDao.seleccionar();

        //Listando todos los empleados
        empleados.forEach(empleado -> {
            System.out.println(empleado);
        });

        Empleado empleadoBorrar = new Empleado();
        empleadoBorrar.setIdEmpleado("11.000.111");

        empleadoDao.delete(empleadoBorrar);

        List<Empleado> empleados2 = empleadoDao.seleccionar();

        //Listando todos los empleados
        empleados2.forEach(empleado -> {
            System.out.println(empleado);
        });

    }
}