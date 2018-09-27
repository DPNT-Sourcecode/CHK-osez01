package befaster.solutions.CHK;

import java.util.HashMap;

//Started CHK_R3 at 1158 min

public class CheckoutSolution {

//     static int aCount = 0;
//     static int a3Deal = 0;
//     static int a5Deal = 0;

    class Variable {
        public int num;

        public Variable(int num) {
            this.num = num;
        }

        public void reduce(Integer reduceBy){
            num = ((num - reduceBy) > 0) ? (num - reduceBy) : 0;
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

        Variable aCount = new Variable(0);
        Variable a3Deal = new Variable(0);
        Variable a5Deal = new Variable(0);

        Variable bCount = new Variable(0);
        Variable bDeal = new Variable(0);

        Variable eCount = new Variable(0);

        Variable hCount = new Variable(0);
        Variable h5Deal = new Variable(0);
        Variable h10Deal = new Variable(0);

        Variable kCount = new Variable(0);
        Variable kDeal = new Variable(0);

        Variable mCount = new Variable(0);

        Variable nCount = new Variable(0);
        Variable nDeal = new Variable(0);

        Variable pCount = new Variable(0);
        Variable pDeal = new Variable(0);

        Variable qCount = new Variable(0);
        Variable qDeal = new Variable(0);

        Variable rCount = new Variable(0);

        Variable vCount = new Variable(0);
        Variable v2Deal = new Variable(0);
        Variable v3Deal = new Variable(0);



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
                    multipleForDeal(aCount, new Variable(5) ,new Variable(3), a5Deal, a3Deal);
                    break;
                case 'B':
                    singleForDeal(bCount, new Variable(2), bDeal);
                    break;
                case 'E':
                    eCount.num++;
                    break;
                case 'F':
                    fCount++;
                    break;
                case 'H':
                    multipleForDeal(hCount, new Variable(10),  new Variable(5), h10Deal, h5Deal);
                    break;
                case 'K':
                    singleForDeal(kCount, new Variable(2), kDeal);
                    break;
                case 'M':
                    mCount.num++;
                    break;
                case 'N':
                    singleForDeal(nCount, new Variable(3), nDeal);
                    break;
                case 'P':
                    singleForDeal(pCount, new Variable(5), pDeal);
                    break;
                case 'Q':
                    singleForDeal(qCount, new Variable(3), qDeal);
                    break;
                case 'R':
                    rCount.num++;
                    break;
                case 'U':
                    uCount++;
                    break;
                case 'V':
                    multipleForDeal(vCount, new Variable(3), new Variable(2), v3Deal, v2Deal);
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
        getOtherFree(eCount, 2, bCount, bDeal);
        getOtherFree(rCount, 3, qCount, qDeal);
        // F calculations
        int fTotal;
        if(fCount > 2) {
            fTotal = 10 * ((fCount/2) + 1);
        } else {
            fTotal = 10 * fCount;
        }

        if(nCount.num > 2) {
            mCount.reduce(nDeal.num);
        }
        //U Calc
        int uTotal;
        if(uCount > 2) {
            uTotal = 40 *(uCount - (uCount/3));
        } else {
            uTotal = 40 * uCount;
        }

        int aTotal = (50 * aCount.num) - (a3Deal.num * 20) + (a5Deal.num * 200);
        int bTotal = singleForTotal(30, bCount.num, 15, bDeal.num);
        int eTotal = (40 * eCount.num);
        int hTotal = (10 * hCount.num) - (h5Deal.num * 5) + (h10Deal.num * 80);
        int kTotal = singleForTotal(80, kCount.num, 10, kDeal.num);
        int mTotal = (15 * mCount.num);
        int nTotal = (40 * nCount.num);
        int pTotal = singleForTotal(50, pCount.num, 50, pDeal.num);
        int qTotal = singleForTotal(30, qCount.num, 10, qDeal.num);
        int rTotal = (50 * rCount.num);
        int vTotal = (50 * vCount.num) - (v2Deal.num * 10) + (v3Deal.num * 130);
        // Return all the totals added up
        return aTotal + bTotal + eTotal + fTotal + hTotal + kTotal + pTotal + qTotal + rTotal + mTotal + nTotal + uTotal + vTotal + noOfferTotal;
    }

    private void multipleForDeal(Variable count, Variable X, Variable Y , Variable dealXCount, Variable dealYCount) {
        count.num++;
        boolean modX = (count.num % X.num) == 0;
        boolean modY = (count.num % Y.num) == 0;
        if (modX) {
            dealYCount.num = 0;
            count.num = 0;
            dealXCount.num++;
        } else if (modY) {
            dealYCount.num++;
        }
    }

    private void singleForDeal(Variable count, Variable modValue, Variable dealCount) {
        count.num++;
        if((count.num % modValue.num) == 0) {dealCount.num++;}
    }

    private Integer singleForTotal(Integer countPrice, Integer countValue, Integer dealSaving, Integer dealValue) {
        return (countPrice * countValue) - (dealSaving * dealValue);
    }

    // Buy A amount of X, get one Y free (which has its own YDeal)
    private void getOtherFree(Variable xCount, Integer a , Variable yCount, Variable yDeal ){
        if (xCount.num > 1 & yCount.num > 0 ) {
            if(((yCount.num % a) == 0) & yDeal.num > 0) {
                yDeal.reduce(xCount.num/a);
            }
            yCount.reduce(xCount.num/a);
        }
    }
}
