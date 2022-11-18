package Entidades.TiposPokemon;

import Entidades.Pokemon;
import Main.Enums.Raridade;

public class PokemonAr extends Pokemon {

    public PokemonAr(String nome, int vida, int attackPoints, Raridade raridade) {
        super(nome, vida, attackPoints, raridade);
    }
    
    /*
     * Tabela de danos - Tipo Ar:
     * Água: Ultra-Eficaz (2x)
     * Planta: Fraco (0.5x)
     * Fogo e Ar: Ataque Normal (1x)
     */
    
    @Override
    public int dano(Pokemon p){
        if(p instanceof PokemonAgua) return this.getAttackPoints() * 2;
        if (p instanceof PokemonPlanta) return (int)(this.getAttackPoints() * 0.5);
        else return super.dano(p);
    }
}

