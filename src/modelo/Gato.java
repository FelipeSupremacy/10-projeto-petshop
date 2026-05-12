package modelo;

public class Gato extends Animal {

    public Gato(String nome, double peso) {
        super(nome, peso);
    }

    @Override
    public double calcularPrecoBase() {
        return 45.0;
    }
}
