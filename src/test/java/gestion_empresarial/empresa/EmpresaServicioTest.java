package gestion_empresarial.empresa;

import gestion_empresarial.empresa.exception.EmpleadoNoEncontradoException;
import gestion_empresarial.empresa.model.Empleado;
import gestion_empresarial.empresa.service.EmpresaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmpresaServicioTest {
    private EmpresaService service;

	@BeforeEach
	void setUp() {
        service = new EmpresaService();
        service.agregarEmpleado(new Empleado("1", "JUAN", 520.0, "IT"));
        service.agregarEmpleado(new Empleado("2", "CARLOS", 1520.0, "HR"));
	}

    @Test
    void testCalcularSalarioTotal(){
        double total = service.calcularSalarioTotal();
        assertEquals(2040,total);
    }

    @Test
    void testCalcularSalarioTotalIncorrecto(){
        double total = service.calcularSalarioTotal();
        assertEquals(1000,total);
    }

    @Test
    void testBuscarEmpleadoExistente() {
        assertTrue(service.buscarporId("1").isPresent());
    }

    @Test
    void testEmpleadoNoEncontradoExcepcion() {
        assertThrows(EmpleadoNoEncontradoException.class, () -> {
            service.obtenerEmpleadoPorIdOExcepcion("999");
        });
    }
}
