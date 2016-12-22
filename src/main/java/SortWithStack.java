import java.util.Arrays;

/**
 * Created by User on 20.12.2016.
 */
public class SortWithStack {
    LinkedList<Integer>[] stack;
    SortWithStack(int length){
        stack = new LinkedList[length];
    }

    public LinkedList<Integer> sortLinkedList(LinkedList<Integer> linkedlist){
        LinkedList<Integer> sortedLinkedList = new LinkedList<Integer>();
        int posOnStack = 0;
        for(int i = 0; i < linkedlist.count; i++){
            if(stack[posOnStack] == null) stack[posOnStack] = new LinkedList<Integer>();
            int val = linkedlist.getByIndex(i);
            if(posOnStack > 1){
                boolean search = false;
                do{
                    if(posOnStack-2 >= 0) {
                        int curCount = stack[posOnStack - 1].count;
                        int prevCount = stack[posOnStack - 2].count;
                        if (curCount > 0 && prevCount == curCount) {
                            stack[posOnStack - 2] = sort(stack[posOnStack - 2], stack[posOnStack - 1]);
                            stack[posOnStack - 1] = new LinkedList<Integer>();
                            posOnStack--;
                            search = true;
                        } else {
                            search = false;
                        }
                    }else {
                        search = false;
                    }
                }while(search);
            }
            stack[posOnStack].put(val);
            posOnStack++;
        }
        sortedLinkedList = stack[0];
        for(int i = 1; i < posOnStack; i++){
            sortedLinkedList = sort(sortedLinkedList,stack[i]);
        }

        return sortedLinkedList;
    }

    private boolean havePair(){
        return false;
    }

    private LinkedList<Integer> sort(LinkedList<Integer> first, LinkedList<Integer> second){
        LinkedList<Integer> newLinkedList = new LinkedList<Integer>();
        int currR = 0, currL = 0;
        int count = (first.count+second.count);
        for(int i = 0; i < count; i++){
            if(i-currR > second.count-1){
                newLinkedList.put(first.getByIndex(i-currL));
                continue;
            }else if(i-currL > first.count-1){
                newLinkedList.put(second.getByIndex(i-currR));
                continue;
            }
            int left = first.getByIndex(i-currL), right = second.getByIndex(i-currR);
            if(left > right){
                newLinkedList.put(right);
                currL++;
            }else if(left < right){
                newLinkedList.put(left);
                currR++;
            }else if(left == right){
                newLinkedList.put(right);
                newLinkedList.put(left);
                count--;
            }
        }
        LinkedList<Integer> ll2 = newLinkedList;
        newLinkedList = new LinkedList<Integer>();
        int c = ll2.count;
        for(int i = 0; i < c; i++){
            newLinkedList.put(ll2.pull());
        }
        return newLinkedList;
    }


}
