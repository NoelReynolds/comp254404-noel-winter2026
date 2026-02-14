public class Main
{
    private enum UniqueTest
    {
        TEST_1,
        TEST_2
    }

    public static void main(String[] args)
    {
        //Excercise 1:
        //Also commented above each function in the Exercises class
        System.out.println("Example 1 has a Big-Oh as; n is O(n)");
        System.out.println("Example 2 has a Big-Oh as; (1/2)n is O(n)");
        System.out.println("Example 3 has a Big-Oh as; n^2 is O(n)");
        System.out.println("Example 4 has a Big-Oh as; n is O(n)"); //The same as the first? It looks different but shouldn't run longer I think
        System.out.println("Example 5 has a Big-Oh as; n^3 is O(n)");

        //Excercise 2:
        //Example array
        double[] doub = {1, 1, 3, 5, 5, 5, 7, 7, 9, 13};
        //Start recording time
        long doub1Start = System.currentTimeMillis();
        //Dummy value (taken but never assigned)
        double[] doub1Dummy = PrefixAverage.prefixAverage1(doub);
        //End time
        long doub1End = System.currentTimeMillis();
        long doub1Time = doub1End - doub1Start;
        //Ditto with alt test
        long doub2Start = System.currentTimeMillis();
        double[] doub2Dummy = PrefixAverage.prefixAverage2(doub); //Decided there's no need to use a different array
        long doub2End = System.currentTimeMillis();
        long doub2Time = doub2End - doub2Start;
        System.out.println("Prefix Average 1 took " + doub1Time + " additional milisecond(s),\n"
        + "Prefix Average 2 took " + doub2Time + " additional milisecond(s)");

        //Excercise 3:
        int[] arr = {1};
        //Commented out due to an error
        /*System.out.println("Unique1 returns under a minute with a highest value of " + binarySearchTick(UniqueTest.TEST_1,arr,3600000)
        + "\nAnd unique2 returns under a minute with a highest value of " + binarySearchTick(UniqueTest.TEST_2,arr,3600000));*/
    }

    public static int binarySearchTick(UniqueTest test, int[] arr, long targetTick)
    //public static int binarySearchTick(UniqueTest test, int[] arr, int targetTick)
    {
        //if (low > high) { return -1; }
        //else
        //{
            long tick = System.currentTimeMillis();
            //int tick = (int)System.currentTimeMillis();
            if (test == UniqueTest.TEST_1)
            {
                if (Uniqueness.unique1(arr))
                {
                    System.out.println("Test 1");
                }
            }
            if (test == UniqueTest.TEST_2)
            {
                if (Uniqueness.unique2(arr))
                {
                    System.out.println("Test 2");
                }
            }
            long endTick = System.currentTimeMillis();
            //int endTick = (int)System.currentTimeMillis();
            long elapse = endTick - tick;
            //int elapse = endTick - tick;

            System.out.println(elapse);

            if (elapse == targetTick) { return arr.length; }
            else if (elapse < targetTick)
            {
                int[] _arr = generateArray(arr.length+1);
                return binarySearchTick(test, arr, targetTick, arr.length, _arr.length, (int)elapse);
                //return binarySearchTick(test, arr, targetTick, arr.length, _arr.length, elapse);
            }
            else
            {
                int[] _arr = generateArray(arr.length-1);
                return binarySearchTick(test, arr, targetTick, arr.length, _arr.length, (int)elapse);
                //return binarySearchTick(test, arr, targetTick, arr.length, _arr.length, elapse);
            }

            //int mid = (low + high) / 2;
            //
            //do
            //{
                //if (test == UniqueTest.TEST_1)
                //{

                    /*do
                    {
                        tick++;

                    } while (tick < targetTick && !Uniqueness.unique1(arr));
                    if (tick < targetTick && !Uniqueness.unique1(arr))
                    {
                        tick++;
                    }
                    else
                    {

                    }*/
                //}
            //}

            //if (targetTick == data[mid]) { return true; }
            //else if (target < data[mid]) { return binarySearch(data,target,low,mid-1); }
            //else { return binarySearch(data, target, mid+1, high); }
        //}
        /*int tick = 0;
        int[] n = {1};
        int priorSize = 1;
        int lowN = 1;
        int highN = 9999;
        boolean hasResult = false;
        while (!hasResult)
        {
            if (test == UniqueTest.TEST_1)
            {
                do
                {
                    tick++;
                } while (tick <= 1200 && !Uniqueness.unique1(n));
            } else if (test == UniqueTest.TEST_2) {
                
            } else { return -1; }

        }
        return tick;*/
    }

    public static int binarySearchTick(UniqueTest test, int[] arr, long targetTick, int low, int high, int prior)
    //public static int binarySearchTick(UniqueTest test, int[] arr, int targetTick, int low, int high, int prior)
    {
        //if (low > high) { return -1; }
        long tick = System.currentTimeMillis();
        //int tick = (int)System.currentTimeMillis();
        if (test == UniqueTest.TEST_1)
        {
            if (Uniqueness.unique1(arr))
            {
                System.out.println("Test 1");
            }
        }
        if (test == UniqueTest.TEST_2)
        {
            if (Uniqueness.unique2(arr))
            {
                System.out.println("Test 2");
            }
        }
        long endTick = System.currentTimeMillis();
        //int endTick = (int)System.currentTimeMillis();
        long elapse = endTick - tick;
        //int elapse = endTick - tick;

        System.out.println(elapse);

        if (elapse == targetTick) { return arr.length; }
        else if (elapse > targetTick && low == high) { return prior; }
        else if (elapse < targetTick)
        {
            int[] _arr = generateArray(arr.length+1);
            return binarySearchTick(test, arr, targetTick, arr.length, _arr.length, (int)elapse);
            //return binarySearchTick(test, arr, targetTick, arr.length, _arr.length, elapse);
        }
        else
        {
            int[] _arr = generateArray(arr.length-1);
            return binarySearchTick(test, arr, targetTick, arr.length, _arr.length, (int)elapse);
            //return binarySearchTick(test, arr, targetTick, arr.length, _arr.length, elapse);
        }
    }

    //Binary Search from the lab
    public static boolean binarySearch(int[] data, int target, int low, int high)
    {
        if (low > high) { return false; }
        else
        {
            int mid = (low + high) / 2;
            if (target == data[mid]) { return true; }
            else if (target < data[mid]) { return binarySearch(data,target,low,mid-1); }
            else { return binarySearch(data, target, mid+1, high); }
        }
    }

    //Based off of the example from the lab
    /*public static int binarySearch(UniqueTest t)
    {
        if (t == null) { return -1; }
        //Variable declations
        int[] arr = {1,2};
        int arrSize = 2;
        int tick = 0;
        //Placeholders, values are also placeholder
        int lowArr = 2;
        int highArr = 400000;
        //
        boolean testConclusion = false;
        //Check for tick 1200 (1 minute?)
        while (!testConclusion)
        {
            if (t == UniqueTest.TEST_1)
            {
                do
                {
                    tick++;
                } while (!Uniqueness.unique1(arr));
                if (tick > 1200)
                {
                    highArr = arr.length;
                    tick = 0;
                }
            }
            else if (t == UniqueTest.TEST_2)
            {

            }
        }
        /*while (tick != 1199)
        {
            //int disTick = tick+1;
            //System.out.println("Tick test, Tick: " + disTick);
            if (t == UniqueTest.TEST_1)
            {
                //System.out.println("Tick test, Tick: " + disTick);
                do
                {
                    tick++;
                    //System.out.println("Tick: " + tick);
                } while (!Uniqueness.unique1(arr));
                if (Uniqueness.unique1(arr))
                {
                    arr = generateArray(arrSize*arrSize);
                    arrSize = arr.length;
                    System.out.println("Tick: " + tick);
                    System.out.println("Array length: " + arr.length);
                    tick = 0;
                }
            }
            else if (t == UniqueTest.TEST_2)
            {
                do { tick++; } while (!Uniqueness.unique2(arr));
                if (Uniqueness.unique2(arr))
                {
                    arr = extendArray(arr);
                    tick = 0;
                }
            }
        }*//*
        return arr.length;
    }*/

    static public int[] generateArray(int size)
    {
        if (size < 1) { return null; }
        int[] _arr = new int[size];
        for (int i = 0; i < size; i++) {
            _arr[i] = i+1;
        }
        return _arr;
    }

    static public int[] extendArray(int[] _arr)
    {
        int[] _new = new int[_arr.length+1];
        for (int i = 0; i < _arr.length; i++) {
            _new[i] = _arr[i];
        }
        _new[_arr.length] = _arr.length+1;
        return _new;
    }
}
