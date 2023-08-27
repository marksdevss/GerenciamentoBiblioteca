package util;

import biblioteca.LivroBiblioteca;
import entidade.Livro;

import java.util.Scanner;

public class Util {

    Scanner leia = new Scanner(System.in);
    LivroBiblioteca livroBiblioteca = new LivroBiblioteca();

    Livro livro = new Livro();

    public void Options() {
        int opcoes;

        System.out.println("Escolha uma opcao abaixo: ");
        System.out.println("================================");

        System.out.println("Digite 1 - Cadastrar Livros ");
        System.out.println("Digite 2 - Mostrar Livros");
        System.out.println("Digite 3 - Atualizar Livros");
        System.out.println("Digite 4 - Deletar Livro");

        System.out.println("Digite o numero da opcao desejada: ");
        opcoes = leia.nextInt();

        switch (opcoes){
            case 1 :
                System.out.println("Titulo do livro: ");
                livro.setTitulo(leia.next());
                System.out.println("Autor: ");
                livro.setAutor(leia.next());
                System.out.println("Ano de publicacao: ");
                livro.setAno_publicacao(Integer.parseInt(leia.next()));

                livroBiblioteca.CreateLivro(livro);
                break;
            case 2 :
                for (Livro showLivro:livroBiblioteca.showLivros()){
                    System.out.println("ID: " + showLivro.getId_livro());
                    System.out.println("titulo: " + showLivro.getTitulo());
                    System.out.println("autor: " + showLivro.getAutor());
                    System.out.println("Ano de Publicacao: " + showLivro.getAno_publicacao());
                    System.out.println("===============================================================");
                }
                break;
            case 3:
                System.out.println("Digite o id do livro para atualizar: ");
                livro.setId_livro(leia.nextInt());
                System.out.println("Novo titulo: ");
                livro.setTitulo(leia.next());
                System.out.println("Novo autor: ");
                livro.setAutor(leia.next());
                System.out.println("Novo ano de publicacao: ");
                livro.setAno_publicacao(leia.nextInt());
                livroBiblioteca.UpdateLivro(livro);
                break;
            case 4:
                System.out.println("Digite o id do livro para deletar: ");
                int id = leia.nextInt();
                livroBiblioteca.DeleteLivro(id);
                break;
            default:
                System.out.println("Essa opcao nao existe");
                break;
        }


    }

}
