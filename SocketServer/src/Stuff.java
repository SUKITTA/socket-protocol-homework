public class Stuff {
    private String name;
    private int amount;

    Stuff(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return name + ":" + amount + "\n";
    }
}
