package Entidades.TiposPokemon;

import Entidades.Pokemon;
import Main.Enums.Raridade;

public class PokemonPlanta extends Pokemon {

    public PokemonPlanta(String nome, int vida, int attackPoints, Raridade raridade) {
        super(nome, vida, attackPoints, raridade);
    }
    
    /*
     * Tabela de danos - Tipo Planta:
     * Fogo e Ar: Ultra-Eficaz (2x)
     * Planta e Água: Fraco (0.5x)
     */

    @Override
    public int dano(Pokemon p){
        if(p instanceof PokemonFogo || p instanceof PokemonAr) return this.getAttackPoints() * 2;
        if (p instanceof PokemonPlanta || p instanceof PokemonAgua) return (int)(this.getAttackPoints() * 0.5);
        else return super.dano(p);
    }
}
