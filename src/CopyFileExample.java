import java.io.*;
import java.util.Scanner;

public class CopyFileExample {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        File inputFile = new File("src/file.txt");
        File outputFile = new File("src/fileCopy.txt");
        try {
            inputStream = new FileInputStream(inputFile);
            outputStream = new FileOutputStream(outputFile);
            int length;
            byte[] buffer = new byte[1024];
            while ((length = inputStream.read(buffer)) > 0){
                outputStream.write(buffer,0,length);
            }
            System.out.println("File is copied successful");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            inputStream.close();
            outputStream.close();
        }
        try {
            FileInputStream fileInputStream = new FileInputStream((new File("src/file.txt")));

            Scanner fileScanner = new Scanner(fileInputStream);
            fileScanner.useDelimiter("\\Z");
            String content = fileScanner.next();

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/fileCopy.txt"));
            bufferedWriter.write(content);

            fileInputStream.close();
            fileScanner.close();
            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println("File does not exist.");
        }

    }
}
