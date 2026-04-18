import java.util.Stack;
import java.util.List;
import java.util.Queue;

public class Main
{
    public static void main(String[] args)
    {
        //System.out.printf("Hello and welcome!");

        //Excercise 1:

        //PositionalList

        //Excercise 2:
        Stack<String> _s = new Stack<>();
        _s.push("Apple");
        _s.push("Pear");
        _s.push("Oranage");
        Stack<String> _t = new Stack<>();
        _t.push("Cat");
        _t.push("Dog");
        _t.push("Bird");
        _t = transfer(_s, _t);
        System.out.println(_t.toString());

        //Excercise 3:

    }

    public static Stack transfer(Stack S, Stack T)
    {
        if (S.size() <= 0 || T.size() < 0) return null;
        Stack _T = T;
        Stack _S = S;

        while (!_S.isEmpty())
        {
            Object e = _S.peek();
            _T.push(e);
            _S.pop();
        }

        return _T;
    }
}