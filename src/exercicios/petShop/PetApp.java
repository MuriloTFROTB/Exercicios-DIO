import java.util.Scanner;

public class PetApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PetMachine machine = new PetMachine();
        Pet pet = null;

        while (true) {
            System.out.println("\n=== MENU PET MACHINE ===");
            System.out.println("1. Adicionar pet na máquina");
            System.out.println("2. Retirar pet da máquina");
            System.out.println("3. Lavar pet");
            System.out.println("4. Lavar máquina");
            System.out.println("5. Adicionar água");
            System.out.println("6. Adicionar shampoo");
            System.out.println("7. Ver status");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // consumir a quebra de linha

            switch (opcao) {
                case 1:
                    if (machine.hasPet()) {
                        System.out.println("Já tem um pet na máquina.");
                    } else {
                        System.out.print("Nome do pet: ");
                        String nome = scanner.nextLine();
                        pet = new Pet(nome);
                        machine.setPet(pet);
                    }
                    break;

                case 2:
                    if (!machine.hasPet()) {
                        System.out.println("Não há pet na máquina.");
                    } else {
                        machine.removePet();
                    }
                    break;

                case 3:
                    machine.takeAShower();
                    break;

                case 4:
                    machine.washMachine();
                    break;

                case 5:
                    machine.addWater();
                    System.out.println("Água adicionada.");
                    break;

                case 6:
                    machine.addShanpoo();
                    System.out.println("Shampoo adicionado.");
                    break;

                case 7:
                    System.out.println("--- STATUS ---");
                    System.out.println("Água: " + machine.getWater());
                    System.out.println("Shampoo: " + machine.getShanpoo());
                    System.out.println("Pet na máquina: " + (machine.hasPet() ? "Sim (" + pet.getName() + ")" : "Não"));
                    if (pet != null) {
                        System.out.println("Pet limpo: " + (pet.isClean() ? "Sim" : "Não"));
                    }
                    break;

                case 0:
                    System.out.println("Encerrando o programa...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
