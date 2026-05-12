package modelo;

public class Consulta extends Servico {

    public Consulta(Animal animal) {
        super("Consulta", 30, animal);
    }

    @Override
    public double calcularCusto() {

        return getAnimal().calcularPrecoBase() + 35.0;
    }
}
