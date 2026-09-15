package view;

import model.Produto;
import controller.ControleDeEstoque;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuEstoque {

    static Scanner read = new Scanner(System.in);
    //instancia o scanner read
    static ControleDeEstoque controller = new ControleDeEstoque();
    //instancia controller, como objeto da classe ControleDeEstoque podendo utilizar os metodos inseridos nesta

    public static void iniciarInterface() {
        int opcao;

        do {
            try {
                 Thread.sleep(1000);
            } catch (InterruptedException e) {
               System.out.println("erro");
               Thread.currentThread().interrupt();
            }
           
            MenuEstoque.mostrarMenu();
            opcao = read.nextInt();
            read.nextLine();

            switch (opcao) {
                case 1:
                    adicionarItens();
                    break;

                case 2:
                    verEstoque();
                    break;

                case 3:
                    alterarEstoque();
                    break;

                case 4:
                    retirarItem();
                    break;

                case 5:
                    deletarItem();
                    break;

                case 0:
                    System.out.println("Programa encerrado.");
                    break;

                default:
                    System.out.println("Opção inválida, insira outra");
            }
        } while (opcao != 0);
        read.close();
    }
    //mostrar menu, requerir a escolha do funcionario e utilizar a funcionalidade desejada por ele enquanto for !0.
    
    public static void mostrarMenu() {
        System.out.println("\n ============ CONTROLE DE ESTOQUE =============");
        System.out.println("ESCOLHA A FUNCIONALIDADE QUE DESEJA ACESSAR:");
        System.out.println("1 - ADICIONAR ITEM \n" + "2 - VER ESTOQUE \n" + "3 - ALTERAR ITEM DO ESTOQUE \n" + "4 - RETIRAR ITEM \n"+ "5 - DELETAR ITEM \n"+ "0 - SAIR DO PROGRAMA \n");
        //interface para o usuario
    }

    private static void adicionarItens() {

        System.out.println("Nome do item: ");
        String nome = read.nextLine();
        System.out.println("Quantidade do item: ");
        int quantidade = read.nextInt();
        read.nextLine();
        controller.adicionarItem(nome, quantidade);
        System.out.println("Produto adicionado ao estoque");
        //interação ao usuario que manda a requisição para o controller, o qual aciona o metodo adicionarItem
    }

    private static void verEstoque() {

        if (controller.estoqueVazio()) {
            System.out.println("O Estoque está vazio");
            return;
        } //invoca estoqueVazio() para conferir se está vazio ou nao
        ArrayList<Produto> produtos = controller.getProdutos();
        //pega o conteudo da arraylist do controller
        for (Produto p : produtos) {
            System.out.println("\nESTOQUE:\n \n"+p.getNome() + " - " + p.getQuantidade());
        } //para cada elemento dentro da arrayList, retorne nome e quantidade
    } 

    private static void alterarEstoque() {

        if (controller.estoqueVazio() == true) {
            System.out.println("O Estoque está vazio");
            return;
            //invoca estoqueVazio
        }
        verEstoque();
        System.out.println("Nome do item que deseja alterar: ");
        String nome = read.nextLine();
        System.out.println("Novo nome do item: ");
        String novoNome = read.nextLine();
        System.out.println("Nova quantidade do item: ");
        int novaQuantidade = read.nextInt();
        read.nextLine();
//invoca verEstoque, e pergunta as alterações ao usuário.
        boolean existeproduto = controller.alterarEstoque(
                nome,
                novoNome,
                novaQuantidade
        );
//invoca alterarEstoque do controller para alterar os atributps

        if (existeproduto) {
            System.out.println("Produto alterado com sucesso");
        } else {
            System.out.println("Produto não encontrado");
        } 
    } 
 //verifica se o produto é válido

    private static void retirarItem() {

        if (controller.estoqueVazio() == true) {
            System.out.println("O Estoque está vazio");
            return;
        }
        verEstoque();
        System.out.println("Nome do item que deseja retirar: ");
        String nome = read.nextLine();
        System.out.println("Quantidade que deseja retirar: ");
        int quantidade = read.nextInt();
        read.nextLine();
        boolean existeproduto = controller.retirarItem(nome, quantidade);
        //pergunta pro usuário oq e quantos ele quer retirar, após isso invoca retirarItem.

        if (existeproduto) {
            System.out.println("Quantidade retirada com sucesso");
        } else {
            System.out.println("Produto não encontrado ou quantidade insuficiente..");
        } //condição para que seja retirada a quantidade do produto
    }

    private static void deletarItem() {

        if (controller.estoqueVazio() == true) {
            System.out.println("O Estoque está vazio");
            return; //verifica se estoque esta vazio
        } verEstoque();
        System.out.println("Nome do item que deseja deletar: ");
        String nome = read.nextLine();
        boolean existeproduto = controller.deletarItem(nome);
        //mostra o estoque e pede para usuario informar o nome do produto depois invoca o metodo deleletarItem 
        //com parametro nome para retirar com base no "valor" digitado.

        if (existeproduto) {
            System.out.println("Produto deletado com sucesso");
        } else {
            System.out.println("Produto não encontrado");
        }//se o produto existe, ele pode ser deletado.
    }
}

