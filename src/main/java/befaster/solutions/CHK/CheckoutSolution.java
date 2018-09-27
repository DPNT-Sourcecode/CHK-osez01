package befaster.solutions.CHK;

import java.util.HashMap;

//Started CHK_R3 at 1158 min

public class CheckoutSolution {


    private class SKU {
        private int itemCount;
        private int dealOneCount;
        private int dealTwoCount;

        private SKU(int itemCount, int dealOneCount, int dealTwoCount) {
            this.itemCount = itemCount;
            this.dealOneCount = dealOneCount;
            this.dealTwoCount = dealTwoCount;
        }

        private void reduce(Integer reduceBy){
            itemCount = ((itemCount - reduceBy) > 0) ? (itemCount - reduceBy) : 0;
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

        SKU A = new SKU(0 , 0 ,0);

        SKU bCount = new SKU(0 , 0, 0);
        SKU bDeal = new SKU(0);

        SKU eCount = new SKU(0);

        SKU hCount = new SKU(0);
        SKU h5Deal = new SKU(0);
        SKU h10Deal = new SKU(0);

        SKU kCount = new SKU(0);
        SKU kDeal = new SKU(0);

        SKU mCount = new SKU(0);

        SKU nCount = new SKU(0);
        SKU nDeal = new SKU(0);

        SKU pCount = new SKU(0);
        SKU pDeal = new SKU(0);

        SKU qCount = new SKU(0);
        SKU qDeal = new SKU(0);

        SKU rCount = new SKU(0);

        SKU vCount = new SKU(0);
        SKU v2Deal = new SKU(0);
        SKU v3Deal = new SKU(0);



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
                    multipleForDeal(A, new SKU(5) ,new SKU(3), a5Deal, a3Deal);
                    break;
                case 'B':
                    singleForDeal(bCount, new SKU(2), bDeal);
                    break;
                case 'E':
                    eCount.itemCount++;
                    break;
                case 'F':
                    fCount++;
                    break;
                case 'H':
                    multipleForDeal(hCount, new SKU(10),  new SKU(5), h10Deal, h5Deal);
                    break;
                case 'K':
                    singleForDeal(kCount, new SKU(2), kDeal);
                    break;
                case 'M':
                    mCount.itemCount++;
                    break;
                case 'N':
                    singleForDeal(nCount, new SKU(3), nDeal);
                    break;
                case 'P':
                    singleForDeal(pCount, new SKU(5), pDeal);
                    break;
                case 'Q':
                    singleForDeal(qCount, new SKU(3), qDeal);
                    break;
                case 'R':
                    rCount.itemCount++;
                    break;
                case 'U':
                    uCount++;
                    break;
                case 'V':
                    multipleForDeal(vCount, new SKU(3), new SKU(2), v3Deal, v2Deal);
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
        getOtherFree(eCount, 2, bCount, bDeal);
        getOtherFree(rCount, 3, qCount, qDeal);
        // F calculations
        int fTotal;
        if(fCount > 2) {
            fTotal = 10 * ((fCount/2) + 1);
        } else {
            fTotal = 10 * fCount;
        }

        if(nCount.itemCount > 2) {
            mCount.reduce(nDeal.itemCount);
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

        int aTotal = (50 * A.itemCount) - (a3Deal.itemCount * 20) + (a5Deal.itemCount * 200);
        int bTotal = singleForTotal(30, bCount.itemCount, 15, bDeal.itemCount);
        int eTotal = (40 * eCount.itemCount);
        int hTotal = (10 * hCount.itemCount) - (h5Deal.itemCount * 5) + (h10Deal.itemCount * 80);
        int kTotal = singleForTotal(80, kCount.itemCount, 10, kDeal.itemCount);
        int mTotal = (15 * mCount.itemCount);
        int nTotal = (40 * nCount.itemCount);
        int pTotal = singleForTotal(50, pCount.itemCount, 50, pDeal.itemCount);
        int qTotal = singleForTotal(30, qCount.itemCount, 10, qDeal.itemCount);
        int rTotal = (50 * rCount.itemCount);
        int vTotal = (50 * vCount.itemCount) - (v2Deal.itemCount * 10) + (v3Deal.itemCount * 130);
        // Return all the totals added up
        return aTotal + bTotal + eTotal + fTotal + hTotal + kTotal + pTotal + qTotal + rTotal + mTotal + nTotal + uTotal + vTotal + noOfferTotal;
    }

    private void multipleForDeal(SKU count, SKU X, SKU Y , SKU dealXCount, SKU dealYCount) {
        count.itemCount++;
        boolean modX = (count.itemCount % X.itemCount) == 0;
        boolean modY = (count.itemCount % Y.itemCount) == 0;
        if (modX) {
            dealYCount.itemCount = 0;
            count.itemCount = 0;
            dealXCount.itemCount++;
        } else if (modY) {
            dealYCount.itemCount++;
        }
    }

    private void singleForDeal(SKU count, SKU modValue, SKU dealCount) {
        count.itemCount++;
        if((count.itemCount % modValue.itemCount) == 0) {dealCount.itemCount++;}
    }

    private Integer singleForTotal(Integer countPrice, Integer countValue, Integer dealSaving, Integer dealValue) {
        return (countPrice * countValue) - (dealSaving * dealValue);
    }

    // Buy A amount of X, get one Y free (which has its own YDeal)
    private void getOtherFree(SKU xCount, Integer a , SKU yCount, SKU yDeal ){
        if (xCount.itemCount > 1 & yCount.itemCount > 0 ) {
            if(((yCount.itemCount % a) == 0) & yDeal.itemCount > 0) {
                yDeal.reduce(xCount.itemCount /a);
            }
            yCount.reduce(xCount.itemCount /a);
        }
    }
}
