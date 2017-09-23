package dynamic;

import java.util.ArrayList;
import java.util.List;

public class DynamicLibrary {

    public static void example1 (List<Integer> list) {

        List<Integer> a = new ArrayList<>();

        a.add(0, Integer.MIN_VALUE);
        a.addAll(list);
        a.add(Integer.MAX_VALUE);

        int length = a.size();

        Integer[] L = new Integer[length];
        Integer[] T = new Integer[length];
        L[length - 1] = 1;

        for (int i = length - 2; i >= 0; i--) {
            int jMax = length - 1;
            for (int j = i + 1; j <= length - 1; j++) {
                if ( a.get(j) > a.get(i)) {
                    if (L[j] > L[jMax]){
                        jMax = j;
                    }

                }
            }
            L[i] = L[jMax] + 1;
            T[i]= jMax;
        }

        int result = T[0];
        while (result != length - 1) {
            System.out.println(""+result+" - a: "+a.get(result));
            result = T[result];
        }
    }


}
