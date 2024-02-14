/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.claro.sistemagestionempleados.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author lreye
 */
public class ConexionBD {
    //private static final String URL = "jdbc:oracle:thin://DESKTOP-8RKE13C;databaseName=EmpleadoBD";
    private static final String URL = "jdbc:sqlserver://localhost;databaseName=EmpleadoBD;integratedSecurity=true;";
    private static final String USUARIO = "DESKTOP-8RKE13C\\\\lreye";
    private static final String CONTRASEÑA = "12345";
    
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
    }
    
}
