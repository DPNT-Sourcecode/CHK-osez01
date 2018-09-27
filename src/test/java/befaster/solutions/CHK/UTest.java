package befaster.solutions.CHK;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class UTest {
    private CheckoutSolution checkoutSolution;

    @Before
    public void setUp() {
        checkoutSolution = new CheckoutSolution();
    }


    @Test
    public void oneU () {
        assertThat(checkoutSolution.checkout("U"), equalTo(40));
    }

    @Test
    public void twoU () {
        assertThat(checkoutSolution.checkout("UU"), equalTo(80));
    }

    @Test
    public void threeU () {
        assertThat(checkoutSolution.checkout("UUU"), equalTo(120));
    }

    @Test
    public void fourU () {
        assertThat(checkoutSolution.checkout("UUUU"), equalTo(120));
    }

    @Test
    public void fiveU () {
        assertThat(checkoutSolution.checkout("UUUUU"), equalTo(160));
    }

    @Test
    public void sixU () {
        assertThat(checkoutSolution.checkout("UUUUUU"), equalTo(200));
    }

    @Test
    public void sevenU () {
        assertThat(checkoutSolution.checkout("UUUUUUU"), equalTo(200));
    }

}

