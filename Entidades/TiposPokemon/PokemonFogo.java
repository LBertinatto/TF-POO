package Entidades.TiposPokemon;

import Entidades.Pokemon;
import Main.Enums.Raridade;

public class PokemonFogo extends Pokemon {

    public PokemonFogo(String nome, int vida, int attackPoints, Raridade raridade) {
        super(nome, vida, attackPoints, raridade);
    }
    
    /*
     * Tabela de danos - Tipo Fogo:
     * Água: Ultra-Eficaz (2x)
     * Fogo e Planta: Fraco (0.5x)
     * Ar: Ataque Normal (1x)
     */

    @Override
    public int dano(Pokemon p){
        if(p instanceof PokemonAgua) return this.getAttackPoints() * 2;
        if (p instanceof PokemonPlanta || p instanceof PokemonFogo) return (int)(this.getAttackPoints() * 0.5);
        else return super.dano(p);
    }
}
