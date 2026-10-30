package uce.edu.ec;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;
import uce.edu.ec.modelo.Matricula;
import uce.edu.ec.negocio.MatriculaService;

@QuarkusMain
public class Main implements QuarkusApplication {
    

    @Inject
    MatriculaService matriculaService;

    public static void main(String[] args) {

        Quarkus.run(Main.class, args);

    }

    @Override
    public int run(String... args) {

        Matricula matricula = new Matricula("Juan", "Caranqui", " Programación Avanzada II");
        this.matriculaService.matricular(matricula);
        


        return 0;
    }

}
