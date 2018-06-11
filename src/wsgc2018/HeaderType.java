package wsgc2018;

public class HeaderType {

    private int index;
    private String dataName;
    private int[] data;
    private int size;

    public HeaderType(int index, String dataName){
        this.index = index;
        this.dataName = dataName;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getDataName() {
        return dataName;
    }

    public void setDataName(String dataName) {
        this.dataName = dataName;
    }

    public int[] getData() {
        return data;
    }

    public void setData(int[] data) {
        this.data = data;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
