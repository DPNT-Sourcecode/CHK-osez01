package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;

import java.util.Objects;

public class CheckoutSolution {
    private int anInt;

    public Integer checkout(String skus) {
        int aCount = 0;
        int aDeal = 0;
        int aTotal = 0;
        
        int bCount = 0;
        int bTotal = 0;
        
        int cCount = 0;
        int cTotal = 0;
        
        int dCount = 0;
        int dTotal = 0;
        // check for legal input
        if(skus.equals("")) {
            return -1;
        }
        // parse string and count each SKU
        // format "AAABB"?
        System.out.print(skus);
        for(char SKU: skus.toCharArray()) {
            switch (SKU) {
                case 'A': 
                    // Either there is a deal and restart counting
                    if(aCount == 3){
                        aCount = 0;
                        aDeal++;
                    } else {
                        // Or count Item
                        aCount++;
                    }
                    break;
                case 'B': if(aCount == 3){
                    anInt;
                    aDeal++;
                } else {
                    // Or count Item
                    aCount++;
                }
                break;
                case 'C': cCount++;
                case 'D': dCount++;
                default: return -1;
            }

        }
        // Total = item count + deal count
        aTotal = (50 * aCount) + (aDeal * 130);
        // check for offers
        // sum up
//        throw new SolutionNotImplementedException();
        return  aCount;
    }
}
