package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;
import org.apache.commons.codec.binary.StringUtils;

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
        int eCount = 0;
        int eTotal;

        // check for legal input
        if (skus.equals("")) {
            return 0;
        }
        // parse string and count each SKU
        for (char SKU : skus.toCharArray()) {
            switch (SKU) {
                case 'A':
                    aCount++;
                    boolean mod3 = ((aCount) % 3) == 0;
                    boolean mod5 = ((aCount) % 5) == 0;
                    // Either there is a deal and restart counting
                    if (mod5) {
                        a3Deal = 0;
                        aCount = 0;
                        a5Deal++;
                    } else if (mod3) {
                        a3Deal++;
                    }
                    break;
                case 'B':
                    bCount++;
                    if ((bCount % 2) == 0) {
                        bDeal++;
                    }
                    break;
                case 'C':
                    cTotal++;
                    break;
                case 'D':
                    dTotal++;
                    break;
                case 'E':
                    eCount++;
                    break;
                default:
                    return -1;
            }

        }
        // check for offers
        // Total = item count + deal count
        aTotal = (50 * aCount) - (a3Deal * 20) + (a5Deal * 200);
        eTotal = (40 * eCount);

        if (eCount > 1 & bCount > 0 ) {
            bCount = bCount - (eCount/2);
            if(((bCount % 2) == 0) & bDeal > 0) {
                bDeal--;
            }
        }

        bTotal = (30 * bCount) - (bDeal * 15);
        cTotal = (cTotal * 20);
        dTotal = (dTotal * 15);
        // sum up
        return aTotal + bTotal + cTotal + dTotal + eTotal;
    }
}
