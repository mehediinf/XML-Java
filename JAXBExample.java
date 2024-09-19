import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

public class JAXBExample {
    public static void main(String[] args) {
        try {
            // JAXBContext তৈরি
            JAXBContext context = JAXBContext.newInstance(Employee.class);

            // Unmarshaller তৈরি
            Unmarshaller unmarshaller = context.createUnmarshaller();
            String xml = "<employee id=\"1\"><name>John Doe</name><age>30</age><position>Developer</position></employee>";

            // XML থেকে Java অবজেক্টে কনভার্ট করা
            Employee employee = (Employee) unmarshaller.unmarshal(new StringReader(xml));
            System.out.println("Employee ID: " + employee.getId());
            System.out.println("Name: " + employee.getName());
            System.out.println("Age: " + employee.getAge());
            System.out.println("Position: " + employee.getPosition());

            // Marshaller তৈরি
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Java অবজেক্ট থেকে XML-এ কনভার্ট করা
            StringWriter writer = new StringWriter();
            marshaller.marshal(employee, writer);
            System.out.println("XML Output:\n" + writer.toString());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}

@XmlRootElement
class Employee {
    private int id;
    private String name;
    private int age;
    private String position;

    @XmlAttribute
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @XmlElement
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
