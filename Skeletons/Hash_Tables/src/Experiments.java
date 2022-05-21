import java.util.*;


public class Experiments {
    public static void main(String[] args) {
///////////////////////experiment 1////////////////////
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

///////////////////////experiment 2////////////////////
//        int p = 1000000007;
//        int m = 10000019;
//
//        Random rand = new Random();
//        QPHashTable quad1 = new QPHashTable(m, p);
//        AQPHashTable quad2 = new AQPHashTable(m, p);
//        LPHashTable quad3 = new LPHashTable(m, p);
//        DoubleHashTable quad4 = new DoubleHashTable(m, p);
//        //int error_count=0;
//        //int insert_count = 0;
//        int answer = Math.floorDiv(m*19, 20);
//        Collection<OAHashTable> quadlist = new ArrayList<>();
//
//        quadlist.add(quad2);
//        quadlist.add(quad3);
//        quadlist.add(quad4);
//
//        for (OAHashTable quad : quadlist) {
//            long startTime = System.nanoTime();
////            for (int i = 0; i < 5000009; i++) {
//        for(int i=0; i<answer; i++){
//                int b = rand.nextInt(100);
//                HashTableElement hte = new HashTableElement((100 * i + b), i);
//                try {
//                    quad.Insert(hte);
//                    //insert_count ++;
//                } catch (IHashTable.TableIsFullException ex) {
//                    //error_count++;
//                }
//                catch (IHashTable.KeyAlreadyExistsException ex) {
//                }
//            }
//            long endTime = System.nanoTime();
//            long totalTime = endTime - startTime;
//            System.out.println((totalTime / 1000000000.0));
//        }

///////////////////////experiment 3////////////////////
        int p = 1000000007;
        int m = 10000019;
        DoubleHashTable doub_hash = new DoubleHashTable(m, p);

        for(int i = 0; i<6; i++){
            // create list of rand ints
            List<Integer> rand_set = new ArrayList<>();
            Random rand = new Random();
            for(int j = 0; j < 5000009; j++){
                int b = rand.nextInt(100);
                rand_set.add((100 * j + b));
            }
            //add rand int set into list

            long startTime = System.nanoTime();
            for(Integer rand_elem: rand_set){

                HashTableElement hte = new HashTableElement(rand_elem, 0);

                try{ doub_hash.Insert(hte); }

                catch (IHashTable.TableIsFullException ex) {}

                catch (IHashTable.KeyAlreadyExistsException ex) {
                    System.out.println("double key exception");
                }

                }
            for(Integer rand_elem: rand_set){
                try{doub_hash.Delete(rand_elem);
                }
                catch (IHashTable.KeyDoesntExistException ex){
                    System.out.println("delete_error");
                }

            }

            long endTime = System.nanoTime();
            long totalTime = endTime - startTime;
            System.out.println("experiment " + i+ ": " + (totalTime / 1000000000.0));
        }




    }

}
