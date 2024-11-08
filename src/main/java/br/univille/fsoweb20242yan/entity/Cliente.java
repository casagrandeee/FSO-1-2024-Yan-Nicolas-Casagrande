package br.univille.fsoweb20242yan.entity;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 1000, nullable = false)
    private String nome;

    @Column(length = 1000)
    private String endereco;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private Date dataNascimento;
    private double peso;
    private double altura;
    private String preferenciasAlimentares;
    private String metaNutricional;
    private int metaCalorias; // Meta calórica diária
    private int metaProteinas; // Meta de proteínas (g)
    private int metaCarboidratos; // Meta de carboidratos (g)
    private int metaGorduras; // Meta de gorduras (g)
    
    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    private Cidade cidade;

    // Método para calcular a idade de acordo com a data de nascimento
    public int getIdade(){
        if (this.dataNascimento == null){
            return 0;
        }
        LocalDate nascimento = this.dataNascimento.toInstant()
                                .atZone(ZoneId.systemDefault())
                                .toLocalDate();
        return Period.between(nascimento, LocalDate.now()).getYears();
    }

    public Cidade getCidade() {
        return cidade;
    }
    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
    public Date getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getMetaGorduras() {
        return metaGorduras;
    }

    public void setMetaGorduras(int metaGorduras) {
        this.metaGorduras = metaGorduras;
    }

    public int getMetaCarboidratos() {
        return metaCarboidratos;
    }

    public void setMetaCarboidratos(int metaCarboidratos) {
        this.metaCarboidratos = metaCarboidratos;
    }

    public int getMetaProteinas() {
        return metaProteinas;
    }

    public void setMetaProteinas(int metaProteinas) {
        this.metaProteinas = metaProteinas;
    }

    public int getMetaCalorias() {
        return metaCalorias;
    }

    public void setMetaCalorias(int metaCalorias) {
        this.metaCalorias = metaCalorias;
    }

    public String getMetaNutricional() {
        return metaNutricional;
    }

    public void setMetaNutricional(String metaNutricional) {
        this.metaNutricional = metaNutricional;
    }

    public String getPreferenciasAlimentares() {
        return preferenciasAlimentares;
    }

    public void setPreferenciasAlimentares(String preferenciasAlimentares) {
        this.preferenciasAlimentares = preferenciasAlimentares;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    
}
