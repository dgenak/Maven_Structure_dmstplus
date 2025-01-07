package com.dmstplus;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class DownloadTest {

    @Test
    void testDownloadPdf() throws IOException {
        // Δημιουργία ενός προσωρινού αρχείου ως "πηγή"
        Path sourcePath = Files.createTempFile("test-source", ".pdf");
        File sourceFile = sourcePath.toFile();

        // Γράψιμο περιεχομένου στο προσωρινό αρχείο
        try (FileWriter writer = new FileWriter(sourceFile)) {
            writer.write("Test PDF Content");
        }

        // Βεβαιωθείτε ότι το προσωρινό αρχείο υπάρχει
        assertTrue(sourceFile.exists());

        // Δημιουργία του αντικειμένου της κλάσης Download
        Download downloader = new Download();

        // Κλήση της μεθόδου downloadPdf
        downloader.downloadPdf(sourcePath.toString());

        // Ορισμός του path του αναμενόμενου αρχείου προορισμού
        String userHome = System.getProperty("user.home");
        Path destinationPath = Path.of(userHome, "Downloads", "CV.pdf");

        // Έλεγχος αν το αρχείο αντιγράφηκε στη σωστή τοποθεσία
        assertTrue(Files.exists(destinationPath));

        // Έλεγχος αν το περιεχόμενο του αρχείου είναι το ίδιο με το αρχικό
        String originalContent = Files.readString(sourcePath);
        String copiedContent = Files.readString(destinationPath);
        assertEquals(originalContent, copiedContent);

        // Καθαρισμός: Διαγραφή του προσωρινού και του κατεβασμένου αρχείου
        Files.deleteIfExists(sourcePath);
        Files.deleteIfExists(destinationPath);
    }
}
