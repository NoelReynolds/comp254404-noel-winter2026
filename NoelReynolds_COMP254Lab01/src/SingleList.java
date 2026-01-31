//Name: Noel Reynolds
//Id: 301517365

//Exercise 2
public class SingleList<E>
{
    private static class Node<E>
    {
        //Element declaration
        private E element;
        private Node<E> next;
        //Methods
        public Node(E e, Node<E> n)
        {
            element = e;
            next = n;
        }
        public E getElement() { return element; }
        public Node<E> getNext() { return next; }
        public void setNext(Node <E> n) { next = n; }
    }
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;
    //'Constructor'
    public SingleList() {}
    public int getSize() { return size; }
    //
    public Node<E> getNode(int posNum)
    {
        if (size == 0) { return null; }
        Node<E> rn = null; //Return node
        for (int i = 0; i < posNum; i++) {
            if (i == 0) { rn = head; }
            else
            {
                rn = rn.getNext();
            }
        }
        return rn;
    }
    //Phrases the list into a string
    public String toString()
    {
        if (size <= 0) { return null; }
        String str = "";
        Node<E> n_ = null;
        for (int i = 0; i < (size); i++) {
            //Unique check for head
            if (i == 0)
            {
                n_ = head;
            }
            else
            {
                n_ = n_.getNext();
            }
            str += n_.getElement();
        }
        return str;
    }
    public void addToFront(E e)
    {
        Node<E> newNode = new Node<>(e, null);
        if (head != null) { newNode.setNext(head); }
        head = newNode;
        size++;
    }
    //Swaps nodes
    public void swapNodes(Node<E> n_1, Node<E> n_2)
    {
        if (n_1 == n_2) { return; } //Return early if they are the same
        try
        {
            //Temporary nodes (storage)
            Node<E> tn_1 = null; //temporary nodes
            Node<E> tn_2 = null;
            Node<E> pn_1 = null; //Prior node(s)
            Node<E> pn_2 = null;
            boolean usesHeadNode = false; //Special boolean check for switches involving head nodes
            //Check list for nodes
            for (int i = 0; i < size; i++) {
                if (i == 0) { tn_1 = head; }
                else
                {
                    tn_1 = tn_1.getNext();
                }
                if (tn_1 == n_1)
                {
                    if (tn_1 == head) { usesHeadNode = true; }
                    break;
                }
            }
            for (int i = 0; i < size; i++) {
                if (i == 0) { tn_2 = head; }
                else
                {
                    tn_2 = tn_2.getNext();
                }
                if (tn_2 == n_2)
                {
                    if (tn_2 == head) { usesHeadNode = true; }
                    break;
                }
            }
            //Actually swapping
            if (usesHeadNode) //Special code if swaping involves a head node
            {
                pn_1 = head;
                Node<E> pn_0 = head.getNext();
                for (int i = 1; i < size; i++) {
                    pn_1 = pn_1.getNext();
                    if (n_1 == pn_1.getNext())
                    {

                        pn_1.setNext(n_2);
                        if (n_1.getNext() != null) { n_2.setNext(n_1.getNext()); }
                        n_1.setNext(pn_0);
                        head = n_1;
                        break;
                    }
                    else if (n_2 == pn_1.getNext())
                    {
                        pn_1.setNext(n_1);
                        if (n_2.getNext() != null) { n_1.setNext(n_2.getNext()); }
                        n_2.setNext(pn_0);
                        head = n_2;
                        break;
                    }
                }
            }
            else //Regular swapping
            {
                //Getting prior nodes...
                for (int i = 1; i < size; i++) {
                    if (i == 0) { pn_1 = head; }
                    else
                    {
                        pn_1 = pn_1.getNext();
                    }
                    if (n_1 == pn_1.getNext())
                    {
                        break;
                    }
                }
                for (int i = 0; i < size; i++) {
                    if (i == 0) { pn_2 = head; }
                    else
                    {
                        pn_2 = pn_2.getNext();
                    }
                    if (n_2 == pn_2.getNext())
                    {
                        break;
                    }
                }
                //Swapping them
                if (pn_1 != null && pn_2 != null)
                {
                    pn_1.setNext(n_2);
                    if (n_1.getNext() != null) { n_2.setNext(n_1.getNext()); }
                    pn_2.setNext(n_1);
                    if (tn_2.getNext() != null) { n_1.setNext(tn_2.getNext()); } //Use the temporary node to avoid breaking
                }
            }
        }
        catch (Exception e)
        {
            //
        }
    }
}
