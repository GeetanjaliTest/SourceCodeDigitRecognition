package recognition;

import java.io.*;
import java.util.ArrayList;

class MNISTReader {

    static ArrayList<double[][]> getAllNumbers() {
        ArrayList<double[][]> result = new ArrayList<>();

        try (DataInputStream dis = new DataInputStream(new FileInputStream("/Users/geethanjalimohantty/Desktop/gtest1/Digit-Recognition/data/images1.txt"))) {

            int magicNumber = dis.readInt();
            int numberOfImages = dis.readInt();
            int numberOfRows = dis.readInt();
            int numberOfCols = dis.readInt();

            System.out.println("Magic Number: " + magicNumber);
            System.out.println("Number of Images: " + numberOfImages);
            System.out.println("Image Size: " + numberOfRows + "x" + numberOfCols);

            for (int i = 0; i < numberOfImages; i++) {
                double[][] image = new double[numberOfRows][numberOfCols];

                for (int row = 0; row < numberOfRows; row++) {
                    for (int col = 0; col < numberOfCols; col++) {
                        image[row][col] = (dis.readUnsignedByte() & 0xFF) / 255.0;
                    }
                }
                result.add(image);
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error reading MNIST data file. Please check file path or format.");
        }

        return result;
    }

    // ➡️ REPLACE this method with the updated implementation below
    public static double[][] getImageFromFile(String filePath) {
        double[][] image = new double[28][28]; // Standard MNIST image size

        try (DataInputStream dis = new DataInputStream(new FileInputStream(filePath))) {

            int magicNumber = dis.readInt();
            int numberOfImages = dis.readInt();
            int numberOfRows = dis.readInt();
            int numberOfCols = dis.readInt();

            // Ensure image dimensions are valid
            if (numberOfRows != 28 || numberOfCols != 28) {
                System.out.println("Error: Invalid image dimensions. Expected 28x28.");
                return null;
            }

            // Read and normalize pixel values
            for (int row = 0; row < numberOfRows; row++) {
                for (int col = 0; col < numberOfCols; col++) {
                    image[row][col] = (dis.readUnsignedByte() & 0xFF) / 255.0;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error reading the image file. Please check the file path or format.");
            return null;
        }

        return image;
    }
}
