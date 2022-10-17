package Lesson5;

import java.io.Serializable;

public class AppData implements Serializable {
    private String [] header;
    private int [][] value;

    public void setHeader(String[] header) {
        this.header = header;
    }

    public void setValue(int[][] value) {
        this.value = value;
    }
}
