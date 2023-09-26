import java.util.ArrayList;
import java.util.Random;

public class das {

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");
        list.add("Mango");

        Random rand = new Random();
        int lastIndex = -1;

        for(int i=0; i<5; i++) {

            int index;
            do {
                index = rand.nextInt(list.size());
            } while(index == lastIndex);

            String randomString = list.get(index);
            System.out.println(randomString);

            lastIndex = index;
        }

    }

}