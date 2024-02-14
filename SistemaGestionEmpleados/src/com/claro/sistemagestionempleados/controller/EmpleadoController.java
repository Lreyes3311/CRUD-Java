/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.claro.sistemagestionempleados.controller;
import com.claro.sistemagestionempleados.dao.EmpleadoDAO;
import com.claro.sistemagestionempleados.model.Empleado;
import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author lreye
 */
public class EmpleadoController {
        private final EmpleadoDAO empleadoDAO;

    public EmpleadoController() {
        this.empleadoDAO = new EmpleadoDAO();
    }

    // Método para obtener todos los empleados
    public List<Empleado> obtenerTodosEmpleados() throws SQLException {
        return empleadoDAO.obtenerTodos();
    }

    // Método para obtener un empleado por su id
    public Empleado obtenerEmpleadoPorId(int id) throws SQLException {
        return empleadoDAO.obtenerPorId(id);
    }

    // Método para insertar un nuevo empleado
    public void insertarEmpleado(Empleado empleado) throws SQLException {
        empleadoDAO.insertar(empleado);
    }

    // Método para actualizar la información de un empleado
    public void actualizarEmpleado(Empleado empleado) throws SQLException {
        empleadoDAO.actualizar(empleado);
    }

    // Método para eliminar un empleado por su id
    public void eliminarEmpleado(int id) throws SQLException {
        empleadoDAO.eliminar(id);
    }
}
