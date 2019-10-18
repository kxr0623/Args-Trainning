package main.java.TDD.args;

import java.util.HashMap;

public class Schama {
    String paserSchemaStr;  //"l:Boolean p:integer d:String";
    Object schema;
    public Schama(String parserSchamaStr) {
        this.paserSchemaStr=parserSchamaStr;
    }
    public Object toObject(){
        String[] schemaArr=paserSchemaStr.split(" ");
        HashMap<String,Object> schemaMap=new HashMap();
        for (int i=0;i<schemaArr.length;i++){
            String tag = schemaArr[i].split(":")[0];
            String type = schemaArr[i].split(":")[1];
            if ( tag.isEmpty()  ||type.isEmpty() ){
                System.out.println("[Error] the schema string is err");
            }
            else {
                schemaMap.put(tag,type);
            }
        }

    }

}
