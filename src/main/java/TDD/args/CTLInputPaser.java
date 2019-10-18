package main.java.TDD.args;

import java.util.Arrays;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map;

/**
 * Created by 52704 on 2019/10/18.
 */
public class CTLInputPaser {
    String cmd;
    Map<String,String> flagValue;
    public CTLInputPaser(String cmd) {
        this.cmd = cmd;
        flagValue=new HashMap<>();
        ListIterator<String> cltIterator = Arrays.asList(cmd.split("\\s")).listIterator();
        while ( cltIterator.hasNext()){
            String flag = cltIterator.next().substring(1);
            if (cltIterator.hasNext()){
                String value=cltIterator.next();
                if (isValue(value)){
                    flagValue.put(flag,value);
                }else {
                    cltIterator.previous();
                }
            }
        }
    }
    private boolean isValue(String str){
        Boolean is = true;
        if(str.charAt(0)!='-' ) return true;
        if(str.charAt(0)=='-' && str.length()>1 ){
            for(int i=1;i<str.length();i++){
                if(str.charAt(i)<'0' || str.charAt(i)>'9'){
                    is = false;
                }
            }
        }
        return is;
    }
    public String getArg_Val(String flag) {
        return flagValue.get(flag);
    }
}
