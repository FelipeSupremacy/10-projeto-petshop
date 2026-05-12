package modelo;

public class Cachorro extends Animal {

    public Cachorro(String nome, double peso) {
        super(nome, peso);
    }

    @Override
    public double calcularPrecoBase() {

        if (getPeso() <= 10) {
            return 40.0;
        } else if (getPeso() <= 25) {
            return 60.0;
        } else {
            return 85.0;
        }
    }
}
