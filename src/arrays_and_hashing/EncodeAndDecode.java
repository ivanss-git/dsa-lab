package arrays_and_hashing;
import java.util.List;
import java.util.ArrayList;

public class EncodeAndDecode {
    public class solution {
        public String encode(List<String> strs) {
            StringBuilder sb = new StringBuilder();
            for (String str : strs) {
                sb.append(str.length()).append("#").append(str);
            }
            String encoded_string = sb.toString();
            return encoded_string;
        }

        public List<String> decode(String str) {
            List<String> decoded_string = new ArrayList<>();
            int i = 0;

            while (i < str.length()) {
                int slash = str.indexOf('#', i);
                int length = Integer.parseInt(str.substring(i, slash));
                String actual = str.substring(slash + 1, slash + 1 + length);
                decoded_string.add(actual);
                i = slash + 1 + length;
            }
            return decoded_string;
        }
    }
   public static void main (String[] args) {
    EncodeAndDecode ed = new EncodeAndDecode();

    solution solver = ed.new solution();
    List<String> example = List.of("Hello", "World");

    String encoded = solver.encode(example);
    System.out.println("Encoded:" + encoded);

    List<String> decoded = solver.decode(encoded);
    System.out.println("Decoded:" + decoded);

   }
}
