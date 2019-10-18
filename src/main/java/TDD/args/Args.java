package main.java.TDD.args;

import main.java.TDD.args.CTLInputPaser;
import main.java.TDD.args.Schama;

/**
 * Created by 52704 on 2019/10/18.
 */
public class Args {
    private final Schama schama;
    CTLInputPaser argStr;
    Object Arg_Val;
    public Args(String schama, String argStr) {

        this.schama=new Schama(schama);
        this.argStr=new CTLInputPaser(argStr);
    }

    public Object getArg_Val(String tag) {
        Object result=schama.getSchema_result(tag,argStr.getArg_Val(tag));
        return Arg_Val;
    }
}

