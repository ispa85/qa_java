package predators;

import com.example.Lion;
import com.example.Predator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    private Predator predatorMock;

    @Test
    public void singleArgConstructorCreatesMaleLionWithMane() throws Exception {
        Lion lion = new Lion("Самец");
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void constructorWithInvalidSexThrowsException() {
        Exception exception = assertThrows(
                Exception.class,
                () -> new Lion("Неизвестный пол", predatorMock)
        );
        assertEquals(
                "Используйте допустимые значения пола животного - самец или самка",
                exception.getMessage()
        );
    }

    @Test
    public void getKittensReturnsValueFromPredator() throws Exception {
        when(predatorMock.getKittens()).thenReturn(5);
        Lion lion = new Lion("Самка", predatorMock);
        assertEquals(5, lion.getKittens());

    }

    @Test
    public void getKittensCalledOnce() throws Exception {

        Lion lion = new Lion("Самец",predatorMock);
        lion.getKittens();
        Mockito.verify(predatorMock, Mockito.times(1)).getKittens();

    }



    @Test
    public void getFoodReturnsFoodListFromPredator() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(predatorMock.eatMeat()).thenReturn(expectedFood);
        Lion lion = new Lion("Самец", predatorMock);
        List<String> actualFood = lion.getFood();
        assertEquals(expectedFood, actualFood);

    }

    @Test
    public void getFoodCallsEatMeatOnce () throws Exception {
        Lion lion = new Lion("Самец",predatorMock);
        lion.getFood();
        Mockito.verify(predatorMock, Mockito.times(1)).eatMeat();

    }
}
