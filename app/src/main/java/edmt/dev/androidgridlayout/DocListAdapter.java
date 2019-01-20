package edmt.dev.androidgridlayout;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DocListAdapter extends BaseAdapter {


    private Context context;
    private  int layout;
    private ArrayList<Doc> docList;

    public DocListAdapter(Context context, int layout, ArrayList<Doc> docList) {
        this.context = context;
        this.layout = layout;
        this.docList = docList;
    }

    @Override
    public int getCount() {
        return docList.size();
    }

    @Override
    public Object getItem(int position) {
        return docList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder{
        ImageView imageView;
        TextView txtTitle, txtDate;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        View row = view;
        ViewHolder holder = new ViewHolder();

        if(row == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout, null);

            holder.txtTitle = (TextView) row.findViewById(R.id.txtTitle);
            holder.txtDate = (TextView) row.findViewById(R.id.txtDate);
            holder.imageView = (ImageView) row.findViewById(R.id.imgDoc);
            row.setTag(holder);
        }
        else {
            holder = (ViewHolder) row.getTag();
        }

        Doc doc = docList.get(position);

        holder.txtTitle.setText(doc.getName());
        holder.txtDate.setText(doc.getDate());

        byte[] docImage = doc.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(docImage, 0, docImage.length);
        holder.imageView.setImageBitmap(bitmap);

        return row;
    }


}
