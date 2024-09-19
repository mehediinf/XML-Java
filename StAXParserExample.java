import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import java.io.FileInputStream;

public class StAXParserExample {
    public static void main(String[] args) {
        try {
            // XMLInputFactory অবজেক্ট তৈরি করা
            XMLInputFactory factory = XMLInputFactory.newInstance();
            // XMLStreamReader অবজেক্ট তৈরি করা
            XMLStreamReader reader = factory.createXMLStreamReader(new FileInputStream("StAX_example.xml"));
            // XML ডকু মেন্ট পার্সিং
            while (reader.hasNext()) {
                int event = reader.next();
                switch (event) {
                    case XMLStreamConstants.START_ELEMENT:
                        if (reader.getLocalName().equals("employee")) {
                            System.out.println("Start Element: employee");
                            System.out.println("Employee ID: " +
                                    reader.getAttributeValue(null, "id"));
                        }
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        String text = reader.getText().trim();
                        if (!text.isEmpty()) {
                            System.out.println("Content: " + text);
                        }
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        if (reader.getLocalName().equals("employee")) {
                            System.out.println("End Element: employee");
                        }
                        break;
                }
            }
            reader.close();
        } catch (XMLStreamException | java.io.IOException e) {
            e.printStackTrace();
        }
    }
}