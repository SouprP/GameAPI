package me.souprpk.gameapi.api.kits;


public class PlayerKit {

    private KitItem[] items;
    public PlayerKit(KitItem[] items){
        this.items = items;
    }

    public void setKit(KitItem[] items){
        this.items = items;
    }

    public KitItem[] getKitItems(){
        return this.items;
    }
}
