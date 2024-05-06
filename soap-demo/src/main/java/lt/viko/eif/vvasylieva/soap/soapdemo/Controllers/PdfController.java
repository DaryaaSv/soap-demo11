package lt.viko.eif.vvasylieva.soap.soapdemo.Controllers;

import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.*;

@Controller
public class PdfController {

    @GetMapping("/convertToPDF")
    public ResponseEntity<byte[]> convertToPDFController() {
        try {
            byte[] pdfBytes = convertToPDF();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("attachment", "file.pdf");
            headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
            return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    private byte[] convertToPDF() throws Exception {
        File xsltFile = new File("C:\\Users\\Dasha\\Desktop\\soap-demo (2)\\soap-demo\\soap-demo\\src\\main\\resources\\account-to-pdf.xsl");
        StreamSource xmlSource = new StreamSource(new File("C:\\Users\\Dasha\\Desktop\\soap-demo (2)\\soap-demo\\soap-demo\\src\\main\\resources\\gaming.xml"));
        FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());
        FOUserAgent foUserAgent = fopFactory.newFOUserAgent();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        try {
            Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, outputStream);

            TransformerFactory factory = TransformerFactory.newInstance("net.sf.saxon.TransformerFactoryImpl", null);
            Transformer transformer = factory.newTransformer(new StreamSource(xsltFile));

            transformer.transform(xmlSource, new SAXResult(fop.getDefaultHandler()));
            return outputStream.toByteArray();
        } finally {
            outputStream.close();
        }
    }
}
