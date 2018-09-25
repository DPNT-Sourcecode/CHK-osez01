package befaster.solutions.CHK_R1;

import befaster.solutions.CHK.CheckoutSolution;
import befaster.solutions.SUM.SumSolution;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CHK_R1_Test {
    private CheckoutSolution checkoutSolution;

    @Before
    public void setUp() {
        checkoutSolution = new CheckoutSolution();
    }

    @Test
    public void validInput() {
        assertThat(checkoutSolution.checkout("A"), equalTo(50));

    }

    @Test
    public void emptyInput() {
        assertThat(checkoutSolution.checkout(""), equalTo(0));
    }

    @Test
    public void invalidInput() {
        assertThat(checkoutSolution.checkout("-"), equalTo(-1));
    }

    @Test
    public void validThenInvalidInput() {
        assertThat(checkoutSolution.checkout("ABCx"), equalTo(-1));
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
    public void doubleB () {
        assertThat(checkoutSolution.checkout("BB"), equalTo(45));
    }

    @Test
    public void tripleB () {
        assertThat(checkoutSolution.checkout("BBB"), equalTo(75));
    }
}
