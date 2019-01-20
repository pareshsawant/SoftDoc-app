package edmt.dev.androidgridlayout;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.Toast;








import edmt.dev.androidgridlayout.sql.DatabaseHelper;

public class MainActivity extends AppCompatActivity {

    GridLayout mainGrid;
    public static SQLiteHelper sqLiteHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        mainGrid = (GridLayout) findViewById(R.id.mainGrid);
        sqLiteHelper = new SQLiteHelper(this, "FoodDB.sqlite", null, 1);
        //sqLiteHelper.queryData("CREATE TABLE IF NOT EXISTS FOOD(Id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, price VARCHAR, image BLOB)");

        //Set Event
        setSingleEvent(mainGrid);
        //setToggleEvent(mainGrid);



    }

    private void setSingleEvent(GridLayout mainGrid) {



        //Loop all child item of Main Grid
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            //You can see , all child item is CardView , so we just cast object to CardView
            CardView cardView = (CardView) mainGrid.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    Intent intent = new Intent(MainActivity.this,takingImages.class);
                   // intent.putExtra("info","This is activity from card item index  "+finalI);
                    startActivity(intent);

                }
            });
        }
    }
}
