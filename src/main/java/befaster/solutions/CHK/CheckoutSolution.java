package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;

import java.util.Objects;

public class CheckoutSolution {

    public Integer checkout(String skus) {
        int aCount = 0;
        int aDeal = 0;
        int aTotal = 0;
        int bCount = 0;
        int bDeal = 0;
        int bTotal = 0;
        int cTotal = 0;
        int dTotal = 0;

        // check for legal input
        if (skus.equals("")) {
            return 0;
        }
        // parse string and count each SKU
        // format "AAABB"?
        System.out.print(skus);
        for (char SKU : skus.toCharArray()) {
            switch (SKU) {
                case 'A':
                    // Either there is a deal and restart counting
                    if (aCount == 2) {
                        aCount = 0;
                        aDeal++;
                        System.out.print(aCount);
                        System.out.print(aDeal);
                    } else {
                        // Or count Item
                        aCount++;
                    }
                    break;
                case 'B':
                    if (bCount == 1) {
                        bCount = 0;
                        bDeal++;
                    } else {
                        // Or count Item
                        bCount++;
                    }
                    break;
                case 'C':
                    cTotal++;
                    break;
                case 'D':
                    dTotal++;
                    break;
                default:
                    return -1;
            }

        }
        // check for offers
        // Total = item count + deal count
        aTotal = (50 * aCount) + (aDeal * 130);
        bTotal = (30 * bCount) + (bDeal * 45);
        cTotal = (cTotal * 20);
        dTotal = (dTotal * 15);
        // sum up
        return aTotal + bTotal + cTotal + dTotal;
    }
}
