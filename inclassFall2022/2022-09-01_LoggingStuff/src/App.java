import CSC346Utility.Logger;

public class App {
    static Logger log = new Logger("myOwnLog");
    public static void main(String[] args){
        log.info("Starting the logging program");
        String number = "7";
        int i=0;
        try{
            i = Integer.parseInt(number);
        }catch(Exception e){
            log.exception(e);
            //System.exit(1);
        }
        System.out.println("The number is "+ i);


        log.done();
        System.out.println("Done in main()");
    }
}
