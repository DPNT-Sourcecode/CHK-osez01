package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;

import java.util.Objects;

public class CheckoutSolution {

    public Integer checkout(String skus) {
        int aCount = 0;
        int a3Deal = 0;
        int a5Deal = 0;
        int aTotal;
        int bCount = 0;
        int bDeal = 0;
        int bTotal;
        int cTotal = 0;
        int dTotal = 0;

        // check for legal input
        if (skus.equals("")) {
            return 0;
        }
        // parse string and count each SKU
        for (char SKU : skus.toCharArray()) {
            switch (SKU) {
                case 'A':
                    // Either there is a deal and restart counting
                    if (((aCount+1) % 5) == 0) {
                        aCount = 0;
                        a5Deal++;
                    } else if (((aCount+1) % 3) == 0) {
                        aCount = 0;
                        a3Deal++;
                    } else {
                        // Or count Item
                        aCount++;
                    }
                    break;
                case 'B':
//                    if (bCount == 1) {
//                        bCount = 0;
//                        bDeal++;
//                    } else {
//                        // Or count Item
                        bCount++;
//                    }
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
        aTotal = (50 * aCount) + (a3Deal * 130) + (a5Deal * 200);
        bTotal = (30 * bCount) + (bDeal * 45);
        cTotal = (cTotal * 20);
        dTotal = (dTotal * 15);
        // sum up
        return aTotal + bTotal + cTotal + dTotal;
    }
}
