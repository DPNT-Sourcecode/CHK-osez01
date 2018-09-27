package befaster.solutions.CHK;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ATest {
    private CheckoutSolution checkoutSolution;

    @Before
    public void setUp() {
        checkoutSolution = new CheckoutSolution();
    }

       @Test
    public void tripleA () {
        assertThat(checkoutSolution.checkout("AAA"), equalTo(130));
    }

    @Test
    public void quadA () {
        assertThat(checkoutSolution.checkout("AAAA"), equalTo(180));
    }

    @Test
    public void quintpleA () {
        assertThat(checkoutSolution.checkout("AAAAA"), equalTo(200));
    }

    @Test
    public void sextupleA () {
        assertThat(checkoutSolution.checkout("AAAAAA"), equalTo(250));
    }

    @Test
    public void fifteenA () {
        assertThat(checkoutSolution.checkout("AAAAAAAAAAAAAAA"), equalTo(600));
    }


}

