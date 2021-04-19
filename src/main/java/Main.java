import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        long begin = 0;
        long end = 0;
        long reiterations = 100000;

        Compare compare = new Compare(begin, end);

        ArrayList<Integer> arrayList = new ArrayList<>();

        LinkedList<Integer> linkedList = new LinkedList<>();

        String title = "\nTime (ms)  " + "  method  " + "  list type\n";
        System.out.println(title);

        //add
        compare.compareAddToEnd(arrayList, reiterations);
        System.out.println(compare.toString());

        compare.compareAddToEnd(linkedList, reiterations);
        System.out.println(compare.toString());

        //get
        compare.compareGet(arrayList, reiterations);
        System.out.println(compare.toString());

        compare.compareGet(linkedList, reiterations);
        System.out.println(compare.toString());

        //remove with Iterator
        compare.compareRemove(arrayList);
        System.out.println(compare.toString());

        compare.compareRemove(linkedList);
        System.out.println(compare.toString());

        //add again..
        compare.compareAddToEnd(arrayList, reiterations);
        compare.compareAddToEnd(linkedList,reiterations);

        //remove with indexes
        compare.compareRemoveWithIndex(arrayList);
        System.out.println(compare.toString());

        compare.compareRemoveWithIndex(linkedList);
        System.out.println(compare.toString());

        //foreach
        compare.compareForEach(arrayList);
        System.out.println(compare.toString());

        compare.compareForEach(linkedList);
        System.out.println(compare.toString());
    }
}
