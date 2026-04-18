//Name: Noel Reynolds
//Student ID: 301517365

import borrowedFiles.LinkedQueue;

public class Main
{
    //Files in the 'borrowedFiles' folder are taken from the GitHub for base files, except any "Modified" classes

    public static void main(String[] args)
    {
        //I would preform demos or tests here, but I'm having trouble with the Elements as per usual
    }

    //Excercise 2 code (made using ints for simplification):
    public static LinkedQueue mergeQueue(int[] ints)
    {
        if (ints.length < 1) return null;
        if (ints.length == 1)
        {
            LinkedQueue<Integer> q_ = new LinkedQueue<>();
            q_.enqueue(ints[0]);
            return q_;
        }
        else
        {
            //Each item queued
            LinkedQueue<Integer> finalQueue = new LinkedQueue<>();
            LinkedQueue<LinkedQueue<Integer>> masterQueue = new LinkedQueue<>();
            for (int i = 0; i < ints.length; i++) {
                LinkedQueue<Integer> nq = new LinkedQueue<>();
                nq.enqueue(ints[i]);
                masterQueue.enqueue(nq);
            }
            //Set the values for final queue's start
            LinkedQueue<Integer> sq1 = new LinkedQueue<>();
            LinkedQueue<Integer> sq2 = new LinkedQueue<>();
            sq1.enqueue(masterQueue.dequeue().dequeue());
            sq2.enqueue(masterQueue.dequeue().dequeue());
            if (sq1.first() < sq2.first())
            {
                finalQueue.enqueue(sq1.dequeue());
                finalQueue.enqueue(sq2.dequeue());
            }
            else
            {
                finalQueue.enqueue(sq2.dequeue());
                finalQueue.enqueue(sq2.dequeue());
            }
            //Recursion
            return mergeQueue(finalQueue, masterQueue);
        }
        /*LinkedQueue<LinkedQueue> masterQueue = new LinkedQueue<>(); //Returning queue
        LinkedQueue<LinkedQueue> dummyQueue = new LinkedQueue<>(); //Queue for storage
        LinkedQueue<LinkedQueue> dummyQueueAlt = new LinkedQueue<>(); //Queue for storage (larger temporaries)
        for (int i = 0; i < ints.length; i++) {
            LinkedQueue<Integer> queue = new LinkedQueue<>();
            queue.enqueue(ints[i]);
            dummyQueue.enqueue(queue);
        }
        //Split queues from the dummy queue
        while (dummyQueue.size()>1)
        {

        }
        return masterQueue;*/
    }

    private static LinkedQueue mergeQueue(LinkedQueue<Integer> finalQueue, LinkedQueue<LinkedQueue<Integer>> queues)
    {

        //
        return finalQueue;
    }
}