package Main;

import Entidades.Baralho;
import Entidades.TiposPokemon.PokemonAgua;
import Entidades.TiposPokemon.PokemonFogo;
import Main.Enums.Raridade;

public class TesteAtaques {
    public static void main(String[] args) {
        PokemonAgua pedro = new PokemonAgua("Pedro", Raridade.COMUM);
        PokemonFogo joao = new PokemonFogo("João", Raridade.COMUM);

        Baralho baralho = new Baralho();
        baralho.imprimeBaralho();
        baralho.embaralharBaralho();
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/////////////");
        baralho.imprimeBaralho();
    }

}
