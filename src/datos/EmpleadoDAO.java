package datos;

import domain.Empleado;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static datos.Conexion.close;
import static datos.Conexion.getConnection;

public class EmpleadoDAO {

    private static final String SQL_SELECT = "SELECT nDIEmp, nomEmp, sexEmp, fecNac, fecIncorporacion, salEmp, comisionE, cargoE, jefeID, codDepto FROM empleados";
    private static final String SQL_INSERT = "INSERT INTO empleados(nDIEmp, nomEmp, sexEmp, fecNac, fecIncorporacion, salEmp, comisionE, cargoE, jefeID, codDepto) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE empleados SET nomEmp=?, sexEmp=?, fecNac=?, fecIncorporacion=?, salEmp=?, comisionE=?, cargoE=?, jefeID=?, codDepto=? WHERE nDIEmp=?";
    private static final String SQL_DELETE = "DELETE FROM empleados WHERE nDIEmp=?";

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
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }

        return empleados;
    }

    public int insertar(Empleado empleado)
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = Conexion.getConnection();

            stmt = conn.prepareStatement(SQL_INSERT);

            stmt.setString(1, empleado.getIdEmpleado());
            stmt.setString(2, empleado.getNombre());
            stmt.setString(3, empleado.getSexo());
            stmt.setDate(4, empleado.getFecNac());
            stmt.setDate(5, empleado.getFecIncorporacion());
            stmt.setFloat(6, empleado.getSalario());
            stmt.setFloat(7, empleado.getComision());
            stmt.setString(8, empleado.getCargo());
            stmt.setString(9, empleado.getJefeId());
            stmt.setString(10, empleado.getCodDept());

            registros = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        finally {
            try {

                close(stmt);
                close(conn);

            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }

        return registros;
    }

    public int actualizar(Empleado empleado)
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);

            stmt.setString(1, empleado.getNombre());
            stmt.setString(2, empleado.getSexo());
            stmt.setDate(3, empleado.getFecNac());
            stmt.setDate(4, empleado.getFecIncorporacion());
            stmt.setFloat(5, empleado.getSalario());
            stmt.setFloat(6, empleado.getComision());
            stmt.setString(7, empleado.getCargo());
            stmt.setString(8, empleado.getJefeId());
            stmt.setString(9, empleado.getCodDept());
            stmt.setString(10, empleado.getIdEmpleado());

            registros = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }

        return registros;
    }

    public int delete(Empleado empleado)
    {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutanto consulta: " + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);

            stmt.setString(1, empleado.getIdEmpleado());

            rows = stmt.executeUpdate();

            System.out.println("Número de registros eliminados: " + rows);

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        finally {
            try {
                close(stmt);
                close(conn);

            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }

        return rows;
    }

}
