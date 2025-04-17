package exercicios.funcoesCarro;

public class Carro {
    String nome;
    String modelo;
    int marcha_maxima = 6;
    int marcha_minima = 0;
    int marchaAtual = 0;
    double velocidade = 0.0;
    boolean ligado = false;

    public Carro(String nome, String modelo) {
        this.nome = nome;
        this.modelo = modelo;
        this.marchaAtual = 0;
        this.velocidade = 0.0;
        this.ligado = false;
    }

    boolean isligado() {
        return ligado;
    }

    void ligarCarro() {
        if (!ligado) {
            ligado = true;
            System.out.println("Carro ligado!");
        } else {
            System.out.println("Carro já está ligado!");
        }
    }

    void desligarCarro() {
        if (ligado) {
            if (velocidade > 0) {
                System.out.println("Carro em movimento! Reduzindo a velocidade para 0 km/h antes de desligar.");
            } else {
                ligado = false;
                System.out.println("Carro desligado!");
            }

        } else {
            System.out.println("Carro já está desligado!");
        }
    }

    void alterarVelocidade(double valor) {
        if (!isligado()) {
            System.out.println("Carro desligado! Não é possível alterar a velocidade.");
            return;
        }

        double novaVelocidade = velocidade + valor;

        if (marchaAtual == 0) {
            System.out.println("Carro em ponto morto! Não é possível acelerar.");
            return;
        }

        if (novaVelocidade < 0) {
            velocidade = 0;
        }

        if (velocidadeMarcha(novaVelocidade, marchaAtual)) {
            velocidade = novaVelocidade;
            System.out.println("Velocidade atual: " + velocidade + " km/h, marcha: " + marchaAtual);
        } else {
            System.out.println("A velocidade não é compatível com a marcha atual!");
            if (velocidade > 0) {
                velocidade = 0;
                System.out.println("Reduzindo a velocidade para 0 km/h.");
            }
        }
    }

    boolean velocidadeMarcha(double velocidade, int marcha) {
        switch (marcha) {
            case 0:
                return velocidade == 0;
            case 1:
                return velocidade >= 0 && velocidade <= 20;
            case 2:
                return velocidade > 20 && velocidade <= 40;
            case 3:
                return velocidade > 40 && velocidade <= 60;
            case 4:
                return velocidade > 60 && velocidade <= 80;
            case 5:
                return velocidade > 80 && velocidade <= 100;
            case 6:
                return velocidade > 100 && velocidade <= 120;

            default:
                System.out.println("Marcha inválida!");
                return false;
        }
    }

    void acelerar() {
        alterarVelocidade(1.0);

    }

    void desacelerar() {
        alterarVelocidade(-1.0);
    }

    void aumentarMarcha() {
        if (!isligado()) {
            System.out.println("Carro desligado! Não é possível mudar a marcha.");
            return;
        }
        if (marchaAtual < marcha_maxima) {
            marchaAtual++;
            System.out.println("Marcha aumentada para: " + marchaAtual);
        }

    }

    void diminuirMarcha() {
        if (!isligado()) {
            System.out.println("Carro desligado! Não é possível mudar a marcha.");
            return;
        }
        if (marchaAtual > marcha_minima) {
            marchaAtual--;
            System.out.println("Marcha dimuindo para: " + marchaAtual);
        }
    }

    void virarCarro() {
        if (!isligado()) {
            System.out.println("Carro desligado! Não é possível virar.");
            return;
        }
        if (velocidade <= 40) {
            System.out.println("Virando o carro!");
        } else {
            System.out.println("Carro em alta velocidade! Não é possível virar.");
        }
    }

    void virarEsquerda() {
        virarCarro();
        System.out.println("Virando para a esquerda!");
    }

    void virarDireita() {
        virarCarro();
        System.out.println("Virando para a direita!");
    }

    @Override
    public String toString() {
        return "Carro{" +
                "nome='" + nome + '\'' +
                ", modelo='" + modelo + '\'' +
                ", marcha_maxima=" + marcha_maxima +
                ", marcha_minima=" + marcha_minima +
                ", marchaAtual=" + marchaAtual +
                ", velocidade=" + velocidade +
                ", ligado=" + ligado +
                '}';
    }
}