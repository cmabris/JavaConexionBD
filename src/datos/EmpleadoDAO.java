package datos;

import domain.Empleado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmpleadoDAO {

    private static final String SQL_SELECT = "SELECT nDIEmp, nomEmp, sexEmp, fecNac, fecIncorporacion, salEmp, comisionE, cargoE, jefeID, codDepto FROM empleados";

    public List<Empleado> seleccionar()
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Empleado empleado = null;
        List<Empleado> empleados = new ArrayList<>();

        try {

            conn = Conexion.getConnection();

            stmt = conn.prepareStatement(SQL_SELECT);

            rs = stmt.executeQuery();

            while (rs.next()) {
                String idEmpleado = rs.getString("nDIEmp");
                String nombre = rs.getString("nomEmp");
                String sexo = rs.getString("sexEmp");
                Date fecNac = rs.getDate("fecNac");
                Date fecIncorp = rs.getDate("fecIncorporacion");
                float salario = rs.getFloat("salEmp");
                float comision = rs.getFloat("comisionE");
                String cargo = rs.getString("cargoE");
                String jefe = rs.getString("jefeID");
                String departamento = rs.getString("codDepto");

                empleado = new Empleado(idEmpleado, nombre, sexo.charAt(0), fecNac, fecIncorp, salario, comision, cargo, jefe, departamento);

                empleados.add(empleado);
            }

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(rs);
                Conexion.close(stmt);
                Conexion.close(conn);
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }

        return empleados;
    }

}
