// Importa as bibliotecas do Greenfoot
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Define a classe "Plataforma".
 * Esta é uma classe "mãe" (superclass) usada para agrupar
 * todos os atores que funcionam como chão ou superfícies sólidas.
 * Outras classes (como 'chao') podem herdar dela.
 * @author Maria Luiza Pestana e Geovana Zacaroni
 * @version 12-11-2025
 */
public class Plataforma extends Actor
{
    // Método 'act' (agir): executado repetidamente (a cada quadro)
    public void act()
    {
        // Nenhuma ação é necessária por padrão.
        // Classes filhas (como uma plataforma móvel) podem
        // sobrescrever (override) este método com seu próprio comportamento.
    }
}