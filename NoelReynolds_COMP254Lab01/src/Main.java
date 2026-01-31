//Name: Noel Reynolds
//Id: 301517365

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Exercise 1:\n");

        DoubleList<String> L = new DoubleList();
        L.addToFront("1");
        L.addToFront("2");
        L.addToFront("3");

        DoubleList<String> M = new DoubleList();
        M.addToFront("4");
        M.addToFront("5");
        M.addToFront("6");

        DoubleList<String>[] dl = new DoubleList[]{M, L};

        SingleList<String> L2 = DoubleList.doubleListToSingle(dl);

        System.out.println(L2.toString());

        //-----------------------------------
        System.out.println("\nExercise 2:\n");

        SingleList<String> sl = new SingleList<>();
        System.out.println("Original List:\n");
        sl.addToFront("E");
        sl.addToFront("D");
        sl.addToFront("C");
        sl.addToFront("B");
        sl.addToFront("A");
        System.out.println(sl.toString());
        System.out.println("\nSwapping 'A' and 'C':\n");
        sl.swapNodes(sl.getNode(1), sl.getNode(3)); //Swap nodes
        System.out.println(sl.toString());

        //---------------------------------------
        System.out.println("\nExercise 3:\n");

        CircleList<String> cl = new CircleList<String>("Head");
        cl.addToFront("Body");
        cl.addToFront("Tail");

        System.out.println(cl.toString());

        CircleList<String> nl = cl.clone();

        System.out.println("Cloned Circle List: \n");
        System.out.println(nl.toString());
    }
}