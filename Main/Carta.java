package Main;

import Main.Enums.Raridade;

public class Carta {
    private String nome;
    private Raridade raridade;

    public Carta(String nome, Raridade raridade) {
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Raridade getRaridade() {
        return raridade;
    }

    public void setRaridade(Raridade raridade) {
        this.raridade = raridade;
    }
}
