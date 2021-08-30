package kolakoski_sequence;

import java.util.LinkedList;
import java.util.List;

public class KolakoskiSequenceNthRun {
    
    /**
     * @param n: represents the number of "runs" or "blocks"
     * input "n" is limited to approximately ~40 due sequence growth and space constraint
     * Ex: n=50 will result in java.lang.OutOfMemoryError: Java heap space
     * 
     * @return: Will return only the sequence of "nth" run/block
     */
    public static List<Integer> kolakoskiSequenceNthRun(int n) {
               
        LinkedList<Integer> list = new LinkedList<Integer>();

        try {

            if (n < 1) {
                throw new Exception("Input value must be greater than or equal to 1");
            }

            else if (n == 1) { 
                list.addLast(1);
            }
            else if (n == 2 || n >= 3) {
                list.addLast(2);
            }

            
            if (n > 3) {
                list = kSequenceHelper(n, 4, list);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    private static LinkedList<Integer> kSequenceHelper(int n, int iter, LinkedList<Integer> block) {
        if (iter > n) {
            return block;
        }

        int nextDigit = block.peekLast() % 2 + 1;
        LinkedList<Integer> newBlock = new LinkedList<Integer>();
        
        for (int i : block) {

            for (int j = 1; j <= i; j++) {
                newBlock.addLast(nextDigit);
            }
            
            nextDigit = nextDigit % 2 + 1;
        }

        return kSequenceHelper(n, iter+1, newBlock);
    }

    public static void main(String[] args) {
        List<Integer> list;
        
        list = kolakoskiSequenceNthRun(0);
        System.out.println(list.toString());

        list = kolakoskiSequenceNthRun(1);
        System.out.println(list.toString());

        list = kolakoskiSequenceNthRun(2);
        System.out.println(list.toString());
        
        list = kolakoskiSequenceNthRun(3);
        System.out.println(list.toString());

        list = kolakoskiSequenceNthRun(4);
        System.out.println(list.toString());

        list = kolakoskiSequenceNthRun(5);
        System.out.println(list.toString());

        list = kolakoskiSequenceNthRun(6);
        System.out.println(list.toString());

        list = kolakoskiSequenceNthRun(40);
        System.out.println(list.size());
    }
}