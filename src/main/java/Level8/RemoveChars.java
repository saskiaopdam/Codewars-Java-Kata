package Level8;// Codewars Kata - 8 kyu
// Remove First and Last Character - https://www.codewars.com/kata/56bc28ad5bdaeb48760009b0

public class RemoveChars {
    public static String remove(String str) {
        return str.substring(1, str.length() - 1);
    }
}
