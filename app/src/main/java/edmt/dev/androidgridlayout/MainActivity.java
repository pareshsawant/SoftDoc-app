package edmt.dev.androidgridlayout;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

// import database
import java.util.List;

import edmt.dev.androidgridlayout.database.FolderDbHelper;
import edmt.dev.androidgridlayout.database.model.Folder;

public class MainActivity extends AppCompatActivity {


    // Activity request codes
    private static final int CAMERA_CAPTURE_IMAGE_REQUEST_CODE = 100;

    // key to store image path in savedInstance state
    public static final String KEY_IMAGE_STORAGE_PATH = "image_path";

    public static final int MEDIA_TYPE_IMAGE = 1;

    // Bitmap sampling size
    public static final int BITMAP_SAMPLE_SIZE = 8;

    // Gallery directory name to store the images or videos
    public static final String GALLERY_DIRECTORY_NAME = "Hello Camera";

    // Image and Video file extensions
    public static final String IMAGE_EXTENSION = "jpg";

    private static String imageStoragePath;

    private FolderDbHelper db;
    private Context mContext;


    GridLayout mainGrid;
    Button addFolderBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FolderDbHelper db = new FolderDbHelper(this);
        List<Folder> allFolder = db.getAllFolder();
        if (allFolder.size() == 0) {
            //there are no default folders.
            db.insertFolder("ID Proof");
            db.insertFolder("Education");
            db.insertFolder("Bills");
            db.insertFolder("Cards");
            db.insertFolder("Health");
            db.insertFolder("Certificate");
            db.insertFolder("Notes");

        }
        allFolder = db.getAllFolder();

        mainGrid = (GridLayout) findViewById(R.id.mainGrid);
        SetFolders(mainGrid, allFolder);

        addFolderBtn = (Button) findViewById(R.id.addFolder);
        addFolderBtn.setOnClickListener(showAddFolderPopUp);


    }

    private void SetFolders(GridLayout mainGrid, List<Folder> allFolder) {
        //Loop all child item of Main Grid
        mContext = getApplicationContext();
        for (Folder f : allFolder) {
            createCard(f);
        }

    }

    private void createCard(Folder folder) {
        CardView card = new CardView(mContext);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        card.setLayoutParams(params);
        // Set CardView corner radius
        card.setRadius(9);

        // Set cardView content padding
        card.setContentPadding(15, 15, 15, 15);

        // Set a background color for CardView
        card.setCardBackgroundColor(Color.parseColor("#FFDDFF"));

        // Set the CardView maximum elevation
        card.setMaxCardElevation(15);

        // Set CardView elevation
        card.setCardElevation(9);

        // Initialize a new TextView to put in CardView
        TextView tv = new TextView(mContext);
        tv.setLayoutParams(params);
        tv.setText(folder.getFolder());
        tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 30);
        tv.setTextColor(Color.RED);

        // set event listener
        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, takingImages.class);
                // intent.putExtra("info","This is activity from card item index  "+finalI);
                startActivity(intent);

            }
        });

        // Put the TextView in CardView
        card.addView(tv);

        // Finally, add the CardView in root layout
        mainGrid.addView(card);

    }

    // code to add folder

    // Create an anonymous implementation of OnClickListener
    private View.OnClickListener showAddFolderPopUp = new View.OnClickListener() {
        public void onClick(View v) {
            // show pop up to enter folder name
            // when user clicks on add
            addFolderToDb("Test Folder");
        }
    };

    private void addFolderToDb(String folder) {
        FolderDbHelper db = new FolderDbHelper(this);
        long folderId = db.insertFolder(folder);
        Folder newlyCreatedFolder = db.getFolder(folderId);
        createCard(newlyCreatedFolder);
    }
}
