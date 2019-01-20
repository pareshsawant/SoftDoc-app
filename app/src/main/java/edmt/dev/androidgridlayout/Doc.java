package edmt.dev.androidgridlayout;

public class Doc {


    private int id;
    private String title;
    private String date;
    private byte[] image;

    public Doc(String title, String date, byte[] image, int id) {
        this.title = title;
        this.date = date;
        this.image = image;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return title;
    }

    public void setName(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }


}
