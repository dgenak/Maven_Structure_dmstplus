package com.dmstplus;

import java.awt.Desktop;
import java.io.*;
import java.nio.file.*;
import java.nio.file.StandardCopyOption;

public class Download {

    public void downloadPdf(String sourcePath) {
        // Ορισμός του path του αρχείου προορισμού στον φάκελο Downloads του χρήστη
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
}
