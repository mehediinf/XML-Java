import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class XMLParserExample {
    public static void main(String[] args) {
        try {
            // DocumentBuilderFactory অবজেক্ট তৈরি করা
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            
            // DocumentBuilder অবজেক্ট তৈরি করা
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            // XML ফাইলটি পার্স করা এবং Document অবজেক্টে লোড করা
            Document doc = builder.parse("example.xml");
            
            // রুট এলিমেন্ট পাওয়া
            Element root = doc.getDocumentElement();
            System.out.println("Root Element: " + root.getNodeName());
            
            // "employee" ট্যাগের সব এলিমেন্টের লিস্ট পাওয়া
            NodeList nodeList = doc.getElementsByTagName("employee");
            
            // লিস্টের সব এলিমেন্ট লুপ করে প্রিন্ট করা
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    
                    // নাম, বয়স এবং পজিশন প্রিন্ট করা
                    String name = element.getElementsByTagName("name").item(0).getTextContent();
                    String age = element.getElementsByTagName("age").item(0).getTextContent();
                    String position = element.getElementsByTagName("position").item(0).getTextContent();
                    
                    System.out.println("Employee:");
                    System.out.println("Name: " + name);
                    System.out.println("Age: " + age);
                    System.out.println("Position: " + position);
                    System.out.println("--------------------");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
