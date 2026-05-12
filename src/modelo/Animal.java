package modelo;

public abstract class Animal {

    private String nome;
    private double peso;

    public Animal(String nome, double peso) {
        this.nome = nome;
        this.peso = peso;
    }

    public String getNome() {
        return nome;
    }

    public double getPeso() {
        return peso;
    }

    public abstract double calcularPrecoBase();

    @Override
    public String toString() {
        return getClass().getSimpleName() + " - Nome: " + nome + " - Peso: " + peso;
    }
}

