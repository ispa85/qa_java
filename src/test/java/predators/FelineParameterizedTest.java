package predators;

import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineParameterizedTest {

    private final int kittensCount;

    public FelineParameterizedTest(int kittensCount) {
        this.kittensCount = kittensCount;
    }

    @Parameterized.Parameters(name = "Количество котят: {0}")
    public static Object[][] getKittensData() {
        return new Object[][]{
                {0},
                {1},
                {5}
        };
    }

    @Test
    public void getKittensWithArgReturnsPassedValue() {
        Feline feline = new Feline();
        assertEquals(kittensCount, feline.getKittens(kittensCount));
    }
}
