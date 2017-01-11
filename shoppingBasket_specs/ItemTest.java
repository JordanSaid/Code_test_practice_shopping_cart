import org.junit.Test;
import org.junit.Test.*;
import static org.junit.Assert.*;
import org.junit.Before;
import shoppingBasket.*;

public class ItemTest {
  Item dogWig;
  Item wineDecanter;

  @Before
  public void before() {
    dogWig = new Item("Dog Wig", "Lion Mane for Dog", "Orange", 15.99, true);
    wineDecanter = new Item("Wine Decanter", "Sea Monster Shape", "Clear", 499.00, true);
  }

  @Test
  public void itemHasNameTest() {
    assertEquals ("Dog Wig", dogWig.getName());
  }

  @Test
  public void canChangeItemNameTest() {
    dogWig.setName("Super Cool Dog Wig");
    assertEquals ("Super Cool Dog Wig", dogWig.getName());
  }

  @Test 
  public void itemHasDescriptionTest() {
    assertEquals ("Lion Mane for Dog", dogWig.getDescription());
  }

  @Test 
  public void itemHasColorTest() {
    assertEquals ("Orange", dogWig.getColor());
  }
 
  @Test
  public void canReturnPriceTest() {
    assertEquals(15.99, dogWig.getPrice(), 0.1);
  }

  @Test
  public void canReturnPrice() {
    assertEquals(15.99, dogWig.getPrice(), 0.1);
  }
}