package shoppingBasket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Basket {
  private ArrayList<Item> basket;
  private boolean hasDiscountCard;
  
  public Basket(boolean hasDiscount){
    this.basket = new ArrayList<Item>();
    this.hasDiscountCard = hasDiscount;
  }

  public Basket(){
    this.basket = new ArrayList<Item>();
    this.hasDiscountCard = false;
  }

  public ArrayList<Item> getBasket() {
    return this.basket;
  }

  public void setBasket() {
    this.basket = basket;
  }

  public boolean getHasDiscountCard() {
    return this.hasDiscountCard;
  }

  public void setHasDiscountCard(boolean hasCard) {
    this.hasDiscountCard = hasCard;
  }

  public void addItem(Item item) {
    basket.add(item);
  }

  public Item getItem(int index) {
    return basket.get(index);
  }

  public void removeItem(int index) {
    basket.remove(index);
  }

  public void clearBasket() {
    basket.clear();
  }

  public int itemCount() {
    return basket.size();
  }

  public double totalValue() {
    double value = 0;
    for (Item item : basket) {
      value += item.getPrice();
    }
    return value;
  }

  public ArrayList<Item> bogofItems() {
    ArrayList<Item> bogofList = new ArrayList<Item>();
    for (Item item : basket) {
      if (item.getHasBogof() == true) {
        bogofList.add(item);
      }
    }
  return bogofList;
  }

  public int numberOfBogofItems() {
    ArrayList<Item> bogof = bogofItems();
    int size = bogof.size();
    return size;
  }

  public Item minPriceInBogofList() {
    if (numberOfBogofItems() == 0) {
      return null;
    }

    ArrayList<Item> bogofList = bogofItems();
    Item minValueItem = bogofList.get(0);
    for (Item item : bogofList) {
      if (item.getPrice() < minValueItem.getPrice()) {
        minValueItem = item;
      }
    }

    bogofList.remove(minValueItem);
    return minValueItem;
  }

  public double bogofDiscount() {
    if (numberOfBogofItems() == 0) {
      return 0;
    }

    ArrayList<Item> bogofList = bogofItems();
    double bogofDiscount = 0.00;
    Item minValueItem = minPriceInBogofList();
    int counter = 0;
    int numberOfLoops = (int) bogofList.size() / 2;
    while (counter < numberOfLoops) {
        bogofDiscount += minValueItem.getPrice();
        minValueItem = minPriceInBogofList();
        counter += 1;
      }
      return bogofDiscount;
  }

  public double valueAfterTenPercent() {
    double total = totalValue();
    double bogof = bogofDiscount();
    double afterBogof = (total - bogof);
    if (afterBogof > 20) {
      afterBogof *= 0.9;
    }
    return afterBogof;
  }

  public double valueAfterDiscounts() {
    double finalValue = valueAfterTenPercent();
    if (getHasDiscountCard() == true) {
      finalValue *= 0.98;
    }
    return finalValue;
  }
}