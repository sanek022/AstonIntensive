package HM1;

import java.util.Arrays;
import java.util.Comparator;

public class ArrayList_AlexBalandin<E> implements IntensiveList<E>{
    private int size = 0;
    private E[] array;
    private int capacity = 10;
    /** Задается массив с базовым значением **/
    public ArrayList_AlexBalandin(){
        array = (E[]) new Object[capacity];
    }
    /** Выводится размер массива **/
    @Override
    public int size() {
        return size;
    }
    /** Добавление элемента **/
    @Override
    public void add(E element) {
        if(size == array.length)
            makeLonger();
        array[size] = element;
        size++;
    }
    /** Метод расширения массива общий для трех вставок **/
    private void makeLonger(){
        E[] newArray = (E[]) new Object[(int) (array.length*1.5) + 1];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }
    /** Добавление элемента по индексу **/
    @Override
    public void add(int index, E element) {
        while (index >= array.length || size == array.length)
            makeLonger();
        for (int i = index; i < array.length; i++){
            array[i+1] = array[i];
        }
        array[index] = element;
        size++;
    }
    /** Получение элемента **/
    @Override
    public E get(int index) {
        return array[index];
    }
    /** Замена элемента и возвращение изначального значения **/
    @Override
    public E set(int index, E element) {
        while (index >= array.length)
            makeLonger();
        E old = array[index];
        array[index] = element;
        size++;
        return old;
    }
    /** Удаление элемента и возвращение удаленного значения**/
    @Override
    public E remove(int index) {
        if(size == 0) {
            return null;
        }
        E old = array[index];
        for(int i = index; i < size; i++) {
            array[i] = array[i + 1];
        }
        return old;
    }
    /** Очистка списка и возвращение к базовому размеру **/
    @Override
    public void clear() {
        array = (E[]) new Object[capacity];
    }
    /** Метод для внешнего вызова быстрой сортировки **/
    @Override
    public void quickSort(Comparator<E> comparator) {
        myQuickSort(0, size - 1, comparator);

    }
    /** Метод быстрой сортировки **/
    private void myQuickSort( int low, int high, Comparator<E> comparator) {
        if (low < high) {
            int pi = partition( low, high, comparator);
            myQuickSort( low, pi - 1, comparator );
            myQuickSort(pi + 1, high, comparator);
        }
    }
    /** Метод partition определяет положение опорного элемента  и переставляет элементы так,
     * чтобы элементы меньше опорного находились слева от него, а большие — справа. Этот метод возвращает индекс опорного элемента
     * после перестановки.**/
    private int partition( int low, int high, Comparator<E> comparator) {

        int middle = low + (high - low) / 2;
        E pivot = array[middle];

        E temp = array[middle];
        array[middle] = array[high];
        array[high] = temp;

        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (comparator.compare(array[j],pivot) <= 0) {
                i++;

                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }
    /** Метод показывает отсортирован список или нет **/
    @Override
    public boolean isSorted() {
        for (int i = 0; i < size - 1; i++) {
            var current = (Comparable<E>) array[i];
            if (current.compareTo(array[i+1]) > 0) {
                return false;
            }
        }
        return true;
    }

    /** Обрезание списка до указанного размера**/
    @Override
    public void split(int size) {
        E[] newArray = (E[]) new Object[size];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }
    /** Метод вывода в консоль **/
    @Override
    public String toString() {
        return "ArrayList_AlexBalandin{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}
