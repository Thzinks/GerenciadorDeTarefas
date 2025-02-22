import java.util.ArrayList; 
import java.util.Scanner;

class Tarefa {
    private final String descricao; 
    private boolean concluida;

    public Tarefa(String descricao) {
        this.descricao = descricao;
        this.concluida = false;
    }

    public void concluir() {
        this.concluida = true;
    }

    public String getDescricao() {
        return descricao;
    }
    
    public boolean isConcluida() {
        return concluida;
    }
}

public class GerenciadorDeTarefas {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            ArrayList<Tarefa> tarefas = new ArrayList <>();
            
            int opcao;
            
            do {
                System.out.println("\n=== Gerenciador de Tarefas ===");
                System.out.println("1. Adicionar Tarefa");
                System.out.println("2. Listar Tarefa");
                System.out.println("3. Marcar Tarefa como concluída");
                System.out.println("4. Excluir Tarefa");
                System.out.println("5. Sair");
                System.out.println("Escolha uma opção: ");
                opcao = scanner.nextInt();
                scanner.nextLine();
                
                switch (opcao) {
                    case 1:
                        System.out.println("Digite a descrição da tarefa: ");
                        String descricao = scanner.nextLine();
                        boolean existe = false;
                        
                        for (Tarefa t : tarefas) {
                            if (t.getDescricao().equalsIgnoreCase(descricao)) {
                                existe = true;
                                break;
                            }
                        }
                        
                        if (!existe) {
                            tarefas.add(new Tarefa(descricao));
                            System.out.println("Tarefa adicionada com sucesso!");
                            
                        } else {
                            System.out.println("Essa tarefa já existe");
                        }
                        
                    case 2:
                        System.out.println("\n== Lista de Tarefas ==");
                        if (tarefas.isEmpty()) {
                            System.out.println("Nenhuma tarefa cadastrada.");
                        } else {
                            for (int i = 0; i < tarefas.size(); i++) {
                                Tarefa tarefa = tarefas.get(i);
                                String status = tarefa.isConcluida() ? "[Concluída]" : "[Pendente]";
                                System.out.println((i+1) + ". " + tarefa.getDescricao() + " " + status);
                            }
                        }
                        break;
                        
                    case 3:
                        System.out.println("Digite o número da tarefa a ser concluída: ");
                        int numeroConcluir = scanner.nextInt();
                        if (numeroConcluir > 0 && numeroConcluir <= tarefas.size()) {
                            tarefas.get(numeroConcluir - 1).concluir();
                            System.out.println("Tarefa marcada como concluida!");
                        } else {
                            System.out.println("Número inválido!");
                        }
                        break;
                        
                    case 4:
                        System.out.println("Digite o número da tarefa a ser excluída: ");
                        int numeroExcluir = scanner.nextInt();
                        if (numeroExcluir > 0 && numeroExcluir <= tarefas.size()) {
                            tarefas.remove(numeroExcluir - 1);
                            System.out.println("Tarefa excluída com sucesso!");
                        } else {
                            System.out.println("Número inválido!");
                        }
                        break;
                    case 5:
                        System.out.println("Encerrando o programa...");
                        break;
                    
                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                }
                
            } while (opcao != 5);
        }
    }
}