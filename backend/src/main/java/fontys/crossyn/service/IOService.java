package fontys.crossyn.service;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;


public  class IOService {
    String path = System.getProperty("user.dir") + "\\src\\main\\resources\\";
    String inputPath = path + "txt\\";
    String outputPath = path + "json\\";
    File root_dir = new File(inputPath);
    String[] sub_files = root_dir.list();

    public void convertTxtToJson() {

        for (String fileName : sub_files) {

            String[] parts = fileName.split("\\.");

            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(outputPath + parts[0] + "." + "json"));

                try (Stream<String> stream = Files.lines(Paths.get(inputPath + fileName))) {
                    stream.forEach((line) -> {
                        try {
                            bw.write(line);
                            bw.newLine();
                        } catch (IOException e) {
                            System.out.println(e.getMessage());
                        }
                    });
                } catch (Exception e) {
                    throw e;
                }
                bw.close();
            } catch (Exception exception) {
                System.out.println(exception);
            }
        }
    }
}
