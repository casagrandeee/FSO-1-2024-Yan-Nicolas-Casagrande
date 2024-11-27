package br.univille.fsoweb20242yan.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class CarrinhoItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Produto produto; //relacionamento com Produto

    private int quantidade;

    private double valor; //preço do produto

    public CarrinhoItem() {
    }

    public CarrinhoItem(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.valor = produto.getValor();
    }

    public double getTotal() {
        return quantidade * valor;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}