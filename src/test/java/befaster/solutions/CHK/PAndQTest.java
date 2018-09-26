package befaster.solutions.CHK;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class PAndQTest {
    private CheckoutSolution checkoutSolution;

    @Before
    public void setUp() {
        checkoutSolution = new CheckoutSolution();
    }

    @Test
    public void oneP () {
        assertThat(checkoutSolution.checkout("P"), equalTo(50));
    }

    @Test
    public void oneQ () {
        assertThat(checkoutSolution.checkout("Q"), equalTo(30));
    }

    @Test
    public void fiveP() {
        assertThat(checkoutSolution.checkout("PPPPP"), equalTo(200));
    }

    @Test
    public void threeQ() {
        assertThat(checkoutSolution.checkout("QQQ"), equalTo(80));
    }


    @Test
    public void sixP () {
        assertThat(checkoutSolution.checkout("PPPPPP"), equalTo(250));
    }

    @Test
    public void four () {
        assertThat(checkoutSolution.checkout("QQQQ"), equalTo(110));
    }



}

