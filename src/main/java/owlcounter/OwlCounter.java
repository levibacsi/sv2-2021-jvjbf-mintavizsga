package owlcounter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class OwlCounter {
    private List<String> owls = new ArrayList<>();

    public void readFromFile(Path path){
        try {
            owls = Files.readAllLines(path);
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Can not read file.", ioe);
        }
    }

    public int getNumberOfOwls(String county){
        for (String owlsByCounty: owls) {
            String[] countyAndOwlNumber = owlsByCounty.split("=");
            if (countyAndOwlNumber[0].equals(county)) {
                return Integer.parseInt(countyAndOwlNumber[1]);
            }
        }
        throw new IllegalArgumentException("No such county in Hungary!");
    }

    public int getNumberOfAllOwls(){
        int numberOfAllOwls = 0;
        for (String owlsByCounty: owls) {
            String[] countyAndOwlNumber = owlsByCounty.split("=");
            numberOfAllOwls += Integer.parseInt(countyAndOwlNumber[1]);
        }
        return numberOfAllOwls;
    }

    public List<String> getOwls() {
        return owls;
    }
}