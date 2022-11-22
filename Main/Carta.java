package Main;

import Main.Enums.Raridade;

public class Carta {
    private String nome;
    private Raridade raridade;

    public Carta(String nome, Raridade raridade) {
        this.nome=nome;
        this.raridade=raridade;
    }
    
    public String getNome() {
        return nome;
    }
    
    public Raridade getRaridade() {
        return raridade;
    }
}
