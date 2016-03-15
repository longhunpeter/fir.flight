package io.github.ryanhoo.firFlight.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

/**
 * Created with Android Studio.
 * User: ryan@whitedew.me
 * Date: 3/15/16
 * Time: 10:11 PM
 * Desc: User
 */
/*
{
  "id": "55cdb07ff2fc42680d00000c",
  "uuid": "55cdb042692d337ccd0000d9",
  "name": "Whitedew",
  "email": "tps@whitedew.me",
  "gravatar": "http://gravatar.duoshuo.com/avatar/ca4c48654fa63f4a9347b5f17c74470e.png?r=PG",
  "is_confirmed": true,
  "is_developer": true,
  "created_at": 1439543423,
  "allowed_perms": []
}
*/
public class User implements Parcelable {

    public User() {
        // Empty Constructor
    }

    public User(Parcel in) {
        readFromParcel(in);
    }

    @SerializedName("id")
    private String id;

    @SerializedName("uuid")
    private String uuid;

    @SerializedName("name")
    private String name;

    @SerializedName("gravatar")
    private String gravatar;

    @SerializedName("is_confirmed")
    private boolean confirmed;

    @SerializedName("is_developer")
    private boolean developer;

    @SerializedName("created_at")
    private long createdAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGravatar() {
        return gravatar;
    }

    public void setGravatar(String gravatar) {
        this.gravatar = gravatar;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public boolean isDeveloper() {
        return developer;
    }

    public void setDeveloper(boolean developer) {
        this.developer = developer;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.uuid);
        dest.writeString(this.name);
        dest.writeString(this.gravatar);
        dest.writeByte(confirmed ? (byte) 1 : (byte) 0);
        dest.writeByte(developer ? (byte) 1 : (byte) 0);
        dest.writeLong(this.createdAt);
    }

    private void readFromParcel(Parcel in) {
        this.id = in.readString();
        this.uuid = in.readString();
        this.name = in.readString();
        this.gravatar = in.readString();
        this.confirmed = in.readByte() != 0;
        this.developer = in.readByte() != 0;
        this.createdAt = in.readLong();
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        public User[] newArray(int size) {
            return new User[size];
        }
    };
}