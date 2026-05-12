package modelo;

public class Passaro extends Animal {

    public Passaro(String nome, double peso) {
        super(nome, peso);
    }

    @Override
    public double calcularPrecoBase() {
        return 30.0;
    }
}