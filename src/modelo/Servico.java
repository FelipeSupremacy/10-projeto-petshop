package modelo;

public abstract class Servico {

    private String descricao;
    private int duracaoMinutos;
    private Animal animal;

    public Servico(String descricao, int duracaoMinutos, Animal animal) {
        this.descricao = descricao;
        this.duracaoMinutos = duracaoMinutos;
        this.animal = animal;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }

    public Animal getAnimal() {
        return animal;
    }

    public abstract double calcularCusto();

    @Override
    public String toString() {
        return "Serviço: " + descricao + " | Animal: " + animal.getNome() + " | Valor: R$ " + calcularCusto();
    }
}