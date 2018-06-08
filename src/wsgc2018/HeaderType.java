package wsgc2018;

public class HeaderType {

    private int index;
    private String dataName;
    private int[] data;
    private int size;

    public HeaderType(int index, String dataName,int[] data){
        this.index = index;
        this.dataName = dataName;
        this.data = data;
        this.size = data.length;
    }

}
