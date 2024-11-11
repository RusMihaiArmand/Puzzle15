import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;


public class Puzzle {

    JFrame fereastra;
    JButton butonMeniu, butonJocNou, butonLoad, butonInstr, butonSave, buton3x3, buton5x5, buton7x7;
    int L;
    JButton butonNR[] = new JButton[49];
    JLabel etichetaInstructiuni,etichetaTrofeu1,etichetaTrofeu2;
    JPanel panou;
    Puzzle ()
    {
        initComponent();
    }

    public void initComponent()
    {
        fereastra = new JFrame("Puzzle1");
        fereastra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fereastra.setSize(1500,810);
        fereastra.setVisible(true);
        fereastra.setBackground(new Color(245, 227, 160));

        butonMeniu = new JButton("Meniu");
        butonMeniu.addActionListener(new Puzzle.ActionListenerClass());
        butonMeniu.setBackground(new Color(195,206,185));
        butonJocNou = new JButton("Joc nou");
        butonJocNou.addActionListener(new Puzzle.ActionListenerClass());
        butonJocNou.setBackground(new Color(54,72,209));
        butonLoad = new JButton("Restabileste joc");
        butonLoad.addActionListener(new Puzzle.ActionListenerClass());
        butonLoad.setBackground(new Color(132,255,173));
        butonInstr = new JButton("Instructiuni");
        butonInstr.addActionListener(new Puzzle.ActionListenerClass());
        butonInstr.setBackground(new Color(255,134,68));
        butonSave = new JButton("Salveaza");
        butonSave.addActionListener(new Puzzle.ActionListenerClass());
        butonSave.setBackground(new Color(86,202,206));
        buton3x3 = new JButton("3x3");
        buton3x3.addActionListener(new Puzzle.ActionListenerClass());
        buton3x3.setBackground(new Color(24,206,27));
        buton5x5 = new JButton("5x5");
        buton5x5.addActionListener(new Puzzle.ActionListenerClass());
        buton5x5.setBackground(new Color(206,163,6));
        buton7x7 = new JButton("7x7");
        buton7x7.addActionListener(new Puzzle.ActionListenerClass());
        buton7x7.setBackground(new Color(206,16,26));

        etichetaTrofeu1 = new JLabel();
        etichetaTrofeu1.setBackground(new Color(245, 227, 160));
        etichetaTrofeu1.setOpaque(true);
        etichetaTrofeu1.setIcon(new ImageIcon(new ImageIcon("trophy.png").getImage().getScaledInstance(300, 600, Image.SCALE_DEFAULT))  );
        etichetaTrofeu2 = new JLabel();
        etichetaTrofeu2.setBackground(new Color(245, 227, 160));
        etichetaTrofeu2.setOpaque(true);
        etichetaTrofeu2.setIcon(new ImageIcon(new ImageIcon("trophy.png").getImage().getScaledInstance(300, 600, Image.SCALE_DEFAULT))  );

        for(int i=0; i<49;i++)
        {
            butonNR[i] = new JButton(i+"");
            butonNR[i].addActionListener(new Puzzle.ActionListenerClass());
            if(i%2==0)
                butonNR[i].setBackground(new Color(132,224,255));
            else
                butonNR[i].setBackground(new Color(234,255,173));
            butonNR[i].setFont(new Font("Arial", Font.PLAIN, 40));
        }

        etichetaInstructiuni = new JLabel("<html>Jocul este unul simplu: ti se dau mai multe casute cu numere in ele," +
                " acestea fiind asezate intr-un patrat cu latura N (aceasta valoare putand fi selectata, permitand " +
                "alegerea unei dificultati adecvate).<br/>" +
                "O casuta va fi libera, celelalte continand numerele de la 1 pana la N^2 - 1, distribuite aleatoriu.<br/>" +
                "O casuta cu un numar poate fi mutata in casuta libera daca acestea sunt una langa alta.<br/>" +
                "Pentru a castiga trebuie asezate numerele in ordine crescatoare, de la stanga la dreapta, de sus " +
                "in jos, cu casuta libera in coltul din dreapta jos.</html>");
        etichetaInstructiuni.setBackground(new Color(198, 168, 215));
        etichetaInstructiuni.setOpaque(true);

        panou = new JPanel();
        panou.setSize(1500,810);
        panou.setLayout(null);
        panou.setBackground(new Color(245, 227, 160));
        panou.add(butonJocNou);
        panou.add(butonLoad);
        panou.add(butonInstr);

        butonJocNou.setBounds(350,45,800,210);
        butonLoad.setBounds(350,300,800,210);
        butonInstr.setBounds(350,555,800,210);

        fereastra.add(panou);
        fereastra.setLayout(null);
        panou.setVisible(false);
        panou.setVisible(true);
    }

