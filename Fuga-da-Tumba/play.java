// Importa as bibliotecas do Greenfoot
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Define o ator "play" (Botão Play).
 * Este botão aparece na 'HomePage' e inicia o jogo
 * (carregando a 'Fase1') após ser clicado duas vezes.
 * @author Maria Luiza Pestana e Geovana Zacaroni
 * @version 12-11-2025
 */
public class play extends Actor
{
    // Variáveis para armazenar as dimensões (não usadas fora do construtor)
    private int largura;
    private int altura;
    // Variável para contar o número de cliques no botão
    private int cliques = 0;
    
    // Construtor: executado quando o ator 'play' é criado
    public play( int largura,int altura)
    {
        // Carrega a imagem do botão
        GreenfootImage img = new GreenfootImage("play.png");
        // Redimensiona a imagem
        img.scale(largura, altura); 
        // Define a imagem do ator
        setImage(img);
    }
    
    // Método 'act' (agir): executado repetidamente (a cada quadro)
    public void act()
    {
        // Verifica se o mouse clicou neste ator
        if(Greenfoot.mouseClicked(this))
        {
            // Adiciona +1 ao contador de cliques
            cliques++;
            
            // Se o botão foi clicado 2 ou mais vezes...
            if (cliques >= 2 )
            {
                // ...inicia o jogo carregando a Fase1
                Greenfoot.setWorld(new Fase1());
            }
        }
    }
}