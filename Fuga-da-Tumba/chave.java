// Importa as bibliotecas do Greenfoot
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Define o ator "chave" (Chave).
 * Este é um item colecionável (Requisito J4.6) que o Zumbi precisa
 * pegar para vencer a fase. Ele é passivo e é removido
 * quando o Zumbi o coleta.
 * @author Maria Luiza Pestana e Geovana Zacaroni
 * @version 12-11-2025
 */
public class chave extends Actor
{
    // Construtor: executado quando o ator 'chave' é criado
    public chave(int largura, int altura )
    {
       // Carrega a imagem da chave
       GreenfootImage img = new GreenfootImage("chave.png");
       // Redimensiona a imagem
       img.scale(largura, altura); 
       // Define a imagem do ator
       setImage(img);
    }
    
    // Método público chamado pelo 'Zumbi' quando a chave é coletada
    public void serColetada()
    {
        // 1. Toca o som de coleta
        Greenfoot.playSound("barulhoZumbi.wav"); 
        
        // 2. Remove este ator (a chave) do mundo
        // Isso é feito pela própria chave para evitar o crash no terminal
        getWorld().removeObject(this);
    }
    
    // Método 'act' (agir): executado repetidamente (a cada quadro)
    public void act()
    {
        // Verificação de segurança: se a chave já foi removida, não faz nada.
        if (getWorld() == null) {
            return;
        }
        
        // Nenhuma outra ação é necessária.
        // A chave é um item passivo.
    }
}