package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;
import org.apache.commons.codec.binary.StringUtils;

import java.util.Objects;

//Started CHK_R3 at 1158 min

public class CheckoutSolution {

    public Integer checkout(String skus) {
        int aCount = 0;
        int a3Deal = 0;
        int a5Deal = 0;
        int bCount = 0;
        int bDeal = 0;
        int cCount = 0;
        int dCount = 0;
        int eCount = 0;
        int fCount = 0;

        // Check for empty input
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
                    cCount++;
                    break;
                case 'D':
                    dCount++;
                    break;
                case 'E':
                    eCount++;
                    break;
                case 'F':
                    fCount++;
                    break;
                default:
                    return -1;
            }

        }
        // Total EQUALS item count PLUS MINUS deal count
        // Calculations for Total B price based on amount of E's bought
        if (eCount > 1 & bCount > 0 ) {
            if(((bCount % 2) == 0) & bDeal > 0) {
                bDeal = bDeal - (eCount/2);
                if(bDeal < 0) {bDeal = 0;}
            }
            bCount = bCount - (eCount/2);
        }
        int aTotal = (50 * aCount) - (a3Deal * 20) + (a5Deal * 200);
        int bTotal = (30 * bCount) - (bDeal * 15);
        int cTotal = (cCount * 20);
        int dTotal = (dCount * 15);
        int eTotal = (40 * eCount);
        int fTotal = (10 * ((fCount+1)/2));
        // Return all the totals added up
        return aTotal + bTotal + cTotal + dTotal + eTotal + fTotal;
    }
}
