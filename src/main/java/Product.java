public class Product {
    String name;
    double cost;

    public Product(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return String.format("Name " + name + ", cost " + Formatter.getFormattedRubles(cost));
    }

}
