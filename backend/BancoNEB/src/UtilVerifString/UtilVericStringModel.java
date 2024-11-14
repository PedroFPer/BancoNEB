package UtilVerifString;

public abstract class UtilVericStringModel {
    public boolean vericQuant(String conjCarac){
        if(conjCarac.length()==quantIdeal()){
            return true;
        }
        return false;
    }
    
    protected abstract int quantIdeal();
    
}
