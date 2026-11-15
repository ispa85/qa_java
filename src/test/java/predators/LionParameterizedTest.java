package predators;

import com.example.Lion;
import com.example.Predator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParameterizedTest {

    private final String sex;
    private final boolean expectedHasMane;

    public LionParameterizedTest(String sex, boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
    }

    @Parameterized.Parameters(name = "Пол: {0} -> наличие гривы: {1}")
    public static Object[][] getSexData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Test
    public void doesHaveManeReturnsExpectedValue() throws Exception {
        Predator predatorMock = Mockito.mock(Predator.class);
        Lion lion = new Lion(sex, predatorMock);
        assertEquals(expectedHasMane, lion.doesHaveMane());
    }
}
