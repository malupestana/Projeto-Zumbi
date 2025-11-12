// Importa as bibliotecas do Greenfoot
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Define o ator do botão "Ajuda".
 * Quando clicado, ele avisa o mundo 'HomePage' para mostrar as instruções.
 * @author Maria Luiza Pestana e Geovana Zacaroni
 * @version 12-11-2025
 */
public class Ajuda extends Actor
{
    // Construtor: executado quando o ator 'Ajuda' é criado
    public Ajuda(int largura, int altura )
    {
       // Carrega a imagem do botão "ajuda.png"
       GreenfootImage img = new GreenfootImage("ajuda.png");
       // Redimensiona a imagem para a largura e altura definidas
       img.scale(largura, altura); 
       // Define a imagem redimensionada como a imagem do ator
       setImage(img);
    }
    
    // Método 'act' (agir): executado repetidamente (a cada quadro)
    public void act()
    {
        // Verifica se o mouse clicou neste ator
        if(Greenfoot.mouseClicked(this))
        {
            // Pega uma referência ao mundo atual (HomePage)
            HomePage menu = (HomePage)getWorld();
            // Chama o método 'mostrarInstrucoes' do mundo
            menu.mostrarInstrucoes();
        }
    }
}