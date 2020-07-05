import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class QuickSort {
    public static void main(String[] args)
    {
        Float[] array = new Float[]{23.0f,8.0f,231.33f,15.99f,16.23f,42.22f,4.3f};
        var list = Arrays.asList(array);
        quickSort(list);

        System.out.println(Arrays.toString(array));
    }

    public static <T extends Comparable<T>> void quickSort(List<T> list)
    {
        quickSortRec(list,0,list.size()-1);
    }

    public static <T extends Comparable<T>> void quickSortRec(List<T> list, int l, int r)
    {
        if (r-l < 1)
        {
            return;
        }
        else {
            int[] result = _partition(list,l,r);
            quickSortRec(list,l,result[0]-1);
            quickSortRec(list,result[1]+1,r);
        }
    }

    private static <T extends Comparable<T>> int[] _partition(List<T> list, int l, int r)
    {
        int smaller = l;
        int equal = l;
        int bigger = r;
        T pivot = list.get((l+r)/2);

        while (equal <= bigger)
        {
            if (list.get(equal).compareTo(pivot) == -1)
            {
                swapAtIndex(list,smaller++,equal++);
            }
            else if (list.get(equal).compareTo(pivot) == 0)
            {
                equal++;
            }
            else if (list.get(equal).compareTo(pivot) == 1) {
                swapAtIndex(list, equal, bigger--);
            }
        }
        return new int[] {smaller,bigger};
    }

    private static <T extends Comparable<T>> void swapAtIndex(List<T> list, int one, int two)
    {

        T temp = list.get(one);
        list.set(one, list.get(two));
        list.set(two, temp);
    }
}
