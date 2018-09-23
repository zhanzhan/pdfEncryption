// @author Stanley 170419
package myCodeLib;
import java.io.File;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.AccessPermission;
import org.apache.pdfbox.pdmodel.encryption.StandardProtectionPolicy;

public class PdfEncryption {

    public static void main(String[] args) throws Exception {

//Loading an existing document
        File file = new File("C:\\zTemp\\pdf\\plainPDF.pdf");
        PDDocument document = PDDocument.load(file);

        //Creating access permission object
        AccessPermission ap = new AccessPermission();

        //Creating StandardProtectionPolicy object
        StandardProtectionPolicy spp = new StandardProtectionPolicy("b1234", "b1234", ap);

        //Setting the length of the encryption key
        spp.setEncryptionKeyLength(128);

        //Setting the access permissions
        spp.setPermissions(ap);

        //Protecting the document
        document.protect(spp);

        System.out.println("Document encrypted - Done --------------------");

        //Saving the document
        document.save("C:\\zTemp\\pdf\\encryptedPDF1.pdf");
        //Closing the document
        document.close();
    }
}