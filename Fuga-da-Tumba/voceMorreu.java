// Importa as bibliotecas do Greenfoot
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Define o mundo da tela de "Game Over" (Você Morreu).
 * Toca um som de derrota e permite ao jogador reiniciar ou voltar ao menu.
 * @author Maria Luiza Pestana e Geovana Zacaroni
 * @version 12-11-2025
 */
public class voceMorreu extends World
{

    // Construtor: executado quando o mundo 'voceMorreu' é criado
    public voceMorreu()
    {    
        // Define o tamanho do mundo (largura, altura, tamanho da célula)
        super(1024, 490, 1); 
        
        // Toca o som de derrota "perdeu.wav" uma vez
        Greenfoot.playSound("perdeu.wav");
    }
    
    // Método 'act' (agir): executado repetidamente (a cada quadro)
    public void act()
    {
        // Verifica se o jogador pressionou a tecla "espaço"
        if (Greenfoot.isKeyDown("space"))
        {
            // Se sim, reinicia o jogo carregando a Fase1
            Greenfoot.setWorld(new Fase1()); 
        }

        // Verifica se o jogador pressionou a tecla "enter"
        if (Greenfoot.isKeyDown("enter"))
        {
            // Se sim, volta para o menu principal
            Greenfoot.setWorld(new HomePage()); 
        }
    }
}