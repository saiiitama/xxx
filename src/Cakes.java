public class Cakes extends Products{
    private String name;
    private double price;
    private String description;
    
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
    @Override
    public void getInfo() {
        Cakes cake = new Cakes();
        System.out.println("Name: " + cake.getName() + ", Description: " + cake.getDescription() + ", Price: " + cake.getPrice());
    }
}
