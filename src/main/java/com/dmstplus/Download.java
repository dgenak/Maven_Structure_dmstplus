package com.dmstplus;

import java.awt.Desktop;
import java.io.*;
import java.net.URL;
import java.nio.file.*;

public class Download {

    /**
     * Κατεβάζει και ανοίγει το αρχείο από το τοπικό path.
     * @param sourcePath Το μονοπάτι του αρχείου που θα κατέβει.
     */
    public void downloadPdf(String sourcePath) {
        String userHome = System.getProperty("user.home");
        Path destinationPath = Path.of(userHome, "Downloads", "CV.pdf");

        try {
            Files.copy(Path.of(sourcePath), destinationPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File downloaded successfully to: " + destinationPath.toString());

            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(destinationPath.toFile());
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("An error occurred while downloading or opening the file.");
        }
    }

    /**
     * Κατεβάζει και ανοίγει το αρχείο από URL.
     * @param fileUrl Το URL του αρχείου που θα κατέβει.
     */
    public void downloadAndOpen(String fileUrl) {
        try {
            URL url = new URL(fileUrl);
            String fileName = Paths.get(url.getPath()).getFileName().toString();
            String userHome = System.getProperty("user.home");
            Path destinationPath = Path.of(userHome, "Downloads", fileName);

            try (InputStream in = url.openStream();
                 OutputStream out = new FileOutputStream(destinationPath.toFile())) {

                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = in.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesRead);
                }

                System.out.println("File downloaded successfully to: " + destinationPath);
            }

            if (Desktop.isDesktopSupported() && Files.exists(destinationPath)) {
                Desktop.getDesktop().open(destinationPath.toFile());
                System.out.println("File opened successfully.");
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("An error occurred while downloading or opening the file.");
        }
    }
}
