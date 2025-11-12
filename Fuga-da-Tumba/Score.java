// Importa as bibliotecas do Greenfoot
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Define o ator "Score" (Rótulo do Placar).
 * Este ator é apenas a imagem estática (o "rótulo") para o placar.
 * O número da pontuação é desenhado pelo mundo 'Fase1'.
 * @author Maria Luiza Pestana e Geovana Zacaroni
 * @version 12-11-2025
 */
public class Score extends Actor
{
    
    // Variável para guardar a imagem do rótulo
    private GreenfootImage imagemBase;
    
    // Construtor: executado quando o ator 'Score' é criado
    public Score(int largura, int altura )
    {
       // Carrega a imagem "score.png"
       imagemBase = new GreenfootImage("score.png");
       // Redimensiona a imagem
       imagemBase.scale(largura, altura); 
       // Define a imagem do ator
       setImage(imagemBase);
    }
    
    // Método 'act' (agir): executado repetidamente (a cada quadro)
    public void act()
    {
        // Nenhuma ação é necessária.
        // Este ator é apenas uma imagem estática.
    }
}