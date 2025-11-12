// Importa as bibliotecas do Greenfoot
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Define o ator "tumba" (Lápide).
 * É um objeto de cenário estático, usado apenas para decoração.
 * @author Maria Luiza Pestana e Geovana Zacaroni
 * @version 12-11-2025
 */
public class tumba extends Actor
{
    // Construtor: executado quando o ator 'tumba' é criado
    public tumba( int largura, int altura)
    {
       // Carrega a imagem da lápide
       GreenfootImage img = new GreenfootImage("TombStone (2).png");
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