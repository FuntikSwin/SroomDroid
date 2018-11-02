package com.gpbtmn.fomakin.sroomdroid.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gpbtmn.fomakin.sroomdroid.R;
import com.gpbtmn.fomakin.sroomdroid.domain.entity.Device;

import java.util.List;

public class RvDevicesAdapter extends RecyclerView.Adapter<RvDevicesAdapter.DevicesViewHolder> {

    class DevicesViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvDeviceName;

        public DevicesViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDeviceName = itemView.findViewById(R.id.tvDeviceName);
        }
    }

    private final LayoutInflater inflater;
    private List<Device> devices;

    public RvDevicesAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public DevicesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.devicesview_item, parent, false);
        return new DevicesViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DevicesViewHolder holder, int position) {
        if (devices != null) {
            Device currDevice = devices.get(position);
            holder.tvDeviceName.setText(Integer.toString(currDevice.getNum()) + ": " + currDevice.getName());
        } else {
            holder.tvDeviceName.setText("No name");
        }
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (devices != null) {
            return devices.size();
        } else {
            return 0;
        }
    }
}
