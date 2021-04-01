package parser;

public class ParserURL {

    public static String parser(String path){
        path = path.replace("http://localhost:8081/", "");
        int temp = path.indexOf("?");
        if(temp != -1) {
            path = path.substring(0, temp);
        }
        return path;
    }
}
