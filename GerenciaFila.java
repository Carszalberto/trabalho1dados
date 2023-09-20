import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GerenciaFila {
    private Queue<String> fila = new LinkedList<>();

    public GerenciaFila(String[] elementos) {
        for (String elemento : elementos) {
            fila.add(elemento);
        }
    }

    public void adicionarIntegrante(String integrante) {
        fila.add(integrante);
        fila.poll();
    }

    public boolean consultarPorNome(String nome) {
        return fila.contains(nome);
    }

    public int consultarPosicao(String elemento) {
        if (fila.contains(elemento)) {
            int posicao = 1;
            for (String integrante : fila) {
                if (integrante.equals(elemento)) {
                    return posicao;
                }
                posicao++;
            }
        }
        return -1;
    }

    public void mostrarFila() {
        System.out.println("Pessoas que ja estao na fila:");
        for (String integrante : fila) {
            System.out.println(integrante);
        }
    }

    public static void main(String[] args) {
        String[] elementosIniciais = {"Carlos", "Davi", "Priscila", "Marilia", "Pedro"};
        GerenciaFila fila = new GerenciaFila(elementosIniciais);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Gerenciamento de Fila:");
        
        fila.mostrarFila(); 

        while (true) {
            System.out.print("Digite o nome da pessoa que quer adicionar na fila (Digite 'parar' para encerrar a insercao de integrantes)): ");
            String nome = scanner.nextLine();

            if ("parar".equalsIgnoreCase(nome)) {
                break;
            } else {
                fila.adicionarIntegrante(nome);
                System.out.println(nome + " foi adicionado a fila.");
            }
        }

        fila.mostrarFila();

        System.out.print("Digite o nome que deseja consultar na fila: ");
        String nomeConsulta = scanner.nextLine();

        if (fila.consultarPorNome(nomeConsulta)) {
            System.out.println(nomeConsulta + " esta na fila na posicaoo " + fila.consultarPosicao(nomeConsulta));
        } else {
            System.out.println(nomeConsulta + " nao esta na fila.");
        }

        scanner.close();
    }
}
