package befaster.solutions.CHK;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class FTest {
    private CheckoutSolution checkoutSolution;

    @Before
    public void setUp() {
        checkoutSolution = new CheckoutSolution();
    }


    @Test
    public void oneF () {
        assertThat(checkoutSolution.checkout("F"), equalTo(10));
    }

    @Test
    public void twoF () {
        assertThat(checkoutSolution.checkout("FF"), equalTo(20));
    }

    @Test
    public void threeF () {
        assertThat(checkoutSolution.checkout("FFF"), equalTo(20));
    }

    @Test
    public void fourF () {
        assertThat(checkoutSolution.checkout("FFFF"), equalTo(30));
    }

    @Test
    public void fiveF () {
        assertThat(checkoutSolution.checkout("FFFFF"), equalTo(30));
    }

    @Test
    public void sixF () {
        assertThat(checkoutSolution.checkout("FFFFFF"), equalTo(40));
    }

}

