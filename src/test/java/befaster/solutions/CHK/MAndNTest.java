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

    @Test
    public void threeN () {
        assertThat(checkoutSolution.checkout("NNN"), equalTo(120));
    }

    @Test
    public void threeNoneM () {
        assertThat(checkoutSolution.checkout("NNNM"), equalTo(120));
    }

    @Test
    public void threeNtwoM () {
        assertThat(checkoutSolution.checkout("NNNMM"), equalTo(135));
    }

    @Test
    public void sixNoneM () {
        assertThat(checkoutSolution.checkout("NNNNNN"), equalTo(240));
    }

    @Test
    public void sixNtwoM () {
        assertThat(checkoutSolution.checkout("NNNNNNMM"), equalTo(240));
    }

}

