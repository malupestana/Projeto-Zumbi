// Importa as bibliotecas do Greenfoot
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Define o ator "Arvore".
 * É um objeto de cenário estático, usado apenas para decoração.
 * @author Maria Luiza Pestana e Geovana Zacaroni
 * @version 12-11-2025
 */
public class Arvore extends Actor
{
    // Construtor: executado quando o ator 'Arvore' é criado
    public Arvore(int largura, int altura)
    {
       // Carrega a imagem "Tree.png"
       GreenfootImage img = new GreenfootImage("Tree.png");
       // Redimensiona a imagem para a largura e altura definidas
       img.scale(largura, altura); 
       // Define a imagem redimensionada como a imagem do ator
       setImage(img);
    }
    
    // Método 'act' (agir): executado repetidamente (a cada quadro)
    public void act()
    {
        // Nenhuma ação é necessária. 
        // Este ator é apenas decorativo e não faz nada.
    }
}