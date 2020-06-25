package TestResources;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileReadWrite {
    String path = System.getProperty("user.dir");
    File tempFile;

    public File createFile(String fileText) throws IOException {
        tempFile = new File(path+"\\src\\test\\java\\TestResources\\tempFile.txt");
        tempFile.createNewFile();
        System.out.println("File is created");
        FileWriter fw = new FileWriter(tempFile);
        fw.write(fileText);
        fw.close();
        return tempFile;
    }

    public void writeFile() throws IOException{
        FileWriter fw = new FileWriter("tempFile.txt");
        fw.write("This is a my text");
        fw.flush();
    }

    public void readFile(File f) throws FileNotFoundException {
        Scanner sc = new Scanner(f);
        String data = null;
        while(sc.hasNextLine()){
            data = sc.nextLine();
        }
        System.out.println(data);
    }

    public void deleteFile(File f){
        f.delete();
    }
}
