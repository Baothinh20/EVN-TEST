import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        // https?:\/\/(www\.)?[-a-zA-Z0-9@:%._\+~#=]{1,256}\.[a-zA-Z0-9()]{1,6}\b([-a-zA-Z0-9()@:%_\+.~#?&//=]*)
        // regex
        // https?:\/\/(www\.)?[a-zA-Z0-9]{1,256}\.[a-z]{2,6}\b([-a-zA-Z0-9()@:%_\+.~#?&//=]*)
        // regex chuan de bai
        // test url: https://tiki.vn/dien-thoai-may-tinh-bang/c1789?src=mega-menu
        Pattern pattern = Pattern.compile("https?:\\/\\/(www\\.)?[a-zA-Z0-9]{1,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9()@:%_\\+.~#?&//=]*)", Pattern.CASE_INSENSITIVE);
        String url = "https://tiki.vn/dien-thoai-may-tinh-bang/c1789?src=mega-menu";
        boolean valid = pattern.matcher(url).find();
        // System.out.println(valid);
        if (valid == true) {
            System.out.println("url is valid");
        } else {
            System.out.println("url is not valid");
        }

    }
}