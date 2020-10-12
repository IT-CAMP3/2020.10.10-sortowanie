import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] notSortedArray = new int[10];
        Random losowacz = new Random();

        //losowanie tablicy nieposortowanej
        for(int i = 0; i < notSortedArray.length; i++) {
            notSortedArray[i] = losowacz.nextInt(100);
        }

        //wypisywanie tablicy nieposortowanej
        for(int i = 0; i < notSortedArray.length; i++) {
            System.out.print(notSortedArray[i] + " ");
        }
        System.out.println("");

        int[] sortedArray = new int[notSortedArray.length];

        //przygotowanie nowej tablicy do sortowania
        for(int i = 0; i < sortedArray.length; i++) {
            sortedArray[i] = -1;
        }

        //algorytm sortowania
        sortedArray[0] = notSortedArray[0];

        //kolejne elementy nieposortowanej tablicy
        for(int i = 1; i < notSortedArray.length; i++) {
            //szukamy miejsca w "posortowanej" tablicy
            boolean flag = false;
            for(int j = 0; j < sortedArray.length; j++) {
                //czy znalazłem miejsce dla nieposortowanego elementu ??
                if(notSortedArray[i] < sortedArray[j]) {
                    //jeśli tak to przesuwam posortowane elementy
                    for(int n = sortedArray.length - 1; n > j; n--) {
                        sortedArray[n] = sortedArray[n-1];
                    }
                    //wstawiam nieposortowany element
                    sortedArray[j] = notSortedArray[i];
                    //przrywam operację szukania miejsca dla nieposortowanego elemeny
                    flag = true;
                    break;
                }
            }
            if(!flag) {
                sortedArray[i] = notSortedArray[i];
            }
        }

        for(int i = 0; i < sortedArray.length; i++) {
            System.out.print(sortedArray[i] + " ");
        }
        System.out.println("");
    }
}
