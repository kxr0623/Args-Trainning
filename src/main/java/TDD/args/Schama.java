package main.java.TDD.args;

import java.util.HashMap;

public class Schama {
    private String paserSchemaStr;  //"l:Boolean p:integer d:String";
    private HashMap<String,String> schemaResultMap;
    public Schama(String parserSchamaStr) {
        this.paserSchemaStr=parserSchamaStr;
        this.schemaResultMap=toObject(this.paserSchemaStr);
    }

    public Object getSchema_result(String tag, String strValue) {
        String type = schemaResultMap.get(tag);
        switch (type){
            case "Boolean":
                return "true".equalsIgnoreCase(strValue);
            case "integer":
                return Integer.parseInt(strValue);
            default:
                return strValue;
        }
    }

    private HashMap<String,String> toObject(String paserSchemaStr){
        String[] schemaArr=paserSchemaStr.split("\\s");
        HashMap<String,String> schemaMap=new HashMap();
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
        return schemaMap;
    }

}