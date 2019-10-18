package Test.main.java.TDD.args;

import main.java.TDD.args.Args;
import main.java.TDD.args.CTLInputPaser;
import main.java.TDD.args.Schama;
import org.junit.Assert;
import org.junit.Test;

public class ArgsTest {
    @Test
    public void setArgString(){
//    TODO: 1. devide a string in the command line to a string array
        String ArgString = "-l -p 8080 -d /home/test";
        String SchamaStr = "l:Boolean p:integer d:String";
        Schama schama=new Schama(SchamaStr);
//    TODO: 3. get correct arguments accroding to the Schema and its value.
        Args args = new Args(SchamaStr,ArgString);
        Assert.assertEquals(args.getArg_Val("l"),Boolean.TRUE);
        Assert.assertEquals(args.getArg_Val("p"),8080);
        Assert.assertEquals(args.getArg_Val("d"),"/home/test");
    }

    @Test
    public void test_number(){
        String ArgString = "-l -p -999 -d /home/test";
        Args args = new Args("l:Boolean p:integer d:String",ArgString);
        Assert.assertEquals(args.getArg_Val("l"),Boolean.FALSE);
        Assert.assertEquals(args.getArg_Val("p"),new Integer(-999));
        Assert.assertEquals(args.getArg_Val("d"),"/home/test");
    }

    public void testNol(){
        String ArgString = "-p -999 -d /home/test";

    }


}
