package befaster.solutions.CHK;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class VTest {
    private CheckoutSolution checkoutSolution;

    @Before
    public void setUp() {
        checkoutSolution = new CheckoutSolution();
    }

    @Test
    public void oneV () {
        assertThat(checkoutSolution.checkout("V"), equalTo(50));
    }

    @Test
    public void twoV() {
        assertThat(checkoutSolution.checkout("VV"), equalTo(90));
    }

    @Test
    public void threeV () {
        assertThat(checkoutSolution.checkout("VVV"), equalTo(130));
    }

    @Test
    public void sixV () {
        assertThat(checkoutSolution.checkout("VVVVVV"), equalTo(260));
    }



}

