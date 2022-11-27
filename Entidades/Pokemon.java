package Entidades;
import Main.*;
import Main.Enums.Elementos;
import Main.Enums.Raridade;

public abstract class Pokemon extends Carta{
    private double vida;
    private int attackPoints;
    private boolean isDead;
    private Raridade raridade;
    private Elementos elemento;

    public Pokemon(String nome, Raridade raridade, Elementos elemento) {
        super(nome);
        this.raridade = raridade;
        this.elemento = elemento;
        setVida();
        setAttackPoints();
    }

    public boolean isDead() {return isDead;}

    public void checkDeath() {
        if (vida<=0) {
            isDead = true;
            System.out.println("O pokemon " + " " + this.getNome() + " está morto");
        }
    }


    /**
     * Retorna o dano sofrido 
     * confome os multiplicadores de tipo
     */
    public abstract void atacar(Pokemon p);

    public void recebeAtaque(double dano) {
        vida-=dano;
        checkDeath();
    }

    public double getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }



    public int getAttackPoints() {
        return attackPoints;
    }

    public Raridade getRaridade() {
        return raridade;
    }

    public void setRaridade(Raridade raridade) {
        this.raridade = raridade;
    }

    private void setAttackPoints() {
        if (raridade==Raridade.COMUM) attackPoints = 20;
        if (raridade==Raridade.COMUM) attackPoints = 25;
        if (raridade==Raridade.COMUM) attackPoints = 30;
    }

    public Elementos getElemento() {
        return elemento;
    }

    public int getMaxVida() {
        if (raridade==Raridade.COMUM) return  100;
        if (raridade==Raridade.RARO) return  120;
        return 150;
    }
    private void setVida() {
        vida = getMaxVida();
    }
}