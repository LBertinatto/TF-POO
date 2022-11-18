package Entidades.TiposPokemon;

import Entidades.Pokemon;
import Main.Enums.Raridade;

public class PokemonAgua extends Pokemon {

    public PokemonAgua(String nome, int vida, int attackPoints, Raridade raridade) {
        super(nome, vida, attackPoints, raridade);
    }
    
    /*
     * Tabela de danos - Tipo Água:
     * Planta: Ultra-Eficaz (2x)
     * Fogo e Água: Fraco (0.5x)
     * Ar: Ataque Normal (1x)
     */

    @Override
    public int dano(Pokemon p){
        if(p instanceof PokemonPlanta) return this.getAttackPoints() * 2;
        if (p instanceof PokemonFogo || p instanceof PokemonAgua) return (int)(this.getAttackPoints() * 0.5);
        else return super.dano(p);
    }
}

    
    

