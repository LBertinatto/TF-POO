package Main;

import java.util.Scanner;

public class Jogo {
    Jogador p2;
    Jogador p1;
    Jogador vencedor;
    int turnos;
    Scanner in;

    public Jogo() {
        p2 = new Jogador("P1");
        p1  = new Jogador("P2");
        p1.setInimigo(p2);
        p2.setInimigo(p1);
        vencedor = null;
        turnos =0;
        in = new Scanner(System.in);
    }

    public void decidePrimeiroJogador() {
        int turnos = (int)Math.round(Math.random());
    }

    private boolean morto(Jogador jogador) {
        return jogador.getPokemonVivos()<=0;
    }
    public boolean checkVencedor() {
        if (morto(p1)) {
            vencedor = p2;
            return true;
        }
        if (morto(p2)) {
            vencedor = p1;
            return true;
        }
        return false;
    }

    public Jogador jogadorAtual() {
        if (turnos%2==0) return p1;
        return p2;
    }
    public void primeiroTurno(Jogador jogador) {
        System.out.println("--------Começo do Turno--------");
        System.out.println(jogador.getNome());
        System.out.println("Mão: \n" + jogador.getMao());
        for (int i=0;i<5;i++) {
            System.out.println("Escolha um pokemon para reserva");
            String escolha = in.nextLine();
            jogador.addPokeNaReserva(escolha);
            System.out.println("Deseja colocar outro? (s/n)");
            escolha = in.nextLine();
            if (escolha.equals("n")) break;
        }
        System.out.println("Escolha um pokemon principal");
        System.out.println("Reserva: \n" + jogador.getReserva());
        String escolha = in.nextLine();
        jogador.trocaPokeAtivo(escolha);
        System.out.println("Fim do turno");
        turnos++;
    }
    public void turno(Jogador jogador) {
        System.out.println("--------Começo do Turno--------");
        System.out.println(jogador.getNome());
        if (jogador.getPokemonAtivo()==null) {
            System.out.println("Escolha um novo pokemon ativo");
            System.out.println("Reserva: \n" + jogador.getReserva());
            in.nextLine();
            jogador.trocaAtivoMorto(in.nextLine());
        }
        boolean repeat = true;
        while (repeat) {
            System.out.println("Mão: \n" + jogador.getMao());
            System.out.println("Reserva: \n" + jogador.getReserva());
            System.out.println("Pokemon Ativo: \n" + jogador.pokemonAtivoString());
            System.out.println("Pilha: \n" + jogador.getPilha());
            System.out.println("Escolha uma ação: ");
            System.out.println("1 - Trocar Pokemon Ativo");
            System.out.println("2 - Colocar pokemon na reserva");
            System.out.println("3 - Trocar Pokemon da reserva");
            System.out.println("4 - Usar carta de Treinador");
            System.out.println("5 - Avançar");
            int opção = in.nextInt();
            switch (opção) {
                case 1:
                    System.out.println("Escolha o pokemon ativo");
                    jogador.trocaPokeAtivo(in.nextLine());
                    break;
                case 2:
                    System.out.println("Escolha o pokemon para reserva");
                    jogador.addPokeNaReserva(in.nextLine());
                    break;
                case 3:
                    System.out.println("Escolha o pokemon para trocar");
                    String name = in.nextLine();
                    System.out.println("Escolha o pokemon para reserva");
                    jogador.trocaPokeNaReserva(name, in.nextLine());
                    break;
                case 4:
                    System.out.println("Escolha a carta de treinador");
                    jogador.usarTreinador(in.nextLine());
                    break;
                case 5: repeat = false;
            }
        }
        System.out.println("Escolha uma ação: ");
        System.out.println("1 - Atacar inimigo");
        System.out.println("2 - Comprar uma carta");
        int opção = in.nextInt();
        if (opção==1) jogador.atacar(jogador.getInimigo());
        else jogador.comprarCarta();
        System.out.println("Fim do turno");
        turnos++;
    }

    public void jogar () {
        primeiroTurno(jogadorAtual());
        primeiroTurno(jogadorAtual());
        while(!checkVencedor()) {
            turno(jogadorAtual());
        }
        System.out.println("Vencedor: " + vencedor.getNome());
    }
}
