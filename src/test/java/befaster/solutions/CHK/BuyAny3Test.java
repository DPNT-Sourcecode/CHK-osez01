package befaster.solutions.CHK;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class BuyAny3Test {
    private CheckoutSolution checkoutSolution;

    @Before
    public void setUp() {
        checkoutSolution = new CheckoutSolution();
    }


     @Test
    public void oneS () {
        assertThat(checkoutSolution.checkout("S"), equalTo(20));
    }

    @Test
    public void STX () {
        assertThat(checkoutSolution.checkout("STX"), equalTo(45));
    }

    @Test
    public void STXY () {
        assertThat(checkoutSolution.checkout("STXY"), equalTo(62));
    }

    @Test
    public void XXYYZZ () {
        assertThat(checkoutSolution.checkout("XXYYZZ"), equalTo(90));
    }

    @Test
    public void SSS () {
        assertThat(checkoutSolution.checkout("SSS"), equalTo(45;
    }
    @Test
    public void SSSZ () {
        assertThat(checkoutSolution.checkout("SSSZ"), equalTo(65));
    }
    @Test
    public void ZZZ () {
        assertThat(checkoutSolution.checkout("ZZZ"), equalTo(45));
    }

}

