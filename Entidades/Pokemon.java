package Entidades;
import Main.*;
import Main.Enums.Raridade;

public class Pokemon extends Carta{
    private int vida;
    private int attackPoints;
    private boolean isDead;

    public Pokemon(String nome, int vida, int attackPoints, Raridade raridade) {
        super(nome, raridade);
        this.vida = vida;
        this.attackPoints = attackPoints;
    }

    public boolean isDead() {
        if (this.vida <= 0) {
            this.isDead = true;
        }
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    public void dead(Pokemon p) {
        if (p.isDead) {
            System.out.println("O pokemon " + this.getNome()+ " " + p.getNome() + " está morto");
        }
    }

    /**
     * Diminui a vida do pokemon atacado conforme os 
     * multiplcadores de tipo e raridade
     */
    public void ataque(Pokemon p) {
        if (this.getRaridade() == Raridade.COMUM) {
            p.setVida(p.getVida() - dano(p));
            
        } else if (this.getRaridade() == Raridade.RARO) {
            p.setVida(p.getVida() - (int)(dano(p) * 1.3));
        } else {
            p.setVida(p.getVida() - (int)(dano(p) * 1.7));
        }
    }

    /**
     * Retorna o dano sofrido 
     * confome os multiplicadores de tipo
     */
    public int dano(Pokemon p){
        return getAttackPoints();
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }

}