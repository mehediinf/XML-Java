import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXParserExample {
    public static void main(String[] args) {
        try {
            // SAXParserFactory অবজেক্ট তৈরি করা
            SAXParserFactory factory = SAXParserFactory.newInstance();
            // SAXParser অবজেক্ট তৈরি করা
            SAXParser saxParser = factory.newSAXParser();
            // DefaultHandler অবজেক্ট তৈরি করা
            DefaultHandler handler = new DefaultHandler() {
                // এলিমেন্টের শুরুতে কলব্যাক মেথড
                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes)
                        throws SAXException {
                    if (qName.equalsIgnoreCase("employee")) {
                        System.out.println("Start Element : employee");
                        System.out.println("Employee ID: " +
                                attributes.getValue("id"));
                    }
                }

                @Override
                public void characters(char[] ch, int start, int length) throws SAXException {
                    String content = new String(ch, start, length).trim();
                    if (!content.isEmpty()) {
                        System.out.println("Content: " + content);
                    }

                }

                // এলিমেন্টের শেষ দিকে কলব্যাক মেথড
                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    if (qName.equalsIgnoreCase("employee")) {
                        System.out.println("End Element : employee");
                    }
                }

            };
            // XML ফাইল পার্স করা
            saxParser.parse("SAX_example.xml", handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}