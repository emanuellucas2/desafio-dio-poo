import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Conteudo;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
         Scanner scanner = new Scanner(System.in);

        Curso curso1 = new Curso("curso java", "descrição curso java", 8);
        Curso curso2 = new Curso("curso js", "descrição curso js", 4);

        Mentoria mentoria = new Mentoria("mentoria de java", "descrição mentoria java", LocalDate.now());

        Bootcamp bootcamp = new Bootcamp("Bootcamp Java Developer", "Descrição Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

        while (true) {

            System.out.println("\nMenu:");
            System.out.println("1. Inscrever Dev em Bootcamp");
            System.out.println("2. Ver conteúdos inscritos");
            System.out.println("3. Progredir no Bootcamp");
            System.out.println("4. Avaliar curso/mentoria");
            System.out.println("5. Ver conteúdos concluídos e XP");
            System.out.println("6. Ver avaliação de curso/mentoria");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");

            int escolha = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (escolha) {
                case 1:
                    System.out.print("Nome do Dev: ");
                    String nomeDev = scanner.nextLine();
                    Dev dev = new Dev(nomeDev);
                    dev.inscreverBootcamp(bootcamp);
                    System.out.println("Dev " + nomeDev + " inscrito no Bootcamp.");
                    break;
                case 2:
                    System.out.print("Nome do Dev: ");
                    nomeDev = scanner.nextLine();
                    dev = bootcamp.obterDevPorNome(nomeDev);
                    if (dev != null) {
                        System.out.println("Conteúdos Inscritos " + nomeDev + ": " + dev.getConteudosInscritos());
                    } else {
                        System.out.println("Dev não encontrado.");
                    }
                    break;
                case 3:
                    System.out.print("Nome do Dev: ");
                    nomeDev = scanner.nextLine();
                    dev = bootcamp.obterDevPorNome(nomeDev);
                    if (dev != null) {
                        dev.progredir();
                        System.out.println("Progresso realizado.");
                    } else {
                        System.out.println("Dev não encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("Nome do Dev: ");
                    nomeDev = scanner.nextLine();
                    dev = bootcamp.obterDevPorNome(nomeDev);
                    if (dev != null) {
                        System.out.println("Conteúdos Concluídos " + nomeDev + ": " + dev.getConteudosConcluidos());
                        System.out.print("Escolha um conteúdo para avaliar: ");
                        String tituloConteudo = scanner.nextLine();
                        Conteudo conteudo = dev.obterConteudoConcluido(tituloConteudo);
                        if (conteudo != null) {
                            System.out.print("Dê uma nota (0-10): ");
                            int nota = scanner.nextInt();
                            scanner.nextLine(); // Consumir a nova linha
                            conteudo.avaliar(nota);
                            System.out.println("Avaliação registrada.");
                        } else {
                            System.out.println("Conteúdo não encontrado.");
                        }
                    } else {
                        System.out.println("Dev não encontrado.");
                    }
                    break;
                case 5:
                    System.out.print("Nome do Dev: ");
                    nomeDev = scanner.nextLine();
                    dev = bootcamp.obterDevPorNome(nomeDev);
                    if (dev != null) {
                        System.out.println("Conteúdos Concluídos " + nomeDev + ": " + dev.getConteudosConcluidos());
                        System.out.println("XP Total: " + dev.calcularTotalXp());
                    } else {
                        System.out.println("Dev não encontrado.");
                    }
                    break;
                case 6:
                    System.out.print("Nome do Conteúdo (Curso/Mentoria): ");
                    String tituloConteudo = scanner.nextLine();
                    Conteudo conteudo = bootcamp.obterConteudoPorNome(tituloConteudo);
                    if (conteudo != null) {
                        System.out.println("Avaliações do " + tituloConteudo + ": " + conteudo.getAvaliacoes());
                        System.out.println("Média de Avaliação: " + conteudo.getNota());
                    } else {
                        System.out.println("Conteúdo não encontrado.");
                    }
                    break;
                case 7:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

}