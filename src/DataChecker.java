public class DataChecker {
    public String dataCheck(String beforeEncoding, String afterDecoding){
        if(beforeEncoding.equals(afterDecoding))
            return "Data integrity has been verified.\nThe original file and the decoded file match\n";
        else
            return "Data integrity check failed";
    }
    
}
