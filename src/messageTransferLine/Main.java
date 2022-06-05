package comp2102_project_q2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        File file = new File("C:\\Users\\alper\\Desktop\\class.txt");
        Scanner scanner = new Scanner(file);
        Scanner InputScanner = new Scanner(System.in);

        int numOfHubs;
        int totalStudentCount = 0;
        int choosenStudentCount = 0;
        int randomStudent;
        String studentName;
        LinkedList<String> tempLL = new LinkedList<>();

        System.out.print("Enter the number of hubs (p): ");
        numOfHubs = InputScanner.nextInt();

        while (scanner.hasNext()) { //file okuyor
            totalStudentCount++; //fileda bulunan öğrenci sayısı
            studentName = scanner.nextLine(); //file isimlerini eşitle
            tempLL.add(studentName); //öğrencileri geçici olarak linkedliste ekle
        }

        while (choosenStudentCount < 30) {

            randomStudent = (int) (Math.random() * (totalStudentCount - 0)) + 0;

            if (!tempLL.get(randomStudent).isEmpty() || tempLL.get(randomStudent) != null) {
                doubleLinkedList.addStudent(tempLL.get(randomStudent));
                tempLL.remove(randomStudent);
                choosenStudentCount++;
                totalStudentCount--;
            } else {
                return;
            }
        }
        doubleLinkedList.determineHub(numOfHubs);
        System.out.println("\n{Creating A linked list of 30 students, " + numOfHubs + " are hubs}");

        System.out.print("\nEnter the number of student to pass the message (k) : ");
        int k = InputScanner.nextInt();
        System.out.println("\nDisplaying the student message train, (hubs have a * character on their names) ");
        doubleLinkedList.display();

        System.out.print("\nEnter the message : ");
        String message = InputScanner.next();

        System.out.print("\nEnter the source student's name : ");
        String sourceStName = InputScanner.next();

        System.out.println("\n");
        doubleLinkedList.messageLine(message, sourceStName, k); // messageLine2 methodumuz da mevcut ama istediğimizi yaptıramadığımız için bunu kullandırtıyoruz.
    }
}