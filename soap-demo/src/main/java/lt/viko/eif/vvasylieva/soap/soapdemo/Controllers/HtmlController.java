package lt.viko.eif.vvasylieva.soap.soapdemo.Controllers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.StringWriter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import java.io.FileWriter;

@Controller
@RequestMapping("/gaming")
public class HtmlController {

    @GetMapping(value = "/transformToHTML", produces = MediaType.TEXT_HTML_VALUE)
    public ResponseEntity<String> getHtmlPage() {
        try {
            // Specify the absolute paths to the XML and XSLT files
            File xmlFile = new File("C:\\Users\\Dasha\\Desktop\\soap-demo (2)\\soap-demo\\soap-demo\\src\\main\\resources\\gaming.xml");
            File xsltFile = new File("C:\\Users\\Dasha\\Desktop\\soap-demo (2)\\soap-demo\\soap-demo\\src\\main\\resources\\account-to-html.xsl");

            // Load XML file
            StreamSource xmlSource = new StreamSource(xmlFile);

            // Load XSLT file
            StreamSource xsltSource = new StreamSource(xsltFile);

            // Perform XSLT transformation
            StringWriter writer = new StringWriter();
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer(xsltSource);
            transformer.transform(xmlSource, new StreamResult(writer));
            String htmlContent = writer.toString();

            // Write HTML content to a file in the resources directory
            writeHtmlToFile(htmlContent, "gaming.html");

            return ResponseEntity.ok(htmlContent);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error loading HTML page: " + e.getMessage());
        }
    }

    private void writeHtmlToFile(String content, String fileName) throws Exception {
        FileWriter writer = null;
        try {
            // Get the resource directory path
            Resource resource = new ClassPathResource("");
            String resourcePath = resource.getFile().getAbsolutePath();

            // Construct the file path
            String filePath = resourcePath + File.separator + fileName;

            // Write HTML content to file
            writer = new FileWriter(filePath);
            writer.write(content);
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }
}
