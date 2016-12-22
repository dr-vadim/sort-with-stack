import java.util.Date;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        LinkedList<Integer> lli = new LinkedList<Integer>();
        Random rand = new Random();
        for(int i =0; i < 50; i++){
            int num = rand.nextInt(156);
            lli.put(num);
            System.out.print(num+" ");
        }
        System.out.println();
        SortWithStack sws = new SortWithStack(32);
        LinkedList<Integer> sorted = sws.sortLinkedList(lli);

        for(int i = 0;i < sorted.count; i++){
            System.out.print(sorted.getByIndex(i)+" ");
        }
    }
}
