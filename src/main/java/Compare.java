import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

/**
 * Класс для подсчета времени выполнения основных методов реализаций интерфейса List
 */
public class Compare {

    private long begin;
    private long end;
    private String method;
    private String listType;


    public Compare(long begin, long end) {
        this.begin = begin;
        this.end = end;
    }


    /**
     * @param list - реализация интерфейса List
     *
     * метод используется для определения точной реализации List,
     * используя оператор instanceOf
     */

    private void checkListType(List<Integer> list){
        if (list instanceof ArrayList) {
            listType = "Arraylist";
        } else {
            listType = "LinkedList";
        }
    }


    /**
     * @param list - реализация интерфейса List
     * @param reiterations - количество повторений выполнения метода
     *
     * метод используется для измерения времени выполнения добавления
     * элементов в конец конкретной реализации List
     */
    public void compareAddToEnd(List<Integer> list, long reiterations) {
        method = "compareAddToEnd";

        checkListType(list);

        begin = System.currentTimeMillis();

        for (int i = 0; i < reiterations; i++) {
            list.add(i);
        }
        end = System.currentTimeMillis();
    }


    /**
     * @param list - реализация интерфейса List
     * @param reiterations - количество повторений выполнения метода
     *
     * метод используется для измерения времени выполнения получения элемента,
     * используя конкретную реализацию List
     */
    public void compareGet(List<Integer> list, long reiterations) {
        method = "compareGet";

        checkListType(list);

        begin = System.currentTimeMillis();

        for (int i = 0; i < reiterations; i++) {
            list.get(i);
        }

        end = System.currentTimeMillis();
    }


    /**
     * @param list - реализация интерфейса List
     *
     * метод используется для измерения времени выполнения удаления,
     * используя конкретную реализацию List (with Iterator)
     */
    public void compareRemove(List<Integer> list) {
        method = "compareRemove";

        checkListType(list);

        begin = System.currentTimeMillis();

        for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext();) {
            if (list.contains(iterator.next())) {
                iterator.remove();
            }
        }//O(n^2) method clear() is better - O(n)
        end = System.currentTimeMillis();
    }


    /**
     * @param list - реализация интерфейса List
     *
     * метод используется для измерения времени выполнения удаления,
     * используя конкретную реализацию List (with Indexes)
     */
    public void compareRemoveWithIndex(List<Integer> list) {
        method = "compareRemoveWithIndex";

        checkListType(list);

        begin = System.currentTimeMillis();

        for (int i = 0; i < list.size(); i++) {
            list.remove(i);
        }

        end = System.currentTimeMillis();
    }


    /**
     * @param list - реализация интерфейса List
     *
     * метод используется при измерении времени выполнения
     * проверки каждого элемента на наличие в
     * конкретной реализации List
     */
    public void compareForEach(List<Integer> list) {
        method = "compareForEach";

        checkListType(list);

        begin = System.currentTimeMillis();

        list.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                list.contains(integer);
            }
        });//can be replaced with lambda exp

        end = System.currentTimeMillis();
    }


    /**
     * @return - результат измерений
     */
    @Override
    public String toString() {
        return (end - begin) + " ms " +
                " " + method + " " +
                listType + "\n";
    }
}