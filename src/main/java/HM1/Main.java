package HM1;

public class Main {
    public static void main(String[] args) {
       /* System.out.println("Hello World");
        int[] arr = new int[] {1,5,6,9,8};
        System.out.println(arr.length);*/
        ArrayList_AlexBalandin <Integer> list = new ArrayList_AlexBalandin<>();
        list.add(2); list.add(2); list.add(2); list.add(5); list.add(140); list.add(7);list.add(4); list.add(22); list.add(6);
        System.out.println(list);
        list.quickSort(Integer::compareTo);
        System.out.println(list);
        System.out.println(list.isSorted());
        for (int i = 9; i < 1000; i++) {
            list.add(1000-i);
        }
        System.out.println(list.size());
        list.quickSort(Integer::compareTo);
        System.out.println(list);
        /*list.set(1,5);
        System.out.println(list);*/
        /*ArrayList_AlexBalandin <String> stringlist = new ArrayList_AlexBalandin<>();
        stringlist.add("1"); stringlist.add("2"); stringlist.add("3"); stringlist.add("4");
        System.out.println(stringlist);
        System.out.println(stringlist.set(1,"25"));
        System.out.println(stringlist);
        System.out.println(stringlist.remove(1));
        System.out.println(stringlist);*/
    }
}
