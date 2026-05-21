package modelo;

public class Banho extends Servico {

    public Banho(Animal animal, int duracaoMinutos) {
        super("Banho", duracaoMinutos, animal);
    }

    @Override
    public double calcularCusto() {

        if (getAnimal() instanceof Passaro) {
            return 0;
        }

        return getAnimal().calcularPrecoBase() + (getDuracaoMinutos() * 0.5);
    }
}
