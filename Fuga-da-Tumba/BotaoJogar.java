// Importa as bibliotecas do Greenfoot
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Define o ator "BotaoJogar" (Botão Jogar).
 * Este botão aparece na 'Telainicial' e, ao ser clicado,
 * inicia o jogo carregando o mundo 'Fase1'.
 * @author Maria Luiza Pestana e Geovana Zacaroni
 * @version 12-11-2025
 */
public class BotaoJogar extends Actor
{
    // Método 'act' (agir): executado repetidamente (a cada quadro)
    public void act()
    {
        // Verifica se o mouse clicou neste ator
        if(Greenfoot.mouseClicked(this)){
            // Se sim, substitui o mundo atual pela Fase1
            Greenfoot.setWorld(new Fase1());
        }
    }
}