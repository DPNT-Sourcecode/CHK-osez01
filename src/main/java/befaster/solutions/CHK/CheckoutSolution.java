package befaster.solutions.CHK;

import java.util.HashMap;

//Started CHK_R3 at 1158 min

public class CheckoutSolution {


    private class SKU {
        private int itemCount;
        private int dealOneCount;
        private int dealTwoCount;

        private SKU() {
        }

        private void reduceItemCount(Integer reduceBy){
            itemCount = ((itemCount - reduceBy) > 0) ? (itemCount - reduceBy) : 0;
        }

        private void reduceDealOneCount(Integer reduceBy){
            dealOneCount = ((dealOneCount - reduceBy) > 0) ? (dealOneCount - reduceBy) : 0;
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
        noOfferSkus.put('O', 10);
        noOfferSkus.put('S', 30);
        noOfferSkus.put('T', 20);
        noOfferSkus.put('W', 20);
        noOfferSkus.put('X', 90);
        noOfferSkus.put('Y', 10);
        noOfferSkus.put('Z', 50);

        SKU A = new SKU();
        SKU B = new SKU();
        SKU E = new SKU();
        SKU H = new SKU();
        SKU K = new SKU();
        SKU M = new SKU();
        SKU N = new SKU();
        SKU P = new SKU();
        SKU Q = new SKU();
        SKU R = new SKU();
        SKU V = new SKU();


        int fCount = 0;
        int uCount = 0;
        int noOfferTotal = 0;

        // Check for empty input
        if (skus.equals("")) {
            return 0;
        }
        // parse string and count each SKU
        for (char SKU : skus.toCharArray()) {
            switch (SKU) {
                case 'A':
                    multipleForDeal(A, 5, 3);
                    break;
                case 'B':
                    singleForDeal(B, 2);
                    break;
                case 'E':
                    E.itemCount++;
                    break;
                case 'F':
                    fCount++;
                    break;
                case 'H':
                    multipleForDeal(H, 10, 5);
                    break;
                case 'K':
                    singleForDeal(K, 2);
                    break;
                case 'M':
                    M.itemCount++;
                    break;
                case 'N':
                    singleForDeal(N, 3);
                    break;
                case 'P':
                    singleForDeal(P,5);
                    break;
                case 'Q':
                    singleForDeal(Q, 3);
                    break;
                case 'R':
                    R.itemCount++;
                    break;
                case 'U':
                    uCount++;
                    break;
                case 'V':
                    multipleForDeal(V, 3, 2);
                    break;
                default:
                    if(noOfferSkus.containsKey(SKU)){
                        noOfferTotal += noOfferSkus.get(SKU);
                    } else {
                        return -1;
                    }
                    break;
            }


        }
        getOtherFree(E, 2, B);
        getOtherFree(R, 3, Q);
        // F calculations
        int fTotal;
        if(fCount > 2) {
            fTotal = 10 * ((fCount/2) + 1);
        } else {
            fTotal = 10 * fCount;
        }

        if(N.itemCount > 2) {
            M.reduceItemCount(N.dealOneCount);
        }
        //U Calc
        int reduce;
        if((uCount % 3) == 0) {
            reduce = (uCount/3) - 1;
        } else { reduce = uCount/3;}

        int uTotal;
        if(uCount > 3) {
            uTotal = 40 * (uCount - reduce);
        } else {
            uTotal = 40 * uCount;
        }

        int aTotal = (50 * A.itemCount) - (A.dealTwoCount * 20) + (A.dealOneCount * 200);
        int bTotal = singleForTotal(B,30 ,15);
        int eTotal = (40 * E.itemCount);
        int hTotal = (10 * H.itemCount) - (h5Deal.itemCount * 5) + (h10Deal.itemCount * 80);
        int kTotal = singleForTotal(K, 80, 10);
        int mTotal = (15 * M.itemCount);
        int nTotal = (40 * N.itemCount);
        int pTotal = singleForTotal(P, 50, 50);
        int qTotal = singleForTotal(Q, 30, 30);
        int rTotal = (50 * R.itemCount);
        int vTotal = (50 * V.itemCount) - (v2Deal.itemCount * 10) + (v3Deal.itemCount * 130);
        // Return all the totals added up
        return aTotal + bTotal + eTotal + fTotal + hTotal + kTotal + pTotal + qTotal + rTotal + mTotal + nTotal + uTotal + vTotal + noOfferTotal;
    }

    private void multipleForDeal(SKU sku, Integer X, Integer Y) {
        sku.itemCount++;
        boolean modX = (sku.itemCount % X) == 0;
        boolean modY = (sku.itemCount % Y) == 0;
        if (modX) {
            sku.dealTwoCount = 0;
            sku.itemCount = 0;
            sku.dealOneCount++;
        } else if (modY) {
            sku.dealTwoCount++;
        }
    }

    private void singleForDeal(SKU sku, Integer modValue) {
        sku.itemCount++;
        if((sku.itemCount % modValue) == 0) {sku.dealOneCount++;}
    }

    private Integer singleForTotal(SKU sku, Integer countPrice, Integer dealSaving) {
        return (countPrice * sku.itemCount) - (dealSaving * sku.dealOneCount);
    }

    // Buy A amount of X, get one Y free (which has its own YDeal)
    private void getOtherFree(SKU sku1, Integer a , SKU sku2 ){
        if (sku1.itemCount > 1 & sku2.itemCount > 0 ) {
            if(((sku2.itemCount % a) == 0) & sku2.dealOneCount > 0) {
                sku2.reduceDealOneCount(sku1.itemCount /a);
            }
            sku2.reduceItemCount(sku1.itemCount /a);
        }
    }
}
