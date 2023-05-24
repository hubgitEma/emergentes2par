package com.emergentes.utiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ConexionBD {

    static String driver = "com.mysql.cj.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/bd_almacen";
    static String usuario = "root";
    static String password = "";

    protected Connection conn = null;

    public ConexionBD() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, usuario, password);
            //if (conn != null) {
            //JOptionPane.showMessageDialog(null, "Se establecion la Conexion" + conn);
            //}
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error en la conexion" + e.getMessage());
        }
    }

    public Connection conectar() {
        return conn;
    }

    public void desconectar() {
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Error en la +conexion: " + ex.getMessage());
        }

    }
}
