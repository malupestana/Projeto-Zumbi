// Importa as bibliotecas do Greenfoot
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Define o ator "galho" (Galho).
 * Este é um ator de obstáculo (Requisito J4.7) que causa dano
 * ao jogador ('Zumbi') se for tocado. É um ator passivo.
 * @author Maria Luiza Pestana e Geovana Zacaroni
 * @version 12-11-2025
 */
public class galho extends Actor
{
    // Construtor: executado quando o ator 'galho' é criado
    public galho(int largura, int altura )
    {
       // Carrega a imagem do galho
       GreenfootImage img = new GreenfootImage("DeadBush.png");
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