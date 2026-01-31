//Name: Noel Reynolds
//Id: 301517365

public class CircleList<E>
{
    //Code from lecture;
    private static class Node<E>
    {
        //Element declaration
        private E element;
        private CircleList.Node<E> next;
        //Methods
        public Node(E e, CircleList.Node<E> n)
        {
            element = e;
            next = n;
        }
        public E getElement() { return element; }
        public CircleList.Node<E> getNext() { return next; }
        public void setNext(CircleList.Node<E> n) { next = n; }
    }
    //private CircleList.Node<E> head = null;
    private CircleList.Node<E> tail = null;
    private int size = 0;
    public int size() { return size; }
    public void addToFront(E e)
    {
        if (size == 0)
        {
            tail = new Node<>(e, null);
            tail.setNext(tail);
        }
        else
        {
            Node<E> newest = new Node<>(e, tail.getNext());
            tail.setNext(newest);
        }
        size++;
    }
    //Original code;
    public CircleList(E e)
    {
        tail = new Node<>(e, null);
        tail.setNext(tail);
        size = 1;
    }
    /*public Node<E> getNode(int pos)
    {
        if (pos > size) { return null; }
        Node<E> node = null;
        for (int i = 0; i < pos; i++)
        {
            if (i == 0) { node = tail; }
            else { node = node.getNext(); }
            System.out.println(node.getElement());
        }
        return node;
    }*/
    public E getElementFromNodePos(int pos)
    {
        if (pos > size) { return null; }
        E e;
        Node<E> node = null;
        for (int i = 0; i < pos; i++)
        {
            if (i == 0) { node = tail; }
            else { node = node.getNext(); }
            //System.out.println(node.getElement());
        }
        return node.getElement();
    }
    public E getTailElement()
    {
        return tail.getElement();
    }
    public CircleList clone()
    {
        if (this.size == 0) { return null; }
        //CircleList _cl = cl.clone().getClass();
        CircleList _cl = new CircleList(this.getTailElement());
        for (int i = 1; i < this.size; i++) {
            _cl.addToFront(this.getElementFromNodePos(i+1));
        }
        return _cl;
    }
    public String toString()
    {
        if (this.size == 0) { return null; }
        String s = "Circle List:\n";
        for (int i = 0; i < size; i++) {
            s += (i+1) + ": " + this.getElementFromNodePos(i+1) + "\n";
        }
        return s;
    }
}
