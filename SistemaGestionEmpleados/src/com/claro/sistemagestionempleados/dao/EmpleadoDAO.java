/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.claro.sistemagestionempleados.dao;

import com.claro.sistemagestionempleados.model.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lreye
 */
public class EmpleadoDAO {
    // Método para obtener todos los empleados
    public List<Empleado> obtenerTodos() throws SQLException {
        List<Empleado> empleados = new ArrayList<>();
        Connection conexion = ConexionBD.getConnection();
        String sql = "SELECT * FROM Empleado";
        PreparedStatement statement = conexion.prepareStatement(sql);
        ResultSet resultado = statement.executeQuery();
        while (resultado.next()) {
            int id = resultado.getInt("id");
            String nombre = resultado.getString("nombre");
            String apellido = resultado.getString("apellido");
            int edad = resultado.getInt("edad");
            double salario = resultado.getDouble("salario");
            Empleado empleado = new Empleado(id, nombre, apellido, edad, salario);
            empleados.add(empleado);
        }
        resultado.close();
        statement.close();
        conexion.close();
        return empleados;
    }

    // Método para obtener un empleado por su id
    public Empleado obtenerPorId(int id) throws SQLException {
        Connection conexion = ConexionBD.getConnection();
        String sql = "SELECT * FROM Empleado WHERE id = ?";
        PreparedStatement statement = conexion.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet resultado = statement.executeQuery();
        Empleado empleado = null;
        if (resultado.next()) {
            String nombre = resultado.getString("nombre");
            String apellido = resultado.getString("apellido");
            int edad = resultado.getInt("edad");
            double salario = resultado.getDouble("salario");
            empleado = new Empleado(id, nombre, apellido, edad, salario);
        }
        resultado.close();
        statement.close();
        conexion.close();
        return empleado;
    }

    // Método para insertar un nuevo empleado
    public void insertar(Empleado empleado) throws SQLException {
        Connection conexion = ConexionBD.getConnection();
        String sql = "INSERT INTO Empleado (id, nombre, apellido, edad, salario) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement = conexion.prepareStatement(sql);
        statement.setInt(1, empleado.getId());
        statement.setString(2, empleado.getNombre());
        statement.setString(3, empleado.getApellido());
        statement.setInt(4, empleado.getEdad());
        statement.setDouble(5, empleado.getSalario());
        statement.executeUpdate();
        statement.close();
        conexion.close();
    }

    // Método para actualizar un empleado
    public void actualizar(Empleado empleado) throws SQLException {
        Connection conexion = ConexionBD.getConnection();
        String sql = "UPDATE Empleado SET nombre = ?, apellido = ?, edad = ?, salario = ? WHERE id = ?";
        PreparedStatement statement = conexion.prepareStatement(sql);
        statement.setString(1, empleado.getNombre());
        statement.setString(2, empleado.getApellido());
        statement.setInt(3, empleado.getEdad());
        statement.setDouble(4, empleado.getSalario());
        statement.setInt(5, empleado.getId());
        statement.executeUpdate();
        statement.close();
        conexion.close();
    }

    // Método para eliminar un empleado por su id
    public void eliminar(int id) throws SQLException {
        Connection conexion = ConexionBD.getConnection();
        String sql = "DELETE FROM Empleado WHERE id = ?";
        PreparedStatement statement = conexion.prepareStatement(sql);
        statement.setInt(1, id);
        statement.executeUpdate();
        statement.close();
        conexion.close();
    }
}