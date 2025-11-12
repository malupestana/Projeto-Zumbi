// Importa as bibliotecas do Greenfoot
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Define o ator "moita" (Moita).
 * É um objeto de cenário estático, usado apenas para decoração.
 * @author Maria Luiza Pestana e Geovana Zacaroni
 * @version 12-11-2025
 */
public class moita extends Actor
{
    // Construtor: executado quando o ator 'moita' é criado
    public moita( int largura, int altura )
    {
        // Carrega a imagem da moita
        GreenfootImage img = new GreenfootImage("Bush (2).png");
        // Redimensiona a imagem
        img.scale(largura, altura); 
        // Define a imagem do ator
        setImage(img);
    }
    
    // Método 'act' (agir): executado repetidamente (a cada quadro)
    public void act()
    {
        // Nenhuma ação é necessária.
        // Este ator é apenas decorativo.
    }
}