package String;

public class StringDemo {
    public static void main(String[] args) {
//      Tính bất biến
        String s1 = "Hello";
        System.out.println(System.identityHashCode(s1));
        s1 = s1.concat(" World");
        System.out.println(System.identityHashCode(s1));


//      Phương thức
        String s = "Hello, World!";
        int length = s.length();
        System.out.println("Độ dài chuỗi: " + length);  // In ra: Độ dài chuỗi: 13

        char ch = s.charAt(2);
        System.out.println("Ký tự tại vị trí 2: " + ch);  // In ra: Ký tự tại vị trí 2: l

        String sub = s.substring(0, 6);
        System.out.println("Chuỗi con: " + sub);

        int index = s.indexOf("fun");
        System.out.println("Vị trí đầu tiên của 'fun': " + index);

        String upper = s.toUpperCase();
        System.out.println("Chữ in hoa: " + upper);

        String trimmed = s.trim();
        System.out.println("Chuỗi sau khi loại bỏ khoảng trắng: '" + trimmed + "'");

//      So sánh equal vs ==
        String str1 = new String("Hello");
        String str2 = new String("Hello");

        if (str1 == str2) {
            System.out.println("s1 và s2 trỏ đến cùng một đối tượng");
        } else {
            System.out.println("s1 và s2 trỏ đến các đối tượng khác nhau");
        }

        if (str1.equals(str2)) {
            System.out.println("s1 và s2 có nội dung giống nhau");
        } else {
            System.out.println("s1 và s2 có nội dung khác nhau");
        }

//      String và StringBuilder/StringBuffer
        String str = "Hello";
        System.out.println(System.identityHashCode(str));

        StringBuilder stringBuilder = new StringBuilder("Hello");
        System.out.println(System.identityHashCode(stringBuilder));
        stringBuilder.append(str);
        System.out.println(System.identityHashCode(stringBuilder));
    }
}