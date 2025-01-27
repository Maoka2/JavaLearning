package ObjectPrc;


public class Restaurant {
    int resid;
    String name;
    String address;
    String signatureMenu;
    int rate;

    Restaurant(){

    }

    Restaurant(int resid, String name, String address, String signatureMenu , int rate){
        this.resid = resid;
        this.name = name;
        this.address = address;
        this.signatureMenu = signatureMenu;
        this.rate = rate;
    }

    public String toString() {
        return ("Restaurant " + "[ resId = " + resid + ", name = " + name + ", address = " + address + ", signatureMenu = " + signatureMenu + ", rate = " + rate + " ]");
    }
}


