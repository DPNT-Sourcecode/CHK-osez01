package befaster.solutions.CHK;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class BAndETest {
    private CheckoutSolution checkoutSolution;

    @Before
    public void setUp() {
        checkoutSolution = new CheckoutSolution();
    }


     @Test
    public void oneE () {
        assertThat(checkoutSolution.checkout("E"), equalTo(40));
    }

    @Test
    public void twoE () {
        assertThat(checkoutSolution.checkout("EE"), equalTo(80));
    }

    @Test
    public void twoEoneB () {
        assertThat(checkoutSolution.checkout("EEB"), equalTo(80));
    }

    @Test
    public void twoEtwoB () {
        assertThat(checkoutSolution.checkout("EEBB"), equalTo(110));
    }

    @Test
    public void twoEthreeB () {
        assertThat(checkoutSolution.checkout("EEBBB"), equalTo(125));
    }

    @Test
    public void fourEoneB () {
        assertThat(checkoutSolution.checkout("EEEEB"), equalTo(160));
    }

    @Test
    public void fourEtwoB () {
        assertThat(checkoutSolution.checkout("EEEEBB"), equalTo(160));
    }

    @Test
    public void doubleB () {
        assertThat(checkoutSolution.checkout("BB"), equalTo(45));
    }

    @Test
    public void tripleB () {
        assertThat(checkoutSolution.checkout("BBB"), equalTo(75));
    }

}

