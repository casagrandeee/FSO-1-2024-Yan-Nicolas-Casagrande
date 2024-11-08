package br.univille.fsoweb20242yan.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class PlanoAlimentar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Cliente cliente;

    private String refeicao;
    private String descricao;
    private LocalDate data;

    private int caloriasDiarias;
    private int carboidratos;
    private int proteinas;
    private int gorduras;

    public Long getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getRefeicao() {
        return refeicao;
    }

    public void setRefeicao(String refeicao) {
        this.refeicao = refeicao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getCaloriasDiarias() {
        return caloriasDiarias;
    }

    public void setCaloriasDiarias(int caloriasDiarias) {
        this.caloriasDiarias = caloriasDiarias;
    }

    public int getCarboidratos() {
        return carboidratos;
    }

    public void setCarboidratos(int carboidratos) {
        this.carboidratos = carboidratos;
    }

    public int getProteinas() {
        return proteinas;
    }

    public void setProteinas(int proteinas) {
        this.proteinas = proteinas;
    }

    public int getGorduras() {
        return gorduras;
    }

    public void setGorduras(int gorduras) {
        this.gorduras = gorduras;
    }
}