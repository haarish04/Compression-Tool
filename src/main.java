public class Main {

    public static void main(String[] args){
        String filePath= args[0];
        System.out.println(filePath);
        try{
            InputFileReader input = new InputFileReader();
            input.readFile(filePath);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}