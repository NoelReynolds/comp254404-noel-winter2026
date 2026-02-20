public class Main
{
    public static void main(String[] args)
    {
        //Excercise 1:
        System.out.println("Product of 5 and 3 is " + Recursion.product(5,3));

        //Excercise 2:
        System.out.println("Is the word 'potato' a palindrome? Answer: " + Recursion.isPalindrome("Potato"));
        System.out.println("Is the phrase 'tacocat' a palindrome? Answer: " + Recursion.isPalindrome("tacocat"));

        //Excercise 3:
        System.out.println("The following is a list of files named 'potato' in 'C:\\Users\\Noel\\Downloads\\TestFolder':");
        //String[] files = Recursion.find("C:\\\\Users\\\\Noel\\\\Downloads\\\\TestFolder", "Potato");
        /*I actually don't know how to pass a 'File' object...*/
        /*for (int i = 0; i < files.Length; i++)
        {
            System.out.println(files[i]);
        }*/
    }
}