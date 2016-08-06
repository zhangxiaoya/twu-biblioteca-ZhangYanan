package com.twu.biblioteca;

/**
 * Created by yanzhang on 8/6/16.
 */
public class CheckedRecod {
    private String LibrarayNumber;
    private long ItemId;
    private short ItemType;

    public CheckedRecod(String librarayNumber,
                        long itemId,
                        short itemType){
        LibrarayNumber = librarayNumber;
        ItemId = itemId;
        ItemType = itemType;
    }

    public String getLibrarayNumber(){
        return LibrarayNumber;
    }
    public void setLibrarayNumber(String librarayNumber){
        LibrarayNumber = librarayNumber;
    }

    public long getItemId(){
        return ItemId;
    }
    public void setItemId(long itemId){
        ItemId = itemId;
    }

    public short getItemType(){
        return ItemType;
    }
    public void setItemType(short itemType){
        ItemType = itemType;
    }
}
