import java.util.*;

public class QuickSort<T extends Comparable<T>> {
    public static void main(String[] args)
    {
        // Implemented once by Hoare and once with 3-way-partitioning
    }

    public void quickSortHoare(List<T> list)
    {
        quickSortRecHoare(list,0,list.size()-1);
    }

    private void quickSortRecHoare(List<T> list,int l, int r)
    {
        if (r-l < 1) return;
        else {
            int pivot = _partitionHoare(list,l,r);
            quickSortRecHoare(list,l,pivot);
            quickSortRecHoare(list,pivot+1,r);
        }
    }

    private int _partitionHoare(List<T> list, int l, int r)
    {
        int lidx = l-1; int ridx = r+1; T pivot = list.get(l);
        while (true) {
            do {
                lidx++;
            } while (list.get(lidx).compareTo(pivot) == -1);
            do {
                ridx--;
            } while (list.get(ridx).compareTo(pivot) == 1);
            if (lidx >= ridx) return ridx;
            else swapAtIndex(list,lidx,ridx);
        }
    }

    private void quickSort(List<T> list)
    {
        quickSortRec(list,0,list.size()-1);
    }

    public void quickSortRec(List<T> list, int l, int r)
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

    private int[] _partition(List<T> list, int l, int r)
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

    private void swapAtIndex(List<T> list, int one, int two)
    {

        T temp = list.get(one);
        list.set(one, list.get(two));
        list.set(two, temp);
    }
}
