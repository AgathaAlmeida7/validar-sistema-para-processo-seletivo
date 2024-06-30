import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



class Candidato {
    String nome;
    double salarioPretendido;

    Candidato(String nome, double salarioPretendido) {
        this.nome = nome;
        this.salarioPretendido = salarioPretendido;
    }
}

public class ProcessoSeletivo {

    private static final double SALARIO_BASE = 2000.0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Lista de candidatos
        List<Candidato> candidatos = new ArrayList<>();

        // Adicionando candidatos
        System.out.println("Quantos candidatos deseja adicionar?");
        int numeroDeCandidatos = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        for (int i = 0; i < numeroDeCandidatos; i++) {
            System.out.println("Digite o nome do candidato:");
            String nome = scanner.nextLine();
            System.out.println("Digite o salário pretendido pelo candidato:");
            double salarioPretendido = scanner.nextDouble();
            scanner.nextLine(); // Consumir a nova linha
            candidatos.add(new Candidato(nome, salarioPretendido));
        }

        // Case 1: Verificação do salário pretendido
        for (Candidato candidato : candidatos) {
            if (SALARIO_BASE > candidato.salarioPretendido) {
                System.out.println("LIGAR PARA O CANDIDATO " + candidato.nome);
            } else if (SALARIO_BASE == candidato.salarioPretendido) {
                System.out.println("LIGAR PARA O CANDIDATO " + candidato.nome + " COM CONTRA PROPOSTA");
            } else {
                System.out.println("AGUARDANDO RESULTADO DEMAIS CANDIDATOS " + candidato.nome);
            }
        }

        // Case 2: Seleção de até 5 candidatos para entrevista
        List<Candidato> selecionados = new ArrayList<>();
        for (Candidato candidato : candidatos) {
            if (candidato.salarioPretendido <= SALARIO_BASE && selecionados.size() < 5) {
                selecionados.add(candidato);
            }
        }

        // Case 3: Imprimir lista de candidatos selecionados
        System.out.println("\nCandidatos selecionados para entrevista:");
        for (Candidato candidato : selecionados) {
            System.out.println(candidato.nome + " - Salário Pretendido: " + candidato.salarioPretendido);
        }

        // Case 4: Realizar tentativas de contato
        for (Candidato candidato : selecionados) {
            boolean contatoEstabelecido = false;
            for (int tentativa = 1; tentativa <= 3; tentativa++) {
                System.out.println("Tentando contato com " + candidato.nome + " - Tentativa " + tentativa);
                System.out.println("Digite 's' se conseguiu contato, ou qualquer outra tecla para tentar novamente:");
                String resposta = scanner.nextLine();
                if (resposta.equalsIgnoreCase("s")) {
                    System.out.println("CONSEGUIMOS CONTATO COM " + candidato.nome + " APÓS " + tentativa + " TENTATIVA(S)");
                    contatoEstabelecido = true;
                    break;
                }
            }
            if (!contatoEstabelecido) {
                System.out.println("NÃO CONSEGUIMOS CONTATO COM O " + candidato.nome);
            }
        }

        scanner.close();
    }
}
