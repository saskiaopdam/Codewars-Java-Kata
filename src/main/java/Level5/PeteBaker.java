package Level5;// Codewars Kata - 5 kyu
// Pete the Baker - https://www.codewars.com/kata/525c65e51bf619685c000059

import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

//public class PeteBaker {
//
//    public static int cakes(Map<String, Integer> recipe, Map<String, Integer> available) {
//        List<Integer> maxCakesWithThisIngredient = new ArrayList<>();
//
//        recipe.forEach((k, v) -> {
//            if (available.get(k) == null) {
//                maxCakesWithThisIngredient.add(0);
//            } else {
//                maxCakesWithThisIngredient.add((available.get(k)/v));
//            }
//        });
//
//        int maxCakes = Collections.min(maxCakesWithThisIngredient);
//
//        return maxCakes;
//    }
//}

public class PeteBaker {

    public static int cakes(Map<String, Integer> recipe, Map<String, Integer> available) {

        return recipe.entrySet().stream()
                .mapToInt(entry -> {
                    String ingredient = entry.getKey();
                    int requiredAmount = entry.getValue();
                    int availableAmount = available.getOrDefault(ingredient, 0);
                    return availableAmount / requiredAmount;

                })
                .min()
                .orElse(0);
    }
}
