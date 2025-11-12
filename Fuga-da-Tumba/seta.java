// Importa as bibliotecas do Greenfoot
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Define o ator "seta" (Placa de Saída).
 * Este é um ator passivo que marca o local de saída da fase.
 * O jogador ('Zumbi') verifica se tocou nesta placa para vencer.
 * @author Maria Luiza Pestana e Geovana Zacaroni
 * @version 12-11-2025
 */
public class seta extends Actor
{
    // Construtor: executado quando o ator 'seta' é criado
    public seta(int largura, int altura)
    {
        // Carrega a imagem da placa
        GreenfootImage img = new GreenfootImage("ArrowSign.png");
        // Redimensiona a imagem
        img.scale(largura, altura); 
        // Define a imagem do ator
        setImage(img);
    }
    
    // Método 'act' (agir): executado repetidamente (a cada quadro)
    public void act()
    {
        // Nenhuma ação é necessária.
        // Este ator é passivo; o Zumbi é quem verifica a colisão com ele.
    }
}