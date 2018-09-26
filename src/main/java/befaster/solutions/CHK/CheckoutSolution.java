package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;
import org.apache.commons.codec.binary.StringUtils;

import java.nio.charset.CharacterCodingException;
import java.util.HashMap;
import java.util.Objects;

//Started CHK_R3 at 1158 min

public class CheckoutSolution {

     static int aCount = 0;
     static int a3Deal = 0;
     static int a5Deal = 0;

    private void multipleForDeal(int baseCount, int X, int Y , int dealXCount, int dealYCount) {
        baseCount++;
        boolean modX = (baseCount % X) == 0;
        boolean modY = (baseCount % Y) == 0;
        if (modX) {
            dealYCount = 0;
            baseCount = 0;
            dealXCount++;
        } else if (modY) {
            dealYCount++;
        }
    }

    public Integer checkout(String skus) {
        HashMap<Character, Integer> noOfferSkus = new HashMap<>();
        noOfferSkus.put('C', 20);
        noOfferSkus.put('D', 15);
        noOfferSkus.put('G', 20);
        noOfferSkus.put('I', 35);
        noOfferSkus.put('J', 60);
        noOfferSkus.put('L', 90);
        noOfferSkus.put('M', 15);
        noOfferSkus.put('O', 10);
        noOfferSkus.put('S', 30);
        noOfferSkus.put('T', 20);
        noOfferSkus.put('W', 20);
        noOfferSkus.put('X', 90);
        noOfferSkus.put('Y', 10);
        noOfferSkus.put('Z', 50);


        int bCount = 0;
        int bDeal = 0;
        int eCount = 0;
        int fCount = 0;
        int hCount = 0;
        int h5Deal = 0;
        int h10Deal = 0;

        int noOfferTotal = 0;

        // Check for empty input
        if (skus.equals("")) {
            return 0;
        }
        // parse string and count each SKU
        for (char SKU : skus.toCharArray()) {
            switch (SKU) {
                case 'A':
//                    aCount++;
//                    boolean mod3 = (aCount % 3) == 0;
//                    boolean mod5 = (aCount % 5) == 0;
//                    // Either there is a deal and restart counting
//                    if (mod5) {
//                        a3Deal = 0;
//                        aCount = 0;
//                        a5Deal++;
//                    } else if (mod3) {
//                        a3Deal++;
//                    }
                    multipleForDeal(aCount, 5 ,3, a5Deal, a3Deal);
                    break;
                case 'B':
                    bCount++;
                    if ((bCount % 2) == 0) {
                        bDeal++;
                    }
                    break;
                case 'E':
                    eCount++;
                    break;
                case 'F':
                    fCount++;
                    break;
                case 'H':
                    multipleForDeal(hCount, 10, 5, h10Deal, h5Deal);
                    break;
                default:
                    if(noOfferSkus.containsKey(SKU)){
                        noOfferTotal =+ noOfferSkus.get(SKU);
                    } else {
                        return -1;
                    }
                    break;
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
        // F calculations
        int fTotal;
        if(fCount > 2) {
            fTotal = 10 * ((fCount/2) + 1);
        } else {
            fTotal = 10 * fCount;
        }

        int aTotal = (50 * aCount) - (a3Deal * 20) + (a5Deal * 200);
        int bTotal = (30 * bCount) - (bDeal * 15);
//        int cTotal = (cCount * 20);
//        int dTotal = (dCount * 15);
        int eTotal = (40 * eCount);

        // Return all the totals added up
        return aTotal + bTotal + eTotal + fTotal + noOfferTotal;
    }
}
