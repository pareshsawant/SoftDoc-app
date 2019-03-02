package edmt.dev.androidgridlayout.database.model;

public class Image {
    public static final String TABLE_NAME = "image";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_TIMESTAMP = "timestamp";
    public static final String COLUMN_FOLDER = "fID";
    public static final String COLUMN_TITLE = "iTitle";
    public static final String COLUMN_DESCRIPTION = "iDescription";
    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_NAME + " TEXT,"
                    + COLUMN_FOLDER + " INTEGER NOT NULL,"
                    + COLUMN_TITLE + " TEXT NOT NULL,"
                    + COLUMN_DESCRIPTION + " TEXT,"
                    + COLUMN_TIMESTAMP + " DATETIME DEFAULT CURRENT_TIMESTAMP"
                    + ")";
    private int id;
    private String image;
    private String timestamp;

    public long getfId() {
        return fId;
    }

    public void setfId(long fId) {
        this.fId = fId;
    }

    public String getiTitle() {
        return iTitle;
    }

    public void setiTitle(String iTitle) {
        this.iTitle = iTitle;
    }

    public String getiDescription() {
        return iDescription;
    }

    public void setiDescription(String iDescription) {
        this.iDescription = iDescription;
    }

    private long fId;
    private String iTitle;
    private String iDescription;

    public Image() {
    }

    public Image(int id, String image, String timestamp) {
        this.id = id;
        this.image = image;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}

