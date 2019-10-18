package Test.main.java.TDD.args;

import main.java.TDD.args.Args;
import main.java.TDD.args.CTLInputPaser;
import main.java.TDD.args.Schama;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ArgsTest {
    @Test
    public void setArgString(){
//    TODO: 1. devide a string in the command line to a string array
        String ArgString = "-l -p 8080 -d /home/test";
        CTLInputPaser cip = new CTLInputPaser();
        String[] ArgArray = cip.parse(ArgString);
//    TODO: 2. parser schema(String) to object.
        String  ParserSchamaStr="l:Boolean p:integer d:String";
        Schama schama=new Schama(ParserSchamaStr);


//    TODO: 3. get correct arguments accroding to the Schema and its value.
        Args args = new Args(schama,ArgArray);
        Assert.assertEquals(args.getArg_Val("l"),true);
        Assert.assertEquals(args.getArg_Val("p"),8080);
        Assert.assertEquals(args.getArg_Val("d"),"/home/test");
    }
//


}