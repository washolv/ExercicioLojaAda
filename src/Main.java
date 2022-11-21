import model.*;
import service.impl.*;
import view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        LivroServiceImpl livroService= new LivroServiceImpl();
        AlbumMusicaServiceImpl albumMusicaService= new AlbumMusicaServiceImpl();
        JogoServiceImpl jogoService = new JogoServiceImpl();
        FilmeServiceImpl filmeService= new FilmeServiceImpl();
        BrinquedoServiceImpl brinquedoService= new BrinquedoServiceImpl();

        GerenciaProduto gerenciaProduto = new GerenciaProduto(
                livroService,
                albumMusicaService,
                jogoService,
                filmeService,
                brinquedoService
        );
        gerenciaProduto.criaProdutosInciais();
        Scanner sc = new Scanner(System.in);
        View.menuPrincipal();
        int opcaoSelecionada = sc.nextInt();
        switch (opcaoSelecionada){
            case 1:
                View.menuEstoque();
                opcaoSelecionada = sc.nextInt();
                switch (opcaoSelecionada){
                    case 1:
                        gerenciaProduto.listarTodosEstoque();
                    case 2:
                        View.menuCategoria();
                        opcaoSelecionada = sc.nextInt();
                        gerenciaProduto.listarPorCategoria(opcaoSelecionada);
                        break;
                    default:
                        System.out.print("OPÇAO INVALIDA");
                }
                break;
            case 2:
                View.menuProdutos();
                opcaoSelecionada = sc.nextInt();
                switch (opcaoSelecionada){
                    case 1:
                        gerenciaProduto.listarTodos();
                }
                break;
            case 3:
                System.out.print("SELECIONE O PRODUTO: ");
                break;
            default:
                System.out.print("OPÇAO INVALIDA.");
        }


    }

}
