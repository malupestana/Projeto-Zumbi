// Importa as bibliotecas do Greenfoot
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Define o mundo da Tela Inicial do jogo, que é carregada primeiro.
 * Sua única função é exibir o botão "Jogar" (BotaoJogar).
 * Este mundo não tem som.
 * @author Maria Luiza Pestana e Geovana Zacaroni
 * @version 12-11-2025
 */
public class Telainicial extends World
{

    // Construtor: executado quando a Telainicial é criada
    public Telainicial()
    {    
        // Define o tamanho do mundo (largura, altura, tamanho da célula)
        super(1024, 584, 1);
        
        // Cria um novo objeto BotaoJogar
        BotaoJogar botao = new BotaoJogar();
        // Adiciona o botão no centro exato da tela
        addObject(botao, getWidth() / 2, getHeight() / 2);
    }
}