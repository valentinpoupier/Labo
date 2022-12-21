package stage;

import persone.Personne;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class StageList implements Serializable {
    private Map<Stage, List<Personne>> stageList;

    public StageList(Map<Stage, List<Personne>> stageList) {
        this.stageList = stageList;
    }

    /*public void saveToFile(String fileName) {
        try (FileOutputStream fos = new FileOutputStream(fileName);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(stageList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
}

