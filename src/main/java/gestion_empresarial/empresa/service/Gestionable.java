package gestion_empresarial.empresa.service;

import gestion_empresarial.empresa.model.Empleado;

import java.util.List;
import java.util.Optional;

public interface Gestionable {
    void agregarEmpleado(Empleado empleado);
    Optional<Empleado> buscarporId(String id);
    List<Empleado> listarEmpleados();
    double calcularSalarioTotal();
}
