import java.io.File;

public class Recursion
{
    /*
    I saw this listed when reviewing something and I'm unsure if you want this to be using an array
    like the example as the assignment doesn't specify that (or it seemingly doesn't, the wording
    can go either way). Nonetheless, If it's meant to get the combined value of int[] m that shouldn't
    be too difficult but I presume the practice isn't one for one of what was done in class so I'm
    going to leave it like produce as m*n
     */
    public static int product(int m, int n)
    {
        if (m < 0 || n < 0) return -1;
        else if (n == 1) return m;
        else
        {
            int _m = m+m;
            if (n > 2)
            {
                return product(2, _m, n, m);
            }
            else
            {
                return _m;
            }
        }
    }

    private static int product(int current, int m, int n, int om)
    {
        if (m < 0 || n < 0) return -1;
        else if (current < n)
        {
            int _m = m + om;
            return product(current + 1, _m, n, om);
        }
        else
        {
            return m;
        }
    }

    public static boolean isPalindrome(String _string)
    {
        //Added this in case there's capitalization issues
        _string = _string.toLowerCase();
        //if (_string.length() < 1) return false;
        if (_string.length()==1) return true;
        //Replaced the substring text with charAt as it seems to work better
        else if (_string.length()==2 && _string.charAt(0) == _string.charAt(1))
        {
            return true;
        }
        else if (_string.length() > 2 && _string.charAt(0) == _string.charAt(_string.length()-1))
        {
            return isPalindrome(_string, 1, true);
        }
        else return false;
    }

    private static boolean isPalindrome(String _string, int cpos, boolean returnCheck)
    {
        if (cpos == (_string.length()/2) || cpos == (_string.length()/2+1)) return returnCheck;
        if (_string.charAt(cpos) == _string.charAt(_string.length()-(1+cpos)))
        {
            return isPalindrome(_string,cpos+1,returnCheck);
        }
        else return false;
    }

    public static String[] find(File path, String fileName)
    {
        if (!path.isDirectory() || path.list().length < 1) return null;
        else
        {
            fileName = fileName.toLowerCase();
            String[] files = {};
            //Check if it's the only item
            if (path.list()[0].toLowerCase() == fileName && path.list().length > 1)
            {
                files[0] = path.list()[0];
                return find(path, fileName, files,1);
            }
            else if (path.list()[0].toLowerCase() == fileName && path.list().length == 1 )
            {
                files[0] = path.list()[0];
                return files;
            }
            else return null;
        }
    }

    private static String[] find(File path, String fileName, String[] foundFiles, int targetFileIndex)
    {
        if (path.list()[targetFileIndex].toLowerCase() == fileName && targetFileIndex == path.list().length-1)
        {
            foundFiles[foundFiles.length] = path.list()[targetFileIndex];
            return foundFiles;
        }
        else if (path.list()[targetFileIndex].toLowerCase() == fileName)
        {
            foundFiles[foundFiles.length] = path.list()[targetFileIndex];
            return find(path, fileName, foundFiles, targetFileIndex+1);
        }
        else if (targetFileIndex == path.list().length-1)
        {
            return foundFiles;
        }
        else
        {
            return find(path, fileName, foundFiles, targetFileIndex+1);
        }
    }
}
