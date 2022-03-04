package Utilities;

import LabStuff.LabWork;
import com.google.gson.Gson;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Vector;
import java.io.FileOutputStream;
import java.lang.reflect.Type;

/**
 * Класс для записи в файл
 */
public class FileWriter {
    private static final String envPath = System.getenv("FILE_LOCATION");


    public static String getFilePath() {
        return envPath;
    }

    public static void writeToFile(Vector<LabWork> labWorks){
        Gson gson = new Gson();
        //File file = new File(envPath);
        try(FileOutputStream fout = new FileOutputStream(envPath)){
            String a = gson.toJson(labWorks);
            //byte[] buffer = a.getBytes(StandardCharsets.UTF_8);
            fout.write(a.getBytes(StandardCharsets.UTF_8));
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка! Файл закрыт для записи, коллекция не сохранена");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

