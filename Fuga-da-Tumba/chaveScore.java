// Importa as bibliotecas do Greenfoot
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Define o ator "chaveScore" (Rótulo do Placar de Chaves).
 * Este ator é apenas a imagem estática (o "rótulo") para o placar de chaves.
 * O número de chaves é desenhado pelo mundo 'Fase1'.
 * @author Maria Luiza Pestana e Geovana Zacaroni
 * @version 12-11-2025
 */
public class chaveScore extends Actor
{
    // Variáveis para armazenar as dimensões (não usadas fora do construtor)
    private int largura;
    private int altura;
    
    // Construtor: executado quando o ator 'chaveScore' é criado
    public chaveScore(int largura, int altura )
    {
       // Carrega a imagem do rótulo
       GreenfootImage img = new GreenfootImage("chaveScore.png");
       // Redimensiona a imagem
       img.scale(largura, altura); 
       // Define a imagem do ator
       setImage(img);
    }
    
    // Método 'act' (agir): executado repetidamente (a cada quadro)
    public void act()
    {
        // Nenhuma ação é necessária.
        // Este ator é apenas uma imagem estática.
    }
}