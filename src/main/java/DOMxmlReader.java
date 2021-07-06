import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class DOMxmlReader {

    public static void main(String[] args) {
        try {
            String filepath = args[0];
            File xmlFile = new File(filepath);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();
            NodeList nodeList = document.getElementsByTagName("modification");
            Set<String> attributes= new HashSet<String>();
            for (int i = 0; i < nodeList.getLength(); i++) {
               String attr = nodeList.item(i).getAttributes().getNamedItem("name").getNodeValue();
               attributes.add(attr);
            }
            System.out.println(attributes.size());
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}
