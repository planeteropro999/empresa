package gestion_empresarial.empresa.model;

import lombok.Getter;
import lombok.Setter;

public class Empleado {
    @Getter
    @Setter
    private String id;
    @Getter
    @Setter
    private String nombre;
    @Getter
    @Setter
    private double salario;
    @Getter
    @Setter
    private String departamento;

    public Empleado(String id, String nombre, double salario, String departamento){
        if (id == null || id.isBlank()) throw new IllegalArgumentException("El ID no puede estar vacío");
        if (salario < 0) throw new IllegalArgumentException("El salario no puede ser negativo");
        this.nombre = nombre;
        this.id = id;
        this.salario = salario;
        this.departamento = departamento;
    }

    @Override
    public String toString(){
        return String.format("Empleado{id='%s', nombre='%s', salario=%.2f, departamento='%s'}", id, nombre, salario, departamento);
    }
}