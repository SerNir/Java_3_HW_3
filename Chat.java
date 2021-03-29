import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Chat implements Serializable {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


    public void saveCat(String message) throws IOException {
        File file = new File("C:\\Users\\Serzh\\save.txt\\");
        List<String> listMessage = new ArrayList<>();
        FileOutputStream fos = new FileOutputStream(file);
        if (message != null) {
            listMessage.add(message);
            fos.write(message.getBytes(StandardCharsets.UTF_8));
        }

           fos.close();
    }

    public void chatStart() throws IOException {
        while (true) {
            System.out.println("Enter message:");
            String message = reader.readLine();
            cens(message);
            if (message.equals("/q")) {
                break;
            }
            saveCat(message);
            System.out.println(message);

            System.out.println("Echo " + message);


        }
    }

    public void readMessage() {
        try {
            FileInputStream fis = new FileInputStream("C:\\Users\\Serzh\\save.txt\\");
            int i;
            while ((i = fis.read()) != -1) {
                System.out.print((char) i);
            }
            System.out.println();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String cens(String message) {
        if (message.equals("спб")) {
            return message.toUpperCase();
        }
        return null;
    }
}
