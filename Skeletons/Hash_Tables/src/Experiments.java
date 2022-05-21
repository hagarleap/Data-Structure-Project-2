import java.util.HashSet;
import java.util.Set;
import java.util.Random;


public class Experiments {
    public static void main(String[] args){
//        Set<Integer> set_QP = new HashSet<>();
//        Set<Integer> set_AQP = new HashSet<>();
//        int q = 6571;
//        for(int i = 0; i<q; i++){
//            set_QP.add(Math.floorMod((i*i), q));
//            set_AQP.add(Math.floorMod(((int)(Math.pow(-1,i))*i*i), q));
//        }
//        System.out.println(set_QP.size());
//        System.out.println(set_AQP.size());
//
//        for(int k=0; k<100; k++){
//            Random rand = new Random();
//            QPHashTable quad = new QPHashTable(6571, 1000000007);
//            int error_count = 0;
//            int insert_count = 0;
//            for(int i=0; i<6571; i++){
//                int b = rand.nextInt(100);
//                HashTableElement hte = new HashTableElement((100*i+b), i);
//                try{
//                    quad.Insert(hte);
//                    insert_count ++;
//                }
//                catch (IHashTable.TableIsFullException ex){
//                    error_count++;
//
//                }
//                catch(IHashTable.KeyAlreadyExistsException ex){
//                    error_count++;
//                }
//
//            }
//            System.out.println("amt of errors: "+ error_count + "\nexperiment: " + k + "\nlength" + insert_count);
//            System.out.println("finished experiment: "+ k );
//        }


        int p = 1000000007;
        int m =10000019;

        Random rand = new Random();
        // QPHashTable quad = new QPHashTable( m, p);
        //AQPHashTable quad = new AQPHashTable( m, p);
        // LPHashTable quad = new LPHashTable( m, p);
        DoubleHashTable quad = new DoubleHashTable( m, p);
        //int error_count=0;
        //int insert_count = 0;
        int answer = Math.floorDiv(m*19, 20);
        long startTime = System.nanoTime();
        //for(int i=0; i<5000009; i++){
        for(int i=0; i<answer; i++){
        int b = rand.nextInt(100);
            HashTableElement hte = new HashTableElement((100*i+b), i);
            try{
                quad.Insert(hte);
                //insert_count ++;
            }
            catch (IHashTable.TableIsFullException ex){
                //error_count++;
            }
            catch(IHashTable.KeyAlreadyExistsException ex){
            }
        }
        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println((totalTime/1000000000.0));
        // System.out.println("error count " + error_count);
        //System.out.println("insert count " + insert_count);


    }


}
