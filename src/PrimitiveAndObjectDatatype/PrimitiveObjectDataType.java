package PrimitiveAndObjectDatatype;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class PrimitiveObjectDataType {
    public static void main(String[] args) {
        //  Primitive data types trong Java là gì?
        //  - Là các kiểu dữ liệu đơn giản, không phải là đối tượng, và lưu trữ giá trị trực tiếp
        //  - Các kiểu dữ liệu không phải là đối tượng, do đó không có các phương thức đi kèm như các lớp đối tượng
        boolean booleanVar;
        byte byteVar;
        char charVar;
        short shortVar;
        int intVar;
        long longVar;
        float floatVar;
        double doubleVar;


        //  Object data type trong java là gì?
        //  - Object data type được tạo ra từ một class. Nên có các thuộc tính và hành vi (methods) của đối tượng
        //  - Các đối tượng có thể chứa nhiều loại dữ liệu
        //  - Các đối tượng được tạo ra và tham chiếu địa chỉ đối tượng trên heap
        //  - Giá trị khởi tạo mặc định của nó là null
        //  - Để tạo ra một đối tượng, sử dụng từ khóa new và một constructor
        String stringVar;
        //  Person personVar = new Person();
        //  System.out.println("Address memory: " + System.identityHashCode(personVar));


        //  Phân biệt kiểu dữ liệu nguyên thủy và kiểu dữ liệu object
        //  - Giá trị của kiểu nguyên thủy được lưu trữ trực tiếp trong biến
        //  - Các kiểu dữ liệu nguyên thủy không thể nhận giá trị null
        //  - Kiểu nguyên thủy không thể gọi các phương thức hoặc hành vi khác vì chúng không phải là đối tượng
        boolean isTrue = true;

        //  - Giá trị của kiểu nguyên thủy được lưu trữ trực tiếp trong biến
        //  - Các kiểu dữ liệu nguyên thủy không thể nhận giá trị null
        //  - Kiểu nguyên thủy không thể gọi các phương thức hoặc hành vi khác vì chúng không phải là đối tượng
        String name = "Alice";
        //  Person person = new Person(); // Tạo đối tượng từ lớp Person



        //  Có thể chuyển đổi giữa hai kiểu dữ liệu này không
        int primitiveInt = 10;
        Integer objectInt = Integer.valueOf(primitiveInt);
        byte primitiveByte = 5;
        Byte objectByte = Byte.valueOf(primitiveByte);
        short primitiveShort = 20;
        Short objectShort = Short.valueOf(primitiveShort);
        long primitiveLong = 100L;
        Long objectLong = Long.valueOf(primitiveLong);
        float primitiveFloat = 10.5f;
        Float objectFloat = Float.valueOf(primitiveFloat);
        double primitiveDouble = 20.5;
        Double objectDouble = Double.valueOf(primitiveDouble);
        boolean primitiveBoolean = true;
        Boolean objectBoolean = Boolean.valueOf(primitiveBoolean);
        char primitiveChar = 'A';
        Character objectCharacter = Character.valueOf(primitiveChar);



        // So sánh giữa kiểu dữ liệu nguyên thủy và đối tượng
        // - Không thể so sánh trực tiếp: Không thể so sánh trực tiếp một kiểu dữ liệu nguyên thủy với một kiểu dữ liệu đối tượng.
        int a = 10;
        int b = 14;
        if (a == b) {
            System.out.println("a và b bằng nhau.");
        }

        // - Chuyển đổi trước khi so sánh: Cần chuyển kiểu dữ liệu nguyên thủy thành kiểu wrapper class tương ứng.
        Integer obj1 = 10;
        Integer obj2 = 12;
        // So sánh địa chỉ của đối tượng
        if (obj1 == obj2) {
            System.out.println("obj1 và obj2 có cùng địa chỉ (reference).");
        }

        // So sánh giá trị của đối tượng
        if (obj1.equals(obj2)) {
            System.out.println("obj1 và obj2 có cùng giá trị.");
        }
    }
}