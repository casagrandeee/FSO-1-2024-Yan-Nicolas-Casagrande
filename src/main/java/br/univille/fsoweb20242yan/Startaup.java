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

        var nintendo = new Produto();
        nintendo.setDescricao("Nintendo Switch");
        nintendo.setValor(2000);
        serviceProduto.save(nintendo);
    }   
}