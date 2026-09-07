package gestion_empresarial.empresa;

import gestion_empresarial.empresa.model.Empleado;
import gestion_empresarial.empresa.service.EmpresaService;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static reactor.netty.http.HttpConnectionLiveness.log;
@Log4j2
@SpringBootApplication
public class EmpresaApplication {

	public static void main(String[] args) {
        EmpresaService servicio = new EmpresaService();


    try{
        servicio.agregarEmpleado(new Empleado("1", "Ana Perez", 20500.30, "TIC"));
        servicio.agregarEmpleado(new Empleado("2", "Sebastian Mendoza", 1050.50, "TIC"));
        servicio.agregarEmpleado(new Empleado("3", "Liliana Alvarez", 2050.89, "RRHH"));
        servicio.agregarEmpleado(new Empleado("4", "Carlos Antonio", 5420.01, "RRHH"));

        log.info("===LISTA DE EMPLEADOS===");
        servicio.listarEmpleados().forEach(log::info);

        log.info("===CALCULAR EL SALARIO TOTAL===");
        log.info("Total del salario: ", servicio.calcularSalarioTotal());

        log.info("===BUSQUEDA DE EMPLEADO POR ID===");
        Empleado emp = servicio.obtenerEmpleadoPorIdOExcepcion("1");
        log.info("El empleado encontrado es: " , emp);

        servicio.obtenerEmpleadoPorIdOExcepcion("E999");

    }catch(Exception e){
        log.info("Error en la aplicacion: " , e.getMessage());
    }
    }
}
