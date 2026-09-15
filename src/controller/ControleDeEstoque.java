package controller;

import model.Produto;
import java.util.ArrayList;

public class ControleDeEstoque {

    private ArrayList<Produto> produtos;

    // instancia arrayList produtos com a classe dos objetos sendo Produto.
    public ControleDeEstoque() {
        produtos = new ArrayList<>();
        //construtor 
    }

    public void adicionarItem(String nome, int quantidade) {
        Produto produto = new Produto(nome, quantidade); //instancia produto
        produtos.add(produto);
        //instancia um novo objeto na arraylist
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
        //metodo get para pegar o valor do produto na arrayList
    }

    public boolean estoqueVazio() {
        return produtos.isEmpty();
        //metodo que verifica se o estoque esta vazio
    }

    public Produto buscarProduto(String nome) {
        for (Produto produto : produtos) {
            if (produto.getNome().equalsIgnoreCase(nome)) {
                return produto;
            }
        }
        return null;
        //verifica se existe o produto com base no nome dele.
    }

    public boolean retirarItem(String nome, int quantidade) {
        Produto produto = buscarProduto(nome);
            if (produto == null || quantidade > produto.getQuantidade()) {
                return false;
            }
        int novaQuantidade = produto.getQuantidade() - quantidade;
        produto.setQuantidade(novaQuantidade);

        return true;
        //verifica se o produto existe, pega o produto pelo nome e retira a quantidade desejada.
    }

    public boolean alterarEstoque(String nome, String novoNome, int novaQuantidade) {
        Produto produto = buscarProduto(nome);
            if (produto == null) {
                return false;
            }
        produto.setNome(novoNome);
        produto.setQuantidade(novaQuantidade);
        return true;
        
        //metodo alterarEstoque, invoca buscarProduto, verifica se existe, se sim seta um novo nome
        //e uma nova quantidade
        
    }
    public boolean deletarItem(String nome) {
    	Produto produto = buscarProduto(nome); 
    		if (produto == null) {
    			return false; } 
    		produtos.remove(produto);
    		return true;
    		//procura o produto no metodo buscarProduto, se achar o remove do estoque.
    		}
    }

