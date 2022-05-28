import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class experiment_2 {
     public static void main(String[] args) {
         int p = 1000000007;
         int m = 10000019;
         for(int j=0; j<3; j++) {
             System.out.println("trial "+j);
             Random rand = new Random();
             QPHashTable quad1 = new QPHashTable(m, p);
             AQPHashTable quad2 = new AQPHashTable(m, p);
             LPHashTable quad3 = new LPHashTable(m, p);
             DoubleHashTable quad4 = new DoubleHashTable(m, p);
             //int error_count=0;
             //int insert_count = 0;
             int answer = Math.floorDiv(m * 19, 20);
             Collection<OAHashTable> quadlist = new ArrayList<>();
             quadlist.add(quad1);
             quadlist.add(quad2);
             quadlist.add(quad3);
             quadlist.add(quad4);

             List<HashTableElement> elemList = new ArrayList<>();
             for(int i = 0; i < 5000009; i++){
                 int b = rand.nextInt(100);
                 HashTableElement hte = new HashTableElement((100 * i + b), i);
                 elemList.add(hte);
             }

             for (OAHashTable quad : quadlist) {
                 long startTime = System.nanoTime();
                 for (HashTableElement hte: elemList) {
                     try {
                         quad.Insert(hte);
                         //insert_count ++;
                     } catch (IHashTable.TableIsFullException ex) {
                         //error_count++;
                     } catch (IHashTable.KeyAlreadyExistsException ex) {
                     }
                 }
                 long endTime = System.nanoTime();
                 long totalTime = endTime - startTime;
                 System.out.println("experiment "+ quad.getClass().getSimpleName() +": "+ (totalTime / 1000000000.0));
             }
         }
         System.out.println("experiment 2 part 2");
         for(int j=0; j<3; j++) {
             System.out.println("trial "+j);
             Random rand = new Random();
             AQPHashTable quad2 = new AQPHashTable(m, p);
             LPHashTable quad3 = new LPHashTable(m, p);
             DoubleHashTable quad4 = new DoubleHashTable(m, p);
             //int error_count=0;
             //int insert_count = 0;
             int answer = Math.floorDiv(m * 19, 20);
             Collection<OAHashTable> quadlist = new ArrayList<>();
             quadlist.add(quad2);
             quadlist.add(quad3);
             quadlist.add(quad4);

             List<HashTableElement> elemList = new ArrayList<>();
             for(int i = 0; i < answer; i++){
                 int b = rand.nextInt(100);
                 HashTableElement hte = new HashTableElement((100 * i + b), i);
                 elemList.add(hte);
             }

             for (OAHashTable quad : quadlist) {
                 long startTime = System.nanoTime();

                 for (HashTableElement hte: elemList) {
                     try {
                         quad.Insert(hte);
                         //insert_count ++;
                     } catch (IHashTable.TableIsFullException ex) {
                         //error_count++;
                     } catch (IHashTable.KeyAlreadyExistsException ex) {
                     }
                 }
                 long endTime = System.nanoTime();
                 long totalTime = endTime - startTime;
                 System.out.println("experiment "+ quad.getClass().getSimpleName() +": "+(totalTime / 1000000000.0));
             }
         }
    }
}
