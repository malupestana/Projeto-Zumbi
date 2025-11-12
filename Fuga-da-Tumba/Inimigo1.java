// Importa as bibliotecas do Greenfoot
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Define o ator "Inimigo1", um dos inimigos do jogo (Requisito J4.5).
 * Este inimigo tem um comportamento de movimento aleatório.
 * Ele pode ser ferido e removido do jogo.
 * @author Maria Luiza Pestana e Geovana Zacaroni
 * @version 12-11-2025
 */
public class Inimigo1 extends Actor
{
    // Variáveis para controlar o movimento (atualmente não usadas)
    private int velocidade = 1;
    private int limiteEsquerda = 500;
    private int limiteDireita = 500;
    
    // Variáveis de estado do inimigo
    private int vidas = 5; // Quantidade de vidas
    private boolean morto = false; // Flag para controlar se está morto
    
    // Construtor: executado quando o Inimigo1 é criado
    public Inimigo1( int largura, int altura)
    {
        // Carrega a imagem do inimigo
        GreenfootImage img = new GreenfootImage("Bone (2).png");
        // Redimensiona a imagem
        img.scale(largura, altura); 
        setImage(img);
    }
    
    // Método 'act' (agir): executado repetidamente (a cada quadro)
    public void act()
    {
        // Se o inimigo estiver morto, remove-o e para a execução
        if(morto){
            morrer(getWorld());
            return; // 'return' impede que o resto do 'act' seja executado
        }
        
        // Se estiver vivo, continua se movendo
        moverAleatoriamente();
    }
    
    // Método público chamado pelo 'Projetil' quando este inimigo é atingido
    public void levarDano()
    {
        // Se já está morto, não faz nada
        if (morto) {
            return; 
        }
        
        // Diminui uma vida
        vidas--;
        
        // Se a vida for zero ou menos...
        if (vidas <= 0) 
        {
            morto = true; // Marca o inimigo como morto
            // Avisa o mundo 'Fase1' para adicionar 10 pontos ao placar
            ((Fase1)getWorld()).adicionarPontos(10);
        }
    }
    
    // Método que remove o inimigo do mundo
    public void morrer(World mundo)
    {
        mundo.removeObject(this);
    }
    
    // Método público que avisa outros atores se este inimigo está morto
    public boolean estaMorto()
    {
        return morto;
    }
    
    // Método que define o movimento aleatório do inimigo (Requisito J4.5)
    public void moverAleatoriamente()
    {
        // Move-se 2 pixels para frente
        move(2);
        
        // Tem 5% de chance (número aleatório de 0 a 99 < 5) de virar
        if (Greenfoot.getRandomNumber(100) < 5 )
        {
            // Vira em um ângulo aleatório entre -45 e +45 graus
            turn(Greenfoot.getRandomNumber(90) - 45);
        }
        
        // Se atingir a borda do mundo...
        if ( isAtEdge())
        {
            // ...vira 180 graus (meia-volta)
            turn(180);
        }
    }
}