package sistema;

import interfaces.Calculavel;
import interfaces.Relatorio;
import modelo.*;

import javax.swing.JOptionPane;
import java.util.ArrayList;

public class PetShop implements Relatorio, Calculavel {

    private ArrayList<Animal> animais;
    private ArrayList<Servico> servicos;

    public PetShop() {

        animais = new ArrayList<>();
        servicos = new ArrayList<>();
    }

    public void iniciarSistema() {

        int opcao;

        do {

            String menu = """
                    PET SHOP PATINHAS FELIZES
                    
                    1 - Cadastrar animal
                    2 - Registrar serviço
                    3 - Calcular conta total
                    4 - Exibir relatório
                    5 - Finalizar
                    """;

            opcao = Integer.parseInt(
                    JOptionPane.showInputDialog(menu)
            );

            switch (opcao) {

                case 1:
                    cadastrarAnimal();
                    break;

                case 2:
                    registrarServico();
                    break;

                case 3:
                    mostrarTotal();
                    break;

                case 4:
                    exibirRelatorio();
                    break;

                case 5:
                    JOptionPane.showMessageDialog(null,
                            "Sistema finalizado.");
                    break;

                default:
                    JOptionPane.showMessageDialog(null,
                            "Opção inválida.");
            }

        } while (opcao != 5);
    }

    private void cadastrarAnimal() {

        String[] tipos = {"Cachorro", "Gato", "Pássaro"};

        int tipo = JOptionPane.showOptionDialog(
                null, "Escolha o tipo do animal:", "Cadastro", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, tipos, tipos[0]);

        String nome = JOptionPane.showInputDialog("Digite o nome:");
        double peso = Double.parseDouble(
                JOptionPane.showInputDialog("Digite o peso:")
        );

        Animal animal = null;

        switch (tipo) {

            case 0:
                animal = new Cachorro(nome, peso);
                break;

            case 1:
                animal = new Gato(nome, peso);
                break;

            case 2:
                animal = new Passaro(nome, peso);
                break;
        }

        animais.add(animal);

        JOptionPane.showMessageDialog(null,
                "Animal cadastrado com sucesso!");
    }

    private void registrarServico() {

        if (animais.isEmpty()) {

            JOptionPane.showMessageDialog(null,
                    "Nenhum animal cadastrado.");

            return;
        }

        String lista = "";

        for (int i = 0; i < animais.size(); i++) {

            lista += i + " - " + animais.get(i) + "\n";
        }

        int indice = Integer.parseInt(
                JOptionPane.showInputDialog(
                        "Escolha o animal:\n\n" + lista
                )
        );

        Animal animal = animais.get(indice);

        String[] servicosMenu = {"Banho", "Consulta"};

        int tipoServico = JOptionPane.showOptionDialog(
                null,
                "Escolha o serviço:",
                "Serviços",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                servicosMenu,
                servicosMenu[0]
        );

        Servico servico = null;

        switch (tipoServico) {

            case 0:

                if (animal instanceof Passaro) {

                    JOptionPane.showMessageDialog(null,
                            "Pássaros não podem tomar banho.");

                    return;
                }

                int duracao = Integer.parseInt(
                        JOptionPane.showInputDialog(
                                "Duração do banho (min):"
                        )
                );

                servico = new Banho(animal, duracao);

                break;

            case 1:

                servico = new Consulta(animal);

                break;
        }

        servicos.add(servico);

        JOptionPane.showMessageDialog(null,
                "Serviço registrado com sucesso!");
    }

    @Override
    public double calcularTotal() {

        double total = 0;

        for (Servico s : servicos) {

            total += s.calcularCusto();
        }

        return total;
    }

    private void mostrarTotal() {

        JOptionPane.showMessageDialog(
                null,
                "Total do dia: R$ " + calcularTotal()
        );
    }

    @Override
    public String gerarResumo() {

        if (servicos.isEmpty()) {
            return "Nenhum serviço registrado.";
        }

        String resumo = "RELATÓRIO DO PETSHOP\n\n";

        for (Servico s : servicos) {

            resumo += "Animal: " + s.getAnimal().getNome() + "\n";

            resumo += "Tipo: " + s.getAnimal().getClass().getSimpleName() + "\n";

            resumo += "Serviço: " + s.getDescricao() + "\n";

            resumo += "Valor: R$ " + s.calcularCusto() + "\n\n";
        }
        resumo += "TOTAL GERAL: R$ " + calcularTotal();
        return resumo;
    }

    private void exibirRelatorio() {
        JOptionPane.showMessageDialog(null, gerarResumo());
    }
}