package utilities;

import java.io.*;

/**
 * Класс для чтения файлов
 */

public class FileReader {
    private static final String envPath = System.getenv("FILE_LOCATION");

    public static String getFilePath() {
        return envPath;
    }

    public static String readFromFile() {
        try (BufferedInputStream bufferedReader = new BufferedInputStream(new FileInputStream(envPath))) {
            String data = "";
            int i;
            InputStreamReader ab = new InputStreamReader(bufferedReader, "UTF8");
            while ((i = ab.read()) != -1) {
                data += (char)i ;
            }
            return data;
        } catch (NullPointerException e) {
            System.out.println("Вы забыли указать имя файла.");
            return null;
        } catch (FileNotFoundException e) {
            System.out.println("Указанного файла нет или он закрыт для чтения.");
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
