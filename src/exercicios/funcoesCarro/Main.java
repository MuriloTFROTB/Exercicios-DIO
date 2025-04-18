package exercicios.funcoesCarro;

public class Main {
    public static void main(String[] args) {
        var carro = new Carro("Santana", "Santana 2.0");

        carro.ligarCarro();
        carro.aumentarMarcha();
        for (int i = 0; i < 40; i++) {
            carro.acelerar();
        }
        carro.toString();
    }
}
