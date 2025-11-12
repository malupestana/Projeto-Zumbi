// Importa as bibliotecas do Greenfoot
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Define o mundo da tela de "Vitória" (Você Venceu).
 * Toca um som de vitória e permite ao jogador reiniciar ou voltar ao menu.
 * @author Maria Luiza Pestana e Geovana Zacaroni
 * @version 12-11-2025
 */
public class voceVenceu extends World
{

    // Construtor: executado quando o mundo 'voceVenceu' é criado
    public voceVenceu()
    {    
        // Define o tamanho do mundo (largura, altura, tamanho da célula)
        super(1024, 490, 1); 
        
        // Toca o som de vitória "ganhou.wav" uma vez
        Greenfoot.playSound("ganhou.wav");
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