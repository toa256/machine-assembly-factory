public class Second extends JFrame
{
    public static JLabel label;
    public static JLabel label1;
    public static JLabel label2;
    public static JLabel label3;
    
    Second()
    {
        super("Склады");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(245, 300);
         
        Container container = getContentPane();
        container.setLayout (new FlowLayout(FlowLayout.CENTER));
        
        JPanel panel = new JPanel();
        label = new JLabel("-");
        panel.add(label);
        
        JPanel panel1 = new JPanel();
        label1 = new JLabel("-");
        panel1.add(label1);
        
         JPanel panel2 = new JPanel();
        label2 = new JLabel("-");
        panel2.add(label2);
        
         JPanel panel3 = new JPanel();
        label3 = new JLabel("-");
        panel3.add(label3);
          
        
       container.add(label);
       container.add(label1);
       container.add(label2);
       container.add(label3);
        
        
    }
