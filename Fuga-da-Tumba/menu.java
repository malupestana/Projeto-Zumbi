// Importa as bibliotecas do Greenfoot
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Define o ator "menu" (Botão Menu).
 * Este botão aparece na 'Fase1' e, ao ser clicado,
 * retorna o jogador para o menu principal ('HomePage').
 * @author Maria Luiza Pestana e Geovana Zacaroni
 * @version 12-11-2025
 */
public class menu extends Actor
{
    // Construtor: executado quando o ator 'menu' é criado
    public menu(int largura, int altura )
    {
       // Carrega a imagem do botão
       GreenfootImage img = new GreenfootImage("menu.png");
       // Redimensiona a imagem
       img.scale(largura, altura); 
       // Define a imagem do ator
       setImage(img);
    }
    
    // Método 'act' (agir): executado repetidamente (a cada quadro)
    public void act()
    {
       // Verifica se o mouse clicou neste ator
       if ( Greenfoot.mouseClicked(this))
       {
           // NOTA: É importante parar a música da Fase1 antes de sair.
           // ((Fase1)getWorld()).paraMusica(); // <-- Você pode adicionar isso
           
           // Carrega o mundo 'HomePage' (o menu principal)
           Greenfoot.setWorld(new HomePage());
       }
    }
}