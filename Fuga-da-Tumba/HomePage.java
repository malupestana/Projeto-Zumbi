// Importa as bibliotecas do Greenfoot
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Define o mundo do Menu Principal do jogo, incluindo
 * os botões de play e ajuda.
 * @author Maria Luiza Pestana e Geovana Zacaroni
 * @version 12-11-2025
 */
public class HomePage extends World
{

    // Variável para guardar a referência ao painel de instruções
    public Instruçoes instrucoes;
    
    // Construtor: executado quando a HomePage é criada
    public HomePage()
    {    
        // Define o tamanho do mundo (largura, altura, tamanho da célula)
        super(1024, 585, 1);
        // Chama o método para adicionar os objetos na tela
        prepare();
    }
    
    // Método privado que adiciona os botões e o painel de instruções
    private void prepare()
    {
        // Cria e adiciona o botão 'play'
        play play = new play(200, 80);
        addObject(play,518,471);
        
        // Cria e adiciona o botão 'Ajuda'
        Ajuda ajuda = new Ajuda(80, 60);
        addObject(ajuda,55,48);
        
        // Cria e adiciona o painel de instruções
        instrucoes = new Instruçoes(500, 400);
        addObject(instrucoes, 300, 200);

        // Esconde o painel de instruções por padrão
        instrucoes.setVisible(false);
    }
    
    // Método público que torna o painel de instruções visível
    // É chamado pelo botão 'Ajuda' quando ele é clicado
    public void mostrarInstrucoes()
    {
        instrucoes.setVisible(true);
    }
}