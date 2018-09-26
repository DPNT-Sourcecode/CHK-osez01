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

        Variable aCount = new Variable(0);
        Variable a3Deal = new Variable(0);
        Variable a5Deal = new Variable(0);

        Variable bCount = new Variable(0);
        Variable bDeal = new Variable(0);

        Variable hCount = new Variable(0);
        Variable h5Deal = new Variable(0);
        Variable h10Deal = new Variable(0);

        Variable kCount = new Variable(0);
        Variable kDeal = new Variable(0);

        Variable vCount = new Variable(0);
        Variable v2Deal = new Variable(0);
        Variable v3Deal = new Variable(0);


        int eCount = 0;
        int fCount = 0;

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
                    eCount++;
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
        // Total EQUALS item count PLUS MINUS deal count
        // Calculations for Total B price based on amount of E's bought
        if (eCount > 1 & bCount.num > 0 ) {
            if(((bCount.num % 2) == 0) & bDeal.num > 0) {
                bDeal.num = bDeal.num - (eCount/2);
                if(bDeal.num < 0) {bDeal.num = 0;}
            }
            bCount.num = bCount.num - (eCount/2);
        }
        // F calculations
        int fTotal;
        if(fCount > 2) {
            fTotal = 10 * ((fCount/2) + 1);
        } else {
            fTotal = 10 * fCount;
        }

        int aTotal = (50 * aCount.num) - (a3Deal.num * 20) + (a5Deal.num * 200);
        int bTotal = singleForTotal(30, bCount.num, 15, bDeal.num);
//        (30 * bCount.num) - (bDeal.num * 15);
        int eTotal = (40 * eCount);
        int hTotal = (10 * hCount.num) - (h5Deal.num * 5) + (h10Deal.num * 80);
        int kTotal = (80 * kCount.num) - (kDeal.num * 10);
        int vTotal = (50 * vCount.num) - (v2Deal.num * 10) + (v3Deal.num * 130);

        // Return all the totals added up
        return aTotal + bTotal + eTotal + fTotal + hTotal + kTotal + vTotal + noOfferTotal;
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

    private Integer singleForTotal(Integer countPrice, Integer countValue, Integer dealPrice, Integer dealValue) {
        return (countPrice * countValue) - (dealPrice * dealValue);
    }
}
