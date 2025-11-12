// Importa as bibliotecas do Greenfoot
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Define o ator "inimigo2", o segundo tipo de inimigo (Requisito J4.5).
 * Este inimigo tem um comportamento de patrulha, movendo-se
 * de um lado para o outro entre dois limites.
 * @author Maria Luiza Pestana e Geovana Zacaroni
 * @version 12-11-2025
 */
public class inimigo2 extends Actor
{
    // --- Variáveis de Movimento (Patrulha) ---
    private int velocidade = 1; // Velocidade e direção do movimento
    private int limiteEsquerda = 400; // Coordenada X do limite esquerdo
    private int limiteDireita = 550; // Coordenada X do limite direito
    
    // --- Variáveis de Estado ---
    private int vidas = 5; // Quantidade de vidas
    private boolean morto = false; // Flag para controlar se está morto
    
    // Construtor: executado quando o inimigo2 é criado
    public inimigo2(int largura, int altura )
    {
       // Carrega a imagem do inimigo
       GreenfootImage img = new GreenfootImage("Inimigo2.png");
       // Redimensiona a imagem
       img.scale(largura, altura); 
       setImage(img);
    }
    
    // Método 'act' (agir): executado repetidamente (a cada quadro)
    public void act()
    {
        // Se o inimigo estiver morto, remove-o e para a execução
        if (morto)
        {
            morrer(getWorld()); // Chama o método que remove
            return; // Para o 'act()'
        }
        
        // Se chegou aqui, está vivo e pode se mover
        mover();
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
    
    // Método que define o movimento de patrulha do inimigo (Requisito J4.5)
    public void mover()
    {
        // Move o ator na direção da 'velocidade'
        setLocation(getX() + velocidade, getY());
        
        // Se atingir o limite esquerdo OU o limite direito...
        if (getX() <= limiteEsquerda || getX() >= limiteDireita)
        {
            // ...inverte a velocidade (ex: 1 vira -1, -1 vira 1)
            velocidade = -velocidade;
        }
    }
    
    // (Método antigo, não mais usado pelo 'act')
    // A lógica de dano agora está em 'levarDano' e no 'Projetil'
    public boolean verificarTiro()
    {
        Actor projetil = getOneIntersectingObject(Projetil.class);
        if (projetil != null)
        {
            World mundo = getWorld();
            mundo.removeObject(projetil);
            vidas--;
            
            if ( vidas <= 0 ) 
            {
                morto = true;
                ((Fase1)getWorld()).adicionarPontos(10);
                morrer(mundo);
                return true;
            }
        }
        return false;
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
}