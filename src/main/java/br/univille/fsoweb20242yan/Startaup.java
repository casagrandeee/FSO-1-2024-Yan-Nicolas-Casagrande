package br.univille.fsoweb20242yan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import br.univille.fsoweb20242yan.entity.Cidade;
import br.univille.fsoweb20242yan.entity.Produto;
import br.univille.fsoweb20242yan.service.CidadeService;
import br.univille.fsoweb20242yan.service.ProdutoService;
@Component
public class Startaup {

    @Autowired
    private CidadeService serviceCidade;

    @Autowired
    private ProdutoService serviceProduto;

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event){
        var jlle = new Cidade();
        jlle.setId(1);
        jlle.setNome("Joinville");
        jlle.setEstado("Santa Catarina");
        serviceCidade.save(jlle);

        var jaragua = new Cidade();
        jaragua.setId(2);
        jaragua.setNome("Jaraguá do Sul");
        jaragua.setEstado("Santa Catarina");
        serviceCidade.save(jaragua);

        var chapadao = new Cidade();
        chapadao.setId(3);
        chapadao.setNome("Chapadão do Lageado");
        chapadao.setEstado("Santa Catarina");
        serviceCidade.save(chapadao);

        var pintobandeira = new Cidade();
        pintobandeira.setId(4);
        pintobandeira.setNome("Pinto Bandeira");
        pintobandeira.setEstado("Rio Grande do Sul");
        serviceCidade.save(pintobandeira);

        var rolandia = new Cidade();
        rolandia.setId(5);
        rolandia.setNome("Rolandia");
        rolandia.setEstado("Paraná");
        serviceCidade.save(rolandia);

        var antagorda = new Cidade();
        antagorda.setId(5);
        antagorda.setNome("Anta Gorda");
        antagorda.setEstado("Rio Grande do Sul");
        serviceCidade.save(antagorda);

        var creatina = new Produto();
        creatina.setDescricao("Creatina");
        creatina.setValor(119);
        creatina.setImagemUrl("https://images.unsplash.com/photo-1693996045435-af7c48b9cafb?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mjh8fHdoZXklMjBwcm90ZWlufGVufDB8fDB8fHww");
        serviceProduto.save(creatina);

        var pretreino = new Produto();
        pretreino.setDescricao("Pré-Treino");
        pretreino.setValor(109);
        pretreino.setImagemUrl("https://images.unsplash.com/photo-1704650311981-419f841421cc?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTJ8fHdoZXklMjBwcm90ZWlufGVufDB8fDB8fHww");
        serviceProduto.save(pretreino);

        var termogenico = new Produto();
        termogenico.setDescricao("Termogênico");
        termogenico.setValor(79);
        termogenico.setImagemUrl("https://plus.unsplash.com/premium_photo-1690534068749-524a21d89307?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NjV8fHN1cGxlbWVudG9zfGVufDB8fDB8fHww");
        serviceProduto.save(termogenico);

        var wheyprotein = new Produto();
        wheyprotein.setDescricao("Whey Protein");
        wheyprotein.setValor(139);
        wheyprotein.setImagemUrl("https://images.unsplash.com/photo-1704650311190-7eeb9c4f6e11?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTV8fHdoZXklMjBwcm90ZWlufGVufDB8fDB8fHww");
        serviceProduto.save(wheyprotein);

        var hipercalorico = new Produto();
        hipercalorico.setDescricao("Hipercalórico");
        hipercalorico.setValor(129);
        hipercalorico.setImagemUrl("https://plus.unsplash.com/premium_photo-1690291494818-068ed0f63c42?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NXx8d2hleSUyMHByb3RlaW58ZW58MHx8MHx8fDA%3D");
        serviceProduto.save(hipercalorico);

        var multivitaminico = new Produto();
        multivitaminico.setDescricao("Multivitamíco");
        multivitaminico.setValor(39);
        multivitaminico.setImagemUrl("https://plus.unsplash.com/premium_photo-1732689834566-a7c313f00478?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MzR8fG11bHRpdml0YW1pbmljb3xlbnwwfHwwfHx8MA%3D%3D");
        serviceProduto.save(multivitaminico);

        var bcaa = new Produto();
        bcaa.setDescricao("BCAA");
        bcaa.setValor(59);
        bcaa.setImagemUrl("https://images.unsplash.com/photo-1668440246511-539c5438518d?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MjR8fHN1cGxlbWVudG98ZW58MHx8MHx8fDA%3D");
        serviceProduto.save(bcaa);

        var glutamina = new Produto();
        glutamina.setDescricao("Glutamina");
        glutamina.setValor(79);
        glutamina.setImagemUrl("https://images.unsplash.com/photo-1659090340416-30dfd00978c7?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTF8fHN1cGxlbWVudG98ZW58MHx8MHx8fDA%3D");
        serviceProduto.save(glutamina);

        var omega3 = new Produto();
        omega3.setDescricao("Ômega 3");
        omega3.setValor(49);
        omega3.setImagemUrl("https://images.unsplash.com/photo-1687200266857-764ef12cfdd1?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTJ8fG9tZWdhJTIwM3xlbnwwfHwwfHx8MA%3D%3D");
        serviceProduto.save(omega3);

        var balancaDePesarComida = new Produto();
        balancaDePesarComida.setDescricao("Balança de Pesar Comida");
        balancaDePesarComida.setValor(99);
        balancaDePesarComida.setImagemUrl("https://images.unsplash.com/photo-1557256611-210fcc4476d7?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8N3x8YmFsYW4lQzMlQTdhJTIwZGUlMjBwZXNhciUyMGNvbWlkYXxlbnwwfHwwfHx8MA%3D%3D");
        serviceProduto.save(balancaDePesarComida);

        var garrafinhaTermica = new Produto();
        garrafinhaTermica.setDescricao("Garrafinha Térmica");
        garrafinhaTermica.setValor(29);
        garrafinhaTermica.setImagemUrl("https://plus.unsplash.com/premium_photo-1681154819809-b660a509e1ee?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8Z2FycmFmYSUyMHQlQzMlQTlybWljYXxlbnwwfHwwfHx8MA%3D%3D");
        serviceProduto.save(garrafinhaTermica);
    }   
}