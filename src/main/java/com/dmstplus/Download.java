package com.dmstplus;

import java.awt.Desktop;
import java.io.*;
import java.nio.file.*;

public class Download {

    /**
     * Κατεβάζει και ανοίγει το αρχείο από το μονοπάτι πόρου.
     * @param sourcePath Το μονοπάτι του αρχείου που θα κατέβει.
     */
    public void downloadPdf(String sourcePath) {
        // Διαδρομή προορισμού (Downloads)
        String userHome = System.getProperty("user.home");
        Path destinationPath = Path.of(userHome, "Downloads", "CV.pdf");

        // Αντιγραφή του αρχείου από το source path στο destination path
        try {
            Files.copy(Path.of(sourcePath), destinationPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File downloaded successfully to: " + destinationPath.toString());

            // Άνοιγμα του αρχείου με την προεπιλεγμένη εφαρμογή για PDF
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(destinationPath.toFile());
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("An error occurred while downloading or opening the file.");
        }
    }

    /**
     * Μέθοδος που κατεβάζει και ανοίγει το αρχείο από το μονοπάτι πόρου.
     */
    public void downloadAndOpen() {
    try {
        // Το σωστό μονοπάτι πόρου για το αρχείο PDF
        InputStream resourceStream = getClass().getResourceAsStream("/PDF/CV.pdf");
        if (resourceStream == null) {
            throw new IOException("Resource not found: /PDF/CV.pdf");
        }

        // Διαδρομή προορισμού (Downloads)
        String userHome = System.getProperty("user.home");
        Path destinationPath = Path.of(userHome, "Downloads", "CV.pdf");

        // Αντιγραφή του αρχείου από τους πόρους στο φάκελο Downloads
        try (OutputStream out = new FileOutputStream(destinationPath.toFile())) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = resourceStream.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
            System.out.println("File copied successfully to: " + destinationPath);
        }

        // Άνοιγμα του αρχείου αν είναι δυνατό
        if (Desktop.isDesktopSupported() && Files.exists(destinationPath)) {
            Desktop.getDesktop().open(destinationPath.toFile());
            System.out.println("File opened successfully.");
        } else {
            System.out.println("Cannot open the file. Desktop is not supported or file is missing.");
        }

    } catch (IOException e) {
        e.printStackTrace();
        System.out.println("An error occurred while downloading or opening the file.");
    }
}

}
