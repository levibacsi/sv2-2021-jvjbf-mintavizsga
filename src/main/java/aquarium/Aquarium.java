package aquarium;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {
    private List<Fish> fishList = new ArrayList<>();
    public static final int CAPACITY = 20;
    public static final int WATERBYFISH = 5;
    private int currentCapacity;

    public void addFish(Fish fish){
        if (currentCapacity <= CAPACITY - WATERBYFISH){
            fishList.add(fish);
            currentCapacity += WATERBYFISH;
        } else {
            throw new  IllegalStateException("Can not add fish because there is no more space.");
        }
    }

    public void feed(){
        for (Fish f: fishList){
            f.feed();
        }
    }

    public void removeFish(int maxWeight){
        fishList.removeIf(f -> f.weight > maxWeight);
    }

    public List<String> getStatus(){
        List<String> statusList = new ArrayList<>();
        for (Fish f: fishList){
            statusList.add(f.getStatus());
        }
        return statusList;
    }

    public int getNumberOfFishWithMemoryLoss(){
        int numberOfFishWithMemoryLoss = 0;
        for (Fish f: fishList){
            if (f.hasMemoryLoss()){
                numberOfFishWithMemoryLoss++;
            }
        }
        return numberOfFishWithMemoryLoss;
    }

    public boolean isThereFishWithGivenColor(String color){
        for (Fish f: fishList){
            if (f.getColor().equals(color)){
                return true;
            }
        }
        return false;
    }

    public Fish getSmallestFish(){
        int smallestWeight = fishList.get(0).getWeight();
        Fish smallestFish = fishList.get(0);
        for (Fish f: fishList) {
            if (f.getWeight() < smallestWeight) {
                smallestWeight = f.getWeight();
                smallestFish = f;
            }
        }
        return smallestFish;
    }
}