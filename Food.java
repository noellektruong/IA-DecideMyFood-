import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Food {
    String name;
    String ingredients;
    Set<String> characteristics;

    public Food(String name, String ingredients, String... characteristics) {
        this.name = name;
        this.ingredients = ingredients;
        this.characteristics = new HashSet<String>(
            Arrays.asList(characteristics)
        );
    }
}