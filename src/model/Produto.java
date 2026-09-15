package model;

public class Produto {
	
protected String nome;
protected int quantidade;
	    
	    public Produto (String nome, int quantidade){
	    this.nome = nome;
	    this.quantidade = quantidade;
	    //define o escopo (classe) dos obj
	    
	    }
	    public String getNome(){
	        return nome;
	    }
	    public int getQuantidade(){
	        return quantidade;
	    }
	    public void setNome(String nome){
	        this.nome = nome;
	    }
	    public void setQuantidade(int quantidade){
	        this.quantidade = quantidade;
	    }
	    //getters e setters
	    
}