    class ActionListenerClass implements ActionListener  {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==butonMeniu)
            {
                panou.setVisible(false);
                panou.removeAll();
                panou.add(butonJocNou);
                panou.add(butonLoad);
                panou.add(butonInstr);
                butonJocNou.setBounds(350,45,800,210);
                butonLoad.setBounds(350,300,800,210);
                butonInstr.setBounds(350,555,800,210);
                panou.setVisible(true);
            }
            if(e.getSource()==butonJocNou)
            {
                panou.setVisible(false);
                panou.removeAll();
                panou.add(butonMeniu);
                panou.add(buton3x3);
                panou.add(buton5x5);
                panou.add(buton7x7);
                butonMeniu.setBounds(350,18,800,180);
                buton3x3.setBounds(350,216,800,180);
                buton5x5.setBounds(350,414,800,180);
                buton7x7.setBounds(350,612,800,180);
                panou.setVisible(true);
            }
            if(e.getSource()==butonInstr)
            {
                panou.setVisible(false);
                panou.removeAll();
                panou.add(butonMeniu);
                panou.add(etichetaInstructiuni);
                butonMeniu.setBounds(350,45,800,210);
                etichetaInstructiuni.setBounds(150,285,1200,480);
                panou.setVisible(true);
            }
            if(e.getSource()==buton3x3)
            {
                panou.setVisible(false);
                panou.removeAll();
                L=3;
                panou.add(butonMeniu);
                panou.add(butonSave);
                panou.add(butonLoad);
                butonMeniu.setBounds(150,20,300,100);
                butonSave.setBounds(600,20,300,100);
                butonLoad.setBounds(1050,20,300,100);
                for(int i=0;i<L*L;i++)
                {
                    panou.add(butonNR[i]);
                    butonNR[i].setBounds(450+i%L*200,140+(i/L)*200,200,200);
                }

                ArrayList<Integer> list = new ArrayList<Integer>();
                for (int i=0; i<L*L; i++) {
                    list.add(i);
                }
                boolean ok=false;
                while(ok==false)
                {
                    Collections.shuffle(list);
                    int inversiuni = 0;
                    for (int i=0; i<L*L; i++)
                        for (int j=i+1; j<L*L; j++)
                            if(list.get(i)>list.get(j) && list.get(j)!=0)
                            { inversiuni++;
                            }
                    if(inversiuni%2==0)
                        ok=true;
                }

                for (int i=0; i<L*L; i++) {
                    butonNR[i].setText(list.get(i) + "");
                    if(butonNR[i].getText().equals("0"))
                        butonNR[i].setText(" ");
                }
                panou.setVisible(true);
            }
            if(e.getSource()==buton5x5)
            {
                panou.setVisible(false);
                panou.removeAll();
                L=5;
                panou.add(butonMeniu);
                panou.add(butonSave);
                panou.add(butonLoad);
                butonMeniu.setBounds(150,20,300,100);
                butonSave.setBounds(600,20,300,100);
                butonLoad.setBounds(1050,20,300,100);
                for(int i=0;i<L*L;i++)
                {
                    panou.add(butonNR[i]);
                    butonNR[i].setBounds(425+i%L*130,140+(i/L)*130,130,130);
                }

                ArrayList<Integer> list = new ArrayList<Integer>();
                for (int i=0; i<L*L; i++) {
                    list.add(i);
                }
                boolean ok=false;
                while(ok==false)
                {
                    Collections.shuffle(list);
                    int inversiuni = 0;
                    for (int i=0; i<L*L; i++)
                        for (int j=i+1; j<L*L; j++)
                            if(list.get(i)>list.get(j) && list.get(j)!=0)
                            {
                                inversiuni++;
                            }
                    if(inversiuni%2==0)
                        ok=true;
                }

                for (int i=0; i<L*L; i++) {
                    butonNR[i].setText(list.get(i) + "");

                    if(butonNR[i].getText().equals("0"))
                        butonNR[i].setText(" ");
                }
                panou.setVisible(true);
            }
            if(e.getSource()==buton7x7)
            {
                panou.setVisible(false);
                panou.removeAll();
                L=7;
                panou.add(butonMeniu);
                panou.add(butonSave);
                panou.add(butonLoad);
                butonMeniu.setBounds(150,20,300,100);
                butonSave.setBounds(600,20,300,100);
                butonLoad.setBounds(1050,20,300,100);
                for(int i=0;i<L*L;i++)
                {
                    panou.add(butonNR[i]);
                    butonNR[i].setBounds(435+i%L*90,150+(i/L)*90,90,90);
                }

                ArrayList<Integer> list = new ArrayList<Integer>();
                for (int i=0; i<L*L; i++) {
                    list.add(i);
                }
                boolean ok=false;
                while(ok==false)
                {
                    Collections.shuffle(list);
                    int inversiuni = 0;
                    for (int i=0; i<L*L; i++)
                        for (int j=i+1; j<L*L; j++)
                            if(list.get(i)>list.get(j) && list.get(j)!=0)
                            {
                                inversiuni++;
                            }

                    if(inversiuni%2==0)
                        ok=true;
                }

                for (int i=0; i<L*L; i++) {
                    butonNR[i].setText(list.get(i) + "");
                    if(butonNR[i].getText().equals("0"))
                        butonNR[i].setText(" ");
                }
                panou.setVisible(true);
            }
            if(e.getSource()==butonSave)
            {
                try{
                    BufferedWriter fisier = new BufferedWriter(new FileWriter("save"));
                    fisier.write(L+ "\n");
                    for(int i=0;i<L*L;i++)
                    {
                        if(butonNR[i].getText().equals(" "))
                            fisier.write("0"+ "\n");
                        else
                            fisier.write(butonNR[i].getText()+ "\n");
                    }
                    fisier.close();
                }
                catch (Exception excep)
                {
                }
            }
            if(e.getSource()==butonLoad)
            {
                try{
                    BufferedReader fisier = new BufferedReader(new FileReader("save"));
                   L = Integer.parseInt(fisier.readLine());

                   panou.setVisible(false);
                   panou.removeAll();

                   panou.add(butonMeniu);
                   panou.add(butonSave);
                   panou.add(butonLoad);
                   butonMeniu.setBounds(150,20,300,100);
                   butonSave.setBounds(600,20,300,100);
                   butonLoad.setBounds(1050,20,300,100);

                   switch(L){
                       case 3:
                           for(int i=0;i<L*L;i++)
                           {
                               panou.add(butonNR[i]);
                               butonNR[i].setText(fisier.readLine());
                               if(butonNR[i].getText().equals("0"))
                                   butonNR[i].setText(" ");
                               butonNR[i].setBounds(450+i%L*200,140+(i/L)*200,200,200);
                           }
                           break;
                       case 5:
                           for(int i=0;i<L*L;i++)
                           {
                               panou.add(butonNR[i]);
                               butonNR[i].setText(fisier.readLine());
                               if(butonNR[i].getText().equals("0"))
                                   butonNR[i].setText(" ");
                               butonNR[i].setBounds(425+i%L*130,140+(i/L)*130,130,130);
                           }
                           break;
                       case 7:
                           for(int i=0;i<L*L;i++)
                           {
                               panou.add(butonNR[i]);
                               butonNR[i].setText(fisier.readLine());
                               if(butonNR[i].getText().equals("0"))
                                   butonNR[i].setText(" ");
                               butonNR[i].setBounds(435+i%L*90,150+(i/L)*90,90,90);
                           }
                           break;
                       default: break;
                   }

                   panou.setVisible(true);
                   fisier.close();
                }
                catch (Exception excep)
                {
                }
            }

