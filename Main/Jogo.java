package Main;

import java.util.Scanner;

public class Jogo {
    Jogador p2;
    Jogador p1;
    Jogador vencedor;
    int turnos;
    Scanner in;

    public Jogo() {
        p2 = new Jogador();
        p1  = new Jogador();
        p1.setInimigo(p2);
        p2.setInimigo(p1);
        vencedor = null;
        turnos = decidePrimeiroJogador();
        in = new Scanner(System.in);
        decidePrimeiroJogador();
    }

    private int decidePrimeiroJogador() {
        return (int)Math.round(Math.random());
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
        while (jogador.getReserva().getReserva().size()<5) {
            System.out.println("Escolha um pokemon para reserva");
            try {
                String escolha = in.nextLine();
                jogador.addPokeNaReserva(escolha);
                if (jogador.getReserva().getReserva().size()<5) {
                    System.out.println("Deseja colocar outro? (s/n)");
                    escolha = in.nextLine();
                    if (escolha.equals("n")) break;
                    else if (!escolha.equals("s")) {
                        System.out.println("Escolha inválida");
                    }
                }
            }
            catch (Exception e) {
                System.out.println("Opção Inválida");
            }
        }
        System.out.println("Escolha um pokemon principal");
        System.out.println("Reserva: \n" + jogador.getReserva());
        String escolha = in.nextLine();
        try {
            jogador.trocaPokeAtivo(escolha);
        }
        catch (Exception e) {
            System.out.println("Opção Inválida");
        }
        System.out.println("Fim do turno");
        turnos++;
    }
    public void turno(Jogador jogador) {
        System.out.println("--------Começo do Turno--------");
        System.out.println(jogador.getNome());
        if (jogador.getPokemonAtivo()==null) {
            System.out.println("Escolha um novo pokemon ativo");
            System.out.println("Reserva: \n" + jogador.getReserva());
            try {
                in.nextLine();
                jogador.trocaAtivoMorto(in.nextLine());
            }
            catch (Exception e) {
                System.out.println("Opção Inválida");
            }

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
            try {
                int opção = in.nextInt();
                in.nextLine();
                switch (opção) {
                    case 1 -> {
                        if (jogador.getPokemonVivos() <= 1) {
                            System.out.println("Sem pokemons na reserva");
                            break;
                        }
                        System.out.println("Escolha o pokemon ativo");
                        jogador.trocaPokeAtivo(in.nextLine());
                    }
                    case 2 -> {
                        if (jogador.getMao().getMao().size() <= 0) {
                            System.out.println("Sem pokemons na mão");
                            break;
                        }
                        System.out.println("Escolha o pokemon para reserva");
                        System.out.println(jogador.getMao());
                        jogador.addPokeNaReserva(in.nextLine());
                    }
                    case 3 -> {
                        if (jogador.getPokemonVivos() <= 1) {
                            System.out.println("Sem pokemons na reserva");
                            break;
                        }
                        if (jogador.getMao().getMao().size() <= 0) {
                            System.out.println("Sem pokemons na mão");
                            break;
                        }
                        System.out.println("Escolha o pokemon para trocar");
                        System.out.println(jogador.getReserva());
                        String name = in.nextLine();
                        System.out.println("Escolha o pokemon para reserva");
                        System.out.println(jogador.getMao());
                        jogador.trocaPokeNaReserva(name, in.nextLine());
                    }
                    case 4 -> {
                        if (jogador.getMao().getTreinadores().size() <= 0) {
                            System.out.println("Sem treinadores na mão");
                            break;
                        }
                        System.out.println("Escolha a carta de treinador");
                        System.out.println(jogador.getMao().getTreinadores());
                        jogador.usarTreinador(in.nextLine());
                    }
                    default -> repeat = false;
                }
            }
            catch (Exception e) {
                System.out.println("Opção Inválida");
            }
        }

        System.out.println("Escolha uma ação: ");
        System.out.println("1 - Atacar inimigo");
        System.out.println("2 - Comprar uma carta");
        try {
            int opção = in.nextInt();
            if (opção == 1) jogador.atacar(jogador.getInimigo());
            else jogador.comprarCarta();
        }
        catch (Exception e) {
            System.out.println("Opção Inválida");
        }
        System.out.println("Fim do turno");
        turnos++;
    }

    private void escolherNomesDosJogadores() {
        System.out.println("Escolha o nome do player 1");
        p1.setNome(in.nextLine());
        System.out.println("Escolha o nome do player 2");
        p2.setNome(in.nextLine());
    }
    public void jogar () {
        escolherNomesDosJogadores();
        primeiroTurno(jogadorAtual());
        primeiroTurno(jogadorAtual());
        while(!checkVencedor()) {
            turno(jogadorAtual());
        }
        System.out.println("Vencedor: " + vencedor.getNome());
    }
}
