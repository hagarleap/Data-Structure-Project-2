import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class experimen_3 {
    public static void main(String[] args) {
        /////////////////////////experiment 3////////////////////
        for(int g=0; g<10; g++) {
            int p = 1000000007;
            int m = 10000019;
            DoubleHashTable doub_hash = new DoubleHashTable(m, p);

            for (int i = 0; i < 6; i++) {
                // create list of rand ints
                List<HashTableElement> rand_set = new ArrayList<>();
                Random rand = new Random();
                for (int j = 0; j < (m / 2); j++) {
                    int b = rand.nextInt(100);
                    HashTableElement hte = new HashTableElement((100 * j + b), j);
                    rand_set.add(hte);
                }
                //add rand int set into list

                long startTime = System.nanoTime();
                for (HashTableElement hte : rand_set) {

                    try {
                        doub_hash.Insert(hte);
                    } catch (IHashTable.TableIsFullException ex) {
                        System.out.println("table seems full!");
                    } catch (IHashTable.KeyAlreadyExistsException ex) {
                        System.out.println("double key exception");
                    }

                }
                for (HashTableElement hte : rand_set) {
                    try {
                        doub_hash.Delete(hte.GetKey());
                    } catch (IHashTable.KeyDoesntExistException ex) {
                        System.out.println("key was not found!");
                    }

                }

                long endTime = System.nanoTime();
                long totalTime = endTime - startTime;
                System.out.println("experiment " + i + ": " + (totalTime / 1000000000.0));
            }


        }

    }
}
