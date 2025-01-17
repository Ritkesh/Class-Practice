package com.company;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Scanner;

public class WhatsAppMessage {
    public static void main(String[] args) throws InterruptedException, AWTException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter The Message");
        String msg = sc.nextLine();
        System.out.println("How many times");
        int size = sc.nextInt();
        StringSelection stSc = new StringSelection(msg);
        Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
        cb.setContents(stSc,null);
        Thread.sleep(2000);
        Robot robot = new Robot();
        for(int i = 0;i<size;i++){
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);

            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_V);


            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        }



    }
}
