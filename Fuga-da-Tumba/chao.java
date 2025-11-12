// Importa as bibliotecas do Greenfoot
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Define o ator "chao" (Chão).
 * Este é um ator de plataforma sólido (Requisito J4.7) usado
 * pelo Zumbi para andar e pular. É um ator passivo.
 * @author Maria Luiza Pestana e Geovana Zacaroni
 * @version 12-11-2025
 */
public class chao extends Actor
{
    // Construtor: executado quando o ator 'chao' é criado
    public chao(int largura, int altura )
    {
       // Carrega a imagem da plataforma de chão
       GreenfootImage img = new GreenfootImage("chao.png");
       // Redimensiona a imagem para a largura e altura definidas
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