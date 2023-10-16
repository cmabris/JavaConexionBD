import java.sql.*;
import datos.Conexion;

public class Main {
    public static void main(String[] args) {

        try {

            Connection conn = Conexion.getConnection();

            Statement instruccion = conn.createStatement();

            String sql = "SELECT nomEmp, fecNac, salEmp FROM empleados";

            ResultSet resultado = instruccion.executeQuery(sql);

            while (resultado.next()) {

                System.out.print("Empleado: " + resultado.getString("nomEmp"));
                System.out.print(", Fecha Nac.: " + resultado.getDate("fecNac"));
                System.out.print(", Salario: " + resultado.getInt("salEmp"));
                System.out.println("");

            }

            Conexion.close(resultado);
            Conexion.close(instruccion);
            Conexion.close(conn);

        } catch (SQLException ex) {

            ex.printStackTrace(System.out);

        }

    }
}