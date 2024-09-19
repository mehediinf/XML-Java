import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class DOMParserExample {
    public static void main(String[] args) {
        try {
            // DocumentBuilderFactory অবজেক্ট তৈরি করা
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();// DocumentBuilder অবজেক্ট তৈরি করা
            DocumentBuilder builder = factory.newDocumentBuilder();
            // XML ফাইল পার্স করা
            Document doc = builder.parse("DOM_example.xml");
            // ডকু মেন্টের রুট এলিমেন্ট পাওয়া
            Element root = doc.getDocumentElement();
            System.out.println("Root Element: " + root.getNodeName());
            // 'employee' এলিমেন্টের সমস্ত উদাহরণ সংগ্রহ করা
            NodeList employees = doc.getElementsByTagName("employee");
            for (int i = 0; i < employees.getLength(); i++) {
                Element employee = (Element) employees.item(i);
                // 'employee' এলিমেন্টের অ্যাট্রিবিউট এবং চাইল্ড এলিমেন্ট পড়া
                String id = employee.getAttribute("id");
                String name = employee.getElementsByTagName("name").item(0).getTextContent();
                String age = employee.getElementsByTagName("age").item(1).getTextContent();
                String position = employee.getElementsByTagName("position").item(0).getTextContent();
                System.out.println("Employee ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
                System.out.println("Position: " + position);
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}