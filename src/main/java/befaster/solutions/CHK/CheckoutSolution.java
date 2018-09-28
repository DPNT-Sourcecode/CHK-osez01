package befaster.solutions.CHK;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

//Started CHK_R3 at 1158 min

public class CheckoutSolution {


    private class SKU {
        private int itemCount;
        private int dealOneCount;
        private int dealTwoCount;
        private int itemPrice;
        private int dealOnePrice;
        private int dealTwoPrice;

        private SKU(int itemPrice) {
            this.itemPrice = itemPrice;
        }

        private SKU (int itemPrice, int dealOnePrice) {
            this.itemPrice = itemPrice;
            this.dealOnePrice = dealOnePrice;
        }

        private SKU (int itemPrice, int dealOnePrice, int dealTwoPrice) {
            this.itemPrice = itemPrice;
            this.dealOnePrice = dealOnePrice;
            this.dealTwoPrice = dealTwoPrice;
        }

       private Integer getItemCount() {
            return itemCount;
       }

        private Integer getItemPrice() {
            return itemPrice;
        }

        private void reduceItemCount(Integer reduceBy){
            itemCount = ((itemCount - reduceBy) > 0) ? (itemCount - reduceBy) : 0;
        }

        private void reduceDealOneCount(Integer reduceBy){
            dealOneCount = ((dealOneCount - reduceBy) > 0) ? (dealOneCount - reduceBy) : 0;
        }

        private Integer basicTotal() {
            return itemCount * itemPrice;
        }

        private Integer dealTotal(){
            return (itemPrice * itemCount) - (dealTwoCount * dealTwoPrice) + (dealOneCount * dealOnePrice);
        }

        private Integer singleForTotal() {
            return (itemPrice * itemCount) - (dealOnePrice * dealOneCount);
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
        noOfferSkus.put('W', 20);

        SKU A = new SKU(50,200,20);
        SKU B = new SKU(30, 15);
        SKU E = new SKU(40);
        SKU H = new SKU(10,80,5);
        SKU K = new SKU(70,20);
        SKU M = new SKU(15);
        SKU N = new SKU(40);
        SKU P = new SKU(50,50);
        SKU Q = new SKU(30 ,10);
        SKU R = new SKU(50);
        SKU S = new SKU(20,5);
        SKU T = new SKU(20,5);
        SKU V = new SKU(50, 130,10);
        SKU X = new SKU(17,2);
        SKU Y = new SKU(20 ,5);
        SKU Z = new SKU( 21, 6);

        ArrayList<SKU> buy3List = new ArrayList<>();
        buy3List.add(S);
        buy3List.add(T);
        buy3List.add(X);
        buy3List.add(Y);
        buy3List.add(Z);


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
                case 'S':
                    S.itemCount++;
                    break;
                case 'T':
                    T.itemCount++;
                    break;
                case 'U':
                    uCount++;
                    break;
                case 'V':
                    multipleForDeal(V, 3, 2);
                    break;
                case 'X':
                    X.itemCount++;
                    break;
                case 'Y':
                    Y.itemCount++;
                    break;
                case 'Z':
                    Z.itemCount++;
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
        // E and R implications
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

        Integer buy3DealTotal = calculateTotal(buy3List);


        // Return all the totals added up
        return A.dealTotal() + B.singleForTotal() + E.basicTotal() + fTotal + H.dealTotal()
                + K.singleForTotal() +  + M.basicTotal() +  N.basicTotal() + P.singleForTotal()
                + Q.singleForTotal() + R.basicTotal()
                + uTotal + V.dealTotal()
                + noOfferTotal + buy3DealTotal;
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

    // Buy A amount of X, get one Y free (which has its own YDeal)
    private void getOtherFree(SKU sku1, Integer a , SKU sku2 ){
        if (sku1.itemCount > 1 & sku2.itemCount > 0 ) {
            if(((sku2.itemCount % a) == 0) & sku2.dealOneCount > 0) {
                sku2.reduceDealOneCount(sku1.itemCount /a);
            }
            sku2.reduceItemCount(sku1.itemCount /a);
        }
    }

    private Integer calculateTotal (ArrayList<SKU> list) {
        List<SKU> itemsBought = list.stream().filter(s -> s.itemCount > 0).collect(Collectors.toList());

        itemsBought.sort(Comparator.comparing(SKU::getItemPrice).reversed());

        Integer totalItemsBought  = itemsBought.stream().mapToInt(SKU::getItemCount).sum();
        Integer dealCount = ((totalItemsBought/3));
        Integer numberOfItemsOnDeal = dealCount * 3;
        Integer total = 0;
        for(SKU sku : itemsBought) { //For each sku
            for(int i = 0; i < sku.itemCount; i++){ // For each item
                if(numberOfItemsOnDeal > 0) {
                    total += (sku.itemPrice - sku.dealOnePrice);
                    numberOfItemsOnDeal--;
                } else {
                    total += sku.itemPrice;
                }
            }

        }

        return total;
    }
}
