public class Candies extends Products {
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
        Candies candy = new Candies();
        System.out.println("Name: " + candy.getName() + ", Description: " + candy.getDescription() + ", Price: " + candy.getPrice());
    }
}