            int bt=-1;
            for(int i =0;i<49;i++) {
                if (e.getSource() == butonNR[i]) {
                    bt = i;
                }
            }
            if(bt!=-1)
            {
                if(bt>=L && butonNR[bt-L].getText().equals(" ")) {
                    butonNR[bt - L].setText(butonNR[bt].getText());
                    butonNR[bt].setText(" ");
                }
                if(bt+L<L*L && butonNR[bt+L].getText().equals(" ")) {
                    butonNR[bt + L].setText(butonNR[bt].getText());
                    butonNR[bt].setText(" ");
                }
                if(bt%L!=0 && butonNR[bt-1].getText().equals(" ")) {
                    butonNR[bt - 1].setText(butonNR[bt].getText());
                    butonNR[bt].setText(" ");
                }
                if((bt+1)%L!=0 && butonNR[bt+1].getText().equals(" ")) {
                    butonNR[bt + 1].setText(butonNR[bt].getText());
                    butonNR[bt].setText(" ");
                }

                boolean win = true;
                for(int i=0; i<L*L-1;i++)
                    if(butonNR[i].getText().equals( i+1+""  )==false)
                    {
                        win = false;
                    }
                if(win==true)
                {
                    etichetaTrofeu1.setBounds(0,210,300,600);
                    etichetaTrofeu2.setBounds(1200,210,300,600);
                    panou.add(etichetaTrofeu1);
                    panou.add(etichetaTrofeu2);
                    etichetaTrofeu1.setVisible(true);
                    etichetaTrofeu2.setVisible(true);
                }
                else
                {
                    etichetaTrofeu1.setVisible(false);
                    etichetaTrofeu2.setVisible(false);
                    panou.remove(etichetaTrofeu1);
                    panou.remove(etichetaTrofeu2);
                }
            }
        }
    }

    public static void main(String args[])
    {
       new Puzzle();
    }
}
