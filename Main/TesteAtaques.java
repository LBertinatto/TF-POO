package Main;

import Entidades.TiposPokemon.PokemonAgua;
import Entidades.TiposPokemon.PokemonFogo;
import Main.Enums.Raridade;

public class TesteAtaques {
    public static void main(String[] args) {
        PokemonAgua pedro = new PokemonAgua("Pedro", Raridade.COMUM);
        PokemonFogo joao = new PokemonFogo("João", Raridade.COMUM);

        System.out.println(joao.getVida());
        pedro.atacar(joao);
        System.out.println(joao.getVida());pedro.atacar(joao);
        System.out.println(joao.getVida());pedro.atacar(joao);
        System.out.println(joao.getVida());pedro.atacar(joao);
        System.out.println(joao.getVida());pedro.atacar(joao);
        System.out.println(joao.getVida());
    }

}
