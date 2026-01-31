//Name: Noel Reynolds
//Id: 301517365

public class DoubleList<E>
{
    //Modified Node
    private static class Node<E>
    {
        //Element declaration
        private E element;
        private DoubleList.Node<E> next;
        private DoubleList.Node<E> previous;
        //Methods
        public Node(E e, DoubleList.Node<E> n, DoubleList.Node<E> p)
        {
            element = e;
            next = n;
            previous = p;
        }
        public E getElement() { return element; }
        public DoubleList.Node<E> getNext() { return next; }
        public DoubleList.Node<E> getPrevious() { return previous; }
        public void setNext(DoubleList.Node<E> n) { next = n; }
        public void setPrevious(DoubleList.Node<E> p) { previous = p; }
    }
    private Node<E> header;
    private Node<E> tailer;
    private int size = 0;
    public DoubleList()
    {
        header = new Node<>(null, null, null);
        tailer = new Node<>(null, header, null);
        header.setNext(tailer);
    }
    public int size() { return size; }
    public boolean isEmpty() { return size==0; }
    public E first()
    {
        if (isEmpty()) return null;
        return header.getNext().getElement();
    }
    public E last()
    {
        if (isEmpty()) return null;
        return tailer.getPrevious().getElement();
    }

    //public void addFirst(E e) { addBetween(e, header, header.getNext()); }
    public void addToFront(E e) //Personal constructor
    {
        Node<E> nextNode = null;
        Node<E> previousNode = null;
        if (size==0)
        {
            Node<E> node = new Node<>(e, nextNode, previousNode);
            node.setNext(node);
            node.setPrevious(node);
            //System.out.println(node.getElement());
        }
        else
        {
            if (size == 1) { nextNode = getNode(0); }
            else { nextNode = getNode(1); }
            previousNode = getNode(size);
            Node<E> node = new Node<>(e, nextNode, previousNode);
            //System.out.println(node.getElement());
        }
        size++;
    }
    //public void addLast(E e) { addBetween(e, tailer, tailer.getPrevious()); }
    private void addBetween(E e, Node<E> predecessor, Node<E> successor)
    {
        //System.out.println(predecessor.getElement() + ", " + successor.getElement());
        Node<E> newest = new Node<>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrevious(newest);
        /*if (header.getElement() != null && tailer.getElement() == null)
        {
            tailer = newest;
        }
        else if (header.getElement() == null)
        {
            header = newest;
            tailer = new Node<>(e, null, null);
        }
        else
        {
            header = predecessor;
            tailer = successor;
        }*/
        this.size++;
    }
    //public Node<E> getHeader() { return header; }
    public Node<E> getNode(int pos)
    {
        if (pos > this.size) { return null; }
        Node<E> node = null;
        for (int i = 0; i < pos+1; i++)
        {
            if (i == 0) { node = header; }
            else { node = node.getNext(); }
        }
        return node;
    }
    //'Converter':
    static public SingleList doubleListToSingle(DoubleList[] doubleLists)
    {
        if (doubleLists.length == 0) { return null; }
        //Variables
        SingleList single = new SingleList<>();
        //Loop breaking down the lists:
        for (int i = 0; i < doubleLists.length; i++)
        {
            //DoubleList _double = doubleLists[i];
            Node node = doubleLists[i].header;
            //System.out.println((doubleLists[i].header.getElement()));
            for (int j = 0; j < doubleLists[i].size; j++)
            {
                if (j != 0) { node = node.getNext(); }
                single.addToFront(node.getElement());
                //single.addToFront(_double.getNode(j).getElement());
                //if (j == 0) { node = _double.header; }
                //else { node = node.getNext(); }
                //System.out.println(node.getElement());
                //node = _double.getNode(j);
                //single.addToFront(_double.getNode(j).getElement());
                //single.addToFront(node.getElement());
            }
        }
        return single;
    }
}
