package befaster.solutions.CHK;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class KTest {
    private CheckoutSolution checkoutSolution;

    @Before
    public void setUp() {
        checkoutSolution = new CheckoutSolution();
    }

    @Test
    public void oneK () {
        assertThat(checkoutSolution.checkout("K"), equalTo(80));
    }

    @Test
    public void twoK() {
        assertThat(checkoutSolution.checkout("KK"), equalTo(150));
    }

    @Test
    public void threeK () {
        assertThat(checkoutSolution.checkout("KKK"), equalTo(230));
    }

    @Test
    public void sixK () {
        assertThat(checkoutSolution.checkout("KKKKKK"), equalTo(450));
    }



}

