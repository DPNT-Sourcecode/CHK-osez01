package befaster.solutions.CHK;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class MAndNTest {
    private CheckoutSolution checkoutSolution;

    @Before
    public void setUp() {
        checkoutSolution = new CheckoutSolution();
    }


     @Test
    public void oneM () {
        assertThat(checkoutSolution.checkout("M"), equalTo(15));
    }

    @Test
    public void oneN () {
        assertThat(checkoutSolution.checkout("N"), equalTo(40));
    }



}

