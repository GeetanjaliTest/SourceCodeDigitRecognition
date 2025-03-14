package recognition;

import java.io.*;
import java.util.Random;

public class MNISTFileGenerator {
    public static void main(String[] args) {
        String filePath = "/Users/geethanjalimohantty/Desktop/gtest1/Digit-Recognition/data/images1.txt";

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filePath))) {
            // Write MNIST file header
            dos.writeInt(2051); // Magic Number for image file
            dos.writeInt(5);    // Number of sample images
            dos.writeInt(28);   // Number of rows
            dos.writeInt(28);   // Number of columns

            // Random image data generator
            Random random = new Random();

            for (int img = 0; img < 5; img++) { // 5 sample images
                for (int row = 0; row < 28; row++) {
                    for (int col = 0; col < 28; col++) {
                        int pixelValue = random.nextInt(256); // Random grayscale value (0-255)
                        dos.writeByte(pixelValue);
                    }
                }
            }

            System.out.println("Sample MNIST file generated successfully at: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

