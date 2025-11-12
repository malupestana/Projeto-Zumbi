// Importa as bibliotecas do Greenfoot
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Define o ator "Instruçoes" (Instruções).
 * Este ator é um painel que aparece na 'HomePage' quando o botão
 * 'Ajuda' é clicado. Ele pode ser fechado pressionando 'enter'.
 * @author Maria Luiza Pestana e Geovana Zacaroni
 * @version 12-11-2025
 */
public class Instruçoes extends Actor
{
    // Variável para controlar se o painel está visível ou não
    private boolean visivel = false;
    
    // Construtor: executado quando o ator 'Instruçoes' é criado
    public Instruçoes(int largura, int altura )
    {
       // Carrega a imagem do painel
       GreenfootImage img = new GreenfootImage("Instruçoes.png");
       // Redimensiona a imagem
       img.scale(largura, altura); 
       setImage(img);
    }
    
    // Método 'act' (agir): executado repetidamente (a cada quadro)
    public void act()
    {
       // Se o painel estiver visível E a tecla 'enter' for pressionada...
       if(visivel && Greenfoot.isKeyDown("enter"))
       {
           // ...chama o método para esconder o painel.
           setVisible(false);
       }
    }
    
    // Método público que controla a visibilidade do painel
    // É chamado pela 'HomePage' (para mostrar) e pelo 'act' (para esconder)
    public void setVisible(boolean mostrar)
    {
        // Atualiza a variável de controle
        visivel = mostrar;
        
        // Define a transparência da imagem:
        // Se 'mostrar' for true, transparência = 255 (visível)
        // Se 'mostrar' for false, transparência = 0 (invisível)
        getImage().setTransparency(mostrar ? 255 : 0 );
    }
}