import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.GreenfootSound;

/**
 * Define o mundo da Fase 1 do jogo, incluindo o cenário,
 * jogadores, itens, placares e música.
 * @author Maria Luiza Pestana e Geovana Zacaroni
 * @version 12-11-2025
 */
public class Fase1 extends World
{
    
    // Variável para armazenar a pontuação
    private int score = 0;
    // Variável para armazenar o número de chaves
    private int chaves = 0;
    // Variável para controlar a música de fundo
    private GreenfootSound musicaDeFundo;
    
    // Construtor: é executado quando a Fase1 é criada
    public Fase1()
    {    
        // Define o tamanho da tela (largura, altura, tamanho da célula)
        super(1024, 584, 1); 
        // Chama o método para adicionar os objetos no mundo
        prepare();
        // Mostra o placar (score) inicial na tela
        atualizarScore();
        // Mostra o placar de chaves inicial na tela
        atualizarChaves();
        
        // Carrega o arquivo de música de fundo
        musicaDeFundo = new GreenfootSound("musicaDeFundo.wav");
        // Toca a música em loop (repetidamente)
        musicaDeFundo.playLoop();
        // Toca um som de efeito (groar do zumbi) uma vez
        Greenfoot.playSound("zombie.wav");
    }
    
    // Método privado que adiciona todos os atores no cenário
    private void prepare()
    {
        // Adiciona os vários pedaços de chão (plataformas)
        chao chao = new chao(300, 70);
        addObject(chao,152,549);

        chao chao2 = new chao(300, 70);
        addObject(chao2,544,548);

        chao chao3 = new chao(300, 70);
        addObject(chao3,868,447);

        chao chao5 = new chao(200,70);
        addObject(chao5,484,359);

        chao chao7 = new chao(80, 70);
        addObject(chao7,804,294);

        chao chao8 = new chao(200, 70);
        addObject(chao8,962,268);

        // Adiciona a placa de saída
        seta seta = new seta(70, 80);
        addObject(seta,936,191);

        // Adiciona decorações
        tumba tumba = new tumba(50, 60);
        addObject(tumba,660,484);

        moita moita = new moita(100, 70);
        addObject(moita,456,483);
        // ( ... resto das moitas ... )
        moita moita6 = new moita(60, 30);
        addObject(moita6,640,500);

        // Adiciona os botões de UI (interface)
        menu menu = new menu(80, 60);
        addObject(menu, 962,43);

        Score score = new Score(200, 60);
        addObject(score,456,42);

        // Adiciona o Inimigo 2
        inimigo2 inimigo2 = new inimigo2(100, 100);
        addObject(inimigo2,403,292);

        Restart restart = new Restart(70, 50);
        addObject(restart,980,548);

        // Adiciona o Jogador (Zumbi)
        Zumbi zumbi = new Zumbi(80, 80);
        addObject(zumbi,69,476);
        zumbi.setLocation(69,476);

        // Adiciona a Chave
        chave chave = new chave(60, 60);
        addObject(chave,604,435);

        // Adiciona os Inimigos 1
        Inimigo1 inimigo1 = new Inimigo1(80, 80);
        addObject(inimigo1,844,358);
        Inimigo1 inimigo12 = new Inimigo1(80, 80);
        addObject(inimigo12,535,464);

        // ( ... reposicionamento de UI e adição de galhos ... )
        score.setLocation(168,47);
        score.setLocation(147,49);
        score.setLocation(120,49);

        chaveScore chaveScore = new chaveScore(200, 60);
        addObject(chaveScore,441,150);
        chaveScore.setLocation(351,59);
        chaveScore.setLocation(333,61);
        chaveScore.setLocation(328,59);
        chaveScore.setLocation(326,51);

        galho galho = new galho(90, 60);
        addObject(galho,348,551);

        galho galho2 = new galho(90, 60);
        addObject(galho2,760,544);
        
        galho galho3 = new galho(90, 60);
        addObject(galho3,870,543);
    }

    // Método público que permite outros atores (como Inimigos) adicionarem pontos
    public void adicionarPontos(int valor)
    {
        score += valor;
        atualizarScore(); // Atualiza o placar na tela
    }
    
    // Método privado que usa 'showText' para desenhar o placar no mundo
    private void atualizarScore()
    {
        showText(": " + score, 180, 45);
    }

    // Método que retorna o placar atual (pode ser usado no futuro)
    public int getScore()
    {
        return score;
    }
    
    // Método público que permite o Zumbi adicionar uma chave
    public void adicionarChave()
    {
        chaves++;
        atualizarChaves(); // Atualiza o placar de chaves
    }

    // Método privado que usa 'showText' para desenhar o número de chaves
    public void atualizarChaves()
    {
        showText(": " + chaves,380, 45);
    }

    // Método que retorna a contagem atual de chaves
    public int getChaves()
    {
        return chaves;
    }
    
    // Método público para parar a música (chamado ao morrer ou vencer)
    public void paraMusica(){
        musicaDeFundo.stop();
    }
    
}