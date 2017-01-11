import org.junit.Test;
import org.junit.Test.*;
import static org.junit.Assert.*;
import org.junit.Before;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import shoppingBasket.*;

public class BasketTest {
  Basket basket;
  Basket basket1;
  Item dogWig;
  Item wineDecanter;
  Item catHat;
  Item pen;

  @Before
  public void before() {
    dogWig = new Item("Dog Wig", "Lion Mane for Dog", "Orange", 15.99, true);
    wineDecanter = new Item("Wine Decanter", "Sea Monster Shape", "Clear", 499.00, true);
    catHat = new Item ("Cat Hat", "Cool Hat for Cat", "Pink", 10.00, false);
    pen = new Item("Pen", "Biro Pen", "Black", 1, true);
    basket = new Basket(true); 
    basket1 = new Basket();
  }

  @Test
  public void basketStartsEmptyTest(){
    assertEquals(0, basket.itemCount());
  }

  @Test
  public void canAddItemTest(){
    basket.addItem(dogWig);
    assertEquals(1, basket.itemCount());
  }

  @Test
  public void canGetBasketValueTest(){
    basket.addItem(dogWig);
    basket.addItem(wineDecanter);
    assertEquals(514.99, basket.totalValue(), 0.1);
  }

  @Test
  public void canFindBogofItemsTest() {
    basket.addItem(dogWig);
    basket.addItem(wineDecanter);
    ArrayList<Item> bogofItems = basket.bogofItems();
    assertEquals(2, bogofItems.size());
  }

  @Test
  public void  canFindMinPriceInBogofListTest() {
    basket.addItem(dogWig);
    basket.addItem(wineDecanter);
    Item minValueItem = basket.minPriceInBogofList();
    assertEquals(15.99, minValueItem.getPrice(), 0.1);
  }

  @Test
  public void canFindValueOfBogofDiscount() {
    basket.addItem(dogWig);
    basket.addItem(wineDecanter);
    double discount = basket.bogofDiscount();
    assertEquals(15.99, discount, 0.1);
  }

  @Test
  public void canFindValueOfBogofDiscountWithManyItems() {
    basket.addItem(dogWig);
    basket.addItem(wineDecanter);
    basket.addItem(dogWig);
    basket.addItem(wineDecanter);
    basket.addItem(dogWig);
    basket.addItem(wineDecanter);
    double discount = basket.bogofDiscount();
    assertEquals(47.97, discount, 0.1);
  }

  @Test
  public void canFindValueOfBogofDiscountWithOddItems() {
    basket.addItem(dogWig);
    basket.addItem(wineDecanter);
    basket.addItem(dogWig);
    basket.addItem(wineDecanter);
    basket.addItem(wineDecanter);
    double discount = basket.bogofDiscount();
    assertEquals(31.98, discount, 0.1);
  }

  @Test
  public void canFindValueAfter10PercentOff() {
    basket.addItem(dogWig);
    basket.addItem(wineDecanter);
    basket.addItem(dogWig);
    basket.addItem(wineDecanter);
    basket.addItem(wineDecanter);
    double price = basket.valueAfterTenPercent();
    assertEquals(1347.3, price, 0.1);
  }

  @Test
  public void hasDiscountCardTest() {
    assertEquals(true, basket.getHasDiscountCard());
  }

  @Test
  public void canFindValueAfterAllDiscountsTest() {
    basket.addItem(dogWig);
    basket.addItem(wineDecanter);
    basket.addItem(dogWig);
    basket.addItem(wineDecanter);
    basket.addItem(wineDecanter);
    double price = basket.valueAfterDiscounts();
    assertEquals(1320.35, price, 0.1);
  }

  @Test
  public void bogofDiscountZeroTest() {
    basket1.addItem(catHat);
    basket1.addItem(catHat);
    double price = basket1.bogofDiscount();
    assertEquals(0, price, 0.1);
  }

  @Test
  public void noTenPercentDiscountTest() {
    basket1.addItem(catHat);
    double price = basket1.valueAfterTenPercent();
    assertEquals(10, price, 0.1);
  }

  @Test
  public void noDiscountTest() {
    basket1.addItem(catHat);
    double price = basket1.valueAfterDiscounts();
    assertEquals(10, price, 0.1);
  }

  @Test
  public void onlyBogofTest() {
    basket1.addItem(pen);
    basket1.addItem(pen);
    double price = basket1.valueAfterDiscounts();
    assertEquals(1, price, 0.1);
  }

  @Test
  public void onlyLoyaltyTest() {
    basket.addItem(catHat);
    double price = basket.valueAfterDiscounts();
    assertEquals(9.8, price, 0.1);
  }

  @Test
  public void only10PercentTest() {
    basket1.addItem(catHat);
    basket1.addItem(catHat);
    basket1.addItem(catHat);
    double price = basket1.valueAfterDiscounts();
    assertEquals(27, price, 0.1);
  }

}