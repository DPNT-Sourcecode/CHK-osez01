package befaster.solutions.CHK;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class InputTest {
    private CheckoutSolution checkoutSolution;

    @Before
    public void setUp() {
        checkoutSolution = new CheckoutSolution();
    }


    @Test public void inputs() {
        assertThat(checkoutSolution.checkout("A"), equalTo(50));
    }

    @Test
    public void validInput() {
        assertThat(checkoutSolution.checkout("A"), equalTo(50));

    }

    @Test
    public void emptyInput() {
        assertThat(checkoutSolution.checkout(""), equalTo(0));
    }

    @Test
    public void invalidInput() {
        assertThat(checkoutSolution.checkout("-"), equalTo(-1));
    }

    @Test
    public void validThenInvalidInput() {
        assertThat(checkoutSolution.checkout("ABCx"), equalTo(-1));
    }

}

