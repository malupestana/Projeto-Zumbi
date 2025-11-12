// Importa as bibliotecas do Greenfoot
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Define o ator "Zumbi", o jogador principal (Requisito J4.4).
 * Controla o movimento, física (pulo/gravidade), combate (vidas/atirar)
 * e a interação com itens (chave) e a saída da fase.
 * @author Maria Luiza Pestana e Geovana Zacaroni
 * @version 12-11-2025
 */
public class Zumbi extends Actor
{
    // --- Variáveis de Física e Movimento ---
    private int vVelocidade = 0; // Velocidade vertical (para pulo e gravidade)
    private int gravidade = 1;     // Força da gravidade
    private int puloAltura = -4;   // Força inicial do pulo (negativa = para cima)
    
    // --- Variáveis de Estado do Jogador ---
    private int vidas = 10;           // Vidas do jogador
    private int tempoInvulneravel = 0; // Timer para invencibilidade após dano
    private boolean temChave = false; // Flag se o jogador já pegou a chave
    
    // --- Variáveis não utilizadas ---
    private int velocidade; // (Não usada, o movimento usa valores fixos)
    private int direcao;    // (Não usada)

    // Construtor: executado quando o Zumbi é criado
    public Zumbi( int Altura, int Largura )
    {
        // Carrega a imagem do Zumbi
        GreenfootImage img = new GreenfootImage("zumbi.png");
        // Redimensiona a imagem
        img.scale(Largura, Altura); 
        setImage(img);
    }
    
    // Método 'act' (agir): executado repetidamente (a cada quadro)
    // Gerencia a ordem de todas as ações do Zumbi
    public void act()
    {
        // NOTA: A ordem aqui é importante.
        mover();           // 1. Lê os comandos de movimento e pulo (BUG: pulo aqui)
        aplicarFisica();   // 2. Aplica gravidade e colisão com o chão
        Atirar();          // 3. Verifica se o jogador atirou
        verificarColisoes(); // 4. Verifica se tocou em inimigos/obstáculos
        verificarMorte();    // 5. (Redundante) Verifica se as vidas acabaram
        verificarChave();    // 6. Verifica se tocou na chave
        verificarPlaca();    // 7. Verifica se tocou na saída
    }
    
    // Verifica se o Zumbi tocou em algum perigo
    // NOTA: Esta lógica está com bugs, o 'tempoInvulneravel' não funciona bem
    public void verificarColisoes()
    {
        // O jogador perde vida imediatamente ao tocar,
        // ignorando a invulnerabilidade
        if (isTouching(Inimigo1.class))
        {
            perderVida();
        }
        if (isTouching(inimigo2.class))
        {
            perderVida();
        }
        if (isTouching(galho.class))
        {
            perderVida();
        }
        
        // A invulnerabilidade só é checada *depois* e apenas para Inimigo1
        if (tempoInvulneravel == 0 && isTouching(Inimigo1.class))
        {
            perderVida();
            tempoInvulneravel = 30; // 30 quadros de invulnerabilidade
        }
    }
    
    // Diminui uma vida e chama 'morrer' se a vida acabar
    public void perderVida()
    {
        vidas--; // Decrementa a vida
        if (vidas <= 0)
        {
            morrer(); // Chama o método de morte
        }
    }
    
    // (Redundante) Verifica *de novo* se o jogador morreu
    public void verificarMorte()
    {
        if (vidas <= 0 )
        {
            morrer();
        }
    }
    
    // Carrega a tela de derrota ("voceMorreu")
    public void morrer()
    {
        // NOTA: Falta parar a música da Fase1 aqui.
        Greenfoot.setWorld(new voceMorreu());
    }
    
    // (Física Antiga) Move o jogador para baixo
    // Usado pelo método 'mover' antigo
    public void cair()
    {
        setLocation(getX(), getY() + vVelocidade);
        vVelocidade = vVelocidade + gravidade;
    }
    
    // Verifica o input do jogador para movimento horizontal e pulo
    public void mover()
    {
        // Movimento para a direita
        if(Greenfoot.isKeyDown("right"))
        {
            move(4);
        }
        // Movimento para a esquerda
        if(Greenfoot.isKeyDown("left"))
        {
            move(-4);
        }
        
        // BUG: Lógica de pulo antiga que causa pulos infinitos
        // (Não checa se o jogador está no chão)
        if (Greenfoot.isKeyDown("up"))
        {
            vVelocidade = puloAltura; // Define a velocidade do pulo
            cair(); // Aplica o movimento do pulo/queda
        }
    }
    
    // Verifica se o Zumbi está tocando o chão
    // Retorna 'true' se estiver no chão, 'false' se não
    public boolean noChao ()
    {
        // Verifica 1 pixel abaixo dos pés do Zumbi se há um 'chao'
        Actor nochao = getOneObjectAtOffset(0, getImage().getHeight()/2 + 1, chao.class);
        // Retorna 'true' se tocou em algo, 'false' se 'nochao' for nulo
        return nochao != null;
    }

    // Aplica a gravidade e a colisão com o chão
    private void aplicarFisica()
    {
        // 1. Aumenta a velocidade de queda com a gravidade
        vVelocidade = vVelocidade + gravidade;
        
        // 2. Move o Zumbi na vertical
        setLocation(getX(), getY() + vVelocidade);
        
        // 3. Loop de correção: Se o Zumbi afundou no chão...
        while (noChao() == true)
        {
            // ...move ele 1 pixel para CIMA...
            setLocation(getX(), getY() - 1);
            // ...e para a velocidade de queda (para ele não deslizar).
            vVelocidade = 0;
        }
    }
    
    // (Redundante) Move o jogador horizontalmente
    // BUG: Este método está no código mas não é chamado no 'act'
    private void moverTiro()
    {
        if(Greenfoot.isKeyDown("right"))
        {
            setLocation (getX() + 5, getY());
        }
        if(Greenfoot.isKeyDown("left"))
        {
            setLocation (getX() -5, getY());
        }
    }
    
    // Verifica se o jogador atirou (tecla "espaço")
    private void Atirar()
    {
        // Se "espaço" estiver pressionado...
        if ( Greenfoot.isKeyDown("space"))
        {
            // ...cria um novo Projeil na frente do Zumbi.
            // NOTA: 'isKeyDown' atira muito rápido (rajada)
            getWorld().addObject(new Projetil(60,60,-1),getX()-30 ,getY());
        }
    }
    
    // Verifica se o Zumbi tocou na chave
    // Esta é a versão CORRIGIDA que evita o crash no terminal
    public void verificarChave()
    {
        // Pega o objeto 'chave' específico que está tocando
        chave chaveTocada = (chave) getOneIntersectingObject(chave.class);
        
        // Se tocou...
        if (chaveTocada != null)
        {
            // 1. Atualiza a flag que tem a chave
            temChave = true;
            
            // 2. Avisa o Mundo (Fase1) para atualizar o placar
            ((Fase1)getWorld()).adicionarChave(); 
            
            // 3. Manda a CHAVE se remover (para evitar o crash)
            chaveTocada.serColetada();
        }
    }
    
    // Verifica se o Zumbi tocou na placa de saída
    public void verificarPlaca()
    {
        // Se tocou na 'seta'...
        if (isTouching(seta.class))
        {
            // ...e se o jogador 'temChave'
            if (temChave)
            {
                // ...vence o jogo.
                vencerJogo();
            }
        }
    }
    
    // Carrega a tela de vitória
    public void vencerJogo()
    {
        // NOTA: Falta parar a música da Fase1 aqui.
        Greenfoot.setWorld( new voceVenceu());
    }
}