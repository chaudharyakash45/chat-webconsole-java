import java.net.*;



import java.io.*;

 class  client{
  

    Socket socket;

    BufferedReader br;
     PrintWriter out;
          public client(){


    try {
        System.out.println("sending request...");
      Socket =new Socket("127.0.0.1",77777);
      System.out.println("connection done...");

       
      br= new BufferedReader(new InputStreamReader(socket.getInputStream()));
      out= new PrintWriter(socket.getOutputStream());

      startReading();
      startWritting();

    } catch (Exception e) {
        //TODO: handle exception
    
          }
        }












    public void startReading()
    {
     //this is used to reading the string code from another socket
       Runnable r1=()->{

           System.out.println("reader started...");
           while(true)
           {
               String msg = br.readLine()
            try{
               if(msg.equals("exit")){
                   System.out.println("the client has teriminated the chat");
                   break;
               }
               System.out.println("client: " +msg);
           }
           catch( Exception e){
               e.printStackTrace();
           }

           }

       }; 
       new Thread(r1).start();
    }



    public void startWritting(){

        //this is used to writing the data imediatliy with server
     Runnable r2=()->
     {
         System.out.println("write started...");
         while(true){
          
            try {
                 
                BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
                String content=br.readLine();


                out.println(content);
                
            } catch (Exception e) {
                e.printStackTrace();
            }



         }

     };
     new Thread(r2).start();
         
    }
    
    public static void main(String[] args) {
    System.out.println("here we start the clients ");   
    new client();  
       
        
       
    }

    
}
