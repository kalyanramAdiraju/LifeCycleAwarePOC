package gmailsample.com.lifecycleaware.Adapters;

import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import gmailsample.com.lifecycleaware.R;
import gmailsample.com.lifecycleaware.models.MainResponse;

/**
 * Created by nineleaps on 13/4/18.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewViewHolder> {
    private LiveData<MainResponse> mData;
    private Context mContext;
    private LayoutInflater layoutInflater;

    public RecyclerViewAdapter(Context context, LiveData<MainResponse> mData) {
        this.mData = mData;
        this.mContext = context;
    }

    @Override
    public RecyclerViewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return new RecyclerViewViewHolder(layoutInflater.inflate(R.layout.inflate_layout, parent,
                false));
    }

    @Override
    public void onBindViewHolder(RecyclerViewViewHolder holder, int position) {
        if (null!=mData.getValue().getRestResponse()){
            holder.mTextView.setText(mData.getValue().getRestResponse().getResult().get(position).getName());
        }else {
            Log.d("response","1233");
        }

    }

    @Override
    public int getItemCount() {
        return mData.getValue().getRestResponse().getResult().size();
    }

    public class RecyclerViewViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.texview)
        TextView mTextView;

        public RecyclerViewViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
