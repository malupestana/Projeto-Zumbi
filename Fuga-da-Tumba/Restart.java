// Importa as bibliotecas do Greenfoot
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Define o ator "Restart" (Botão Reiniciar).
 * Este botão aparece na 'Fase1' e, ao ser clicado,
 * reinicia o nível carregando uma nova 'Fase1'.
 * @author Maria Luiza Pestana e Geovana Zacaroni
 * @version 12-11-2025
 */
public class Restart extends Actor
{
    // Construtor: executado quando o ator 'Restart' é criado
    public Restart(int largura, int altura )
    {
       // Carrega a imagem do botão
       GreenfootImage img = new GreenfootImage("restart.png");
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
            // NOTA: Antes de reiniciar, é bom parar a música da fase atual
            // para evitar que duas músicas toquem ao mesmo tempo.
            // ((Fase1)getWorld()).paraMusica(); // <-- Você pode adicionar isso
            
            // Carrega um novo mundo 'Fase1', reiniciando o jogo
            Greenfoot.setWorld( new Fase1());
        }
    }
}