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
    public void single () {
        assertThat(checkoutSolution.checkout("ABCDEFGHIJKLMNOPQRSTUVWXYZ"), equalTo(965));
    }


}

