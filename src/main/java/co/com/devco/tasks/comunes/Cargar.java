package co.com.devco.tasks.comunes;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Cargar {

    private Cargar() {
        throw new IllegalStateException("No se carga la clase");
    }

    public static CargarDatosPrueba cargoLosDatosDeLaTransaccionConLaSiguiente(List<Map<String, Object>> informacion) {
        return instrumented(CargarDatosPrueba.class, informacion);
    }

    public static CargarDatosPrueba conLaSiguiente(List<Map<String, Object>> informacion) {
        return instrumented(CargarDatosPrueba.class, informacion);
    }
}