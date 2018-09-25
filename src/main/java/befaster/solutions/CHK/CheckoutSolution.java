package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;

public class CheckoutSolution {
    public Integer checkout(String skus) {
        int aCount = 0;
        int bCount = 0;
        int cCount = 0;
        int dCount = 0;
        // check for legal input
        // parse string
        // format "AAABB"?
        System.out.print(skus);
        for(char SKU: skus.toCharArray()) {
            if(SKU == 'A') {
               aCount++;
            }
            if(SKU == 'B') {
                bCount++;
            }
            if(SKU == 'C') {
                cCount++;
            }
            if(SKU == 'D') {
                dCount++;
            }
        }
        // count each item
        // check for offers
        // sum up
        throw new SolutionNotImplementedException();
    }
}
