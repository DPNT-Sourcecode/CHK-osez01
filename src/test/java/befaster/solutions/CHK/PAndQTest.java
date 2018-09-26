package befaster.solutions.CHK;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class HTest {
    private CheckoutSolution checkoutSolution;

    @Before
    public void setUp() {
        checkoutSolution = new CheckoutSolution();
    }

    @Test
    public void oneH () {
        assertThat(checkoutSolution.checkout("H"), equalTo(10));
    }

    @Test
    public void five5() {
        assertThat(checkoutSolution.checkout("HHHHH"), equalTo(45));
    }

    @Test
    public void tenH () {
        assertThat(checkoutSolution.checkout("HHHHHHHHHH"), equalTo(80));
    }

    @Test
    public void sixH () {
        assertThat(checkoutSolution.checkout("HHHHHH"), equalTo(55));
    }



}

