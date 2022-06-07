package app;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class main {

	public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        System.out.println(dtf.format(LocalDateTime.now()));

	}

}
