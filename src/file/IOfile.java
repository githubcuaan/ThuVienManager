package file;

import java.io.*;
import java.util.ArrayList;

public class IOfile<T> {

    // write
    public void writeFile(ArrayList<T> list, String path) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path)))
        {
            oos.writeObject(list);
        } catch (IOException ex) {
            System.out.println("Error: writing to file");
            ex.printStackTrace();
        }
    }

    // read file
    public ArrayList<T> readFile(String path) {
        File f = new File(path);
        if (!f.exists()) {
            System.out.println("Error: file does not exist");
            return new ArrayList<>();
        }

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            return (ArrayList<T>) ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Error: reading file");
            ex.printStackTrace();
        }

        return new ArrayList<>();
    }
}
