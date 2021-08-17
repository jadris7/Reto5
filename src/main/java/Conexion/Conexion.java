package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Conexion {

    private static final String UBICACION_BD = "ProyectosConstruccion.db";
    
    String url = "jdbc:sqlite:" + UBICACION_BD;

    String strConxionDB = url;
    Connection conn = null;

    public Conexion() {
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(strConxionDB);

            System.out.println("Conexion establecida");
        } catch (Exception e) {
            System.out.println("Error de conexion " + e);
        }
    }

    public ResultSet consultarRegistros(String strSentenciaSQL) {
        try {

            PreparedStatement pstm = conn.prepareStatement(strSentenciaSQL);
            ResultSet respuesta = pstm.executeQuery();
            return respuesta;

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

}
