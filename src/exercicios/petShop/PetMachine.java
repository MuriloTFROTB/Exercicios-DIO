public class PetMachine {
    private boolean clean;

    private int water;

    private int shanpoo;

    private Pet pet;

    public void setPet(Pet pet){
        if(!this.clean){
            System.out.println("A maquina nao esta limpa!");
            return;
        }


        if(hasPet()){
            System.out.println("Ja existe um pet na maquina!");
            return;
        }

        this.pet = pet;
    }

    public void removePet(){
        this.clean = this.pet.isClean();

        System.out.println("O pet " + pet.getName() + " foi retirado da maquina!");

        this.pet = null;
    }

    public void washMachine(){
        this.water -=10;
        this.shanpoo -=2;
        this.clean = true;
        System.out.println("A maquina foi limpa!");
    }

    public boolean hasPet(){
        return pet != null;
    }

    public void takeAShower() {
        if (this.pet == null) {
            System.out.println("Coloque o pet na maquina");
            return;
        }

    
        this.water -=10;
        this.shanpoo -=2;
        pet.setClean(true);
        System.out.println("O pet " + pet.getName() + " tomou banho!");
    }

    public void addWater() {
        if (water == 30) {
            System.out.println("A agua ja esta cheia!");
            return;
        }
        water += 2;
    }

    public void addShanpoo() {
        if (shanpoo == 30) {
            System.out.println("A shanpoo ja esta cheia!");
            return;
        }
        shanpoo += 2;
    }

    public int getShanpoo() {
        return shanpoo;
    }

    public int getWater() {
        return water;
    }
}
