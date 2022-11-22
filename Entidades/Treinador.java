package Entidades;
import Main.*;
import Main.Enums.Raridade;

public class Treinador extends Carta {
    
    private String descricao;
    private String tipo;

    public Treinador(String nome, Raridade raridade, String descricao, String tipo) {
        super(nome, raridade);
        this.descricao=descricao;
        this.tipo=tipo;
    }
    
    public String getDescricao()    {
        return descricao;
    }
    
    public String getTipo()    {
        return tipo;
    }
    
}
