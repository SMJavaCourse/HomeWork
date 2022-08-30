package helper;

public class SearchTimeDemo {
    public static void main (String[] args){
        long start = System.currentTimeMillis();
        long end = System.currentTimeMillis() - start;
        System.out.printf("Найдено за %s ms: %s\n", end);
    }
}
