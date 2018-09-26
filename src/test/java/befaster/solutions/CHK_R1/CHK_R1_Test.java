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
    public void fifteenA () {
        assertThat(checkoutSolution.checkout("AAAAAAAAAAAAAAA"), equalTo(600));
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
        assertThat(checkoutSolution.checkout("HHHHH"), equalTo(55));
    }



}

