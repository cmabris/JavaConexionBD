import java.sql.*;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/empleadoss_departamentoss";

        try {

            Connection conexion = DriverManager.getConnection(url, "root", "root");

            Statement instruccion = conexion.createStatement();

            String sql = "SELECT nomEmp, fecNac, salEmp FROM empleados";

            ResultSet resultado = instruccion.executeQuery(sql);

            while (resultado.next()) {

                System.out.print("Empleado: " + resultado.getString("nomEmp"));
                System.out.print(", Fecha Nac.: " + resultado.getDate("fecNac"));
                System.out.print(", Salario: " + resultado.getInt("salEmp"));
                System.out.println("");

            }

            resultado.close();
            instruccion.close();
            conexion.close();

        } catch (SQLException ex) {

            ex.printStackTrace(System.out);

        }

    }
}