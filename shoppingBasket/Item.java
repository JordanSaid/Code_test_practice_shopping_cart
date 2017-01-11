package shoppingBasket;
public class Item {
  private String name;
  private String description;
  private String color;
  private double price;
  private boolean hasBogof;

  public Item(String name, String description, String color, double price, boolean hasBogof){
    this.name = name;
    this.description = description;
    this.color = color;
    this.price = price;
    this.hasBogof = hasBogof;
  }

  public String getName() { return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription () { return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getColor() { return this.color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public double getPrice() { return this.price;
  }

  public void setPrice(float price) {
    this.price = price;
  }

  public boolean getHasBogof() { return this.hasBogof;
  }

  public void setHasBogof(boolean bogof) {
    this.hasBogof = bogof;
  }

}