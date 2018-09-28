package befaster.solutions.CHK;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class AlphabetTest {
    private CheckoutSolution checkoutSolution;

    @Before
    public void setUp() {
        checkoutSolution = new CheckoutSolution();
    }


    @Test
    public void noOffer () {
        assertThat(checkoutSolution.checkout("CDGIJLMOW"), equalTo(285));
    }

       @Test
    public void single () {
        assertThat(checkoutSolution.checkout("ABCDEFGHIJKLMNOPQRSTUVWXYZ"), equalTo(837));
    }

    @Test
    public void doubleT () {
        assertThat(checkoutSolution.checkout("ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZ"), equalTo(1880));
    }


}

