// Importa as bibliotecas do Greenfoot
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Define o ator "Projetil" (o osso que o Zumbi atira).
 * Este ator se move para frente, avisa os inimigos quando os acerta
 * e se remove do mundo (para evitar crashes).
 * @author Maria Luiza Pestana e Geovana Zacaroni
 * @version 12-11-2025
 */
public class Projetil extends Actor
{
    // Variáveis para controlar o movimento
    private int velocidade;
    private int direcao;
    
    // Construtor: executado quando o Projetil é criado
    public Projetil(int largura, int altura, int direcao )
    {
       // Carrega a imagem do projétil
       GreenfootImage img = new GreenfootImage("Bone (4).png");
       // Redimensiona a imagem
       img.scale(largura, altura); 
       setImage(img);
       
       // Armazena a direção e velocidade (embora não usadas em 'moverProjetil')
       this.direcao = direcao;
       this.velocidade = 6;
    }
    
    // Método 'act' (agir): executado repetidamente (a cada quadro)
    public void act()
    {
        // Verificação de segurança: se o projétil já foi removido, para tudo.
        // Isso evita o crash no terminal.
        if (getWorld() == null) {
            return;
        }

        // 1. Verifica se acertou um inimigo
        if (verificarAcerto()) {
            return; // Se acertou, para o 'act()' aqui.
        }
        
        // 2. Se não acertou, se move
        // (Verificação de segurança extra)
        if (getWorld() != null) {
            moverProjetil();
        } else {
            return;
        }

        // 3. Verifica se saiu da borda
        if (verificarBorda()) {
            return; // Se saiu da borda, para o 'act()' aqui.
        }
    }

    // Método privado que verifica se o projétil acertou um inimigo
    // Retorna 'true' se acertou (e foi removido)
    private boolean verificarAcerto()
    {
        // Tenta acertar o Inimigo1
        // 'getOneIntersectingObject' verifica se está tocando em Inimigo1
        Inimigo1 inimigo1 = (Inimigo1) getOneIntersectingObject(Inimigo1.class);
        // Se tocou em um Inimigo1 E ele está vivo...
        if (inimigo1 != null && inimigo1.estaMorto() == false) 
        {
            inimigo1.levarDano(); // Chama o método 'levarDano' do inimigo
            getWorld().removeObject(this); // Remove a si mesmo (o projétil)
            return true; // Avisa que acertou
        }
        
        // Tenta acertar o inimigo2
        inimigo2 inimigo2 = (inimigo2) getOneIntersectingObject(inimigo2.class);
        // Se tocou em um inimigo2 E ele está vivo...
        if (inimigo2 != null && inimigo2.estaMorto() == false) 
        {
            inimigo2.levarDano(); // Chama o método 'levarDano' do inimigo
            getWorld().removeObject(this); // Remove a si mesmo (o projétil)
            return true; // Avisa que acertou
        }
        
        return false; // Não acertou nada
    }

    // Método privado que verifica se o projétil atingiu a borda do mundo
    // Retorna 'true' se foi removido
    private boolean verificarBorda()
    {
        // 'isAtEdge' verifica se o ator está na borda do mundo
        if (isAtEdge())
        {
            getWorld().removeObject(this); // Remove a si mesmo
            return true;
        }
        return false;
    }
    
    // Método que move o projétil
    public void moverProjetil()
    {
        // Move 5 pixels para a direita (getX()+5)
        // NOTA: Este código não usa as variáveis 'velocidade' ou 'direcao'
        setLocation(getX()+5, getY());
    }
}