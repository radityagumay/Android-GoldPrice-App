package com.raditya.goldprice.network.model.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by raditya.gumay on 02/04/2016.
 */
public class GoldResponse implements Parcelable {

    @SerializedName("errors")
    @Expose
    public Object errors;
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("source_name")
    @Expose
    public String sourceName;
    @SerializedName("source_code")
    @Expose
    public String sourceCode;
    @SerializedName("code")
    @Expose
    public String code;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("urlize_name")
    @Expose
    public String urlizeName;
    @SerializedName("display_url")
    @Expose
    public String displayUrl;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("updated_at")
    @Expose
    public String updatedAt;
    @SerializedName("frequency")
    @Expose
    public String frequency;
    @SerializedName("from_date")
    @Expose
    public String fromDate;
    @SerializedName("to_date")
    @Expose
    public String toDate;
    @SerializedName("column_names")
    @Expose
    public List<String> columnNames = new ArrayList<>();
    @SerializedName("public")
    @Expose
    public Boolean _public;
    @SerializedName("type")
    @Expose
    public Object type;
    @SerializedName("premium")
    @Expose
    public Boolean premium;
    @SerializedName("data")
    @Expose
    public List<List<String>> data = new ArrayList<>();

    protected GoldResponse(Parcel in) {
        sourceName = in.readString();
        sourceCode = in.readString();
        code = in.readString();
        name = in.readString();
        urlizeName = in.readString();
        displayUrl = in.readString();
        description = in.readString();
        updatedAt = in.readString();
        frequency = in.readString();
        fromDate = in.readString();
        toDate = in.readString();
        columnNames = in.createStringArrayList();
    }

    public static final Creator<GoldResponse> CREATOR = new Creator<GoldResponse>() {
        @Override
        public GoldResponse createFromParcel(Parcel in) {
            return new GoldResponse(in);
        }

        @Override
        public GoldResponse[] newArray(int size) {
            return new GoldResponse[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(sourceName);
        dest.writeString(sourceCode);
        dest.writeString(code);
        dest.writeString(name);
        dest.writeString(urlizeName);
        dest.writeString(displayUrl);
        dest.writeString(description);
        dest.writeString(updatedAt);
        dest.writeString(frequency);
        dest.writeString(fromDate);
        dest.writeString(toDate);
        dest.writeStringList(columnNames);
    }
}
