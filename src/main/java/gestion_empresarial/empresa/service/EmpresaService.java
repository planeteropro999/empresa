package gestion_empresarial.empresa.service;

import gestion_empresarial.empresa.exception.EmpleadoNoEncontradoException;
import gestion_empresarial.empresa.model.Empleado;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmpresaService implements Gestionable{

    private final List<Empleado> empleados = new ArrayList<>();

    @Override
    public void agregarEmpleado(Empleado empleado){
        if(empleado == null){
            throw new IllegalArgumentException("El empleado no puede llegar nulo.");
        }else{
            empleados.add(empleado);
        }
    }

    @Override
    public Optional<Empleado> buscarporId(String id){
        return empleados.stream().filter(e-> e.getId().
                equalsIgnoreCase(id)).findFirst();
    }

    @Override
    public List<Empleado> listarEmpleados(){
        return new ArrayList<>(empleados);
    }

    @Override
    public double calcularSalarioTotal(){
        return empleados.stream().mapToDouble(Empleado ::getSalario).sum();
    }

    public List<Empleado> filtrarPorDepartamento(String depto) {
        return empleados.stream()
                .filter(e -> e.getDepartamento().equalsIgnoreCase(depto))
                .collect(Collectors.toList());
    }

    public Empleado obtenerEmpleadoPorIdOExcepcion(String id) {
        return buscarporId(id)
                .orElseThrow(() ->
                new EmpleadoNoEncontradoException("No se encontró el empleado con ID: " + id));
    }
}
