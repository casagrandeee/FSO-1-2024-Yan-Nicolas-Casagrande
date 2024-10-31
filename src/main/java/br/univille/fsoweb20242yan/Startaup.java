package br.univille.fsoweb20242yan;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Startaup {
    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event){
    }   
}