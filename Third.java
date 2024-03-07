public class Third extends JFrame
{
    public int i;
    static int storageСС = 0; 
    static int storageEG = 0; 
    static int storageACC = 0; 
    static int finished_car = 0; 
    static int solded_car = 0;
    static int N = 50 ;
    static int NF = 50;
    static int NS = 50;
    public static boolean started = false; 
    public static boolean kuzov = false; 
    public static boolean dvig = false;
    public static boolean acc = false;
    public static boolean proiz = false;
    public static boolean magaz = false;
    public static boolean isStopped = false;
    
    Third() throws FileNotFoundException
    {
            super("Начало работы фабрики");
            
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int result = JOptionPane.showConfirmDialog (null, "Возобновить последнюю работу фабрики?","?", dialogButton);
            if(result == JOptionPane.YES_OPTION)
            {
                Scanner s = new Scanner(new File("src/input.txt"));
                int[] array = new int[5];
                for (int i = 0; i < array.length; i++)
                array[i] = s.nextInt();
                
                storageСС = array[0]; 
                storageEG = array[1]; 
                storageACC = array[2]; 
                finished_car = array[3]; 
                solded_car = array[4];
                
                
    
            }
            
           else if(result == JOptionPane.NO_OPTION) 
            {
  
                storageСС = 0; 
                storageEG = 0; 
                storageACC = 0; 
                finished_car = 0; 
                solded_car = 0;
            }
              
        setSize(150, 150);
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        JButton button = new JButton("Начать работу");
        addWindowListener(new WindowAdapter()
{
        	  public void windowClosing(WindowEvent e)
                  {
               
              
              FileWriter filewriter;
                      try {
              int[] array = new int[5];       
              array[0] = storageСС; 
              array[1] = storageEG;
              array[2] = storageACC;
              array[3] = finished_car;
              array[4] = solded_car;
                          filewriter = new FileWriter(new File("src/input.txt"));
                           
                          for (int i=0;i<5;++i)
                
                filewriter.write(array[i]+ " ");
                filewriter.flush();
                      } catch (IOException ex) {
                          Logger.getLogger(Third.class.getName()).log(Level.SEVERE, null, ex);
                      }
 
               
              
	      System.exit(0);
        	  }
        	});
   
         

        button.addMouseListener(new MouseAdapter() 
        {
            public void mouseClicked(MouseEvent evt) 
            {
                buttonMouseClicked(evt);
            }
        });
        panel.add(button);
        setContentPane(panel);
        
        
        
    }
   
    public void windowClosing(WindowEvent e) 
    {
        System.out.println("");
         
                System.exit(0);
            
    }
    public void buttonMouseClicked(MouseEvent evt) 
    {
        started=true;
        Fabric start =new Fabric();
       
        start.execute();
    }

    public class Fabric extends SwingWorker<Integer, Object> 
    {
        private static final long SLEEP_TIME=1000;
        public int Work() throws FileNotFoundException        
        {     
                
        String input;
        input = JOptionPane.showInputDialog("Введите размер склада");
        N=Integer.parseInt(input);
        
        String input1;
        input1 = JOptionPane.showInputDialog("Введите размер склада машин"); 
        NF=Integer.parseInt(input1);
        
        String input2;
        input2 = JOptionPane.showInputDialog("Введите количество продаж");
        NS=Integer.parseInt(input2);
        
            for (i =0; i <101; i++) 
            {
               
                Second.label.setText("Начинается поставка деталей ");
                if (acc == true && dvig==true && kuzov==true) Second.label.setText("Склады заполнены. Поставка прекращается ");
                
                Second.label1.setText( "Склад двигателей: " + storageEG);
                if (dvig==true) Second.label1.setText( "Склад двигателей заполнен. ");
                
                Second.label2.setText( "Склад кузовов: "+ storageСС);
                if (kuzov == true) Second.label2.setText( "Склад кузовов заполнен.");
                
                Second.label3.setText( "Склад аксессуаров: "+ storageACC);
                if (acc == true) Second.label3.setText( "Склад аксессуаров заполнен. ");
                
                Build.label.setText("Используются детали со склада. Производство начинается");
                if (proiz == true ) Build.label.setText("Продажа машин окончена. Производство останавливается");
                Build.label1.setText("Готовых машин на складе:" + finished_car);
                
                Sell.label.setText("Продажа машин со склада");
                if (magaz==true) Sell.label.setText("Продажа останавливается");
                Sell.label1.setText("Машин продано: "+solded_car);
                
                
                try {
                    Thread.sleep(SLEEP_TIME);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return 1;
        }

        @Override
        protected Integer doInBackground() throws FileNotFoundException 
        {
            return new Integer(Work());
        }
        
        
        
    }
    
    
        public static class Сarcase extends Thread { 
        @Override
        public void run() {
            
      
            boolean sawException = false;
            
            while (storageСС != N)
            {
                try {
                    if(storageСС < (N+1)) 
                    {
                        storageСС += 1;
                        
                        Thread.sleep(300);
                    }

                }catch (InterruptedException e) {

                    sawException = true;
                }
            }
            
            kuzov = true;
            if (sawException) Thread.currentThread().interrupt();

        }
    }
    
    public static class StorageEG extends Thread { 
        @Override
        public void run() {
            boolean sawException = false;
            
            while (storageEG != N)
            {
                try {
                    if(storageEG < (N+1))
                    {
                        storageEG += 1;
                        Thread.sleep(300);
                    }

                }catch (InterruptedException e) {

                    sawException = true;
                }
            }
            
            dvig = true;
            if (sawException) Thread.currentThread().interrupt();

        }
    }

    public static class StorageACC extends Thread { 
        @Override
        public void run() {
            boolean sawException = false;
            
            while (storageACC != N)
            {
                try {
                    if(storageACC < (N+1)) {
                        storageACC += 1;
                        Thread.sleep(300);
                    }

                }catch (InterruptedException e) {

                    sawException = true;
                }
            }
            
            acc = true;
            if (sawException) Thread.currentThread().interrupt();

        }
    }

    public static class BuildCar extends Thread { 
        @Override
        public void run() 
        {
            boolean sawException = false;
            
            while (isStopped != true)
            {
                try {
                    if(finished_car < NF)
                    {
                    if(storageACC > 0) {
                        if (storageEG > 0) {
                            if (storageСС > 0) {
                                storageСС  -= 1;
                                storageACC -= 1;
                                storageEG  -= 1;
                                finished_car += 1;

                            }
                        }
                    }
                        else {
                            
                        }
                        Thread.sleep(300);
                    }

                }catch (InterruptedException e) {

                    sawException = true;
                }
            }
            proiz = true;
            if (sawException) Thread.currentThread().interrupt();

        }
    }

    public static class Selling extends Thread { 
        @Override
        public void run() {
            boolean sawException = false;
            
            while (solded_car < NS)
            {
                try {
                    if(finished_car > 0) {
                        finished_car -= 1;
                        solded_car += 1;
                        

                    }
                    Thread.sleep(350);
                }catch (InterruptedException e) {

                    sawException = true;
                }
            }
            
            isStopped= true;
            magaz = true;
            if (sawException) Thread.currentThread().interrupt();

        }
    }
    
    
    
    
    
}
