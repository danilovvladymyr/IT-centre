package session1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by danilov on 12/19/15.
 */
public class TaskIteration {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        Iterator<Integer> iter = list.iterator();

        for ( ;iter.hasNext(); ) {
//            Iterator iter = list.iterator();

            int num = iter.next();
            if ( num % 2 != 0 ) {
                iter.remove();
            }
        }
    }
}
