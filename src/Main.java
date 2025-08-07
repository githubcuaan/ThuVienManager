import ui.MenuChinh;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class Main {
    public static void main(String[] args) throws UnsupportedEncodingException {
        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            System.err.println("Không hỗ trợ UTF-8 bro 😭");
        }
        new MenuChinh().start();
    }
}