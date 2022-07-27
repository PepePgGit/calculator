
import lombok.SneakyThrows;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class XmlHandler
{
    private final Document document;

    @SneakyThrows
    XmlHandler(File file){
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = builder.parse(file);
        doc.getDocumentElement().normalize();

        this.document = doc;
    }

    public int getFirstIndex(NodeList list){
        int i;
        for(i = 0; i < list.getLength(); i++){
            if(list.item(i).getAttributes().getNamedItem("currency") != null){
                break;
            }
        }
        return i;
    }

    public Map<String, BigDecimal> parseXml()
    {
        Map<String, BigDecimal> map = new HashMap<>();
        NodeList nodeList = document.getElementsByTagName("Cube");
        int index = getFirstIndex(nodeList);
        while(nodeList.item(index) != null){
            map.put(nodeList.item(index).getAttributes().getNamedItem("currency").getTextContent(),
                    new BigDecimal(nodeList.item(index).getAttributes().getNamedItem("rate").getTextContent()));
            index++;
        }
        return map;
    }
}
