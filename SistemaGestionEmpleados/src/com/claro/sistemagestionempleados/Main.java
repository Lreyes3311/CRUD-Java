/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.claro.sistemagestionempleados;
import com.claro.sistemagestionempleados.controller.EmpleadoController;
import com.claro.sistemagestionempleados.model.Empleado;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author lreye
 */
public class Main {
    public static void main(String[] args) {
        // Instanciar el controlador de empleados
        EmpleadoController empleadoController = new EmpleadoController();

        try {
            // Obtener todos los empleados
            List<Empleado> empleados = empleadoController.obtenerTodosEmpleados();
            // Imprimir información de los empleados
            for (Empleado empleado : empleados) {
                System.out.println(empleado);
            }

            // Obtener un empleado por su id (ejemplo: id = 1)
            Empleado empleado = empleadoController.obtenerEmpleadoPorId(1);
            if (empleado != null) {
                System.out.println("Empleado encontrado: " + empleado);
            } else {
                System.out.println("Empleado no encontrado.");
            }

            // Insertar un nuevo empleado
            Empleado nuevoEmpleado = new Empleado(5, "Juan", "Gomez", 35, 3000.0);
            empleadoController.insertarEmpleado(nuevoEmpleado);
            System.out.println("Nuevo empleado insertado.");

            // Actualizar la información de un empleado (ejemplo: id = 2)
            Empleado empleadoActualizar = empleadoController.obtenerEmpleadoPorId(2);
            if (empleadoActualizar != null) {
                empleadoActualizar.setSalario(3500.0);
                empleadoController.actualizarEmpleado(empleadoActualizar);
                System.out.println("Empleado actualizado: " + empleadoActualizar);
            } else {
                System.out.println("Empleado no encontrado para actualizar.");
            }

            // Eliminar un empleado por su id (ejemplo: id = 3)
            empleadoController.eliminarEmpleado(3);
            System.out.println("Empleado eliminado.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }        
}
